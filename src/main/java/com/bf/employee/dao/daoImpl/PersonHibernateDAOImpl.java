package com.bf.employee.dao.daoImpl;


import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.PersonDAO;
import com.bf.employee.entity.Person;
import com.bf.employee.entity.RegistrationToken;
import com.bf.employee.entity.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PersonHibernateDAOImpl extends AbstractHibernateDAO implements PersonDAO {

    public PersonHibernateDAOImpl() {
        setClazz(Person.class);
    }


    /*
    * Override method from RegistrationTokenDAO.
    * Register Person to the DB
    */
    @Override
    public void registerPerson(Person person) {
        getCurrentSession().persist(person);
    }

    /*
    * Return PersonID with matching firstName, lastName, email, and ssn
    */
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

    /*
    * Check is the Person exist in DB or not
    */
    @Override
    public boolean isPersonExist(Person person) {
        Query query = getCurrentSession().
                createQuery("select 1 from Person p " +
                        "where p.firstName = :firstName and p.lastName = :lastName and p.email = :email and p.ssn = :ssn");
        query.setParameter("firstName", person.getFirstName());
        query.setParameter("lastName", person.getLastName());
        query.setParameter("email", person.getEmail());
        query.setParameter("ssn", person.getSsn());
        if((query.uniqueResult() != null)){
            return true;
        }else{
            return false;
        }

    }
}
