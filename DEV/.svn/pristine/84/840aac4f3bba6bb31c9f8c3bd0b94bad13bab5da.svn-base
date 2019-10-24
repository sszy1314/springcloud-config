/**
 * 
 */
package com.yaic.app.common.dto.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

/** 
 * @ClassName: PolicyDto 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月28日 下午3:10:58  
 */
public class PolicyDto extends Dto{
	private static final long serialVersionUID = 1L;
	//保单号
	@Id
	private String policyId;
	@Transient
	private List<ContactsDto> buyerPolicy; 
	@Transient
	private List<ContactsDto> recognizeePolicy; 
	//用户ID
	private String userId;
	//保险ID
	private String insuranceId;
	//保险名
	private String insuranceName;
	//保单状态0未付款/已付款
	private Integer policyStatus;
	//保单份额
	private Integer policyHare;
	//保单创建生效时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	private Date policyCreateDate;
	//保单生效时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	private Date policyStartDate;
	//保单结束时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8") 
	private Date policyEndDate;
	//保单金额
	private BigDecimal policySum;
	//投保人ID
	private String buyerContactsId;
	//被保人ID
	private String recognizeeContactsId;
	//投保人被保人关系-1本人-2父母-3配偶-4子女
	private Integer buyerRecognizeeRelation;
	
	
	public Integer getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(Integer policyStatus) {
		this.policyStatus = policyStatus;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public List<ContactsDto> getBuyerPolicy() {
		return buyerPolicy;
	}
	public void setBuyerPolicy(List<ContactsDto> buyerPolicy) {
		this.buyerPolicy = buyerPolicy;
	}
	public List<ContactsDto> getRecognizeePolicy() {
		return recognizeePolicy;
	}
	public void setRecognizeePolicy(List<ContactsDto> recognizeePolicy) {
		this.recognizeePolicy = recognizeePolicy;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getInsuranceName() {
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public Integer getPolicyHare() {
		return policyHare;
	}
	public void setPolicyHare(Integer policyHare) {
		this.policyHare = policyHare;
	}
	public Date getPolicyCreateDate() {
		return policyCreateDate;
	}
	public void setPolicyCreateDate(Date policyCreateDate) {
		this.policyCreateDate = policyCreateDate;
	}
	public Date getPolicyStartDate() {
		return policyStartDate;
	}
	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}
	public Date getPolicyEndDate() {
		return policyEndDate;
	}
	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}
	public String getBuyerContactsId() {
		return buyerContactsId;
	}
	public BigDecimal getPolicySum() {
		return policySum;
	}
	public void setPolicySum(BigDecimal policySum) {
		this.policySum = policySum;
	}
	public void setBuyerContactsId(String buyerContactsId) {
		this.buyerContactsId = buyerContactsId;
	}
	public String getRecognizeeContactsId() {
		return recognizeeContactsId;
	}
	public void setRecognizeeContactsId(String recognizeeContactsId) {
		this.recognizeeContactsId = recognizeeContactsId;
	}
	public Integer getBuyerRecognizeeRelation() {
		return buyerRecognizeeRelation;
	}
	public void setBuyerRecognizeeRelation(Integer buyerRecognizeeRelation) {
		this.buyerRecognizeeRelation = buyerRecognizeeRelation;
	}
	
	
	
}
