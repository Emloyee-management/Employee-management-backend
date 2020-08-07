package com.bf.employee.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import com.bf.employee.dao.HousingDetailsDAO;
import com.bf.employee.dao.daoImpl.HouseDetailsDAOImpl;
import com.bf.employee.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HousingDetailService {
	@Autowired
	public HousingDetailsDAO houseDAO;

	@Transactional
	public House findHouseIDFromPersonID(int personID){
		return houseDAO.findHouseIDFromPersonID(personID);
	}
	@Transactional
	public HouseEmployeeResponse getEmployeeByHouseID(House h) { return houseDAO.getEmployeeByHouseID(h);}

	@Transactional
	public FacilityReportResponse listFacilityReport(House h) {return houseDAO.getFacilityReportDetail(h);}

	@Transactional
	public House findById(Integer id) {
		return houseDAO.getHouseById(id);
	}
}
