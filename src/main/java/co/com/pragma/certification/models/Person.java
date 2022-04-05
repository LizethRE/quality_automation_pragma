package co.com.pragma.certification.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {
    private String title;
    private String firstName;
    private String lastName;
    private String dateBirth;
}
