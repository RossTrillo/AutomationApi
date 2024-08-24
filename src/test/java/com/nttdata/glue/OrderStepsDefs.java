package com.nttdata.glue;

import com.nttdata.steps.OrderSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class OrderStepsDefs {

    @Steps
    OrderSteps orderSteps;


    @Given("consulto si el petId {string} existe")
    public void consultoSiElPetIdExiste(String petId) {
        Assert.assertTrue("El petId no existe", orderSteps.consultPetId(petId));
    }

    @When("creo una nueva orden con petId {string}, quantity {int}, y status {string}")
    public void creoUnaNuevaOrdenConPetId(String petId, int quantity, String status) {
        orderSteps.createOrder(petId, quantity, status);
    }

    @Then("el código de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        orderSteps.validateResponseCode(statusCode);
    }

    @Given("el ID de pedido es {string}")
    public void elIdDePedidoEs(String orderId) {
        Assert.assertNotNull("El orderId no puede ser null", orderId);
        Assert.assertFalse("El orderId no puede estar vacío", orderId.trim().isEmpty());
    }

    @When("consulto el pedido con ID {string}")
    public void consultoElPedidoConId(String orderId) {
        orderSteps.consultOrderById(orderId);
    }


}
