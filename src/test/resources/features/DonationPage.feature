Feature: Donation Form
@wip
  Scenario: Visiting Donation Form and Preparing a Donation
  Given The user is on the donation page
    And The user enters "5" Euro in the amount input box and select "einmalig" radio button
    And The user selects "SEPA Lastschrift" radio button
    And The user clicks on the succesIBANButton and copy success IBAN value
    Then The user sends copied success IBAN value to the inputBoxIBAN
    When The user clicks on the jetztSpenden button
    Then The user donates successfully
