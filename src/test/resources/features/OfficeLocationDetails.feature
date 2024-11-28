Feature: Office Location Details

  Rule: Details of the Offices Locations
    Scenario Outline: Verify details of each office location
      Given I am navigated to "Our locations" page
      When I click on the location "<location>"
      And I select an office location "<officeLocation>"
      Then I see the details: address "<address>", phone number "<phone>" and email "<email>" for location "<location>"

      Examples:
        | location    | officeLocation          | address                                                                         | phone           |  email                               |
        | Asia        | Malaysia                | Level 3A, 1 Sentral, Jalan Rakyat, Kuala Lumpur Sentral, Kuala Lumpur 50470    | +60 3 2109 1000 | info-kl@datacom.com.au               |
        | Australia   | Adelaide                | 118 Franklin Street, Adelaide, South Australia 5000                             | +61 8 7221 7900  | contactsa@datacom.com.au          |
        | New Zealand | Auckland                | 58 Gaunt Street, Auckland CBD, Auckland 1010                                   | +64 9 303 1489   | reception.gaunt@datacom.co.nz        |


  Rule: Link Navigation
    Scenario Outline: Verify user is navigated to get directions
      Given I am in "<location>" location tab of "Our locations" page
      When I select an office location "<officeLocation>"
      And I click on the Get Directions link
      Then I am navigated to Google Maps

      Examples:
        | location    | officeLocation          |
        | Asia        | Malaysia                |


    Scenario Outline: Verify user is navigated to get directions
      Given I am in "<location>" location tab of "Our locations" page
      When I select an office location "<officeLocation>"
      And I click on the Phone Number link
      Then I see an alert pop up to pick an app

      Examples:
        | location    | officeLocation          |
        | Australia   | Townsville              |

    Scenario Outline: Verify user is navigated to get directions
      Given I am in "<location>" location tab of "Our locations" page
      When I select an office location "<officeLocation>"
      And I click on the Email link
      Then I see an email is displayed

      Examples:
        | location    | officeLocation          |
        | New Zealand | Auckland                |
