/**
 * 
 */
package com.yaic.app.common.dto.domain;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/** 
 * @ClassName: UserDto 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月13日 下午2:57:24  
 */
@Table(name = "app_user")
public class UserDto extends Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//用户ID
	private String userId;
	//用户手机号
	private String mobile;	
	//用户名
	private String userName;
	//用户密码
	private String passWord;
	//用户邮箱
	private String email;
	//注册时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	private Date createdDate = new Date();
	//昵称
	private String userNickname;
	//头像URL
	private String userImgUrl;
	//身份证姓名
	private String userCertificateName = "null";
	//身份证号码
	private String userCertificateNumber = "null";

	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserImgUrl() {
		return userImgUrl;
	}
	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}
	public String getUserCertificateName() {
		return userCertificateName;
	}
	public void setUserCertificateName(String userCertificateName) {
		this.userCertificateName = userCertificateName;
	}
	public String getUserCertificateNumber() {
		return userCertificateNumber;
	}
	public void setUserCertificateNumber(String userCertificateNumber) {
		this.userCertificateNumber = userCertificateNumber;
	}
	
	
	
}
