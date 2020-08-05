package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.VisaStatusDAO;
import com.bf.employee.entity.VisaStatus;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class VisaStatusHibernateDAOImpl extends AbstractHibernateDAO implements VisaStatusDAO {

    public VisaStatusHibernateDAOImpl() {
        setClazz(VisaStatus.class);
    }


    @Override
    public int registerVisaStatus(VisaStatus visaStatus) {
        getCurrentSession().persist(visaStatus);
        return visaStatus.getId();
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
        System.out.println("visa: "+query.getResultList().toString());
        return (int)query.getResultList().get(0);
    }
}
