package co.com.pragma.certification.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {
    private String company;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String additional;
    private String homePhone;
    private String mobilePhone;
    private String addressAlias;
}
