package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 物资信息：(MaterialInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MaterialInformation")
public class MaterialInformation implements Serializable {

    // MaterialInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_information_id")
    private Integer material_information_id;

    // 物资编号
    @Basic
    private String item_no;
    // 物资名称
    @Basic
    private String item_name;
    // 物资类别
    @Basic
    private String material_category;
    // 品牌
    @Basic
    private String brand;
    // 规格
    @Basic
    private String specifications;
    // 图片
    @Basic
    private String picture;
    // 库存
    @Basic
    private Integer stock;
    // 生产日期
    @Basic
    private Timestamp date_of_manufacture;
    // 有效期
    @Basic
    private String term_of_validity;
    // 物资用途
    @Basic
    private String material_use;
    // 物资介绍
    @Basic
    private String material_introduction;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;












    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
