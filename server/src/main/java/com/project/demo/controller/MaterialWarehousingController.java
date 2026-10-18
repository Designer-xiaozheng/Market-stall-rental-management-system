package com.project.demo.controller;

import com.project.demo.entity.MaterialWarehousing;
import com.project.demo.service.MaterialWarehousingService;
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
 * 物资入库：(MaterialWarehousing)表控制层
 *
 */
@RestController
@RequestMapping("/material_warehousing")
public class MaterialWarehousingController extends BaseController<MaterialWarehousing, MaterialWarehousingService> {

    /**
     * 物资入库对象
     */
    @Autowired
    public MaterialWarehousingController(MaterialWarehousingService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(material_warehousing_id) AS max FROM "+"`material_warehousing`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = "UPDATE `material_information` INNER JOIN `material_warehousing` ON material_information.item_no=material_warehousing.item_no SET material_information.stock= material_information.stock + material_warehousing.receipt_quantity WHERE material_warehousing.material_warehousing_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
