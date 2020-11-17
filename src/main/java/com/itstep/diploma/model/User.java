package com.itstep.diploma.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "user", schema = "mycosts")
public class User {

    @Id
    @Column(name="user_id")
    @GeneratedValue
    private Long user_id;

    @NotBlank(message="Username is mandatory")
    @Column(name="username")
    private String username;

    @NotBlank(message="Password is mandatory")
    @Length(max = 6, min = 3)
    @Column(name="password")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date create_time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_role_id"))
    private Role roleSet;

    public User() {
    }

    public User(String username, String password) {
    }

    public User(Long user_id, @NotBlank(message = "Username is mandatory") String username,
                @NotBlank(message = "Password is mandatory") @Length(max = 6, min = 3) String password,
                Date create_time, Role roleSet) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.create_time = create_time;
        this.roleSet = roleSet;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Role getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Role roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", create_time=" + create_time +
                ", roleSet=" + roleSet +
                '}';
    }
}
