/**
 * 
 */
package com.yaic.app.common.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.app.common.dao.ContactsDao;
import com.yaic.app.common.dto.domain.ContactsDto;
import com.yaic.app.common.util.Util;
import com.yaic.app.common.vo.ResponseMsg;

/** 
 * @ClassName: ContactsServic 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月26日 下午7:29:59  
 */
@Service
public class ContactsService {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactsService.class);

	@Autowired
	private ContactsDao contactsDao;
	//新增联系人
	public ResponseMsg<?> insert(ContactsDto contacts) {
		ContactsDto contactsInfo = selectOne(contacts);
		if (contactsInfo == null) {
			contacts.setContactsId(Util.getUUID ());
			int num = contactsDao.insert(contacts);
			if (num > 0) {
				return ResponseMsg.Response(ResponseMsg.OK, "添加成功！", contacts.getContactsId());
			}else {
				return ResponseMsg.Response(ResponseMsg.ERROR, "数据异常,请联系客管理员！", null);
			}
		}
		return ResponseMsg.Response(ResponseMsg.FAI, "联系人已存在！", null);
	}

	public List<ContactsDto> contactsList(ContactsDto contacts) {
		return contactsDao.contactsList(contacts);
	}
	public ContactsDto selectOne(ContactsDto contacts) {
		return contactsDao.selectOne(contacts);
		
	}
	//修改联系人
	public ResponseMsg<?> update(ContactsDto contacts) {
		//根据用户ID查询和身份证号查询
		ContactsDto contactsInfo = selectOne(contacts);
		if (contactsInfo != null &&  !contactsInfo.getContactsId().equals(contacts.getContactsId())) {
			return ResponseMsg.Response(ResponseMsg.FAI, "联系人已存在！",  contacts.getContactsId());
		}	
		int num = contactsDao.update(contacts);
		if (num > 0) {
			return ResponseMsg.Response(ResponseMsg.OK, "修改成功！",  contacts.getContactsId());
		}else {
			return ResponseMsg.Response(ResponseMsg.ERROR, "数据异常,请联系管理员！", null);
		}
	}

	/** 
	* @Title: addOrUpdate 
	* @Description: TODO 
	* @param contacts
	* @return ResponseMsg<?>
	* @author chenlong
	* @date 2019年3月28日下午3:24:56
	*/ 
	public ResponseMsg<?> addOrUpdate(ContactsDto contacts) {
		ResponseMsg<?> insertStatus = insert(contacts);
		if (insertStatus.getStatus() == -1) {
			return update(contacts);
		}else if(insertStatus.getStatus() == 1){
			return insertStatus;	
		}else {
			return insertStatus;
		}
	}

	/** 
	* @Title: delete 
	* @Description: TODO 
	* @param contactsId
	* @return ResponseMsg<?>
	* @author chenlong
	 * @param contactsId 
	* @date 2019年4月28日下午5:39:12
	*/ 
	public ResponseMsg<?> delete(String contactsId) {
		if (StringUtils.isBlank(contactsId) ) {
			return ResponseMsg.Response(ResponseMsg.FAI, "参数不能为空！", null);
		}
		int num = contactsDao.delete(contactsId);
		if (num>0) {
			return ResponseMsg.Response(ResponseMsg.OK, "删除成功！", null);
		}
		return ResponseMsg.Response(ResponseMsg.ERROR, "数据异常,请联系管理员！", null);
	}

}
