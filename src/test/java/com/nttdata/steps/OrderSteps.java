package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class OrderSteps {

    private static final String PET_URL = "https://petstore.swagger.io/v2/pet";
    private static final String ORDER_URL = "https://petstore.swagger.io/v2/store/order";

    @Step("Consultar si el petId {0} existe")
    public boolean consultPetId(String petId) {
        int statusCode = SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get(PET_URL + "/" + petId)
                .then()
                .log().all()
                .extract()
                .statusCode();
        return statusCode == 200;
    }

    @Step("Crear una nueva orden con petId {0}, quantity {1}, y status {2}")
    public void createOrder(String petId, int quantity, String status) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + quantity + ",\n" +
                        "  \"shipDate\": \"2024-08-24T18:44:26.383Z\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(ORDER_URL)
                .then()
                .log().all()
                .statusCode(200);
    }
    @Step("Validar el código de respuesta {0}")
    public void validateResponseCode(int statusCode) {
        SerenityRest.lastResponse().then().statusCode(statusCode);
    }

    @Step("Consultar el pedido con ID {0}")
    public void consultOrderById(String orderId) {
        SerenityRest.given()
                .contentType("application/json")
                .accept("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get(ORDER_URL + "/" + orderId)
                .then()
                .log().all()
                .statusCode(200);
    }


}
