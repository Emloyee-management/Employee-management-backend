package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.AddressDAO;
import com.bf.employee.dao.ContactDAO;
import com.bf.employee.entity.Address;
import com.bf.employee.entity.Contact;
import com.bf.employee.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class ContactHibernateDAOImpl extends AbstractHibernateDAO implements ContactDAO {

    public ContactHibernateDAOImpl() {
        setClazz(Employee.class);
    }
    /*
     * Override method from AddressDAO.
     * Register Address to the DB
     */
    @Override
    public int registerContact(Contact contact) {
        getCurrentSession().persist(contact);
        return contact.getId();
    }



}
