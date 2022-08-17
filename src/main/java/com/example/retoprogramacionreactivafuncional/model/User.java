package com.example.retoprogramacionreactivafuncional.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "user")
public class User {
    @Id
    private String idUser;
    private String name;
    private Integer Age;

    public User(String name, Integer Age) {
        this.name = name;
        this.Age = Age;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        this.Age = age;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idPersona=" + idUser +
                ", nombres='" + name + '\'' +
                ", edad=" + Age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) && Objects.equals(name, user.name) && Objects.equals(Age, user.Age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, name, Age);
    }
}
