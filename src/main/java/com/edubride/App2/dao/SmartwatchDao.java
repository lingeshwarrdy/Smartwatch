package com.edubride.App2.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubride.App2.model.Smartwatch;
import com.edubridge.utils.HibernateUtils;


public class SmartwatchDao implements SmartwatchDaoI {

    @Override
    public void addSmartwatch(Smartwatch smartwatch) {
        Transaction tx = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        	session.persist(smartwatch);
            tx = session.beginTransaction();
            session.persist(smartwatch);
            tx.commit();
            System.out.println("New smartwatch added!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Smartwatch> getAllSmartwatches() {
        List<Smartwatch> smartwatches = new ArrayList<Smartwatch>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "from Smartwatch";
            Query<Smartwatch> query = session.createQuery(hql, Smartwatch.class);
            smartwatches = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smartwatches;
    }

    @Override
    public Smartwatch getSmartwatchById(Integer id) {
        Smartwatch smartwatch = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            smartwatch = session.get(Smartwatch.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smartwatch;
    }

    @Override
    public void updateSmartwatch(Smartwatch smartwatch) {
        Transaction tx = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(smartwatch);
            tx.commit();
            System.out.println("Smartwatch is updated!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSmartwatch(Integer id) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Smartwatch smartwatch = session.get(Smartwatch.class, id);

            if (smartwatch != null) {
                session.remove(smartwatch);
                tx.commit();
                System.out.println("Smartwatch is deleted!");
            } else {
                System.out.println("No smartwatch found!");
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllSmartwatches() {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            String hql = "delete from Smartwatch";
            Query query = session.createQuery(hql);
            query.executeUpdate();
            tx.commit();
            System.out.println("All smartwatches are deleted!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
