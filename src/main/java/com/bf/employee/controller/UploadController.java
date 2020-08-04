package com.bf.employee.controller;

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
 * @description:
 * @author: Yang Yuan
 * @Time: 15:14
 */

@RestController
public class UploadController {
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;

    TrimSpace ts = new TrimSpace();
    String classPath = ts.Trim(ClassUtils.getDefaultClassLoader().getResource("").getPath()) + "static";

    @RequestMapping("/upload")
    void test(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") Integer id) throws IOException {
        String realpath = "";
        //获取文件名
        String name = "";

        if (multipartFile != null) {
            name = multipartFile.getOriginalFilename();//直接返回文件的名字
//            String suffix = name.substring(name.lastIndexOf(".") + 1, name.length());//我这里取得文件后缀
            String filepath = classPath;//获取项目路径到webapp
//            filepath = filepath.replace("%20", " ");
            File file = new File(filepath);
            if (!file.exists()) {//目录不存在就创建
                file.mkdirs();
            }
            multipartFile.transferTo(new File(file + "\\" + name));//保存文件
            System.out.println(filepath);
            response.sendRedirect("/download.html");
        }
    }


    @RequestMapping("/download")
    ResponseEntity download() throws FileNotFoundException {
        String fileName = request.getParameter("filename");
        String filePath = classPath;
        File file = new File(filePath + "\\" + fileName);
        System.out.println(file);
        InputStream in = new FileInputStream(file);
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/pdf");
        headers.add("Content-Disposition", "attachment; filename=" + file.getName() );
        InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
        return new ResponseEntity<InputStreamResource>(isr, headers, HttpStatus.OK);
    }
}
