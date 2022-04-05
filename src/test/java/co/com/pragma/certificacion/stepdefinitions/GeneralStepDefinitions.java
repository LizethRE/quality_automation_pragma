package co.com.pragma.certificacion.stepdefinitions;

import co.com.pragma.certification.questions.TheAlertMessage;
import co.com.pragma.certification.questions.TheUsername;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


public class GeneralStepDefinitions {
    @Entonces("^deberia ver el nombre de usuario (.*)$")
    public void deberiaVerElNombreUsuario(String username) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheUsername.value(), equalTo(username)));
    }

    @Entonces("^deberia ver la alerta con el mensaje (.*)$")
    public void deberiaVerLaAlertaConElMensaje(String message) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheAlertMessage.text(), equalTo(message)));
    }
}
