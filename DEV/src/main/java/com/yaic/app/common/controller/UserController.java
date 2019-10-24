/**
 * 
 */
package com.yaic.app.common.controller;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaic.app.common.dto.domain.UserDto;
import com.yaic.app.common.service.UserService;
import com.yaic.app.common.vo.ResponseMsg;

/** 
 * @ClassName: UserController 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月13日 下午7:30:29  
 */
@Controller  
@RequestMapping("/users")  
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private UserService userService;
	//秘钥暂时为密码+p
	
	
	/**
	 *登陆
	 * @param userName
	 * @param passWord
	 * @return Response
	 */
    @PostMapping("/login")  
    @ResponseBody  
    public ResponseMsg<?> login(@RequestBody   UserDto user) {
    	return userService.login(user);
    }
    /**
	 *找回密码
	 * @param userName
	 * @param mobile
	 * @param new passWord
	 * @return Response
	 */
    @PostMapping("/findPassWord")  
    @ResponseBody  
    public ResponseMsg<?> findPassWord(@RequestBody UserDto user) {
    	return userService.updatePassword(user);
    }
    
    /**
  	 *添加用户
  	 * @param userDto
  	 * @return Response
  	 */
    @PostMapping("/addUser")  
    @ResponseBody  
    public ResponseMsg<?> addUser(@RequestBody UserDto user) {
    	return userService.insert(user);
    }  
    /**
  	 *删除认证
  	 * @param userId
  	 * @return Response
  	 */
    @PostMapping("/delIdentity")  
    @ResponseBody  
    public ResponseMsg<?> delIdentity(@RequestBody String userId) {
		return userService.delIdentity(userId);
    }
    /**
  	 *添加认证
  	 * @param userDto
  	 * @return Response
  	 */
    @PostMapping("/addIdentity")  
    @ResponseBody  
    public ResponseMsg<?> addIdentity(@RequestBody UserDto user) {
    	return userService.addIdentity(user);
    }  
    /**
  	 *修改用户名
  	 * @param UserDto
  	 * @return Response
  	 */
    @PostMapping("/updateUserNickname")  
    @ResponseBody  
    public ResponseMsg<?> updateUserName(@RequestBody UserDto user) {
    	return userService.updateUserNickname(user);
    }
    
}  
