Feature: Dummy Feature to demonstrate tags

	@smoke
  Scenario: Test Tags1
    Given user creates a tag
    When he want to execute selected scenarios
    Then only those selected will get executed

	@uat
  Scenario: Test Tags2
    Given user creates a tag
    When he want to execute selected scenarios
    Then only those selected will get executed

	@regression
  Scenario: Test Tags3
    Given user creates a tag
    When he want to execute selected scenarios
    Then only those selected will get executed
