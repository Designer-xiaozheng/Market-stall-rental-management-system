package com.project.demo.controller;

import com.project.demo.entity.MaterialInformation;
import com.project.demo.service.MaterialInformationService;
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
 * 物资信息：(MaterialInformation)表控制层
 *
 */
@RestController
@RequestMapping("/material_information")
public class MaterialInformationController extends BaseController<MaterialInformation, MaterialInformationService> {

    /**
     * 物资信息对象
     */
    @Autowired
    public MaterialInformationController(MaterialInformationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
