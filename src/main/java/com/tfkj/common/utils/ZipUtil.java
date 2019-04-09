package com.tfkj.common.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.*;

public class ZipUtil
{
    public void zip(String zipFileName,String sourceFileName) throws Exception
    {
        //创建zip输出流
        ZipOutputStream out = new ZipOutputStream( new FileOutputStream(zipFileName));
        File sourceFile = new File(sourceFileName);

        compress(out,sourceFile,sourceFile.getName());
        out.flush();
        out.close();
    }

    public void compress(ZipOutputStream out,File sourceFile,String base) throws Exception
    {
        //如果路径为目录（文件夹）
        if(sourceFile.isDirectory())
        {
            //取出文件夹中的文件（或子文件夹）
            File[] flist = sourceFile.listFiles();
            if(flist.length==0)//如果文件夹为空，则只需在目的地zip文件中写入一个目录进入点
            {
                System.out.println(base+"/");
                out.putNextEntry(  new ZipEntry(base+"/") );
            }
            else//如果文件夹不为空，则递归调用compress，文件夹中的每一个文件（或文件夹）进行压缩
            {
                for(int i=0;i<flist.length;i++)
                {
                    compress(out,flist[i],base+"/"+flist[i].getName());
                }
            }
        }
        else//如果不是目录（文件夹），即为文件，则先写入目录进入点，之后将文件写入zip文件中
        {
            out.putNextEntry( new ZipEntry(base) );
            FileInputStream fos = new FileInputStream(sourceFile);
            BufferedInputStream bis = new BufferedInputStream(fos);

            int tag;
            System.out.println(base);
            //将源文件写入到zip文件中
            while((tag=bis.read())!=-1)
            {
                out.write(tag);
            }
            bis.close();
            fos.close();
        }
    }

    /**
     * 解压缩ZIP文件，将ZIP文件里的内容解压到targetDIR目录下
     * @param zipPath 待解压缩的ZIP文件名
     * @param descDir  目标目录
     */
    public void upzipFile(String zipPath, String descDir) throws Exception{
        upzipFile( new File(zipPath) , descDir ) ;
    }

    /**
     * 对.zip文件进行解压缩
     * @param zipFile  解压缩文件
     * @param descDir  压缩的目标地址，如：D:\\测试 或 /mnt/d/测试
     * @return
     */
    @SuppressWarnings("rawtypes")
    public void upzipFile(File zipFile, String descDir) throws Exception{
        byte[] _byte = new byte[1024];

        if(!zipFile.exists()){
            throw new Exception("解压失败，文件 " + zipFile + " 不存在!");
        }
        ZipFile _zipFile = new ZipFile(zipFile , Charset.forName("GBK")) ;
        for(Enumeration entries = _zipFile.entries(); entries.hasMoreElements() ; ){
            ZipEntry entry = (ZipEntry)entries.nextElement() ;
            File _file = new File(descDir + File.separator + entry.getName()) ;
            if( entry.isDirectory() ){
                _file.mkdirs() ;
            }else{
                File _parent = _file.getParentFile() ;
                if( !_parent.exists() ){
                    _parent.mkdirs() ;
                }
                InputStream _in = _zipFile.getInputStream(entry);
                OutputStream _out = new FileOutputStream(_file) ;
                int len = 0 ;
                while( (len = _in.read(_byte)) > 0){
                    _out.write(_byte, 0, len);
                }
                _in.close();
                _out.flush();
                _out.close();
            }
        }
    }


    public static void main(String[] args)
    {
        ZipUtil zipCom = new ZipUtil();
        try
        {
            //zipCom.zip("c:\\temp\\111.zip","c:\\temp\\ppp");
            zipCom.upzipFile("c:\\temp\\111.zip","c:\\temp\\xxx");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}




