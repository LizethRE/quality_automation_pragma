package co.com.pragma.certification.tasks.builders;

import co.com.pragma.certification.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.pragma.certification.userinterface.AuthenticationPage.*;

public class LoginTask implements Task {
    private User user;

    public LoginTask(User user) {
        this.user = user;
    }

    public static LoginBuilder with() {
        return new LoginBuilder();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGN_IN_TITLE_LABEL).andAlignToTop(),
                Enter.theValue(user.getEmailAddress()).into(SIGN_IN_EMAIL_ADDRESS_INPUT),
                Enter.theValue(user.getPassword()).into(SIGN_IN_PASSWORD_INPUT),
                Click.on(SIGN_IN_BUTTON)
        );
    }

    public static class LoginBuilder{
        private String emailAddress;
        private String password;

        public LoginBuilder emailAddress(String emailAddress){
            this.emailAddress = emailAddress;
            return this;
        }

        public LoginBuilder password(String password){
            this.password = password;
            return this;
        }

        public LoginTask andEnd(){
            return new LoginTask(User.builder()
                    .emailAddress(this.emailAddress)
                    .password(this.password)
                    .build()
            );
        }
    }
}
