
//  BSD License. Author: jano@jano.com.es

package com.tut.spring.dao;

import com.tut.spring.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Anotations on this class:
 *   - @Service exposes this bean in the Spring context using the given name.
 */
@Service(value = "userDao")
public class UserDaoImpl implements UserDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


// accessors

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


// UserDao implementation

    @Transactional
    public void saveOrUpdate(User user) {
        this.getSessionFactory().getCurrentSession().saveOrUpdate(user);
    }

    @Transactional
    public void delete(User user) {
        this.getSessionFactory().getCurrentSession().delete(user);
    }

    @Transactional
    public void deleteAll() {
        // no cascades so just use HQL
        String hql = String.format("delete from User");
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }

    @Transactional
    public User find(int id) {
        User user = new User();
        this.getSessionFactory().getCurrentSession().load(user, id);
        return user;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Query query = this.getSessionFactory().getCurrentSession().createQuery("from User");
        return (List<User>) query.list();
    }

}
