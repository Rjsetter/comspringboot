package com.example.bean;

/**
 * 文章类型实体类，对应数据库tb_article_type
 * @author RJSETTER
 * @Date 2019/2/21
 */
public class TbArticleType {
    private Integer typeId;
    private String typeName;
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
