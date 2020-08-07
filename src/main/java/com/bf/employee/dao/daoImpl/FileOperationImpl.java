package com.bf.employee.dao.daoImpl;

import com.bf.employee.constant.Constant;
import com.bf.employee.dao.FileOperationDao;
import com.bf.employee.util.TrimSpace;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/5
 */

@Repository
public class FileOperationImpl implements FileOperationDao {
    TrimSpace ts = new TrimSpace();//replace space in the file name

    @Override
    public void uploadFile(MultipartFile multipartFile, Integer id) throws IOException {
        String uploadedFileName = "";
        String classPath = ts.Trim(Constant.CLASS_PATH);
        if (multipartFile != null) {
            uploadedFileName = multipartFile.getOriginalFilename();
//            String suffix = name.substring(name.lastIndexOf(".") + 1, name.length());//
            String filepath = classPath + "\\" + id;
            File file = new File(filepath);
            if (!file.exists()) {
                file.mkdirs();
            }
            multipartFile.transferTo(new File(file + "\\" + uploadedFileName));//save the file to server
    }


    }

    @Override
    public ResponseEntity download(String fileName, Integer id) throws FileNotFoundException {
        String classPath = ts.Trim(Constant.CLASS_PATH);
        String filePath = classPath + "\\" + id;
        File file = new File(filePath + "\\" + fileName);
//        System.out.println(file);
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/pdf");
        headers.add("Content-Disposition", "attachment; filename=" + file.getName() );
        InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
        return new ResponseEntity<InputStreamResource>(isr, headers, HttpStatus.OK);
    }
}
