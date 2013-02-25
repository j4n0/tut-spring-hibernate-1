
//  BSD License. Author: jano@jano.com.es

package com.tut.spring.dao;

import java.util.List;
import com.tut.spring.model.User;

public interface UserDao {

    public void saveOrUpdate(User user);

    public void delete(User user);

    public void deleteAll();

    public User find(int id);

    public List<User> findAll();
    
}
