@SmokeSuite
Feature: DEV-38329 Verify that user is able to edit attribute

  Background:
    Given USER logged into the system
    And USER adds a new Mailing List

  Scenario: API: Verify that user is able to edit attribute of type text
    And USER adds a new Attribute
    When USER edit Attribute name of type TEXT
    Then Verify that Attribute was edited successfully

  Scenario: API: Verify that user is able to edit attribute of type text area
    And USER adds a new Attribute
    When USER edit Attribute name of type TEXTAREA
    #And USER edit number of rows and columns
    Then Verify that Attribute was edited successfully

  Scenario: API: Verify that user is able to edit attribute of type date
    And USER adds a new Attribute
    When USER edit Attribute name of type DATE
    Then Verify that Attribute was edited successfully

  Scenario: API: Verify that user is able to edit attribute of type radio button
    And USER adds a new Attribute
    When USER edit Attribute name of type DATE
    #And USER selects an attribute choice
    Then Verify that Attribute was edited successfully

  Scenario: API: Verify that user is able to edit attribute of type radio button
    And USER adds a new Attribute
    When USER edit Attribute name of type RADIO_BUTTON
    #And USER selects an attribute choice
    Then Verify that Attribute was edited successfully

  Scenario: API: Verify that user is able to edit attribute of type select list
    And USER adds a new Attribute
    When USER edit Attribute name of type RADIO_BUTTON
    #And USER selects an attribute choice
    Then Verify that Attribute was edited successfully

  Scenario: API: Verify that user is able to edit attribute of type Multiple select list
    And USER adds a new Attribute
    When USER edit Attribute name of type RADIO_BUTTON
    #And USER selects an attribute choice
    Then Verify that Attribute was edited successfully

  Scenario: API: Verify that user is able to edit attribute of type Multiple Checkbox
    And USER adds a new Attribute
    When USER edit Attribute name of type RADIO_BUTTON
    #And USER selects an attribute choice
    Then Verify that Attribute was edited successfully

  Scenario: API: Verify that user is able to edit attribute of type Autoincrement
    And USER adds a new Attribute
    When USER edit Attribute name of type RADIO_BUTTON
    #And USER selects an attribute choice
    Then Verify that Attribute was edited successfully


