package me.jjo.gymbook.dto;


import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserLoginDto {
    @NotNull
    @Size(min = 9, max = 15)
    private String phone;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;
}
