Feature: Sofia cena
  Scenario: Sofia Cenando macarrones
    Given Menu Macarrones
      | Macarrones |
    When Sofia cena
    Then se come todo

  Scenario:Sofia Cenando pescado con patatas
    Given Menu Pescado con Patatas
      | Pescado |
      | Patatas |
    When Sofia cena
    Then se come todo

