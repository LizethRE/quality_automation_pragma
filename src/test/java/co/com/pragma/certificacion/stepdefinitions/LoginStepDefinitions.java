package co.com.pragma.certificacion.stepdefinitions;

import co.com.pragma.certification.tasks.builders.LoginTask;
import co.com.pragma.certification.userinterface.AuthenticationPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

public class LoginStepDefinitions {
    @Dado("que {actor} quiere iniciar sesion en Automation Practice")
    public void queElUsuarioQuiereIniciarSesionEnAutomationPractice(Actor actor) {
        actor.wasAbleTo(Open.browserOn().the(AuthenticationPage.class));
    }

    @Cuando("ingresa sus credenciales (.*) y (.*)$")
    public void ingresaSusCredenciales(String emailAddress, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.with()
                .emailAddress(emailAddress)
                .password(password)
                .andEnd()
        );
    }

    @Cuando("^ingresa su correo electronico (.*)$")
    public void ingresaSuCorreoElectronico(String emailAddress) {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.with()
                .emailAddress(emailAddress)
                .andEnd()
        );
    }

    @Cuando("^ingresa su contrasena (.*)$")
    public void ingresaSuContrasena(String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.with()
                .password(password)
                .andEnd()
        );
    }
}
