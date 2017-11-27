import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.exceptions.TestCompromisedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HoraDeCenar {

    private Cena cena;
    private Hijo hijo;


    @Given("^Menu .+$")
    public void menu(List<String> menu) throws Throwable {
        cena = new Cena(menu);
    }

    @When("^Sofia cena$")
    public void sofiaCena() throws Throwable {
        hijo = new Sofia();

    }

    @When("^Jorge cena$")
    public void jorgeCena() throws Throwable {
        hijo = new Jorge();
        if (!cena.getComida().stream()
                .allMatch(hijo.getGustos()::containsKey)) {
            throw new TestCompromisedException("Cuando cumpla un año");
        }
    }

    @Then("^se come todo")
    public void seComeTodo() throws Throwable {
        assertThat(cena.cenar(hijo)).isTrue();
    }


    private class Sofia implements Hijo {


        private Sofia() {
            gustos.put("Macarrones", true);
            gustos.put("Pescado", false);
            gustos.put("Patatas", true);
        }

    }

    private class Jorge implements Hijo {

        private Jorge() {
            gustos.put("Leche", true);
            gustos.put("Cereales", true);
        }
    }

    private class Cena {

        private final List<String> comida;

        Cena(List<String> comida) {

            this.comida = comida;
        }

        public List<String> getComida() {
            return comida;
        }

        boolean cenar(Hijo sofia) {
            return sofia.gusta(comida);

        }
    }

    public interface Hijo {

        Map<String, Boolean> gustos = new HashMap<>();

        default boolean gusta(List<String> comida) {
            return comida.stream()
                    .allMatch(gustos::get);
        }

        default Map<String, Boolean> getGustos() {
            return gustos;
        }
    }
}
