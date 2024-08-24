Feature: Crear y Consultar Pedido en PetStore

  @crearOrden
  Scenario Outline: Crear una nueva orden con un petId válido
    Given consulto si el petId "<petId>" existe
    When creo una nueva orden con petId "<petId>", quantity <quantity>, y status "<status>"
    Then el código de respuesta es 200
    And el cuerpo de la respuesta no está vacío

    Examples:
      | petId | quantity | status |
      | 5     | 7        | placed |
      | 2     | 5        | placed |

  @consultarOrden
  Scenario Outline: Consultar un pedido existente por ID
    Given el ID de pedido es "<orderId>"
    When consulto el pedido con ID "<orderId>"
    Then el código de respuesta es 200
    And el cuerpo de la respuesta no está vacío

    Examples:
      | orderId             |
      | 9223372036854775807 |
      | 112121212176        |
