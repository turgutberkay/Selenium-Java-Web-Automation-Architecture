@LoginPage
Feature: LoginPage Feature

    # Cucumberda given when then yapısında literaturun aksine kisiler hep farkli sekilde caselerini yaziyorlar. Ben her islemimi bir when then ile tanımlamayı tercih ettim. Mantıklı birlestirmeler ile birden fazla adımı bir gherkin cumlesine stepDefinationsta baglayabiliriz. Bu konuyu dilerseniz teknik gorusmede de tartısabılırız.
  @Case-4
  Scenario Outline: Success Login Scenarios
    Given go to Url
    When taps to Login Header on the Home Page
    Then should see Login Form on the Login Page
    When write to E-posta "<ePosta>" on the Login Page
    When write to Password "<password>" on the Login Page
    When taps to Login Button on the Login Page
    Then should see Logged In MemberShip on the Login Page
    Examples:
      | ePosta                 | | password     |
      | denemepoc123@gmail.com | | pocdeneme123 |