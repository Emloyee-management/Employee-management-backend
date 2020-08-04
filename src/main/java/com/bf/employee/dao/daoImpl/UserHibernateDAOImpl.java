package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.UserDAO;
import com.bf.employee.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserHibernateDAOImpl extends AbstractHibernateDAO implements UserDAO {

    public UserHibernateDAOImpl() {
        setClazz(User.class);
    }

    /*
    * Override method from RegistrationTokenDAO.
    * Save a User into DB
    */
    @Override
    public void registerUser(User user) {
        getCurrentSession().persist(user);
    }

}
