package com.bf.employee.dao.daoImpl;

import com.bf.employee.constant.Constant;
import com.bf.employee.dao.DocumentDao;
import com.bf.employee.entity.DocumentList;
import com.bf.employee.entity.DocumentResponse;
import com.bf.employee.entity.PersonalDocument;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Yang Yuan
 * @Time: 2020/8/9
 */

@Repository
public class DocumentDaoImpl implements DocumentDao {
    @Resource
    private SessionFactory sf;

    @Override
    public List<PersonalDocument> getAllDocsByEmployeeId(Integer eid) {
        Session session;
        try {
            session = sf.getCurrentSession();
        }

        catch (HibernateException hibernateException) {
            session = sf.openSession();
        }
        String hql = "select p from PersonalDocument p where p.employeeId = :eid";
        List<Object> list =  session.createQuery(hql).setParameter("eid", eid).list();
        List<PersonalDocument> res = new ArrayList<>();
        for(Object o : list) {
            res.add((PersonalDocument) o);
        }
        return res;
    }

    @Override
    @Transactional
    public Boolean updateDocStatus(Integer eid, String docName) {
        Session session;
        try {
            session = sf.getCurrentSession();
        }

        catch (HibernateException hibernateException) {
            session = sf.openSession();
        }
        PersonalDocument personalDocument = new PersonalDocument();
        personalDocument.setEmployeeId(eid);
        personalDocument.setTitle(docName);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        personalDocument.setCreatedDate(formatter.format(date));
        personalDocument.setPath(Constant.CLASS_PATH + "\\" + eid + "\\" + docName);
        session.persist(personalDocument);
//        session.beginTransaction().commit();
//        session.getTransaction().commit();
        return true;
    }
}
