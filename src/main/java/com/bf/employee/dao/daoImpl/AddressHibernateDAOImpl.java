package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.AddressDAO;
import com.bf.employee.entity.Address;
import com.bf.employee.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class AddressHibernateDAOImpl extends AbstractHibernateDAO implements AddressDAO {

    public AddressHibernateDAOImpl() {
        setClazz(Address.class);
    }
    /*
     * Override method from AddressDAO.
     * Register Address to the DB
     */
    @Resource
    private SessionFactory sf;
    @Override
    public int registerAddress(Address address) {
        try {
            getCurrentSession().persist(address);
        }
        catch (HibernateException e) {
            sf.openSession().persist(address);
        }
        return address.getId();
    }

    @Override
    public int getAddressIdByPersonId(int personId) {
        String addressQ = "SELECT a FROM Address a WHERE personId = :person_id";
        Query addressQuery = getCurrentSession().createQuery(addressQ);
        addressQuery.setParameter("person_id", personId);
        Address a = (Address) addressQuery.list().get(0);
        return a.getId();
    }

    @Override
    public int updateAddress(Address address) {
        getCurrentSession().clear();
        getCurrentSession().update(address);
        return address.getId();
    }


}
