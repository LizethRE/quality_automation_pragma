package co.com.pragma.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.pragma.certification.userinterface.AlertPage.ALERT_LABEL;


public class TheAlertMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return ALERT_LABEL.resolveFor(actor).getText();
    }

    public static TheAlertMessage text() {
        return new TheAlertMessage();
    }
}