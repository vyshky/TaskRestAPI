Feature: Test Rest-Api

  Scenario: I get get user and rooms
    Given I ask you to give me back the room numbers
    Given I ask you to give me back the users. start = 1 end = 5


  Scenario Outline: I check the privileges of all users
    When I check to enter the room. userId = <id> maxRoom = <room>
    Examples: I enter the rooms
      | id | room |
      | 1  | 5    |
      | 2  | 5    |
      | 3  | 5    |
      | 5  | 5    |
      | 6  | 5    |
      | 7  | 5    |
      | 8  | 5    |
      | 9  | 5    |
      | 10 | 5    |