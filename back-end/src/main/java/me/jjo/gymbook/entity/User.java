package me.jjo.gymbook.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "password",length = 100 , nullable = false)
    private String password;

    @JsonIgnore
    @Column(name = "phone", length = 15, nullable = false, unique = true)
    private String phone;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    @Builder
    public User(String name,String password, String phone, Set<Authority> authorities) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.authorities = authorities;
    }
}
