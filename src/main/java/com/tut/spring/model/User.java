
//  BSD License. Author: jano@jano.com.es

package com.tut.spring.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int id = 0;
    
    @Column(name = "name")
    private String name = null;
    
    @Column(name = "email")
    private String email = null;


// constructors

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {
    }

// accessors

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

// Object overrides

    @Override
    public String toString() {
        return "[" + this.id + ", " + this.name + ", " + this.email + "]";
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    // Two users are equal if they have the same id.
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof User) {
            if (id == ((User)obj).id) {
                return true;
            }
        }
        return false;
    }
    
}