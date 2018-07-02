package db;

import models.Father;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFather {
    private static Session session;
    private static Transaction transaction;

    public static void save(Father father) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(father);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Father father) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(father);
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
            Criteria criteria = session.createCriteria(Father.class);
            List<Father> results = criteria.list();
            transaction = session.beginTransaction();
            for (Father Father : results) {
                session.delete(Father);
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Father> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Father> results = null;

        try {
            Criteria criteria = session.createCriteria(Father.class);
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Father find(int id) {
        Father result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria criteria = session.createCriteria(Father.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Father) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }


    public static List<Father> oldFathers() {
            session = HibernateUtil.getSessionFactory().openSession();
            List<Father> results = null;
            try {
                Criteria criteria = session.createCriteria(Father.class);
                criteria.add(Restrictions.gt("age", 40));

                results = criteria.list();
            } catch (HibernateException e) {
                e.printStackTrace();
            } finally {
                session.close();
            }
            return results;
        }
    }

