package com.bf.employee.controller;

import com.bf.employee.entity.PersonalDocument;
import com.bf.employee.service.serviceImpl.DocumentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/9
 */

@RestController
public class DocumentController {
    @Resource
    private DocumentService service;

    @RequestMapping("/viewAllDocs")
    List<PersonalDocument> getAllDocs(@RequestParam("eid") Integer eid) {
        return service.getAllDocsByEmployeeId(eid);
    }
}
