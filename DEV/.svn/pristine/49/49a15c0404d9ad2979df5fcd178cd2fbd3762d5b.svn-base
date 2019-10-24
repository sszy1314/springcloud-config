/**
 * 
 */
package com.yaic.app.common.util;

import java.text.SimpleDateFormat;

/** 
 * @ClassName: GetTime 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月29日 上午11:43:34  
 */
public class GetTimeNumber {

	
	/**
	 * 20位末尾的数字id
	 */

	public static  int Guid=100;
	public static String getGuid() {
		
		GetTimeNumber.Guid+=1;

		long now = System.currentTimeMillis();  
		//获取4位年份数字  
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");  
		//获取时间戳  
		String time=dateFormat.format(now);
		String info=now+"";
		//获取三位随机数  
		//int ran=(int) ((Math.random()*9+1)*100); 
		//要是一段时间内的数据连过大会有重复的情况，所以做以下修改
		int ran=0;
		if(GetTimeNumber.Guid>999){
			GetTimeNumber.Guid=100;    	
		}
		ran=GetTimeNumber.Guid;
				
		return time+info.substring(2, info.length())+ran;  
	}

}
