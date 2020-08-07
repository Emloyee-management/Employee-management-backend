package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.VisaStatusDAO;

import com.bf.employee.entity.VisaStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


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


    @Transactional
    @Override
    public Boolean updateVisaType(int employeeVisaStatusId, String visaType) {
        Session session = sf.getCurrentSession();
        String hql = "UPDATE VisaStatus set visaType = :visaType " +
                "WHERE id = :visaStatusId";
        Query query = session.createQuery(hql);
        query.setParameter("visaType", visaType);
        query.setParameter("visaStatusId", employeeVisaStatusId);
        int result = query.executeUpdate();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
}
