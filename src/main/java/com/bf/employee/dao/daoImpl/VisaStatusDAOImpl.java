package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.VisaStatusDAO;
import com.bf.employee.entity.LoginResponse;
import com.bf.employee.entity.User;
import com.bf.employee.entity.VisaStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Zishan
 */

@Repository
public class VisaStatusDAOImpl implements VisaStatusDAO {
    @Resource
    private SessionFactory sf;

    @Override
    public VisaStatus getVisaInfo(int employeeVisaStatusId) {
        Session session = sf.getCurrentSession();
        String hql = "FROM VisaStatus V WHERE V.id = " + employeeVisaStatusId;
        Query query = session.createQuery(hql);
        return (VisaStatus) query.list().get(0);
    }
}
