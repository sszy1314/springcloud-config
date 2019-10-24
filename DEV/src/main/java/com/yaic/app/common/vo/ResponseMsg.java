/*
 * 文件名: ResponseMsg.java
 * 文件编号: 
 * 版权: Copyright (c) 2018, YAN Co.Ltd. and/or its affiliates. All rights reserved.Use is subject to license terms.
 * 描述: TODO
 * 创建人: wj
 * 创建时间: 2018年6月6日
 * 修改人:
 * 修改时间: 2018年6月6日
 * 修改变更号: 
 * 修改内容: TODO
 */
package com.yaic.app.common.vo;

/**
 * @Title ResponseMsg
 * @Description TODO
 * @author wj
 * @date 2018年6月6日
 * @version V1.0
 * @see 
 * @since V1.0
 */
public class ResponseMsg<T> {
    public static final int OK = 1;
    public static final int FAI = -1;
    public static final int ERROR = -2;
    private int status;
    private String msg;
    private T body;
    
    private ResponseMsg(){}
    private ResponseMsg(int status , String msg , T body){
        this.status = status;
        this.msg = msg;
        this.body = body;
    }
    public static <T> ResponseMsg<T> Response(int status , String msg , T body){
        return new ResponseMsg<T>(status, msg, body);
    }
    
    public int getStatus () {
        return status;
    }
    public void setStatus ( int status ) {
        this.status = status;
    }
    public String getMsg () {
        return msg;
    }
    public void setMsg ( String msg ) {
        this.msg = msg;
    }
    public T getBody () {
        return body;
    }
    public void setBody ( T body ) {
        this.body = body;
    }
}