package co.com.pragma.certification.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:sign.in.page")
public class AuthenticationPage extends PageObject {
    public static final Target CREATE_TITLE_LABEL = Target.the("título de la primera sección").
            located(By.cssSelector("#create-account_form > .page-subheading"));
    public static final Target CREATE_EMAIL_ADDRESS_INPUT = Target.the("el campo dirección de correo").
            located(By.id("email_create"));
    public static final Target CREATE_AN_ACCOUNT_BUTTON = Target.the("crear una cuenta").
            located(By.id("SubmitCreate"));
    public static final Target SIGN_IN_TITLE_LABEL = Target.the("título de la secunda sección").
            located(By.cssSelector("#login_form > .page-subheading"));
    public static final Target SIGN_IN_EMAIL_ADDRESS_INPUT = Target.the("el campo dirección de correo").
            located(By.id("email"));
    public static final Target SIGN_IN_PASSWORD_INPUT = Target.the("el campo contraseña").
            located(By.id("passwd"));
    public static final Target SIGN_IN_BUTTON = Target.the("iniciar sesión").
            located(By.id("SubmitLogin"));
}
