@TestUI
Feature: Registration using Data table

  Scenario Outline: Registration using data table
    Given I am on the home page
    When I amend the URl with "<userId>"
    Then I should see with values of "<name>","<location>","<public_repos>","<public_gists>","<followers>","<following>"

    Examples:
      | userId | name             | location   | public_repos | public_gists | followers | following |
      | 6wl    | Gregory Loscombe | Manchester | 6            | 11           | 16        | 29        |
