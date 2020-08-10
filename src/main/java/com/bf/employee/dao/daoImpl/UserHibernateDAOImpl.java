package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.UserDAO;
import com.bf.employee.entity.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserHibernateDAOImpl extends AbstractHibernateDAO implements UserDAO {

    public UserHibernateDAOImpl() {
        setClazz(User.class);
    }

    /*
    * Override method from UserDAO.
    * Save a User into DB
    */
    @Override
    public int registerUser(User user) {
        getCurrentSession().persist(user);
        return user.getId();
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
