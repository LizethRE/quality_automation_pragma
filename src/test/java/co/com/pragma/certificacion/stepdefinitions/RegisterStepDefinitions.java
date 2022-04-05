package co.com.pragma.certificacion.stepdefinitions;

import co.com.pragma.certification.abilities.ReadSpreadsheet;
import co.com.pragma.certification.tasks.builders.RegisterTask;
import co.com.pragma.certification.userinterface.AuthenticationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

import static co.com.pragma.certification.abilities.ReadSpreadsheet.getCellData;

//import static co.com.pragma.certification.abilities.ReadSpreadsheet.getCellData;

public class RegisterStepDefinitions {
    private static final String FILE_PATH = "src/test/resources/data/data.xlsx";
    private static final String SHEET_NAME = "data";
    @Dado("que {actor} quiere registrarse en Automation Practice")
    public void queElUsuarioQuiereRegistrarseEnAutomationPractice(Actor actor) {
        actor.wasAbleTo(Open.browserOn().the(AuthenticationPage.class));
    }

    @Cuando("^diligencia el formulario de registro$")
    public void diligenciaElFormularioDeRegistro(DataTable dataTable) {
        List<List<String>> items = dataTable.asLists(String.class);
        int rowNumber = 1;

        OnStage.theActorInTheSpotlight().attemptsTo(RegisterTask.with()
                .title(items.get(rowNumber).get(0).trim())
                .firstName(items.get(rowNumber).get(1).trim())
                .lastName(items.get(rowNumber).get(2).trim())
                .emailAddress(items.get(rowNumber).get(3).trim())
                .password(items.get(rowNumber).get(4).trim())
                .dateOfBirth(items.get(rowNumber).get(5).trim())
                .company(items.get(rowNumber).get(6).trim())
                .address(items.get(rowNumber).get(7).trim())
                .secondAddress(items.get(rowNumber).get(8).trim())
                .city(items.get(rowNumber).get(9).trim())
                .state(items.get(rowNumber).get(10).trim())
                .postalCode(items.get(rowNumber).get(11).trim())
                .country(items.get(rowNumber).get(12).trim())
                .additionalInformation(items.get(rowNumber).get(13).trim())
                .homePhone(items.get(rowNumber).get(14).trim())
                .mobilePhone(items.get(rowNumber).get(15).trim())
                .addressAlias(items.get(rowNumber).get(16).trim())
                .andEnd()
        );
    }

    @Cuando("diligencia el formulario de registro con una hoja de calculo")
    public void diligenciaElFormularioDeRegistroConUnaHojaDeCalculo() {
        int rowNumber = 1;

        OnStage.theActorInTheSpotlight().can(ReadSpreadsheet.by(FILE_PATH, SHEET_NAME));

        OnStage.theActorInTheSpotlight().attemptsTo(RegisterTask.with()
                .title(getCellData(rowNumber, 0))
                .firstName(getCellData(rowNumber, 1))
                .lastName(getCellData(rowNumber, 2))
                .emailAddress(getCellData(rowNumber, 3))
                .password(getCellData(rowNumber,4))
                .dateOfBirth(getCellData(rowNumber,5))
                .company(getCellData(rowNumber, 10))
                .address(getCellData(rowNumber, 11))
                .city(getCellData(rowNumber, 13))
                .state(getCellData(rowNumber, 14))
                .postalCode(getCellData(rowNumber, 15))
                .country(getCellData(rowNumber, 16))
                .mobilePhone(getCellData(rowNumber, 19))
                .addressAlias(getCellData(rowNumber, 20))
                .andEnd()
        );
    }
}
