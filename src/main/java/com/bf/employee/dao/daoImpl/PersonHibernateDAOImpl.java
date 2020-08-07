package com.bf.employee.dao.daoImpl;


import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.PersonDAO;
import com.bf.employee.entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        } else {
            return false;
        }

    }

    @Override
    public PersonalInfoResponse getPersonalInfo(Integer personId) {
        PersonalInfoResponse personalInfoResponse = new PersonalInfoResponse();

        Session session = getCurrentSession();
        String employeeQ = "SELECT e FROM Employee e WHERE personId = :person_id";
        String personQ = "SELECT p FROM Person p WHERE id = :person_id";
        String addressQ = "SELECT a FROM Address a WHERE personId = :person_id";
        String contactQ = "SELECT c FROM Contact c WHERE personId = :person_id AND isEmergency = 1";

        Query employeeQuery = session.createQuery(employeeQ);
        Query personQuery = session.createQuery(personQ);
        Query addressQuery = session.createQuery(addressQ);
        Query contactQuery = session.createQuery(contactQ);

        employeeQuery.setParameter("person_id", personId);
        personQuery.setParameter("person_id", personId);
        addressQuery.setParameter("person_id", personId);
        contactQuery.setParameter("person_id", personId);

        Employee employeeInfo = (Employee) employeeQuery.list().get(0);
        Person personInfo = (Person) personQuery.list().get(0);
        Address addressInfo = (Address) addressQuery.list().get(0);
        Contact contactInfo = (Contact) contactQuery.list().get(0);

        String visaQ = "SELECT v FROM VisaStatus v WHERE id=:visa_status_id";
        Query visaQuery = session.createQuery(visaQ);
        visaQuery.setParameter("visa_status_id", employeeInfo.getVisaStatusId());
        VisaStatus visaInfo = (VisaStatus) visaQuery.list().get(0);

        personalInfoResponse.setVisaType(visaInfo.getVisaType());

        personalInfoResponse.setFirstName(personInfo.getFirstName());
        personalInfoResponse.setLastName(personInfo.getLastName());
        personalInfoResponse.setWorkEmail(personInfo.getEmail());
        personalInfoResponse.setCellPhone(personInfo.getCellphone());
        personalInfoResponse.setAlternatePhone(personInfo.getAlternatePhone());
        personalInfoResponse.setDob(personInfo.getDob());

        personalInfoResponse.setAvatar(employeeInfo.getAvatar());
        personalInfoResponse.setTitle(employeeInfo.getTitle());
        personalInfoResponse.setEmploymentStartDate(employeeInfo.getStartDate());
        personalInfoResponse.setEmploymentEndDate(employeeInfo.getEndDate());
        personalInfoResponse.setVisaStartDate(employeeInfo.getVisaStartDate());
        personalInfoResponse.setVisaEndDate(employeeInfo.getVisaEndDate());

        personalInfoResponse.setAddressLine1(addressInfo.getAddressLine1());
        personalInfoResponse.setAddressLine2(addressInfo.getAddressLine2());
        personalInfoResponse.setCity(addressInfo.getCity());
        personalInfoResponse.setStateName(addressInfo.getStateName());
        personalInfoResponse.setZipCode(addressInfo.getZipcode());

        personQuery.setParameter("person_id", contactInfo.getPersonId());
        addressQuery.setParameter("person_id", contactInfo.getPersonId());

        Person emergencyInfo = (Person) personQuery.list().get(0);
        Address emergencyAddressInfo = (Address) addressQuery.list().get(0);
        personalInfoResponse.setEmergencyContactFullname(emergencyInfo.getFirstName() + " " + emergencyInfo.getLastName());
        personalInfoResponse.setEmergencyContactPhone(emergencyInfo.getCellphone());
        personalInfoResponse.setEmergencyContactAddress(emergencyAddressInfo.getAddressLine1() + ", " + emergencyAddressInfo.getCity() + ", " + emergencyAddressInfo.getStateName());

//        System.out.println(employeeInfo.getTitle());
        return personalInfoResponse;
    }
}
