package com.project.demo.controller;

import com.project.demo.entity.MaterialApplication;
import com.project.demo.service.MaterialApplicationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 物资申领：(MaterialApplication)表控制层
 *
 */
@RestController
@RequestMapping("/material_application")
public class MaterialApplicationController extends BaseController<MaterialApplication, MaterialApplicationService> {

    /**
     * 物资申领对象
     */
    @Autowired
    public MaterialApplicationController(MaterialApplicationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(material_application_id) AS max FROM "+"`material_application`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `material_information` INNER JOIN `material_application` ON material_information.item_no=material_application.item_no WHERE material_information.stock < material_application.application_quantity AND material_application.material_application_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"material_application"+" WHERE "+"material_application_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"库存不足!");
        }
        sql = "UPDATE `material_information` INNER JOIN `material_application` ON material_information.item_no=material_application.item_no SET material_information.stock= material_information.stock - material_application.application_quantity WHERE material_application.material_application_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
