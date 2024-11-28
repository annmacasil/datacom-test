Feature: Media Pack

  Rule: Media Pack Verification
    Scenario Outline: Verify location per country/continent
      Given I am on the "Our locations" page
      When I click on the location "<location>" tab
      Then I see the different office address "<officesPerLocation>" of the selected location "<location>"

      Examples:
        | location    | officesPerLocation                                                                              |
        | New Zealand | Auckland,Christchurch,Dunedin,Hamilton,Hastings,Nelson,New Plymouth,Rotorua,Tauranga,Wellington |
        | Australia   | Adelaide,Brisbane,Canberra,Melbourne,Modbury,Perth,Sydney - Denison Street,Townsville           |
        | Asia        | Malaysia,Philippines,Singapore                                                                  |


