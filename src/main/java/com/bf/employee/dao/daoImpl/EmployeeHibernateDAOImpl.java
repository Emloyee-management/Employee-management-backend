package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.EmployeeDAO;
import com.bf.employee.entity.Employee;
import com.bf.employee.entity.Person;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class EmployeeHibernateDAOImpl extends AbstractHibernateDAO implements EmployeeDAO {

    public EmployeeHibernateDAOImpl() {
        setClazz(Employee.class);
    }

    /*
     * Override method from EmployeeDAO.
     * Register Employee to the DB
     */

    @Resource
    private SessionFactory sf;
    @Override
    public int registerEmployee(Employee employee) {
        try {
            getCurrentSession().persist(employee);
        }
        catch (HibernateException e) {
            sf.openSession().persist(employee);
        }
        return employee.getId();
    }
}
