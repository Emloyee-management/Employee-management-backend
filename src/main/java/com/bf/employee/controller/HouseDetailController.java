package com.bf.employee.controller;

import com.bf.employee.entity.*;
import com.bf.employee.service.serviceImpl.RegistrationTokenService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.web.bind.annotation.*;

import com.bf.employee.service.serviceImpl.HousingDetailService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/houseDetail")
public class HouseDetailController {
    @Resource
    private SessionFactory sf;
    @Resource
    private HttpServletRequest request;
    @Autowired
    private HousingDetailService housingDetailService;
    @Autowired
    private RegistrationTokenService registrationTokenService;
    @Autowired
    private HousingDetailService housingService;

    @RequestMapping(value = "/house", method = RequestMethod.GET)
    public House findHouseIDByPersonID() {
//		String personId = request.getParameter("personId");
//		*****For testing purpose
        String personId = request.getParameter("personId");
        House h = housingService.findHouseIDFromPersonID(Integer.valueOf(personId));
        return h;
    }

    @RequestMapping(value = "/house/tenants", method = RequestMethod.GET)
    public HouseEmployeeResponse listEmployeeInSameHouse() {
        String personId = request.getParameter("personId");
        House h = housingService.findHouseIDFromPersonID(Integer.valueOf(personId));
        return housingService.getEmployeeByHouseID(h);
    }

    @RequestMapping(value = "/facility/list", method = RequestMethod.GET)
    public FacilityReportResponse listFacilityReport() {
        String personId = request.getParameter("personId");
        House h = housingService.findHouseIDFromPersonID(Integer.valueOf(personId));
        return housingService.listFacilityReport(h);
    }

    @RequestMapping(value = "/facility/list", method = RequestMethod.POST)
    public boolean addReport() {
        String title = request.getParameter("title");
        String empId = request.getParameter("employeeID");
        String reportDate = request.getParameter("reportDate");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        FacilityReport report = new FacilityReport(title, Integer.parseInt(empId),
                reportDate, description, status);
        try {
            sf.getCurrentSession().save(report);
        }
        catch (HibernateException e) {
            sf.openSession().save(report);
        }
//        sf.getCurrentSession().save(report);
        return true;
    }

    @RequestMapping(value = "/facility/list", method = RequestMethod.PUT)
    public void updateReport() {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String empId = request.getParameter("employeeID");
        String reportDate = request.getParameter("reportDate");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        FacilityReport newReport = sf.getCurrentSession().get(FacilityReport.class, Integer.parseInt(id));
        newReport.setTitle(title);
        newReport.setDescription(description);
        newReport.setEmployeeId(Integer.parseInt(empId));
        newReport.setReportDate(reportDate);
        newReport.setStatus(status);
        try {
            sf.getCurrentSession().update(newReport);
//            session = sf.getCurrentSession();
        } catch (HibernateException e) {
            sf.openSession().update(newReport);
        }
//        sf.getCurrentSession().update(newReport);
    }

    @Transactional
    @RequestMapping(value = "/facility/list/comment", method = RequestMethod.POST)
    public void createComment() {
        String rId = request.getParameter("reportId");
        String eid = request.getParameter("eid");
        String comment = request.getParameter("comment");
        String createdDate = request.getParameter("createdDate");
        String lastModified = request.getParameter("lastModified");
        FacilityReportDetail cmt = new FacilityReportDetail(Integer.parseInt(rId), Integer.parseInt(eid), comment, createdDate, lastModified);
        sf.getCurrentSession().save(cmt);
    }

    @Transactional
    @RequestMapping(value = "/facility/list/comment", method = RequestMethod.PUT)
    public void updateComment() {
        String cId = request.getParameter("cid");
        String rId = request.getParameter("reportId");
        String eid = request.getParameter("eid");
        String cmt = request.getParameter("comment");
        String createdDate = request.getParameter("createdDate");
        String lastModified = request.getParameter("lastModified");
        FacilityReportDetail comment = (FacilityReportDetail) sf.getCurrentSession().get(FacilityReportDetail.class, Integer.parseInt(cId));
        System.out.println(comment.getComments());
        comment.setEmployeeId(Integer.parseInt(eid));
        comment.setComments(cmt);
        comment.setCreatedDate(createdDate);
        comment.setLastModificationDate(lastModified);
        comment.setReportId(Integer.parseInt(rId));
        sf.getCurrentSession().update(comment);
    }
}
