package co.com.pragma.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.pragma.certification.userinterface.AccountHomePage.USERNAME_LABEL;


public class TheUsername implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return USERNAME_LABEL.resolveFor(actor).getText();
    }

    public static TheUsername value() {
        return new TheUsername();
    }
}