package com.bf.employee.dao;

import com.bf.employee.entity.DocumentResponse;
import com.bf.employee.entity.PersonalDocument;

import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/9
 */
public interface DocumentDao {
    List<PersonalDocument> getAllDocsByEmployeeId(Integer eid);
    Boolean updateDocStatus(Integer eid, String docName);
}
