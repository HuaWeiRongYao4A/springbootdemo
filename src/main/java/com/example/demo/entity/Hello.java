package com.example.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2017/6/23.
 */
public class Hello {
    @JSONField(name = "patent_id")
    private String patentId;
    @JSONField(name = "patent_type")
    private String patentType;

    public String getPatentId() {
        return patentId;
    }

    public void setPatentId(String patentId) {
        this.patentId = patentId;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

}
