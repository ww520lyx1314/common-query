package com.tfkj.common.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="tfkj")
public class BootdoConfig {
	//上传路径
	private String uploadPath;

	private String photoSize;

	private String photoType;

	private String customTplSecretKey;

	public String getCustomTplSecretKey() {
		return customTplSecretKey;
	}

	public void setCustomTplSecretKey(String customTplSecretKey) {
		this.customTplSecretKey = customTplSecretKey;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getPhotoSize() {
		return photoSize;
	}

	public void setPhotoSize(String photoSize) {
		this.photoSize = photoSize;
	}

	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
}
