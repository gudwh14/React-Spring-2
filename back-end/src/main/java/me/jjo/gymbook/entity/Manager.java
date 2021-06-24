package me.jjo.gymbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "manager")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gym_name" , length = 20, nullable = false , unique = true)
    private String gymName;

    @JsonIgnore
    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name= "gym_type", length = 10, nullable = false)
    private String gymType;

    @Column(name = "location", length = 35, nullable = false)
    private String location;

    @Column(name = "phone", length = 15, nullable = false)
    private String phone;

    @ManyToMany
    @JoinTable(
            name = "manager_authority",
            joinColumns = {@JoinColumn(name = "manager_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    @Builder
    public Manager(String gymName, String password, String gymType, String location, String phone) {
        this.gymName = gymName;
        this.password = password;
        this.gymType = gymType;
        this.location = location;
        this.phone = phone;
    }
}
