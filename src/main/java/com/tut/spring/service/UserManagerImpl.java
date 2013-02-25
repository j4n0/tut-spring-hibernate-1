
//  BSD License. Author: jano@jano.com.es

package com.tut.spring.service;

import java.util.List;

import javax.annotation.Resource;

import com.tut.spring.dao.UserDao;
import com.tut.spring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Annotations on this class:
 *   - @Service enables autowiring of this class by name.
 *   - @Transaction creates a transaction for the given operation.
 *   - @Resource marks a field that needs to be injected by the container when this class is initialized.
 */
@Service(value = "userManager")
public class UserManagerImpl implements UserManager {

    @Resource(name = "userDao")
    private UserDao userDAO = null;

// accessors

    public UserDao getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDao userDAO) {
        this.userDAO = userDAO;
    }

// UserManager implementation

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertUsers(List<User> users) {
        if (users != null) {
            for (User user : users) {
                this.userDAO.saveOrUpdate(user);
            }
        }
    }

    public List<User> findAll() {
        return this.userDAO.findAll();
    }

}
