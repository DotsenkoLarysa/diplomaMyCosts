package com.itstep.diploma.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user", schema = "mycosts")
public class User implements UserDetails {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    @Size(min = 2, message = "Не меньше 5 знаків")
    @Column(name = "username")
    private String username;

    @Size(min = 3, message = "Не меньше 6 знаків")
    @Column(name = "password", length = 400)
    private String password;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "create_time")
    private Date create_time;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable (name="user_role", joinColumns={@JoinColumn(name = "user_userId", referencedColumnName = "user_id")},
            inverseJoinColumns={@JoinColumn(name="role_roleId",referencedColumnName="role_id")})
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Journal> journalSet;

    @OneToMany(mappedBy = "user")
    private Set<Balance> balanceSet;

    public User() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Journal> getJournalSet() {
        return journalSet;
    }

    public void setJournalSet(Set<Journal> journalSet) {
        this.journalSet = journalSet;
    }

    public Set<Balance> getBalanceSet() {
        return balanceSet;
    }

    public void setBalanceSet(Set<Balance> balanceSet) {
        this.balanceSet = balanceSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", create_time=" + create_time +
                ", role=" + role +
                '}';
    }
}
