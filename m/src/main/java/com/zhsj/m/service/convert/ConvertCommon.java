package com.zhsj.m.service.convert;

/**
 * Created by taoxiangshan on 2017/8/19.
 */
public interface ConvertCommon<V, P> {
    /**
     * PO 转 VO
     *
     * @param p 数据库对象
     * @return v 页面展现对象
     */
    public V toVO(P p);


    /**
     * VO 转 PO
     *
     * @param v 页面展现对象
     * @return p 数据库对象
     */
    public P toPO(V v);
}
