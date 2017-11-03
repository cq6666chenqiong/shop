package com.zhsj.m.util;

/**
 * Created by wuyongtao on 2017/11/1.
 */
public class StoreNoUtils
{
    public static synchronized String getStoreNO(long seq){//门店编码
        seq = seq^674653;
        String rd = String.format("%3s%07d","111",seq);
        return rd;
    }

    public static synchronized String getMerchantNO(long seq){//商户编码
        seq = seq^674653;
        String rd = String.format("%3s%07d","151",seq);
        return rd;
    }
}
