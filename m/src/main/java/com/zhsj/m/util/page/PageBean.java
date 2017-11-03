package com.zhsj.m.util.page;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by taoxiangshan on 2017/10/18.
 */
public class PageBean {
    int pageNo=1;   //当前页 页面传过来
    int pageSize=5; //每页条数 自定义
    int totalCount=0; //总记录数  数据库查
    int totalPage=1;  //根据totalCount和pageSize计算得出
    int startNum=0;
    int endNum=0;
    List<?>list;
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getTotalPage() {
        if(totalCount>0) {
            if (totalCount % pageSize == 0) {
            	
                return totalCount / pageSize;
            } else {
                //return (totalCount / pageSize) + 1;
            	return (int) Math.ceil(new BigDecimal(totalCount).divide(new BigDecimal(pageSize)).doubleValue());
            }
        }else{
            return 1;
        }
    }
    public void setTotalPage(int totalPage) {
       this.totalPage=totalPage;
    }
    public int getStartNum() {
        return (pageNo-1)*pageSize;
    }
    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }
    public int getEndNum() {
        return (pageNo*pageSize)+1;
    }
    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }
    public List<?> getList() {
        return list;
    }
    public void setList(List<?> list) {
        this.list = list;
    }

    public static void main(String[] args){

        System.out.println("********************************"+Math.ceil(new BigDecimal(13).divide(new BigDecimal(5)).doubleValue()));
    }

}
