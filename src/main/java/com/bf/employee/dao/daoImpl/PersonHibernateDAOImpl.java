package com.bf.employee.dao.daoImpl;


import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.PersonDAO;
import com.bf.employee.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonHibernateDAOImpl extends AbstractHibernateDAO implements PersonDAO {

    /*
    * Override method from RegistrationTokenDAO.
    * Register Person to the DB
    */
    @Override
    public void registerPerson(Person person) {
        getCurrentSession().persist(person);
    }
}
