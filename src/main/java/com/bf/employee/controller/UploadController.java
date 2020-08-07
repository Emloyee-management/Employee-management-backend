package com.bf.employee.controller;

import com.bf.employee.service.FileService;
import com.bf.employee.util.TrimSpace;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: Controller for file uploading and downloading
 * @author: Yang Yuan
 * @Time: 15:14
 */

@RestController
public class UploadController {
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;
    @Resource
    private FileService service;
    @RequestMapping("/upload")
    void upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") Integer id) throws IOException {
        service.uploadFile(multipartFile, id);
        response.sendRedirect("/download.html");
    }

    
    @RequestMapping("/download")
    ResponseEntity download(@RequestParam("fileName") String fileName, @RequestParam("id") Integer id) throws FileNotFoundException {
        return service.download(fileName, id);
    }
}
