package com.bf.employee.controller;

import com.bf.employee.service.FileService;
import com.bf.employee.service.serviceImpl.VisaStatusService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * @description: Controller for file uploading and downloading
 * @author: Yang Yuan
 * @Time: 15:14
 */

@RestController
public class UploadController {
//    @Resource
//    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;
    @Resource
    private FileService fileService;
    @Resource
    private VisaStatusService visaStatusService;

    @RequestMapping("/upload")
    void upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") Integer id, @RequestParam("visaType") String visaType) throws IOException {
        fileService.uploadFile(multipartFile, id);
        visaStatusService.updateVisaType(id, visaType);
        response.sendRedirect("/download.html");
    }

    
    @RequestMapping("/download")
    ResponseEntity download(@RequestParam("fileName") String fileName, @RequestParam("id") Integer id) throws FileNotFoundException {
        return fileService.download(fileName, id);
    }
}
