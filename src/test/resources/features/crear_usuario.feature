Feature: Crear nueva orden en PetStore

  @crearOrden
  Scenario: Crear una nueva orden con un petId válido
    Given consulto si el petId "1" existe
    When creo una nueva orden con petId "1", quantity 2, y status "placed"
    Then el código de respuesta es 200
