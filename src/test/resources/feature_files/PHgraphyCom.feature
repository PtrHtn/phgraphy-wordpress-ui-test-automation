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
    When user clicks button Close and accept
    Then Cookie Policy bar is not displayed

  @SmokeTest
  Scenario: User can open image
    When user clicks on the first image in the gallery
    Then first image is displayed in higher resolution

  @SmokeTest
  Scenario: Title of the gallery is the same as the top bar button name pressed
    When user clicks on the top bar button named "PORTRAIT PHOTOGRAPHY"
    Then title of the gallery is "PORTRAIT PHOTOGRAPHY"