package com.zhsj.m.vo;

import java.io.Serializable;

/**
 * Created by taoxiangshan on 17/10/14.
 */
public class Particular  implements Serializable {
    private String sontile;
    private String sonurl;

    public String getSontile() {
        return sontile;
    }

    public void setSontile(String sontile) {
        this.sontile = sontile;
    }

    public String getSonurl() {
        return sonurl;
    }

    public void setSonurl(String sonurl) {
        this.sonurl = sonurl;
    }
}
