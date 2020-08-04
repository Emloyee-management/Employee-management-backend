package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.VisaStatusDAO;
import com.bf.employee.entity.Employee;
import com.bf.employee.entity.VisaStatus;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class VisaStatusHibernateDAOImpl extends AbstractHibernateDAO implements VisaStatusDAO {

    public VisaStatusHibernateDAOImpl() {
        setClazz(VisaStatus.class);
    }


    @Override
    public void registerVisaStatus(VisaStatus visaStatus) {
        getCurrentSession().persist(visaStatus);
    }

    /*
     * Return PersonID with matching firstName, lastName, email, and ssn
     */
    @Override
    public int findByUserName(String userName) {
        Query query = getCurrentSession().
                createQuery("select vs.id from VisaStatus vs " +
                        "where vs.createUser =:userName");
        query.setParameter("userName", userName);
        return (int)query.uniqueResult();
    }
}
