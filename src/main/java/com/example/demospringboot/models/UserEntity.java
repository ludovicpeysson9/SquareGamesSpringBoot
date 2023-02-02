package com.example.demospringboot.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;
//import org.hibernate.annotations.Table;

@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean accountNonExpired;

    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


//    @ManyToMany(fetch = FetchType.EAGER)
    @ElementCollection(fetch = FetchType.EAGER)
    private Collection<String> userAuthorities;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
//    public Collection<UserRoleEntity> getUserRoles() {
//        return userRoles;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userAuthorities.stream().map(s -> new GrantedAuthority() {
            // parcours userAuthorities et transforme chaque élément en objet GrantedAuthority
            @Override
            public String getAuthority() {
                return s;
            }
        }).collect(Collectors.toList());
        //le .collect permet d'arrêter et de convertir le stream pour pouvoir le retourner
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserAuthorities(Collection<String> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }
}
