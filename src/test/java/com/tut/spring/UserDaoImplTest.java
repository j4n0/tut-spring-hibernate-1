//  BSD License. Author: jano@jano.com.es

package com.tut.spring;

import com.tut.spring.dao.UserDao;
import com.tut.spring.model.User;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserDaoImplTest {

    private UserDao userDao;


    @BeforeClass
    public void setUpClass() throws Exception {
        SpringContext context = SpringContext.getInstance();
        this.userDao = (UserDao) context.getBean("userDao");
    }

    @AfterClass
    public void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        this.userDao.deleteAll();
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        User user = new User(1, "Jano",  "jano@jano.com.es");
        this.userDao.saveOrUpdate(user);
        User found = this.userDao.find(1);
        Assert.assertEquals(user, found,"Object created " + user + " should equal object read " + found);
    }

    @Test
    public void testDelete() throws Exception {
        User user = new User(1, "Jano",  "jano@jano.com.es");
        this.userDao.saveOrUpdate(user);
        this.userDao.delete(user);
        List<User> users = this.userDao.findAll();
        Assert.assertEquals(users.size(),0);
    }

    // public void testFind() throws Exception
    // Tested elsewhere.

    @Test
    public void testFindAll() throws Exception {
        User jano = new User(1, "Jano",  "jano@jano.com.es");
        this.userDao.saveOrUpdate(jano);
        User alice = new User(2, "Alice",  "alice@wonderland.com");
        this.userDao.saveOrUpdate(alice);
        List<User> users = this.userDao.findAll();
        Assert.assertEquals(users.size(),2);
    }
}
