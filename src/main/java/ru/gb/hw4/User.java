package ru.gb.hw4;

public class User {
    private static Integer counter = 0;
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public User() {
    }

    public User(String name, String email, Integer age) {
        this.id = counter++;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
