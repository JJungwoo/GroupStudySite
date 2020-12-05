package com.gss.groupstudysite.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;
    private String email;
    private String nickname;
    private Boolean subscription;
}
