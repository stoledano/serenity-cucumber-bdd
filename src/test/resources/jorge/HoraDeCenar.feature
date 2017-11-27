Feature: Jorge cena
  Scenario: Jorge cenando leche y cereales
    Given Menu Biberon leche y cereales
      | Leche |
      | Cereales |
    When Jorge cena
    Then se come todo

  Scenario:Jorge cenando tortilla
    Given Menu Tortilla
      | Tortilla |
    When Jorge cena
    Then se come todo

