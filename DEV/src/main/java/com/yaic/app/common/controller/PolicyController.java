/**
 * 
 */
package com.yaic.app.common.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yaic.app.common.dto.domain.ContactsDto;
import com.yaic.app.common.dto.domain.PolicyDto;
import com.yaic.app.common.dto.domain.UserDto;
import com.yaic.app.common.service.ContactsService;
import com.yaic.app.common.service.PolicyService;
import com.yaic.app.common.util.GetTimeNumber;
import com.yaic.app.common.vo.ResponseMsg;

/** 
 * @ClassName: PolicyController 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月28日 下午2:06:42  
 */
@Controller  
@RequestMapping("/policy")  
public class PolicyController {
	private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);
	@Autowired
    private ContactsService contactsService;
	@Autowired
    private PolicyService  policyService;

	/**
	 * 保单详情
	 * @param ContactsDto:userId
	 * @return Response
	 */
	@PostMapping("/selPolicy")  
    @ResponseBody  
    public ResponseMsg<?> selPolicy(@RequestBody String  policyId ) {
		 if (StringUtils.isBlank(policyId) ) {
		     logger.warn("/policy/list:args is null.");
		     return ResponseMsg.Response(ResponseMsg.FAI, "参数不能为空！", null);
		 }
		
		 Map<String,Object> map= policyService.selPolicy(policyId);
		return ResponseMsg.Response(ResponseMsg.OK, "查询成功", map);
    }
	/**
	 * 保单支付
	 * @param ContactsDto:userId
	 * @return Response
	 */
	@PostMapping("/payPolicy")  
    @ResponseBody  
    public ResponseMsg<?> payPolicy(@RequestBody String  policyId ) {
		 if (StringUtils.isBlank(policyId) ) {
		     logger.warn("/policy/list:args is null.");
		     return ResponseMsg.Response(ResponseMsg.FAI, "参数不能为空！", null);
		 }
		
		 int num= policyService.payPolicy(policyId);
		 if (num>0) {
			 return ResponseMsg.Response(ResponseMsg.OK, "支付成功", null);
		}
		return ResponseMsg.Response(ResponseMsg.FAI, "支付失败", null);
    }
	/**
	 *全部保单
	 * @param ContactsDto:userId
	 * @return Response
	 */
	@PostMapping("/list")  
    @ResponseBody  
    public ResponseMsg<?> list(@RequestBody PolicyDto policyDto ) {
		 if (StringUtils.isBlank(policyDto.getUserId()) | null == policyDto.getPolicyStatus() ) {
		     logger.warn("/policy/list:args is null.");
		     return ResponseMsg.Response(ResponseMsg.FAI, "参数不能为空！", null);
		 }
		 Integer policyStatus =  policyDto.getPolicyStatus();
		 if (policyStatus  == 0) {
			 policyDto.setPolicyStartDate(new Date());
		}else{
			 policyDto.setPolicyEndDate(new Date());
		}
    	List<PolicyDto> list = policyService.list(policyDto);
		return ResponseMsg.Response(ResponseMsg.OK, "查询成功", list);
    }
	/**
	 *添加保单
	 * @param ContactsDto:userId
	 * @return Response
	 */
    @PostMapping("/addPolicy")  
    @ResponseBody  
    public ResponseMsg<?> addPolicy(@RequestBody PolicyDto  policyDtoJson) {
    	//投保人
    	List<ContactsDto> buyerPolicy = policyDtoJson.getBuyerPolicy();
    	ResponseMsg<?> buyer = contactsService.addOrUpdate( buyerPolicy.get(0));
    	if (buyer.getStatus() == -2) {
    		return buyer;
		}
    	//被保人
    	List<ContactsDto> recognizeePolicy = policyDtoJson.getRecognizeePolicy();
    	ResponseMsg<?> recognizee = contactsService.addOrUpdate( recognizeePolicy.get(0));
    	if (recognizee.getStatus() == -2) {
    		return recognizee;
		}
    	
    	policyDtoJson.setPolicyCreateDate(new Date());
    	policyDtoJson.setPolicyStatus(0);
    	policyDtoJson.setPolicyId(GetTimeNumber.getGuid());
    	policyDtoJson.setBuyerContactsId(buyer.getBody().toString());
    	policyDtoJson.setRecognizeeContactsId(recognizee.getBody().toString());
    	policyService.insert(policyDtoJson);
    	logger.info("用户 " + "[" + policyDtoJson.getUserId() + "] 生成保单 ");
    	Map<String,Object> map = policyService.selPolicy(policyDtoJson.getPolicyId());
		return ResponseMsg.Response(ResponseMsg.OK, "生成保单待支付！", map);
    }
}
