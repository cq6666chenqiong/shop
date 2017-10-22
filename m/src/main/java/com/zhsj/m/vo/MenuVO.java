package com.zhsj.m.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by taoxiangshan on 17/10/14.
 */
public class MenuVO implements Serializable {
    private String title;
    private List<Particular>particulars;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Particular> getParticulars() {
        return particulars;
    }

    public void setParticulars(List<Particular> particulars) {
        this.particulars = particulars;
    }
}
