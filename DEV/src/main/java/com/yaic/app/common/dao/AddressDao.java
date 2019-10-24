/**
 * 
 */
package com.yaic.app.common.dao;

import java.util.List;

import com.yaic.app.common.dto.domain.AddressDto;
import com.yaic.app.common.vo.ResponseMsg;

/** 
 * @ClassName: AddressDao 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年5月21日 下午5:58:36  
 */
public interface AddressDao {
	public void update(AddressDto addressDto);
	public void insert(AddressDto addressDto);
	public List<AddressDto> list(AddressDto addressDto);
	public void delete(String addressId);

}
