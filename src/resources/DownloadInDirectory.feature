Feature: I want to download file in the selected directory

  Background: Open page
    When I open the "https://www.mvideo.ru/" site page
    Then Page "https://www.mvideo.ru/" opened

#  Scenario: Download
#    Given I click on the download file with "mp4" extension
#    And Wait for download
#    When File with filename "Pexels Videos 1321208.mp4" downloaded
#    And File has correct extension
#    And File has correct size
#    And File has correct name
#    Then File downloaded successfully without problems

  Scenario Outline: Search picture with enter key
    When Searching item "<searchObject>"
    And click enter
    Then Search of "<type>" "<searchObject>" completed

    Examples:
      | searchObject | type   |
      | Телефоны     | GOODS  |
      | *            | SYMBOL |
      | Samsung      | BRAND  |
      |              | PROMO  |

  Scenario Outline: Search picture with click on the search button
    When Searching item "<searchObject>"
    And click on the search button
    Then Search of "<type>" "<searchObject>" completed

    Examples:
      | searchObject | type   |
      | Телевизоры   | GOODS  |
      | !            | SYMBOL |
      | LG           | BRAND  |
      |              | PROMO  |







