@SearchPage
Feature: SearchPage Feature

  # Cucumberda given when then yapısında literaturun aksine kisiler hep farkli sekilde caselerini yaziyorlar. Ben her islemimi bir when then ile tanımlamayı tercih ettim. Mantıklı birlestirmeler ile birden fazla adımı bir gherkin cumlesine stepDefinationsta baglayabiliriz. Bu konuyu dilerseniz teknik gorusmede de tartısabılırız.
  @Case-1
  Scenario Outline: Listing of Istanbul Ankara flights between 10:00 and 18:00
    Given go to Url
    Then should see Home Page
    When taps to Round-Trip CheckBox on the Home Page
    Then should see Date of Arrival Text "<dateOfArrivalText>" on the Home Page
    When write to "<cityFromWhere>" From Where Textbox on the HomePage
    Then should see Airport Options From Where on the HomePage
    When taps to First Airport From Where on the HomePage
    When write to "<cityToWhere>" To Where Textbox on the HomePage
    Then should see Airport Options To Where on the HomePage
    When taps to First Airport To Where on the HomePage
    When taps to Departure Date on the Home Page
    Then should see Departure Calendar on the Home Page
    When choose to Departure Month Date "<departureMonthAndYear>" on the Home Page
    When choose to Day Date Calendar "<departureDay>" on the Home Page
    When taps to Date Of Arrival on the Home Page
    Then should see Arrival Calendar on the Home Page
    When choose to Arrival Month Date "<arrivalMonthAndYear>" on the Home Page
    When choose to Day Date Calendar "<arrivalDay>" on the Home Page
    When taps to Number Of Passengers on the Home Page
    Then should see Passengers Panel on the Home Page
    When choose to Adult Passengers Number 2 on the Home Page
    When taps to Done Button Passengers Panel on the Home Page
    When taps to Find Cheps Button on the Home Page
    Then should see Search Page
    Then should see Departure-Arrival Time Filter on the Search Page
    When taps to Departure-Arrival Time Filter on the Search Page
    Then should see Departure Time Slider on the Search Page
    Then should see Arrival Time Slider on the Search Page
    When choose Departure Time Left Slider "<departureTimeLeftSlider>" Departure-Arrival Time Filter on the Search Page
    When choose Departure Time Right Slider "<departureTimeRightSlider>" Departure-Arrival Time Filter on the Search Page
    Then should see Departure Times of the Flights are between "<departureTimeLeftSlider>" and "<departureTimeRightSlider>" on the Search Page
    Examples:
      | dateOfArrivalText | | cityFromWhere | | cityToWhere | | departureMonthAndYear | | departureDay | | arrivalMonthAndYear | | arrivalDay | | departureTimeLeftSlider | | departureTimeRightSlider |
      | Dönüş Tarihi      | | İstanbul      | | Ankara      | | Nisan 2024            | | 12           | | Mayıs 2024          | | 23         | | 10:00                   | | 18:00                    |

  @Case-2
  Scenario Outline: Listing of Istanbul Ankara flights between 10:00 and 18:00 then Flights sorted by Ascending Price
    Given go to Url
    Then should see Home Page
    When taps to Round-Trip CheckBox on the Home Page
    Then should see Date of Arrival Text "<dateOfArrivalText>" on the Home Page
    When write to "<cityFromWhere>" From Where Textbox on the HomePage
    Then should see Airport Options From Where on the HomePage
    When taps to First Airport From Where on the HomePage
    When write to "<cityToWhere>" To Where Textbox on the HomePage
    Then should see Airport Options To Where on the HomePage
    When taps to First Airport To Where on the HomePage
    When taps to Departure Date on the Home Page
    Then should see Departure Calendar on the Home Page
    When choose to Departure Month Date "<departureMonthAndYear>" on the Home Page
    When choose to Day Date Calendar "<departureDay>" on the Home Page
    When taps to Date Of Arrival on the Home Page
    Then should see Arrival Calendar on the Home Page
    When choose to Arrival Month Date "<arrivalMonthAndYear>" on the Home Page
    When choose to Day Date Calendar "<arrivalDay>" on the Home Page
    When taps to Number Of Passengers on the Home Page
    Then should see Passengers Panel on the Home Page
    When choose to Adult Passengers Number 2 on the Home Page
    When taps to Done Button Passengers Panel on the Home Page
    When taps to Find Cheps Button on the Home Page
    Then should see Search Page
    Then should see Departure-Arrival Time Filter on the Search Page
    When taps to Departure-Arrival Time Filter on the Search Page
    Then should see Departure Time Slider on the Search Page
    Then should see Arrival Time Slider on the Search Page
    When choose Departure Time Left Slider "<departureTimeLeftSlider>" Departure-Arrival Time Filter on the Search Page
    When choose Departure Time Right Slider "<departureTimeRightSlider>" Departure-Arrival Time Filter on the Search Page
    When taps to Airline Filter on the Search Page
    When taps to "<chooseAirline>" Airline Filter on the Search Page
    Then should see Flights sorted by Ascending Price on the Search Page
    Examples:
      | dateOfArrivalText | | cityFromWhere | | cityToWhere | | departureMonthAndYear | | departureDay | | arrivalMonthAndYear | | arrivalDay | | departureTimeLeftSlider | | departureTimeRightSlider | | chooseAirline            |
      | Dönüş Tarihi      | | İstanbul      | | Ankara      | | Nisan 2024            | | 12           | | Mayıs 2024          | | 23         | | 10:00                   | | 18:00                    | | Türk Hava Yolları        |

  @Case-3
  Scenario Outline: The number of flights listed is more than 0
    Given go to Url
    Then should see Home Page
    When taps to Round-Trip CheckBox on the Home Page
    Then should see Date of Arrival Text "<dateOfArrivalText>" on the Home Page
    When write to "<cityFromWhere>" From Where Textbox on the HomePage
    Then should see Airport Options From Where on the HomePage
    When taps to First Airport From Where on the HomePage
    When write to "<cityToWhere>" To Where Textbox on the HomePage
    Then should see Airport Options To Where on the HomePage
    When taps to First Airport To Where on the HomePage
    When taps to Departure Date on the Home Page
    Then should see Departure Calendar on the Home Page
    When choose to Departure Month Date "<departureMonthAndYear>" on the Home Page
    When choose to Day Date Calendar "<departureDay>" on the Home Page
    When taps to Date Of Arrival on the Home Page
    Then should see Arrival Calendar on the Home Page
    When choose to Arrival Month Date "<arrivalMonthAndYear>" on the Home Page
    When choose to Day Date Calendar "<arrivalDay>" on the Home Page
    When taps to Number Of Passengers on the Home Page
    Then should see Passengers Panel on the Home Page
    When choose to Adult Passengers Number 2 on the Home Page
    When taps to Done Button Passengers Panel on the Home Page
    When taps to Find Cheps Button on the Home Page
    Then should see Search Page
    Then should see more than zero flights listed on the Search Page
    Examples:
      | dateOfArrivalText | | cityFromWhere | | cityToWhere | | departureMonthAndYear | | departureDay | | arrivalMonthAndYear | | arrivalDay |
      | Dönüş Tarihi      | | Antalya       | | İstanbul    | | Mart 2024             | | 22           | | Haziran 2024        | | 28         |
