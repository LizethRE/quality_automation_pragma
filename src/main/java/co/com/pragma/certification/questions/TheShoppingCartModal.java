package co.com.pragma.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterface.ShoppingCartModal.MESSAGE_LABEL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class TheShoppingCartModal implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(MESSAGE_LABEL, isVisible()).forNoMoreThan(10).seconds());

        return MESSAGE_LABEL.resolveFor(actor).getText();
    }

    public static TheShoppingCartModal text() {
        return new TheShoppingCartModal();
    }
}