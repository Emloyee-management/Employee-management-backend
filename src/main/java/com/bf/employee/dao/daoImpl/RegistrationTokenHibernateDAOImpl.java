package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.RegistrationTokenDAO;
import com.bf.employee.entity.Contact;
import com.bf.employee.entity.RegistrationToken;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@Repository
public class RegistrationTokenHibernateDAOImpl extends AbstractHibernateDAO implements RegistrationTokenDAO {

    public RegistrationTokenHibernateDAOImpl() {
        setClazz(RegistrationToken.class);
    }

    /*
    * Override method from RegistrationTokenDAO.
    * Check if the RegistrationToken exists in the DB
    */
    @Override
    public boolean isRegTokExists(String regToken) {

        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Query query = session.
                createQuery("select 1 from RegistrationToken t where t.token = :regToken");
        query.setParameter("regToken", regToken);
        if((query.uniqueResult() != null)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isRegTokValid(String regToken){
        Query query = getCurrentSession().
                createQuery("select validDuration from RegistrationToken t where t.token = :regToken");
        query.setParameter("regToken", regToken);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime validDuration = LocalDateTime.parse(query.getResultList().get(0).toString());

        return (now.isBefore(validDuration));

    }

    @Override
    public int persistRegistrationToken(RegistrationToken registrationToken) {
        getCurrentSession().persist(registrationToken);
        return registrationToken.getId();
    }
}
