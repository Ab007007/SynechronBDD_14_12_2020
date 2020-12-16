Feature: Dummy Feature to demonstrate tags

	@smoke1
  Scenario: Test Tags1
    Given user creates a tag
    When he want to execute selected scenarios
    Then only those selected will get executed

	@uat
  Scenario: Test Tags2
    Given user creates a tag
    When he want to execute selected scenarios
    Then only those selected will get executed

	@regression1
  Scenario: Test Tags3
    Given user creates a tag
    When he want to execute selected scenarios
    Then only those selected will get executed
