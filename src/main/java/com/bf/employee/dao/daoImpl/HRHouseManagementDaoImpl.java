package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.HRHouseManagementDao;
import com.bf.employee.dao.HousingDetailsDAO;
import com.bf.employee.entity.*;
import com.bf.employee.service.serviceImpl.HousingDetailService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/8
 */

@Repository
@Transactional
public class HRHouseManagementDaoImpl implements HRHouseManagementDao{
    @Resource
    private SessionFactory sf;

    @Resource
    private HousingDetailsDAO dao;

    @Override
    public List<HRHouseDetailResponse> viewAllHouses() {
        Session session = sf.getCurrentSession();
        String hql = "select h.address, h.numberOfPerson, h.address, h.id, p.firstName, p.email, p.cellphone from House h, Person p, Employee e " +
                "where p.id = e.personId and e.houseId = h.id";
        List<Object> list = session.createQuery(hql).list();
        List<HRHouseDetailResponse> res = new ArrayList<>();

        for(int i = 0; i < list.size(); i++)
        {
            Object[] temp = (Object[]) list.get(i);
            HRHouseDetailResponse response = new HRHouseDetailResponse();
            response.setAddress(temp[0].toString());
            response.setNumOfEmployee((Integer) temp[1]);
            response.setAddress(temp[2].toString());
            response.setHouseId((Integer) temp[3]);
            response.setLandlord(temp[4].toString());
            response.setEmail(temp[5] == null ? "" : temp[5].toString());
            response.setPhone(temp[6].toString());
            res.add(response);
        }
        return res;
    }


    @Override
    public HRFacilityResponse viewOneHouseById(Integer hid) {
        HRFacilityResponse res = new HRFacilityResponse();
        String hql = "select count(*) as numOfChair,\n" +
                "       (select count(*)  from Facility fa where fa.type = 'bed') as numOfBed,\n" +
                "       (select count(*) from Facility fa where fa.type = 'table') as numOfTable,\n" +
                "       (select count(*) from Facility fa where fa.type = 'mattress') as numOfMattress\n" +
                "from Facility f, House h\n" +
                "where f.houseId = h.id and h.id = :hid and f.type = 'chair'";
        Session session = sf.getCurrentSession();
        List<Object[]> list = session.createQuery(hql).setParameter("hid", hid).list();
        res.setNumOfBeds(Math.toIntExact((Long) list.get(0)[1]));
        res.setNumOfChairs(Math.toIntExact((Long) list.get(0)[0]));
        res.setNumOfTables(Math.toIntExact((Long) list.get(0)[2]));
        res.setNumOfMattress(Math.toIntExact((Long) list.get(0)[3]));

        List<FacilityReport> facilityReports = new ArrayList<>();
        House h = new House();
        h.setId(hid);
        FacilityReportResponse temp = dao.getFacilityReportDetail(h);
        ReportResponse reportResponse = temp.getReportResponse().get(0);
        FacilityReport facilityReport = new FacilityReport();
        facilityReport.setTitle(reportResponse.getTitle());
        facilityReport.setStatus(reportResponse.getStatus());
        facilityReports.add(facilityReport);
        res.setFacilityReports(facilityReports);
        return res;
    }
}
