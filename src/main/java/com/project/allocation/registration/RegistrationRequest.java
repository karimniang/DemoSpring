package com.project.allocation.registration;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private  String firstname;
    private  String lastname;
    private  String email;
    private  String password;

}
