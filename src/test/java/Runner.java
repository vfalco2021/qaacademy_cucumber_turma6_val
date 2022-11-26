import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//pretty mostra no console o que esta sendo executado, tag seleciona o que esta sendo executado,
// publish gera relatório, steps mostra os steps que foram executados , o que passou e o que não passou, io.gameta é o relatorio alure
@CucumberOptions(features = "classpath:features", tags = "@test001", publish = true, stepNotifications = true, plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class Runner {


}
