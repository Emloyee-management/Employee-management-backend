package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.AddressDAO;
import com.bf.employee.entity.Address;
import com.bf.employee.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class AddressHibernateDAOImpl extends AbstractHibernateDAO implements AddressDAO {

    public AddressHibernateDAOImpl() {
        setClazz(Employee.class);
    }
    /*
     * Override method from AddressDAO.
     * Register Address to the DB
     */
    @Override
    public int registerAddress(Address address) {
        getCurrentSession().persist(address);
        return address.getId();
    }



}
