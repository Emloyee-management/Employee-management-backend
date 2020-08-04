package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.EmployeeDAO;
import com.bf.employee.entity.Employee;
import com.bf.employee.entity.Person;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeHibernateDAOImpl extends AbstractHibernateDAO implements EmployeeDAO {

    public EmployeeHibernateDAOImpl() {
        setClazz(Employee.class);
    }

    /*
     * Override method from RegistrationTokenDAO.
     * Register Employee to the DB
     */
    @Override
    public void registerEmployee(Employee employee) {
        getCurrentSession().persist(employee);
    }
}
