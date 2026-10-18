package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 物资申领：(MaterialApplication)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MaterialApplication")
public class MaterialApplication implements Serializable {

    // MaterialApplication编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_application_id")
    private Integer material_application_id;

    // 物资编号
    @Basic
    private String item_no;
    // 物资名称
    @Basic
    private String item_name;
    // 品牌
    @Basic
    private String brand;
    // 规格
    @Basic
    private String specifications;
    // 库存
    @Basic
    private String stock;
    // 用户编号
    @Basic
    private Integer user_no;
    // 姓名
    @Basic
    private String full_name;
    // 申领数量
    @Basic
    private Integer application_quantity;
    // 申领用途
    @Basic
    private String application_purpose;



    // 审核状态
    @Basic
    private String examine_state;








    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
