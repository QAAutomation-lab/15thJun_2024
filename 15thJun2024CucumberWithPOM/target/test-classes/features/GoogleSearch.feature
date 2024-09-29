Feature: Testing Google search flow

  #Scenario: Validate search result for selenium
  #Given user is on Google search page
  #When user enters "Selenium" and press enter button
  #Then Validate search page is having title as "Selenium - Google Search"
  #And User close the browser
  Scenario Outline: Validate search result for <textTobeSearched>
    Given user is on Google search page
    When user enters <textTobeSearched> and press enter button
    Then Validate search page is having title as <title>
    And User close the browser

    Examples: 
      | textTobeSearched | title                          |
      | Selenium         | Selenium - Google Search       |
      | Manual Testing   | Manual Testing - Google Search |
      | API Testing      | API Testing - Google Search    |
