package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.RegistrationTokenDAO;
import com.bf.employee.entity.RegistrationToken;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationTokenHibernateDAOImpl extends AbstractHibernateDAO implements RegistrationTokenDAO {

    public RegistrationTokenHibernateDAOImpl() {
        setClazz(RegistrationToken.class);
    }

    @Override
    public boolean isRegTokExists(String regToken) {

        Query query = getCurrentSession().
                createQuery("select 1 from RegistrationToken t where t.token = :regToken");
        query.setParameter("regToken", regToken);
        if((query.uniqueResult() != null)){
            return true;
        }else{
            return false;
        }
    }
}
