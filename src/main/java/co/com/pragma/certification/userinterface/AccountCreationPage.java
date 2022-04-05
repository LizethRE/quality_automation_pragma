package co.com.pragma.certification.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AccountCreationPage extends PageObject {
    public static final Target PERSONAL_INFORMATION_TITLE_LABEL = Target.the("título de la primera sección").
            located(By.cssSelector("div:nth-of-type(1) > .page-subheading"));
    public static Target TITLE_COMBO_BOX(int value){
        return Target.the("opcion" + value).
                located(By.id("uniform-id_gender" + value));
    }
    public static final Target CUSTOMER_FIRST_NAME_INPUT = Target.the("el campo nombres").
            located(By.id("customer_firstname"));
    public static final Target CUSTOMER_LAST_NAME_INPUT = Target.the("el campo apellidos").
            located(By.id("customer_lastname"));
    public static final Target EMAIL_INPUT = Target.the("el campo correo electrónico").
            located(By.id("email"));
    public static final Target PASSWORD_INPUT = Target.the("el campo contraseña").
            located(By.id("passwd"));
    public static final Target BIRTHDAY_SELECT = Target.the("día de cumpleaños").
            located(By.id("days"));
    public static final Target BIRTHDAY_MONTH_SELECT = Target.the("mes de cumpleaños").
            located(By.id("months"));
    public static final Target BIRTHDAY_YEAR_SELECT = Target.the("año de cumpleaños").
            located(By.id("years"));
    public static final Target FIRST_NAME_INPUT = Target.the("el campo nombres").
            located(By.id("firstname"));
    public static final Target LAST_NAME_INPUT = Target.the("el campo apellidos").
            located(By.id("lastname"));
    public static final Target COMPANY_INPUT = Target.the("el campo compañia").
            located(By.id("company"));
    public static final Target ADDRESS_ONE_INPUT = Target.the("el campo dirección 1").
            located(By.id("address1"));
    public static final Target ADDRESS_TWO_INPUT = Target.the("el campo dirección 2").
            located(By.id("address2"));
    public static final Target CITY_INPUT = Target.the("el campo ciudad").
            located(By.id("city"));
    public static final Target STATE_SELECT = Target.the("estado").
            located(By.id("id_state"));
    public static final Target POSTAL_CODE_INPUT = Target.the("el campo código postal").
            located(By.id("postcode"));
    public static final Target COUNTRY_SELECT = Target.the("país").
            located(By.id("id_country"));
    public static final Target ADDITIONAL_INFORMATION_TEXTAREA = Target.the("el campo información adicional").
            located(By.id("other"));
    public static final Target HOME_PHONE_INPUT = Target.the("el campo teléfono fijo").
            located(By.id("phone"));
    public static final Target MOBILE_PHONE_INPUT = Target.the("el campo teléfono móvil").
            located(By.id("phone_mobile"));
    public static final Target ADDRESS_ALIAS_INPUT = Target.the("el campo dirección futura").
            located(By.id("alias"));
    public static final Target REGISTER_BUTTON = Target.the("registrar").
            located(By.xpath("//span[.='Register']"));
}
