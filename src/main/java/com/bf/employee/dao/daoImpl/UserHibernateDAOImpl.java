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

    @Override
    public void registerUser(User user) {
        getCurrentSession().persist(user);
    }

//    @Override
//    public User getUserById(Integer id) {
//        return (User) findById(id);
//    }
}
