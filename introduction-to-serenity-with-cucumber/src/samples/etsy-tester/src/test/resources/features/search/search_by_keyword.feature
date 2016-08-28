Feature: Searching by keyword

  In order to find items that I would like to purchase
  As a potential buyer
  I want to be able to search for items containing certain words

  Scenario: Should list items related to a specified keyword
    Given I want to buy a wool scarf
    When I search for items containing 'wool'
    Then I should only see items related to 'wool'


  Scenario: Should be able to filter search results by item type
    Given I have searched for items containing 'wool'
    When I filter results by type 'Handmade'
    Then I should only see items containing 'wool' of type 'Handmade'

   Scenario: Scenario in progress
    Given I have searched for items containing 'wool'
    When I filter results by type 'Handmade'
    Then I should see fewer products

  Scenario Outline: Filter by different item types
    Given I have searched for items containing '<material>'
    When I filter results by type '<type>'
    Then I should only see items containing '<material>' of type '<type>'
  Examples:
    | material | type           |
    | bronze   | Vintage        |
    | silk     | Handmade       |


  Scenario Outline: Failing one example filter by different item types
    Given I have searched for items containing '<material>'
    When I filter results by type '<type>'
    Then I should only see items containing '<material>' of type '<type>'
    Examples:
      | material | type           |
      | bronze   | bronze         |
      | silk     | Handmade       |


  Scenario: Should be able to view details about a searched item
    Given I have searched for items containing 'yarn b'
    When I select an item
    Then I should see the corresponding item details

