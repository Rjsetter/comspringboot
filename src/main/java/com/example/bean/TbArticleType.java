package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 文章类型实体类，对应数据库tb_article_type
 * @author RJSETTER
 * @Date 2019/2/21
 */
@Table(name = "tb_article_type")
public class TbArticleType {
    @Column(name="type_id")
    private Integer typeId;
    @Column(name="type_name")
    private String typeName;
    @Column(name="type_info")
    private String typeInfo;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(String typeInfo) {
        this.typeInfo = typeInfo;
    }
}
