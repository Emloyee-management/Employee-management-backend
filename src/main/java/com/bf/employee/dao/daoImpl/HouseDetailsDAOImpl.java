package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.HousingDetailsDAO;
import com.bf.employee.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.management.Query;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class HouseDetailsDAOImpl extends AbstractHibernateDAO implements HousingDetailsDAO {
    @Resource
    private SessionFactory sf;
    public House findHouseIDFromPersonID(int personID){
        House res = new House();
        String hql = "FROM Employee";
        List<Employee> empList = new ArrayList<>();
        try {
             empList = getCurrentSession().createQuery(hql).list();
        }
        catch (HibernateException e) {
            empList = sf.openSession().createQuery(hql).list();
        }
        String hql2 = "FROM House";
        List<House>houseList = getCurrentSession().createQuery(hql2).list();
        Employee em = new Employee();
        for(Employee e: empList)
        {
            if(e.getPersonId() == personID)
            {
                em = e;
                break;
            }
        }
        for(House h: houseList) {
            if (h.getId() == em.getHouseId()) {
                return h;
            }
        }
        return null;
    }

    @Override
    public HouseEmployeeResponse getEmployeeByHouseID(House h) {
        HouseEmployeeResponse res = new HouseEmployeeResponse();
        res.setHouseAddress(h.getAddress());
        String hql = "select p.firstName, p.middleName, p.lastName, p.cellphone from House h, Person p, Employee e where e.houseId = h.id\n" +
                "and p.id = e.personId and h.id = :hid";
        List<Object> list = new ArrayList<>();
        list = sf.getCurrentSession().createQuery(hql).setParameter("hid", h.getId()).list();
        res.setEmployeeList(list);
        return res;
    }

    @Override
    public FacilityReportResponse getFacilityReportDetail(House h) {
        FacilityReportResponse res = new FacilityReportResponse();
        String hql1 = "select p.firstName, p.middleName, p.lastName, fr.id, fr.title, fr.description, fr.reportDate, fr.status\n"
                + "from House h, Person p, Employee e,\n"
                + "FacilityReport fr where e.houseId = h.id\n"
                + "and p.id = e.personId and fr.employeeId = e.id and h.id = :hid\n";

        List<ReportResponse> rRList = new ArrayList<>();
        List<Object> list1 =  getCurrentSession().createQuery(hql1).setParameter("hid", h.getId()).list();
        for(int i = 0; i < list1.size(); i++)
        {
            Object[] temp = (Object[]) list1.get(i);
            ReportResponse rR = new ReportResponse();
            System.out.println(temp[0].toString());
            rR.setFirstName(temp[0].toString());
            rR.setMiddleName(temp[1].toString());
            rR.setLastName(temp[2].toString());
            rR.setId(Integer.parseInt(temp[3].toString()));
            rR.setTitle(temp[4].toString());
            rR.setDescription(temp[5].toString());
            rR.setReportDate(temp[6].toString());
            rR.setStatus(temp[7].toString());
            rRList.add(rR);
        }
        res.setReportResponse(rRList);

        String hql2 = "select distinct p.firstName, p.middleName, p.lastName, fr.id, frd.comments, frd.createdDate\n"
                + "from House h, Person p, Employee e, FacilityReportDetail frd,\n"
                + "FacilityReport fr where\n"
                + "p.id = e.personId and frd.employeeId = e.id and fr.id = frd.reportId\n";
        List<Object> list2 = getCurrentSession().createQuery(hql2).list();

        List<CommentResponse> crList = new ArrayList<>();
        for(int i = 0; i < list2.size(); i++) {
            Object[] temp = (Object[]) list2.get(i);
            CommentResponse cr = new CommentResponse();
            cr.setFirstName(temp[0].toString());
            cr.setMiddleName(temp[1].toString());
            cr.setLastName(temp[2].toString());
            cr.setReportID(Integer.parseInt(temp[3].toString()));
            cr.setComment(temp[4].toString());
            cr.setCreatedDate(temp[5].toString());
            crList.add(cr);
        }
        res.setCommentResponse(crList);
        return res;
    }


    @Override
    public House getHouseById(Integer id) {
        return (House) findById(id);
    }
}
