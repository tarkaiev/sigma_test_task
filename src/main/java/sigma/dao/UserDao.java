package sigma.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import sigma.model.User;

@Repository
public class UserDao {
    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add new user " + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't update user " + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            user.setDeleted(true);
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't delete user " + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public User findByLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User where "
                    + "deleted = 0 and login = :login", User.class);
            query.setParameter("login", login);
            return query.uniqueResult();
        }
    }

    public List<User> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("from User where deleted = 0", User.class);
            return query.getResultList();
        }
    }
}
