/**
 * 
 */
package com.yaic.app.common.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaic.app.common.dto.domain.ContactsDto;
import com.yaic.app.common.service.ContactsService;
import com.yaic.app.common.util.Util;
import com.yaic.app.common.vo.ResponseMsg;

/** 
 * @ClassName: ContactsController 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月26日 下午7:27:59  
 */
@Controller  
@RequestMapping("/contacts")  
public class ContactsController {
	private static final Logger logger = LoggerFactory.getLogger(ContactsController.class);
	@Autowired
    private ContactsService contactsServic;
	
	/**
	 *添加或修改联系人
	 * @param ContactsDto
	 * @return Response
	 */
	@PostMapping("/addOrUpdate")  
	@ResponseBody  
	public ResponseMsg<?> addOrUpdate(@RequestBody ContactsDto contacts) {	
		if (StringUtils.isBlank(contacts.getContactsId())) {
			return contactsServic.insert(contacts);
		}
		return contactsServic.update(contacts);
	}	/**
	 *删除联系人
	 * @param ContactsDto
	 * @return Response
	 */
	@PostMapping("/delete")  
	@ResponseBody  
	public ResponseMsg<?> delete(@RequestBody String  contactsId) {	
		return contactsServic.delete(contactsId);
	}
	/**
	 *全部联系人
	 * @param ContactsDto:userId
	 * @return Response
	 */
	@PostMapping("/list")  
    @ResponseBody  
    public ResponseMsg<?> contactsList(@RequestBody ContactsDto contacts) {
    	 if (StringUtils.isBlank(contacts.getUserId())) {
             logger.warn("/contacts/list:args is null.");
             return ResponseMsg.Response(ResponseMsg.FAI, "参数不能为空！", null);
         }
    	List<ContactsDto> list = contactsServic.contactsList(contacts);
		return ResponseMsg.Response(ResponseMsg.OK, "查询成功", list);
    }
    
}
