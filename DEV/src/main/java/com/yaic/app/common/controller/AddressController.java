/**
 * 
 */
package com.yaic.app.common.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaic.app.common.dto.domain.AddressDto;
import com.yaic.app.common.dto.domain.ContactsDto;
import com.yaic.app.common.service.AddressService;
import com.yaic.app.common.vo.ResponseMsg;

/** 
 * @ClassName: AddressController 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月26日 下午7:27:59  
 */
@Controller  
@RequestMapping("/address")  
public class AddressController {
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	@Autowired
    private AddressService addressService;
	
	/**
	 *添加或修改常用地址
	 * @param AddressDto
	 * @return Response
	 */
	@PostMapping("/addOrUpdate")  
	@ResponseBody  
	public ResponseMsg<?> addOrUpdate(@RequestBody AddressDto addressDto) {	
		return addressService.addOrUpdate(addressDto);
	}
	/**
	 *常用地址列表
	 * @param AddressDto
	 * @return Response
	 */
	@PostMapping("/list")  
	@ResponseBody  
	public ResponseMsg<?> list(@RequestBody AddressDto addressDto) {	
		return addressService.list(addressDto);
	}
	/**
	 *删除常用地址
	 * @param AddressDto
	 * @return Response
	 */
	@PostMapping("/delete")  
	@ResponseBody  
	public ResponseMsg<?> delete(@RequestBody String addressId) {	
		return addressService.delete(addressId);
	}
	
    
}
