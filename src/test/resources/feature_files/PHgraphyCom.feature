@phgraphy.com
Feature: phgraphy.com
  Will verify if phgraphy.com website is working as expected

  Background: User can navigate to phgraphy.com homepage
    Given user is on the homepage of phgraphy.com website
    Then header image is displayed on the top of page

  @SmokeTest
  Scenario: User can close & accept Cookie Policy
    When user is on the homepage for the first time
    Then Cookie Policy bar is displayed on the bottom of the page
    And contains text "Privacy & Cookies: This site uses cookies. By continuing to use this website, you agree to their use."