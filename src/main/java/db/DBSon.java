package db;

import models.Son;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBSon {

    private static Session session;
    private static Transaction transaction;

    public static void save(Son son) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(son);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void delete(Son son) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(son);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static void deleteAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Son.class);
            List<Son> results = criteria.list();
            transaction = session.beginTransaction();
            for (Son Son : results) {
                session.delete(Son);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Son> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Son> results = null;

        try {
            Criteria criteria = session.createCriteria(Son.class);
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Son find(int id) {
        Son result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Son.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Son) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }


}






