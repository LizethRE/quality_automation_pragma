package co.com.pragma.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		tags = "@rutaCritica",
		glue = "co.com.pragma.certificacion.stepdefinitions",
		snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RutaCriticaRunner {}
