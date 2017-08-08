Feature: Adopt an animal from the zoo site

Scenario: Adopt an animal
Given I am on the home page of Zoo site
When I goto Adoption page and check foravailability
And I adopt an animal
Then I should see the message "your adoption has been set up"
