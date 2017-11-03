package com.zhsj.m.util;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.zhsj.m.vo.OrderInfoVO;

public class FinanceUtil {

	public static String getCondition(List list){
		String queryStr = "";
		if(list.size() > 0){
			queryStr = queryStr + " o.store_code in (";
			for(int i=0;i<list.size();i++){
				Map<String,String> map = (Map<String, String>) list.get(i);
				String mchCode = map.get("mch_code");
				if(i==list.size()-1){
					queryStr = queryStr + "'" + mchCode + "'";
				}else{
					queryStr = queryStr + "'" + mchCode + "',";
				}
				
			}
			queryStr = queryStr + ")";
		}else{
			queryStr = queryStr + " o.store_code in ('')";
		}
		
		return queryStr;
	}
	
	public static void copyOrderBeanProperties(Object source,Object target) {
		Collection<String> excludes = new ArrayList<String>();
		excludes.add("orderPayMethedName");
		excludes.add("orderTypeName");
		excludes.add("netIncome");
		excludes.add("startPage");
		excludes.add("tradeTime");
		BeanUtils.copyProperties(source, target, excludes.toArray(new String[excludes.size()]));
	}
	
	public static void main(String[] args) {
		
		
		
	}
}
