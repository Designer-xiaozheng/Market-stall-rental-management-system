package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 物资入库：(MaterialWarehousing)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "MaterialWarehousing")
public class MaterialWarehousing implements Serializable {

    // MaterialWarehousing编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_warehousing_id")
    private Integer material_warehousing_id;

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
    // 入库数量
    @Basic
    private Integer receipt_quantity;
    // 入库批次
    @Basic
    private String receipt_batch;
    // 入库时间
    @Basic
    private Timestamp warehousing_time;
    // 生产商
    @Basic
    private String manufacturer;
    // 入库信息
    @Basic
    private String warehousing_information;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
