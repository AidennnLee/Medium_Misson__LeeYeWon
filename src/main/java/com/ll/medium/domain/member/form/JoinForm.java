package com.ll.medium.domain.member.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinForm {
    //@Size(min = 3, max = 10)
    private String username;

    //@Size(min = 8, max = 15)
    private String password;

    private String passwordCheck;
}
