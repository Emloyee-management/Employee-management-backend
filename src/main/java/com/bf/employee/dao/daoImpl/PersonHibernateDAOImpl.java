package com.bf.employee.dao.daoImpl;


import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.PersonDAO;
import com.bf.employee.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
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
        Session session;
        try {
            session = getCurrentSession();
        }
        catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
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
        personalInfoResponse.setSsn(personInfo.getSsn());
//        personalInfoResponse.setVisaEndDate(personInfo.set);

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
        personalInfoResponse.setGender(personInfo.getGender());
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


    public List<HRPersonalInfoResponse> getPersonList(){
        List<HRPersonalInfoResponse> pInfoList = new ArrayList<>();

        String personQ = "SELECT p FROM Person p";
        String employeeQ = "SELECT e FROM Employee e WHERE personId = :person_id";
        String addressQ = "SELECT a FROM Address a WHERE personId = :person_id";
        String userQ = "SELECT u FROM User u WHERE personId = :person_id";
        String visaStatusQ = "SELECT v FROM VisaStatus v WHERE CreateUser = :username";

       // String contactQ = "SELECT c FROM Contact c WHERE personId = :person_id AND isEmergency = 1";


        Query personQuery = getCurrentSession().createQuery(personQ);
        Query userQuery = getCurrentSession().createQuery(userQ);


        for(int i=0; i<personQuery.list().size(); i++){
            Person p = (Person) personQuery.list().get(i);
            int personId = p.getId();
            userQuery.setParameter("person_id", personId);
            User u = (User) userQuery.list().get(0);
            String username = u.getUserName();

            Query employeeQuery = getCurrentSession().createQuery(employeeQ);
            Query addressQuery = getCurrentSession().createQuery(addressQ);
            Query visaStatusQuery = getCurrentSession().createQuery(visaStatusQ);
            //Query contactQuery = getCurrentSession().createQuery(contactQ);

            employeeQuery.setParameter("person_id", personId);
            addressQuery.setParameter("person_id", personId);
            visaStatusQuery.setParameter("username",username);
            //contactQuery.setParameter("person_id", personId);

            Employee e = (Employee) employeeQuery.list().get(0);
            Address a = (Address) addressQuery.list().get(0);
            VisaStatus v = (VisaStatus) visaStatusQuery.list().get(0);
            //Contact c = (Contact) contactQuery.list().get(0);

            HRPersonalInfoResponse pr = HRPersonalInfoResponse.builder()
                    //person
                    .firstName(p.getFirstName())
                    .lastName(p.getLastName())
                    .middleName(p.getMiddleName())
                    .email(p.getEmail())
                    .cellphone(p.getCellphone())
                    .alternatePhone(p.getAlternatePhone())
                    .gender(p.getGender())
                    .ssn(p.getSsn())
                    .dob(p.getDob())
                    //employee
                    .avatar(e.getAvatar())
                    .employmentStartDate(e.getStartDate())
                    .employmentEndDate(e.getEndDate())
                    .visaStartDate(e.getVisaStartDate())
                    .visaEndDate(e.getVisaEndDate())
                    .car(e.getCar())
                    .driverLicense(e.getDriverLicence())
                    .driverLicense_expirationDate(e.getDriverExpirationDate())
                    //address
                    .addressLine1(a.getAddressLine1())
                    .addressLine2(a.getAddressLine2())
                    .city(a.getCity())
                    .zipCode(a.getZipcode())
                    .stateName(a.getStateName())
                    .stateAbbr(a.getStateAbbr())
                    //visa-status
                    .visaType(v.getVisaType())
                    .build();




            pInfoList.add(pr);



        }

        return pInfoList;

    }


}
