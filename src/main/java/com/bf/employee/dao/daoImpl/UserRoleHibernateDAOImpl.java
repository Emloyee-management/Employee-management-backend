package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.AddressDAO;
import com.bf.employee.dao.UserRoleDAO;
import com.bf.employee.entity.Address;
import com.bf.employee.entity.Employee;
import com.bf.employee.entity.UserRole;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Repository
@Transactional
public class UserRoleHibernateDAOImpl extends AbstractHibernateDAO implements UserRoleDAO {

    public UserRoleHibernateDAOImpl() {
        setClazz(UserRole.class);
    }
    /*
     * Override method from AddressDAO.
     * Register Address to the DB
     */
    @Resource
    private SessionFactory sf;


    @Override
    public int registerUserRole(UserRole userRole) {
        try {
            getCurrentSession().persist(userRole);
        }
        catch (HibernateException e) {
            sf.openSession().persist(userRole);
        }
        return userRole.getId();
    }

}
