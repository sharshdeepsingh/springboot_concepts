
package org.sharshdeep.model;

public class User {

    private Integer id;
    private String name;
    private String email;
    private String number;

    public User(Integer id, String name,
                String email, String number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }
}
