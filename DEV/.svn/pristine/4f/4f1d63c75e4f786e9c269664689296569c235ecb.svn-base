/**
 * 
 */
package com.yaic.app.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.app.common.dao.ContactsDao;
import com.yaic.app.common.dao.PolicyDao;
import com.yaic.app.common.dto.domain.PolicyDto;
import com.yaic.app.common.dto.domain.UserDto;

/** 
 * @ClassName: PolicyServic 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月28日 下午4:51:32  
 */
@Service
public class PolicyService {
	@Autowired
	private PolicyDao policyDao;
	/** 
	* @Title: addPolicy 
	* @Description: TODO 
	* @param policyDto void
	* @author chenlong
	* @date 2019年3月28日下午4:53:56
	*/ 
	public void insert(PolicyDto policyDto) {
		policyDao.insert(policyDto);
	}
	/** 
	* @Title: policyList 
	* @Description: TODO 
	* @param user
	* @return List<PolicyDto>
	* @author chenlong
	* @date 2019年3月29日下午4:11:29
	*/ 
	public List<PolicyDto> list(PolicyDto policyDto) {
		return policyDao.list(policyDto);
	}
	/** 
	* @Title: selPolicy 
	* @param policyId
	* @return List
	*/ 
	public Map<String,Object> selPolicy(String policyId) {
		return policyDao.selPolicy(policyId);
	}
	public int payPolicy(String policyId) {
		return policyDao.payPolicy(policyId);
	}

}
