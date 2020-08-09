package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.AddressDAO;
import com.bf.employee.dao.ContactDAO;
import com.bf.employee.entity.Address;
import com.bf.employee.entity.Contact;
import com.bf.employee.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ContactHibernateDAOImpl extends AbstractHibernateDAO implements ContactDAO {

    public ContactHibernateDAOImpl() {
        setClazz(Contact.class);
    }
    /*
     * Override method from AddressDAO.
     * Register Address to the DB
     */
    @Resource
    private SessionFactory sf;
    @Override
    public int registerContact(Contact contact) {
        try {
            getCurrentSession().persist(contact);
        }
        catch (HibernateException e) {
           sf.openSession().persist(contact);
        }

        return contact.getId();
    }



}
