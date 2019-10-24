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

import com.yaic.app.common.dao.AddressDao;
import com.yaic.app.common.dao.ContactsDao;
import com.yaic.app.common.dto.domain.AddressDto;
import com.yaic.app.common.dto.domain.ContactsDto;
import com.yaic.app.common.util.Util;
import com.yaic.app.common.vo.ResponseMsg;

/** 
 * @ClassName: AddressService 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年5月21日 下午5:54:37  
 */
@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

	/** 
	* @Title: addOrUpdate 
	* @date 2019年5月21日下午5:54:56
	*/ 
	public ResponseMsg<?> addOrUpdate(AddressDto addressDto) {
		if (addressDto.getAddressId() != null && !"".equals(addressDto.getAddressId())) {
			addressDao.update(addressDto);
			return ResponseMsg.Response(ResponseMsg.OK, "修改成功！",null);
			
		}
		addressDto.setAddressId(Util.getUUID ());
		addressDao.insert(addressDto);
		return ResponseMsg.Response(ResponseMsg.OK, "添加成功！",null);
	}


	/** 
	* @Title: addressList 
	*/ 
	public ResponseMsg<?> list(AddressDto addressDto) {
		if (StringUtils.isBlank(addressDto.getUserId())) {
            logger.warn("/address/list:args is null.");
            return ResponseMsg.Response(ResponseMsg.FAI, "参数不能为空！", null);
        }
		 List<AddressDto> list = addressDao.list(addressDto);
		return ResponseMsg.Response(ResponseMsg.OK, "查询成功", list);
	}


	/** 
	* @Title: delete 
	*/ 
	public ResponseMsg<?> delete(String addressId) {
		if (StringUtils.isBlank(addressId) ) {
			return ResponseMsg.Response(ResponseMsg.FAI, "参数异常！", null);
		}
		addressDao.delete(addressId);
		return ResponseMsg.Response(ResponseMsg.OK, "删除成功！", null);
	}

}
