package com.bf.employee.entity;

import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/9
 */
public class DocumentResponse {
    private List<DocumentList> documents;

    public List<DocumentList> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentList> documents) {
        this.documents = documents;
    }
}
