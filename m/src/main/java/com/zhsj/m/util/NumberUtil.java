package com.zhsj.m.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NumberUtil {
	
	public static String format(String number){
		if(number == null || number.equals("")){
			return "0.00";
		}else{
			DecimalFormat df1 = new DecimalFormat("0.00"); 
			return df1.format(Double.valueOf(number));
		}
		
	}
	
	public static String formatNumberToDateStr(String number){
		if(number == null || number.equals("")){
			return "";
		}else{
			Long l = Long.valueOf(number);
			String stringTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date(l));
			return stringTime;
		}
	}
	

}
