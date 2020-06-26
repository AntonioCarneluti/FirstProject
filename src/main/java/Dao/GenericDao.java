package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class GenericDao<T> {
    SessionFactory sessionFactory;

    public GenericDao() {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        sessionFactory = databaseConnection.getSessionFactory();
    }


    public void add(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public List<T> getAll(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName());
        List<T> results = query.getResultList();
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return results;
    }


    public Optional<T> findByIdOptional(T object, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Optional<T> myOptional = (Optional<T>) session.find(object.getClass(), id);
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return myOptional;
    }

    public T findById(T object, int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where id=" + id + "");
        T result = (T) query.getSingleResult();
        transaction.commit();
        if (session != null) {
            session.close();
        }
        return result;


    }


    public void update(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }

    public void delete(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        if (session != null) {
            session.close();
        }
    }


}