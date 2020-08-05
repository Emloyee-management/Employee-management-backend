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
    * Override method from PersonDAO.
    * Register Person to the DB
    */
    @Override
    public int registerPerson(Person person) {
        getCurrentSession().persist(person);
        return person.getId();
    }

    /*
    * Return PersonID with matching firstName, lastName, email, and ssn
    */
    @Override
    public int findByName(String firstName, String lastName, String email) {
        Query query = getCurrentSession().
                createQuery("select p.id from Person p " +
                        "where p.firstName = :firstName and p.lastName = :lastName and p.email = :email");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("email", email);
        return (int)query.getResultList().get(0);

    }

    /*
    * Check is the Person exist in DB or not
    */
    @Override
    public boolean isPersonExist(Person person) {
        Query query = getCurrentSession().
                createQuery("select 1 from Person p " +
                        "where p.firstName = :firstName and p.lastName = :lastName and p.email = :email");
        query.setParameter("firstName", person.getFirstName());
        query.setParameter("lastName", person.getLastName());
        query.setParameter("email", person.getEmail());
        if((query.uniqueResult() != null)){
            return true;
        }else{
            return false;
        }

    }
}
