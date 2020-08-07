package com.bf.employee.entity;

import java.util.List;

public class FacilityReportResponse {
    private List<ReportResponse> reportResponse;
    private List<CommentResponse> commentResponse;

    public List<ReportResponse> getReportResponse() {
        return reportResponse;
    }

    public void setReportResponse(List<ReportResponse> reportResponse) {
        this.reportResponse = reportResponse;
    }

    public List<CommentResponse> getCommentResponse() {
        return commentResponse;
    }

    public void setCommentResponse(List<CommentResponse> commentResponse) {
        this.commentResponse = commentResponse;
    }
}
