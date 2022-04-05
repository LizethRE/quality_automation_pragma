package co.com.pragma.certification.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AlertPage extends PageObject {
    public static final Target ALERT_LABEL = Target.the("mensaje de la alerta").
            located(By.cssSelector("ol > li"));
}
