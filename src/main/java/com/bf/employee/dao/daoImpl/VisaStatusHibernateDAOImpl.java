package com.bf.employee.dao.daoImpl;

import com.bf.employee.dao.AbstractHibernateDAO;
import com.bf.employee.dao.VisaStatusDAO;
import com.bf.employee.entity.VisaStatus;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class VisaStatusHibernateDAOImpl extends AbstractHibernateDAO implements VisaStatusDAO {

    @Resource
    private SessionFactory sf;

    public VisaStatusHibernateDAOImpl() {
        setClazz(VisaStatus.class);
    }

    @Override
    public int registerVisaStatus(VisaStatus visaStatus) {
        getCurrentSession().persist(visaStatus);
        return visaStatus.getId();
    }

    /*
     * Return PersonID with matching firstName, lastName, email, and ssn
     */
    @Override
    public int findByUserName(String userName) {
        Query query = getCurrentSession().
                createQuery("select vs.id from VisaStatus vs " +
                        "where vs.createUser =:userName");
        query.setParameter("userName", userName);
        return (int)query.getResultList().get(0);
    }

    @Override
    public VisaStatus getVisaInfo(int employeeVisaStatusId) {
        Session session = getCurrentSession();
        String hql = "FROM VisaStatus V WHERE V.id = " + employeeVisaStatusId;
        Query query = session.createQuery(hql);
        return (VisaStatus) query.list().get(0);
    }

    @Override
    public Boolean updateVisaType(int employeeVisaStatusId, String visaType) {
        System.out.println("personService: "+visaType.toString());
        System.out.println("personServiceL" + employeeVisaStatusId);
        Session session = getCurrentSession();
        String hql = "UPDATE VisaStatus set visaType = :visaType " +
                "WHERE id = :visaStatusId";
//        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("visaType", visaType);
        query.setParameter("visaStatusId", employeeVisaStatusId);
        int result = query.executeUpdate();
//        tx.commit();commit
//        session.close();
//        session.getTransaction().commit();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<VisaStatus> getAll() {
        String hql = "FROM VisaStatus";
        List<VisaStatus> list = getCurrentSession().createQuery(hql).list();
        return list;
    }

    @Override
    public int updateVisaStatus(VisaStatus visaStatus) {
        try {
            getCurrentSession().update(visaStatus);
        }
        catch (HibernateException e) {
            sf.openSession().update(visaStatus);
        }

        return visaStatus.getId();
    }
}
