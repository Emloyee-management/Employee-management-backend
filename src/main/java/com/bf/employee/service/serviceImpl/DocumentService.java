package com.bf.employee.service.serviceImpl;

import com.bf.employee.dao.DocumentDao;
import com.bf.employee.entity.PersonalDocument;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/9
 */

@Service
public class DocumentService {
    @Resource
    private DocumentDao dao;
    public List<PersonalDocument> getAllDocsByEmployeeId(Integer eid) {
        return dao.getAllDocsByEmployeeId(eid);
    }

    public boolean updateDocStatus(Integer eid, String docName) {
        return dao.updateDocStatus(eid, docName);
    }
}
