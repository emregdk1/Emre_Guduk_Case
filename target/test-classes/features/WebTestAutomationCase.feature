Feature:Insider UI Test Case

  Background:

    Given Setup Driver "chrome"
    And   Go to "https://useinsider.com/" address

  @Deneme
  Scenario: InsiderUITestCase
    Given Check if current URL contains the value "https://useinsider.com/"
    Given Accept Chrome cookie popup
    Given Go to the Career page and verify the page
      | Company | Careers |
      | True    | True    |
    Given Check if current URL contains the value "https://useinsider.com/careers/"
    Given Navigate to the Career page and validate
      | LocationControl | LifeAtInsiderControl |
      | True            | True                 |
    And   Go to "https://useinsider.com/careers/quality-assurance/" address
    Given Check if current URL contains the value "https://useinsider.com/careers/quality-assurance/"
    Given Navigate to the See all QA jobs page
    Given Check if current URL contains the value "https://useinsider.com/careers/open-positions/?department=qualityassurance"
    Given Wait for the QUALITY ASSURANCE text to load
    Given Select Filter QA jobs
      | Filter Positions | Select Location | Select Department |
      | SEE_ALL_QA_JOBS  | Location        | Department        |
    Given Wait for the View Role button to load
    Given Hover over the view role button
    Given Click the View Role button to load
    And   Switch to new window
    Given Check if current URL contains the value "https://jobs.lever.co/useinsider"
    Given Verify the Lever Filter Control Text





