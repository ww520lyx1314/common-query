package com.tfkj.common.domain;



import java.util.List;


/**
 * 
 * 
 * @author rjwangwei
 * @email 1992lcg@163.com
 * @date 2018-09-11 16:12:02
 */
public class SmryBaseDO extends DataEntity<SmryBaseDO> {
	private static final long serialVersionUID = 1L;
	
	//id
	private String id;
	//姓名
	private String name;
	//性别
	private String sex;
	//出生年月
	private String gj;
	//用于首页查询
	private Integer ageStart;
	private Integer ageEnd;
	private Integer ageSy;
	//民族
	private String mz;
	//曾用名
	private String cym;
	//身份证号
	private String idcard;
	//政治面貌
	private String zzms;
	//联系方式
	private String lxfs;
	//户籍地址
	private String hjdz;
	//户籍公安机关
	private String hjdgajg;
	//常住地址
	private String czdz;
	//常住地址公安机关
	private String czdgajg;
	//照片
	private String photo;
	//职务及职称
	private String zwzc;
	//担任涉密岗位
	private String drsmgw;
	//涉密等级
	private String smdj;
	//持有因公出入境证件情况
	private String ygcrjqk;
	//持有因私出入境证件情况
	private String ygcrjqkzj;
	//拥有外籍、境外永久居留权
	private String wjyjjlq;
	//本人及配偶，子女存在不得任（聘）用到涉密岗位工作的情形
	private String brjsmgw;
	//其他需要说明的情况
	private String qtsm;

	//证件号码
	private String extend1;
	//状态 1为涉密人员，2为脱密人员，3为历史人员
	private String extend2;
	//脱密期开始时间
	private String extend3;
	//脱密期结束时间
	private String extend4;

	//所属单位
	private String ssdw;

	//所属部门
	private String ssbm;

	//入岗时间
	private String rgsj;

	//是否审查
	private String sfsc;

	//审查时间
	private String scsj;

	//培训次数
	private Integer pxcs;

	//培训总学时
	private Integer pxzxs;
	//用于前台传参
	private Integer pxzxsStart;
	private Integer pxzxsEnd;


	//平均成绩
	private Double pjcj;

	//顺序号（用于默认排序）
	private Integer sxh;




	public Integer getPxzxsStart() {
		return pxzxsStart;
	}

	public void setPxzxsStart(Integer pxzxsStart) {
		this.pxzxsStart = pxzxsStart;
	}

	public Integer getPxzxsEnd() {
		return pxzxsEnd;
	}

	public void setPxzxsEnd(Integer pxzxsEnd) {
		this.pxzxsEnd = pxzxsEnd;
	}

	public Integer getAgeStart() {
		return ageStart;
	}

	public void setAgeStart(Integer ageStart) {
		this.ageStart = ageStart;
	}

	public Integer getAgeEnd() {
		return ageEnd;
	}

	public void setAgeEnd(Integer ageEnd) {
		this.ageEnd = ageEnd;
	}

	public Integer getAgeSy() {
		return ageSy;
	}

	public void setAgeSy(Integer ageSy) {
		this.ageSy = ageSy;
	}

	/**
	 * 设置：id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：国籍
	 */
	public void setGj(String gj) {
		this.gj = gj;
	}
	/**
	 * 获取：国籍
	 */
	public String getGj() {
		return gj;
	}
	/**
	 * 设置：民族
	 */
	public void setMz(String mz) {
		this.mz = mz;
	}
	/**
	 * 获取：民族
	 */
	public String getMz() {
		return mz;
	}
	/**
	 * 设置：曾用名
	 */
	public void setCym(String cym) {
		this.cym = cym;
	}
	/**
	 * 获取：曾用名
	 */
	public String getCym() {
		return cym;
	}
	/**
	 * 设置：身份证号
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	/**
	 * 获取：身份证号
	 */
	public String getIdcard() {
		return idcard;
	}
	/**
	 * 设置：政治面貌
	 */
	public void setZzms(String zzms) {
		this.zzms = zzms;
	}
	/**
	 * 获取：政治面貌
	 */
	public String getZzms() {
		return zzms;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLxfs() {
		return lxfs;
	}
	/**
	 * 设置：户籍地址
	 */
	public void setHjdz(String hjdz) {
		this.hjdz = hjdz;
	}
	/**
	 * 获取：户籍地址
	 */
	public String getHjdz() {
		return hjdz;
	}
	/**
	 * 设置：户籍公安机关
	 */
	public void setHjdgajg(String hjdgajg) {
		this.hjdgajg = hjdgajg;
	}
	/**
	 * 获取：户籍公安机关
	 */
	public String getHjdgajg() {
		return hjdgajg;
	}
	/**
	 * 设置：常住地址
	 */
	public void setCzdz(String czdz) {
		this.czdz = czdz;
	}
	/**
	 * 获取：常住地址
	 */
	public String getCzdz() {
		return czdz;
	}
	/**
	 * 设置：常住地址公安机关
	 */
	public void setCzdgajg(String czdgajg) {
		this.czdgajg = czdgajg;
	}
	/**
	 * 获取：常住地址公安机关
	 */
	public String getCzdgajg() {
		return czdgajg;
	}
	/**
	 * 设置：照片
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * 获取：照片
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * 设置：职务及职称
	 */
	public void setZwzc(String zwzc) {
		this.zwzc = zwzc;
	}
	/**
	 * 获取：职务及职称
	 */
	public String getZwzc() {
		return zwzc;
	}
	/**
	 * 设置：担任涉密岗位
	 */
	public void setDrsmgw(String drsmgw) {
		this.drsmgw = drsmgw;
	}
	/**
	 * 获取：担任涉密岗位
	 */
	public String getDrsmgw() {
		return drsmgw;
	}
	/**
	 * 设置：涉密等级
	 */
	public void setSmdj(String smdj) {
		this.smdj = smdj;
	}
	/**
	 * 获取：涉密等级
	 */
	public String getSmdj() {
		return smdj;
	}
	/**
	 * 设置：持有因公出入境证件情况
	 */
	public void setYgcrjqk(String ygcrjqk) {
		this.ygcrjqk = ygcrjqk;
	}
	/**
	 * 获取：持有因公出入境证件情况
	 */
	public String getYgcrjqk() {
		return ygcrjqk;
	}
	/**
	 * 设置：持有因私出入境证件情况
	 */
	public void setYgcrjqkzj(String ygcrjqkzj) {
		this.ygcrjqkzj = ygcrjqkzj;
	}
	/**
	 * 获取：持有因私出入境证件情况
	 */
	public String getYgcrjqkzj() {
		return ygcrjqkzj;
	}
	/**
	 * 设置：拥有外籍、境外永久居留权
	 */
	public void setWjyjjlq(String wjyjjlq) {
		this.wjyjjlq = wjyjjlq;
	}
	/**
	 * 获取：拥有外籍、境外永久居留权
	 */
	public String getWjyjjlq() {
		return wjyjjlq;
	}
	/**
	 * 设置：本人及配偶，子女存在不得任（聘）用到涉密岗位工作的情形
	 */
	public void setBrjsmgw(String brjsmgw) {
		this.brjsmgw = brjsmgw;
	}
	/**
	 * 获取：本人及配偶，子女存在不得任（聘）用到涉密岗位工作的情形
	 */
	public String getBrjsmgw() {
		return brjsmgw;
	}
	/**
	 * 设置：其他需要说明的情况
	 */
	public void setQtsm(String qtsm) {
		this.qtsm = qtsm;
	}
	/**
	 * 获取：其他需要说明的情况
	 */
	public String getQtsm() {
		return qtsm;
	}

	/**
	 * 设置：
	 */
	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}
	/**
	 * 获取：
	 */
	public String getExtend1() {
		return extend1;
	}
	/**
	 * 设置：
	 */
	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}
	/**
	 * 获取：
	 */
	public String getExtend2() {
		return extend2;
	}
	/**
	 * 设置：
	 */
	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}
	/**
	 * 获取：
	 */
	public String getExtend3() {
		return extend3;
	}
	/**
	 * 设置：
	 */
	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}
	/**
	 * 获取：
	 */
	public String getExtend4() {
		return extend4;
	}

	public String getSsdw() {
		return ssdw;
	}

	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}

	public String getSsbm() {
		return ssbm;
	}

	public void setSsbm(String ssbm) {
		this.ssbm = ssbm;
	}

	public String getRgsj() {
		return rgsj;
	}

	public void setRgsj(String rgsj) {
		this.rgsj = rgsj;
	}

	public String getSfsc() {
		return sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}

	public String getScsj() {
		return scsj;
	}

	public void setScsj(String scsj) {
		this.scsj = scsj;
	}

	public Integer getPxcs() {
		return pxcs;
	}

	public void setPxcs(Integer pxcs) {
		this.pxcs = pxcs;
	}

	public Integer getPxzxs() {
		return pxzxs;
	}

	public void setPxzxs(Integer pxzxs) {
		this.pxzxs = pxzxs;
	}

	public Double getPjcj() {
		return pjcj;
	}

	public void setPjcj(Double pjcj) {
		this.pjcj = pjcj;
	}

	public Integer getSxh() {
		return sxh;
	}

	public void setSxh(Integer sxh) {
		this.sxh = sxh;
	}

	/*public String getSmdjText() {
		String str="";
		str=dictService.getName("YW_SMDJ", getSmdj());
		return	str;
	}
	public String getDrsmgwText() {
		String smgw="";
		if(StringUtils.isNotBlank(this.drsmgw)){
			SmgwDO smgwDO=smgwService.get(this.drsmgw.substring(0,drsmgw.length()-1));
			if(smgwDO!=null){
				smgw=smgwDO.getDeptName();
			}
		}
		return smgw;
	}*/
}
