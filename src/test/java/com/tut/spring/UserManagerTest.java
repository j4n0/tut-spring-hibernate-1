
//  BSD License. Author: jano@jano.com.es

package com.tut.spring;

import java.util.ArrayList;
import java.util.List;

import com.tut.spring.model.User;
import com.tut.spring.service.UserManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserManagerTest {

    private static Logger logger = Logger.getLogger(UserManagerTest.class);

    /*
    public static void main(String[] args) throws Exception {
        new UserManagerTest().testInsertUser();
    }


    @Test
    public void testInsertUser() throws Exception {

        SpringContext context = SpringContext.getInstance();

        // create two users
        User user1 = new User(1, "Jano",  "jano@jano.com.es");
        User user2 = new User(2, "Alice", "alice@wonderland.com");
        List<User> users = new ArrayList();
        users.add(user1);
        users.add(user2);

        // insert them
        UserManager userManager = (UserManager) context.getBean("userManager");
        userManager.insertUsers(users);
        logger.debug("Inserted: " + users);

        // read them back
        List<User> userList = userManager.findAll();
        logger.debug("Found: " + userList);

        // check that we read the same data we inserted before
        Assert.assertTrue(userList.contains(user1) && userList.contains(user2));
    }
    */
}