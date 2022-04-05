package co.com.pragma.certification.tasks.builders;

import co.com.pragma.certification.models.Address;
import co.com.pragma.certification.models.Person;
import co.com.pragma.certification.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterface.AccountCreationPage.*;
import static co.com.pragma.certification.userinterface.AuthenticationPage.*;


public class RegisterTask implements Task {
    private User user;
    private Person person;
    private Address address;

    public RegisterTask(User user, Person person, Address address) {
        this.user = user;
        this.person = person;
        this.address = address;
    }

    public static RegisterBuilder with() {
        return new RegisterBuilder();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CREATE_TITLE_LABEL).andAlignToTop(),
                Enter.theValue(user.getEmailAddress()).into(CREATE_EMAIL_ADDRESS_INPUT),
                Click.on(CREATE_AN_ACCOUNT_BUTTON)
        );

        actor.attemptsTo(WaitUntil.the(PERSONAL_INFORMATION_TITLE_LABEL, WebElementStateMatchers.isVisible()).forNoMoreThan(15).seconds());

        if (person.getTitle().contains("Mrs"))
            actor.attemptsTo(Click.on(TITLE_COMBO_BOX(2)));
        else
            actor.attemptsTo(Click.on(TITLE_COMBO_BOX(1)));

        actor.attemptsTo(
                Enter.theValue(person.getFirstName()).into(CUSTOMER_FIRST_NAME_INPUT),
                Enter.theValue(person.getLastName()).into(CUSTOMER_LAST_NAME_INPUT),
                Enter.theValue(user.getPassword()).into(PASSWORD_INPUT)
        );

        String [] dateOfBirth = convertDateOfBirth();

        actor.attemptsTo(
                SelectFromOptions.byValue(dateOfBirth[0]).from(BIRTHDAY_SELECT),
                SelectFromOptions.byValue(dateOfBirth[1]).from(BIRTHDAY_MONTH_SELECT),
                SelectFromOptions.byValue(dateOfBirth[2]).from(BIRTHDAY_YEAR_SELECT),
                Enter.theValue(person.getFirstName()).into(FIRST_NAME_INPUT),
                Enter.theValue(person.getLastName()).into(LAST_NAME_INPUT),
                Enter.theValue(address.getCompany()).into(COMPANY_INPUT),
                Enter.theValue(address.getAddress()).into(ADDRESS_ONE_INPUT),
                Enter.theValue(address.getAddress2()).into(ADDRESS_TWO_INPUT),
                Enter.theValue(address.getCity()).into(CITY_INPUT),
                SelectFromOptions.byVisibleText(address.getState()).from(STATE_SELECT),
                Enter.theValue(address.getPostalCode()).into(POSTAL_CODE_INPUT),
                SelectFromOptions.byVisibleText(address.getCountry()).from(COUNTRY_SELECT),
                Enter.theValue(address.getAdditional()).into(ADDITIONAL_INFORMATION_TEXTAREA),
                Enter.theValue(address.getHomePhone()).into(HOME_PHONE_INPUT),
                Enter.theValue(address.getMobilePhone()).into(MOBILE_PHONE_INPUT),
                Enter.theValue(address.getAddressAlias()).into(ADDRESS_ALIAS_INPUT),
                Click.on(REGISTER_BUTTON)
        );
    }

    public static class RegisterBuilder{
        private String title;
        private String firstName;
        private String lastName;
        private String emailAddress;
        private String password;
        private String dateBirth;
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


        public RegisterBuilder title(String title){
            this.title = title;
            return this;
        }

        public RegisterBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public RegisterBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public RegisterBuilder emailAddress(String emailAddress){
            this.emailAddress = emailAddress;
            return this;
        }

        public RegisterBuilder password(String password){
            this.password = password;
            return this;
        }

        public RegisterBuilder dateOfBirth(String dateBirth){
            this.dateBirth = dateBirth;
            return this;
        }

        public RegisterBuilder company(String company){
            this.company = company;
            return this;
        }

        public RegisterBuilder address(String address){
            this.address = address;
            return this;
        }

        public RegisterBuilder secondAddress(String address){
            this.address2 = address;
            return this;
        }

        public RegisterBuilder city(String city){
            this.city = city;
            return this;
        }

        public RegisterBuilder state(String state){
            this.state = state;
            return this;
        }

        public RegisterBuilder postalCode(String postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public RegisterBuilder country(String country){
            this.country = country;
            return this;
        }

        public RegisterBuilder additionalInformation(String additional){
            this.additional = additional;
            return this;
        }

        public RegisterBuilder homePhone(String homePhone){
            this.homePhone = homePhone;
            return this;
        }

        public RegisterBuilder mobilePhone(String mobilePhone){
            this.mobilePhone = mobilePhone;
            return this;
        }

        public RegisterBuilder addressAlias(String addressAlias){
            this.addressAlias = addressAlias;
            return this;
        }

        public RegisterTask andEnd(){
            return new RegisterTask(
                    User.builder()
                    .emailAddress(this.emailAddress)
                    .password(this.password)
                    .build(),
                    Person.builder()
                            .title(this.title)
                            .firstName(this.firstName)
                            .lastName(this.lastName)
                            .dateBirth(this.dateBirth)
                            .build(),
                    Address.builder()
                            .company(this.company)
                            .address(this.address)
                            .address2(this.address2)
                            .city(this.city)
                            .state(this.state)
                            .postalCode(this.postalCode)
                            .country(this.country)
                            .additional(this.additional)
                            .homePhone(this.homePhone)
                            .mobilePhone(this.mobilePhone)
                            .addressAlias(this.addressAlias)
                            .build()
            );
        }
    }

    public String [] convertDateOfBirth(){
        String [] dateOfBirthSplit = person.getDateBirth().split("/");

        for (int i = 0; i < dateOfBirthSplit.length; i++) {
            if (dateOfBirthSplit[i].charAt(0) == '0'){
                StringBuilder stringBuilder = new StringBuilder(dateOfBirthSplit[i]);
                stringBuilder.deleteCharAt(0);
                dateOfBirthSplit[i] = stringBuilder.toString();
            }
        }
        return dateOfBirthSplit;
    }
}
