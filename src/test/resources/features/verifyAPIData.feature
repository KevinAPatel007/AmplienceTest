@TestApi
Feature: API get request Testing for Amplience's API
  As a user
  I want to to be able get current data from API
  So that I can validate that API functionality

  Scenario Outline: Validate data generated from API
    Given I have base uri
    When I execute get request with userId "<userId>"
    Then I should see status code as "200"
    And I see response with values of "<name>","<id>","<location>","<public_repos>","<public_gists>","<followers>","<following>"
  Examples:
    | userId | name             | id    | location   | public_repos | public_gists | followers | following |
    | 6wl    | Gregory Loscombe | 15330 | Manchester | 6            | 11           | 16        | 29        |

  Scenario Outline: API not available
    Given I have base uri
    When I execute get request with userId "<userId>"
    Then I should see status code as "404"
    Examples:
      | userId |
      |        |
