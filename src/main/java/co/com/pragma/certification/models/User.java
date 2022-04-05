package co.com.pragma.certification.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String emailAddress;
    private String password;
}
