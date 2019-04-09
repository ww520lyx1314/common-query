package com.tfkj.common.utils;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class RSAUtils {
    public static final String KEY_ALGORITHM = "RSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    public static final String SIGNATURE_ALGORITHM="MD5withRSA";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    public static Map<String,Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String,Object> keyMap = new HashMap<String,Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    //获得公钥字符串
    public static String getPublicKeyStr(Map<String, Object> keyMap) throws Exception {
        //获得map中的公钥对象 转为key对象
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    //获得私钥字符串
    public static String getPrivateKeyStr(Map<String, Object> keyMap) throws Exception {
        //获得map中的私钥对象 转为key对象
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        //编码返回字符串
        return encryptBASE64(key.getEncoded());
    }

    //获取公钥
    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    //获取私钥
    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    //解码返回byte
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    //编码返回字符串
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    //***************************签名和验证*******************************
    public static byte[] sign(byte[] data,String privateKeyStr) throws Exception{
        PrivateKey priK = getPrivateKey(privateKeyStr);
        Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
        sig.initSign(priK);
        sig.update(data);
        return sig.sign();
    }

    public static boolean verify(byte[] data,byte[] sign,String publicKeyStr) throws Exception{
        PublicKey pubK = getPublicKey(publicKeyStr);
        Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
        sig.initVerify(pubK);
        sig.update(data);
        return sig.verify(sign);
    }

    //************************加密解密**************************
    public static byte[] encrypt(byte[] plainText,String publicKeyStr)throws Exception{
        PublicKey publicKey = getPublicKey(publicKeyStr);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int inputLen = plainText.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        int i = 0;
        byte[] cache;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(plainText, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(plainText, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptText = out.toByteArray();
        out.close();
        return encryptText;
    }

    public static byte[] decrypt(byte[] encryptText,String privateKeyStr)throws Exception{
        PrivateKey privateKey = getPrivateKey(privateKeyStr);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        int inputLen = encryptText.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptText, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptText, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] plainText = out.toByteArray();
        out.close();
        return plainText;
    }


    public static void main(String[] args) {
        Map<String, Object> keyMap;
        byte[] cipherText;
        String input = "李翔宇是个大英雄!";
        try {
            //keyMap = initKey();
            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDlB6/CsX/Ot5n4gxjjzAw3fnXN9Gzp8PY0Kqvr"+
                    "ZcJ4eYRgAGYWQq0I9T5l/mcCZPYsUoFcJembEGiktBicKFetNJApIbY/oJA1K++aElFkBgFO8aeR"+
                    "MA3SUxCSrJxtksuzEL1QV48VSwkIoeRrVvG6jt5wYeHmboDE6qolArCmnwIDAQAB";
           // String publicKey = getPublicKeyStr(keyMap);
            System.out.println("公钥------------------");
            System.out.println(publicKey);
            //String privateKey = getPrivateKeyStr(keyMap);
            String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAOUHr8Kxf863mfiDGOPMDDd+dc30"+
                    "bOnw9jQqq+tlwnh5hGAAZhZCrQj1PmX+ZwJk9ixSgVwl6ZsQaKS0GJwoV600kCkhtj+gkDUr75oS"+
                    "UWQGAU7xp5EwDdJTEJKsnG2Sy7MQvVBXjxVLCQih5GtW8bqO3nBh4eZugMTqqiUCsKafAgMBAAEC"+
                    "gYEAqCyDwAfMXINu+Q9yqFq9ocYnRMs1anb4ooeu49Q9/27jaAcC71eYbZp/bi9nfleaeCNBP+PK"+
                    "7IUZAdAIvinVbkKqjZyo66xytBp9Fp3qf3QwP9/7ymvo0W0yiw8ORdZw/rekmmNXy4UMY6G7QVcN"+
                    "IZsp5RvBpx44w/38r62Mt0kCQQD/h+37u5JZgPHQZ+gsVrBDiFT8N/jyI49hyrypK2ekOM3QVJRF"+
                    "qGAY1+/iLwckA+fgzpSAF3FSQFuNGeq+zMm9AkEA5XNN9SsJV/wix1aOZ8C4hb/vgRiHwfhXSPEP"+
                    "UyD9I9Xm0Ui/QxSz4geZcUPMp6wzcZh2SyNfIqWBjNdep/DhiwJAFjl4VWCnBenVHk8rPk/73KPK"+
                    "4HTtzgGRwuujJQOFbB8Up33zt2tBkGeXkZCNinBchozxFYL0dDbsv4T1icq98QJAR5VHdvtsONTi"+
                    "jMoGN3w6lQ+iSuY6RFuT75+1JjwefXWYQyas9OKalCPGzT1Xtd/VVNU54oswfQChgC0YzNArrQJA"+
                    "Af7A0KnF8Pd6fcnfnotkY9Xto8SbM9++2UaBIwZiMOEfFTH/gulVmp/NhQY2hoEYOAszz4JuFstO"+
                    "CUFY3KAgKw==";
            System.out.println("私钥------------------");
            System.out.println(privateKey);

            System.out.println("测试可行性-------------------");
            System.out.println("明文======="+input);

            cipherText = encrypt(input.getBytes(),publicKey);
            //加密后的东西
            System.out.println("密文======="+new String(cipherText));
            //开始解密
            byte[] plainText = decrypt(cipherText,privateKey);
            System.out.println("解密后明文===== " + new String(plainText));
            System.out.println("验证签名-----------");

            String str="被签名的内容";
            System.out.println("\n原文:"+str);
            byte[] signature=sign(str.getBytes(),privateKey);
            boolean status=verify(str.getBytes(), signature,publicKey);
            System.out.println("验证情况："+status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
