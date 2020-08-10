package com.bf.employee.dao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileOperationDao {
    void uploadFile(MultipartFile multipartFile, Integer id) throws IOException;
    ResponseEntity download(String fileName, Integer id) throws FileNotFoundException;

}
