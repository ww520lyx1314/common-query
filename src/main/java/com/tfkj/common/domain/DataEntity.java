/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tfkj.common.domain;

import com.tfkj.common.utils.IdGen;
import org.apache.commons.lang3.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据Entity类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;

	protected String remarks; // 备注
	protected UserDO createBy; // 创建者
	protected String createDate; // 创建日期
	protected UserDO updateBy; // 更新者
	protected String updateDate; // 更新日期
	protected String delFlag; // 删除标记（0：正常；1：删除；2：审核）

	public DataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public DataEntity(String id) {
		super(id);
	}

	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert() {
		// 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
		if (!this.isNewRecord) {
			setId(IdGen.uuid());
		}
		UserDO user = null;
		/*if (StringUtils.isNotBlank(user.getUserId().toString())) {
			this.updateBy = user;
			this.createBy = user;
		}*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.updateDate = sdf.format(new Date());
		this.createDate = this.updateDate;

	}

	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate() {
		UserDO user = null;
		/*if (StringUtils.isNotBlank(user.getUserId().toString())) {
			this.updateBy = user;
		}*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.updateDate = sdf.format(new Date());
	}


	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public UserDO getCreateBy() {
		return createBy;
	}

	public void setCreateBy(UserDO createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	public UserDO getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(UserDO updateBy) {
		this.updateBy = updateBy;
	}


	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "DataEntity [remarks=" + remarks + ", createBy=" + createBy + ", createDate=" + createDate + ", updateBy=" + updateBy + ", updateDate=" + updateDate + ", delFlag=" + delFlag + "]";
	}

}
