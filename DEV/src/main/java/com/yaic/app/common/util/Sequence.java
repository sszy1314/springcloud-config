package com.yaic.app.common.util;

public final class Sequence {
	private Sequence(){}
	/**
	 * 获取TreeId的下一个值
	 * <p>User: wj
	 * <p>Date: 2017年10月26日
	 * <p>Version: 1.0
	 * @param current
	 * @return
	 */
	public static String next(String current){
		if(current==null || "".equals(current.trim())){
			return null;
		}
		
		String var = current.trim();
		String pfx = "";
		
		if(var.length() < 4 || var.length() % 4 != 0){
			return null;
		}
		if(var.length() > 4){
			pfx = var.substring(0,(var.length()/4-1) * 4);
			var = var.substring((var.length()/4-1) * 4);
		}

		char[] c = var.toCharArray();

		for(int i = c.length - 1 ; i >= 0 ; i--){
			if(c[i] == '9'){//9
				c[i] = 'A';
				break;
			}else if(c[i] == 'Z'){//Z
				c[i] = 'a';
				break;
			}else if(c[i] == 'z'){//z
				c[i] = i != 0 ? '0' : (char)(c[i]+1);//中断
				continue;
			}else{
				c[i] = (char) (c[i] + 1);
				break;
			}
		}
		return c[0] > 'z' ? null : pfx+String.valueOf(c);
	}
}
