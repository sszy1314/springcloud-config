/**
 * 
 */
package com.yaic.app.common.dao;

import org.apache.ibatis.annotations.Param;

import com.yaic.app.common.dto.domain.UserDto;

/** 
 * @ClassName: UserDao 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月14日 下午2:29:25  
 */
public interface UserDao {

	public UserDto selectOne(UserDto userDto);
	public void insert(UserDto userDto);
	public void updateUser(UserDto userDto);
	public void updateIdentity(UserDto user);
}
