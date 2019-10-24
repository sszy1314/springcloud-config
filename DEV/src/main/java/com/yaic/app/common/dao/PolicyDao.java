/**
 * 
 */
package com.yaic.app.common.dao;

import java.util.List;
import java.util.Map;

import com.yaic.app.common.dto.domain.PolicyDto;
import com.yaic.app.common.dto.domain.UserDto;

/** 
 * @ClassName: PolicyDao 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月28日 下午4:59:42  
 */
public interface PolicyDao {

	/** 
	* @Title: addPolicy 
	* @Description: TODO 
	* @param policyDto void
	* @author chenlong
	* @date 2019年3月28日下午5:00:11
	*/ 
	public void insert(PolicyDto policyDto);
	public List<PolicyDto> list(PolicyDto policyDto);
	public Map<String,Object> selPolicy(String policyId);
	public int payPolicy(String policyId);

}
