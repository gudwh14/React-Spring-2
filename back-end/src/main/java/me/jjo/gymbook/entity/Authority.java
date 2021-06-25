package me.jjo.gymbook.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "authority")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Authority {

    @Id
    @Column(name = "authority_name" , length = 15)
    private String authorityName;


}
