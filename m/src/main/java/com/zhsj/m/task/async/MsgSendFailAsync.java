package com.zhsj.m.task.async;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lcg on 17/1/14.
 */
public class MsgSendFailAsync implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(MsgSendFailAsync.class);

    private String orderNo;
    private long accountId;
    
    
    public MsgSendFailAsync(String orderNo,long accountId){
       this.orderNo = orderNo;
       this.accountId = accountId;
    }

    @Override
    public void run() {
        try{
        }catch (Exception e){
            logger.error("#MsgSendFailAsync.run# e={}",e.getMessage(),e);
        }
    }
}
