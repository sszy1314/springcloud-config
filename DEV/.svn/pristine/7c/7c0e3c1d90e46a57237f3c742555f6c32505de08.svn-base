/**
 * 
 */
package com.yaic.app.common.dto.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/** 
 * @ClassName: Dto 
 * @Description: TODO
 * @author: chenlong
 * @date: 2019年3月13日 下午2:55:13  
 */
public abstract  class Dto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

