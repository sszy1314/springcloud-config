/**
 * 
 */
package com.yaic.app.common.dto.domain;

import java.util.Date;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/** 
 * @ClassName: ContactsDto 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月26日 下午5:29:53  
 */
public class ContactsDto extends Dto{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//常用联系人ID
	private String contactsId;
	//关联用户ID
	private String userId;
	//联系人名字
	private String contactsName;
	//出生年月日
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	private Date contactsBirthday;
	//联系人性别-1男-2女
	private Integer contactsSex;
	//联系人证件类型1身份证-2护照-3港澳台居民居住证
	private Integer contactsCertificate;
	//联系人证件号码
	private String contactsCertificateNumber;
	//联系人电话
	private String contactsMobile;
	//联系人邮箱
	private String contactsEmail;
	//联系人0正常/1逻辑删除
	private Integer contactsStatus;
	
	public Integer getContactsStatus() {
		return contactsStatus;
	}
	public void setContactsStatus(Integer contactsStatus) {
		this.contactsStatus = contactsStatus;
	}
	public String getContactsId() {
		return contactsId;
	}
	public void setContactsId(String contactsId) {
		this.contactsId = contactsId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContactsName() {
		return contactsName;
	}
	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}
	
	public Date getContactsBirthday() {
		return contactsBirthday;
	}
	public void setContactsBirthday(Date contactsBirthday) {
		this.contactsBirthday = contactsBirthday;
	}
	public Integer getContactsSex() {
		return contactsSex;
	}
	public void setContactsSex(Integer contactsSex) {
		this.contactsSex = contactsSex;
	}
	public Integer getContactsCertificate() {
		return contactsCertificate;
	}
	public void setContactsCertificate(Integer contactsCertificate) {
		this.contactsCertificate = contactsCertificate;
	}
	public String getContactsCertificateNumber() {
		return contactsCertificateNumber;
	}
	public void setContactsCertificateNumber(String contactsCertificateNumber) {
		this.contactsCertificateNumber = contactsCertificateNumber;
	}
	public String getContactsMobile() {
		return contactsMobile;
	}
	public void setContactsMobile(String contactsMobile) {
		this.contactsMobile = contactsMobile;
	}
	public String getContactsEmail() {
		return contactsEmail;
	}
	public void setContactsEmail(String contactsEmail) {
		this.contactsEmail = contactsEmail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
