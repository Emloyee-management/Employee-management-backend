package com.bf.employee.dao.daoImpl;


import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.PersonDAO;
import com.bf.employee.entity.Person;
import org.hibernate.query.Query;
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

    @Override
    public int findByName(String firstName, String lastName, String email, String ssn) {
        Query query = getCurrentSession().
                createQuery("select p.id from Person p " +
                        "where p.firstName = :firstName and p.lastName = :lastName and p.email = :email and p.ssn = :ssn");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("email", email);
        query.setParameter("ssn", ssn);
        return (int)query.uniqueResult();
    }
}
