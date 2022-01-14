Feature: I want to download file in the selected directory

  Background: Open page
    When I open the "https://www.mvideo.ru/" site page
    Then Page opened

#  Scenario: Download
#    Given I click on the download file with "mp4" extension
#    And Wait for download
#    When File with filename "Pexels Videos 1321208.mp4" downloaded
#    And File has correct extension
#    And File has correct size
#    And File has correct name
#    Then File downloaded successfully without problems

    Scenario Outline: Search picture
      When I search item "<searchObject>"
      Then Search completed

      Examples:
      | searchObject |
      | Телефоны          |
      | Телевизоры          |
      | |
      | * |
      | ! |














