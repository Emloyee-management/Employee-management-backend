package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.UserDAO;
import com.bf.employee.entity.User;
import org.hibernate.query.Query;
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

    /*
    * Check if the user exists in DB
    */
    @Override
    public boolean isUserExist(User user) {
        Query query = getCurrentSession().
                createQuery("select 1 from User u where u.userName = :userName");
        query.setParameter("userName", user.getUserName());
        if((query.uniqueResult() != null)){
            return true;
        }else{
            return false;
        }
    }


}
