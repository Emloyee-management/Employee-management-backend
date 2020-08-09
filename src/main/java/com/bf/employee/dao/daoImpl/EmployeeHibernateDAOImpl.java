package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.EmployeeDAO;
import com.bf.employee.entity.Employee;
import com.bf.employee.entity.Person;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository
@Transactional
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

    @Override
    public int updateEmployee(Employee employee) {
        getCurrentSession().clear();
        getCurrentSession().update(employee);
        return employee.getId();
    }

    @Override
    public int getEmployeeIdByPersonId(int personId) {
        String employeeQ = "SELECT e FROM Employee e WHERE personId = :person_id";
        Query employeeQuery = getCurrentSession().createQuery(employeeQ);
        employeeQuery.setParameter("person_id", personId);
        Employee e = (Employee) employeeQuery.list().get(0);
        return e.getId();
    }

}
