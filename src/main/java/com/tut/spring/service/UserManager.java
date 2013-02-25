
//  BSD License. Author: jano@jano.com.es

package com.tut.spring.service;

import java.util.List;

import com.tut.spring.model.User;

public interface UserManager {
    
    public void insertUsers(List<User> users);

    public List<User> findAll();
}
