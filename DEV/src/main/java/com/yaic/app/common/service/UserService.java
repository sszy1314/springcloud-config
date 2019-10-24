/**
 * 
 */
package com.yaic.app.common.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.app.common.dao.UserDao;
import com.yaic.app.common.dto.domain.UserDto;
import com.yaic.app.common.util.MD5;
import com.yaic.app.common.util.Util;
import com.yaic.app.common.vo.ResponseMsg;

/** 
 * @ClassName: UserService 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月14日 下午2:16:29  
 */
@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;
	//秘钥
	private String secretKey = "pwp";
	
	/** 
	* 登录
	* @param userDto
	*/ 
	public ResponseMsg<?> login(UserDto user) {
		if(StringUtils.isBlank(user.getUserName()) | StringUtils.isBlank(user.getPassWord())){
            return ResponseMsg.Response(ResponseMsg.FAI, "参数不能为空！", null);
        }
    	UserDto userInfo =selectOne(user);
    	if (userInfo != null) {
			if (MD5.verify(user.getPassWord(), userInfo.getPassWord(),secretKey, "UTF-8")) {
				userInfo.setPassWord("***");
				logger.info("用户 " + "[" + user.getUserName() + "] 登陆成功 ");
				return ResponseMsg.Response(ResponseMsg.OK, "登录成功！", userInfo);
			}
			return ResponseMsg.Response(ResponseMsg.FAI, "账号或密码错误！", null);
		}
    	return ResponseMsg.Response(ResponseMsg.FAI, "账号或密码错误！", null);
	}
	
	/** 
	* 查询一条用户信息
	* @param userDto
	*/ 
	public UserDto selectOne(UserDto user) {
		return userDao.selectOne(user);

	}
	
	

	/** 
	* @Title: insert 
	* @Description: TODO 
	* @param user void
	* @author chenlong
	* @date 2019年3月19日下午5:24:54
	*/ 
	public ResponseMsg<?> insert(UserDto user) {
		if(user == null) {
   		 return ResponseMsg.Response(ResponseMsg.FAI, "参数不能为空！", null);
	   	}
		//用户名查询
		UserDto userDto = new UserDto();
		userDto.setUserName(user.getUserName());
		
	   	UserDto userInfo =selectOne(userDto);
	   	if (userInfo != null) {
	   		 return ResponseMsg.Response(ResponseMsg.FAI, "已注册", null); 
			}
	   	user.setUserId(Util.getUUID ());
	   	user.setCreatedDate(new Date());
	   	String passwoed = MD5.sign(user.getPassWord(), secretKey, "UTF-8");
	   	user.setPassWord(passwoed);
	   	userDao.insert(user);
	   	logger.info("用户 " + "[" + user.getUserName() + "] 注册成功 ");
	   	return ResponseMsg.Response(ResponseMsg.OK, "注册成功！", null);
	}

	/** 
	* @Title: updatePassword 
	* @Description: TODO 
	* @param userId
	* @param passWord void
	* @author chenlong
	* @date 2019年3月28日上午9:58:48
	*/ 
	public ResponseMsg<?> updatePassword(UserDto user) {
		if(StringUtils.isBlank(user.getUserName()) | StringUtils.isBlank(user.getMobile()) ){
            return ResponseMsg.Response(ResponseMsg.FAI, "参数不能为空！", null);
        }
    	UserDto userInfo = selectOne(user);
    	if (userInfo != null) {
    		if (StringUtils.isBlank(user.getPassWord())) {
    			return ResponseMsg.Response(ResponseMsg.OK,"验证通过", null);
			}
    		//为了公用sql而创建实体，同时避免脏数据
    		UserDto userDto = new UserDto();
    		userDto.setPassWord(MD5.sign(user.getPassWord(), secretKey, "UTF-8"));
    		userDto.setUserId(user.getUserId());
    		userDao.updateUser(userDto);
    		logger.info("用户 " + "[" + user.getUserName() + "] 修改密码成功 ");
			return ResponseMsg.Response(ResponseMsg.OK, "修改成功！", null);
		}
    	return ResponseMsg.Response(ResponseMsg.FAI, "参数错误！", null);
	}

	/** 
	* @Title: delIdentity 
	* @param userId
	* @return ResponseMsg<?>
	*/ 
	public ResponseMsg<?> delIdentity(String userId) {
		if (StringUtils.isBlank(userId) ) {
			return ResponseMsg.Response(ResponseMsg.FAI, "参数异常！", null);
		}
		UserDto user = new UserDto();
		user.setUserId(userId);
		userDao.updateIdentity(user);
		return ResponseMsg.Response(ResponseMsg.OK, "解除成功！", null);
	}

	/** 
	* @Title: addIdentity 
	* @param user
	* @return ResponseMsg<?>
	*/ 
	public ResponseMsg<?> addIdentity(UserDto user) {
		if (StringUtils.isBlank(user.getUserId()) ) {
			return ResponseMsg.Response(ResponseMsg.FAI, "参数异常！", null);
		}
		userDao.updateIdentity(user);
		return ResponseMsg.Response(ResponseMsg.OK, "认证成功！", null);
	}
	/** 
	* @Title: updateUserName
	* @Description: TODO 
	* @param UserDto
	* @author chenlong
	* @date 2019年3月28日上午9:58:48
	*/ 
	public ResponseMsg<?> updateUserNickname(UserDto user) {
		if( StringUtils.isBlank(user.getUserId()) | StringUtils.isBlank(user.getUserNickname()) ){
            return ResponseMsg.Response(ResponseMsg.FAI, "参数不能为空！", null);
        }
    		//为了公用sql而创建实体，同时避免脏数据
    		UserDto userDto = new UserDto();
    		userDto.setUserNickname(user.getUserNickname());
    		userDto.setUserId(user.getUserId());
    		userDao.updateUser(userDto);
    		logger.info("用户 " + "[" + user.getUserNickname() + "] 修改昵称成功 ");
			return ResponseMsg.Response(ResponseMsg.OK, "修改成功！", null);
	}

}
