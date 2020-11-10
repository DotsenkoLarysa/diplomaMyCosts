package com.itstep.diploma.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "role", schema = "mycosts")
public class Role {

    @Id
    @Column(name="role_id")
    @GeneratedValue
    private int role_id;

    @Column(name="name")
    private String name;

    public Role() {
    }

    public Role(int role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", name='" + name + '\'' +
                '}';
    }
}
