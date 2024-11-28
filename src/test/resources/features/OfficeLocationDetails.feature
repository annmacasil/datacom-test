Feature: Office Location Details

  Rule: Details of the Offices Locations
    Scenario Outline: Verify details of each office location
      Given I am navigated to "Our locations" page
      When I click on the location "<location>"
      Then I see the following details for "<officeLocation>" office in "<location>" : address "<address>", phone number "<phone>" and email "<email>"

      Examples:
        | location    | officeLocation          | address                                                                         | phone            |  email                               |
        | Asia        | Malaysia                | Level 3A, 1 Sentral, Jalan Rakyat, Kuala Lumpur Sentral, Kuala Lumpur 50470     | +60 3 2109 1000  | info-kl@datacom.com.au               |
        | Australia   | Adelaide                | 118 Franklin Street, Adelaide, South Australia 5000                             | +61 8 7221 7900  | contactsa@datacom.com.au             |
        | New Zealand | Auckland                | 58 Gaunt Street, Auckland CBD, Auckland 1010                                    | +64 9 303 1489   | reception.gaunt@datacom.co.nz        |


  Rule: Link Navigation
    Scenario Outline: Verify user is navigated to get directions
      Given I am in "<location>" location tab of "Our locations" page
      When I select an office location "<officeLocation>"
      And I click on the Get Directions link for "<officeLocation>" office
      Then I am navigated to Google Maps

      Examples:
        | location    | officeLocation          |
        | Asia        | Philippines             |


    Scenario Outline: Verify phone link is working
      Given I am in "<location>" location tab of "Our locations" page
      When I select an office location "<officeLocation>"
      And I click on the Phone Number link in "<officeLocation>" office
      Then I verify the phone link is correct in "<officeLocation>" location

      Examples:
        | location    | officeLocation        |
        | Australia   | Canberra              |

    Scenario Outline: Verify email link to is working
      Given I am in "<location>" location tab of "Our locations" page
      When I select an office location "<officeLocation>"
      And I click on the Email link in "<officeLocation>" office
      Then I verify the mailto link is correct in "<officeLocation>" location

      Examples:
        | location    | officeLocation          |
        | New Zealand | Dunedin                 |
