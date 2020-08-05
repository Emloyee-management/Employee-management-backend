package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.PersonDAO;
import com.bf.employee.entity.PersonalInfoResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonDAOImpl implements PersonDAO{
    @Resource
    private SessionFactory sf;

    @Override
    public PersonalInfoResponse getPersonalInfo(Integer personId) {
        Session session = sf.getCurrentSession();
        String hql = "FROM Person p WHERE PersonID = :person_id";
        Query query = session.createQuery(hql);
        query.setParameter("person_id",1);
        return null;
    }
}
