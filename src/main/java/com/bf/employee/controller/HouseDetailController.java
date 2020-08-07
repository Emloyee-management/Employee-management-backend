package com.bf.employee.controller;

import com.bf.employee.entity.*;
import com.bf.employee.service.serviceImpl.RegistrationTokenService;
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

	//@RequestMapping(value="/house", method=RequestMethod.GET)
	public House findHouseIDByPersonID()
	{
//		String personId = request.getParameter("personId");
//		*****For testing purpose
		String personId = "31";
		House h = housingService.findHouseIDFromPersonID(Integer.valueOf(personId));
		return h;
	}

	@RequestMapping(value="/house", method = RequestMethod.GET)
	public HouseEmployeeResponse listEmployeeInSameHouse()
	{
		House h = findHouseIDByPersonID();
		return housingService.getEmployeeByHouseID(h);
	}

	@RequestMapping(value = "/facility/list", method = RequestMethod.GET)
	public FacilityReportResponse listFacilityReport()
	{
		House h = findHouseIDByPersonID();
		return housingService.listFacilityReport(h);
	}

	@Transactional
	@RequestMapping(value = "/facility/list", method = RequestMethod.POST)
	public void createComment()
	{
		String rId = request.getParameter("reportId");
		String eid = request.getParameter("eid");
		String comment = request.getParameter("comment");
		String createdDate = request.getParameter("createdDate");
		String lastModified = request.getParameter("lastModified");
		FacilityReportDetail cmt = new FacilityReportDetail(Integer.parseInt(rId), Integer.parseInt(eid), comment, createdDate, lastModified);
		sf.getCurrentSession().save(cmt);
	}

	@Transactional
	@RequestMapping(value = "/facility/list", method = RequestMethod.PUT)
	public void updateComment()
	{
		String cId = request.getParameter("cid");
		String rId = request.getParameter("reportId");
		String eid = request.getParameter("eid");
		String cmt = request.getParameter("comment");
		String createdDate = request.getParameter("createdDate");
		String lastModified = request.getParameter("lastModified");
		FacilityReportDetail comment = (FacilityReportDetail)sf.getCurrentSession().get(FacilityReportDetail.class, Integer.parseInt(cId));
		System.out.println(comment.getComments());
		comment.setEmployeeId(Integer.parseInt(eid));
		comment.setComments(cmt);
		comment.setCreatedDate(createdDate);
		comment.setLastModificationDate(lastModified);
		comment.setReportId(Integer.parseInt(rId));
		sf.getCurrentSession().update(comment);
	}
}
