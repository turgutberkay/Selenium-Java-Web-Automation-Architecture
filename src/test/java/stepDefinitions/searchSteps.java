package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

public class searchSteps {

    SearchPage searchPage = new SearchPage();

    @Then("should see Search Page")
    public void shouldSeeSearchPage() {
        searchPage.checkSearchPage();
    }

    @Then("should see Departure-Arrival Time Filter on the Search Page")
    public void shouldSeeDepartureArrivalTimeFilterOnTheSearchPage() {
        searchPage.checkDepartureArrivalTimeFilter();
    }

    @When("taps to Departure-Arrival Time Filter on the Search Page")
    public void tapsToDepartureArrivalTimeFilterOnTheSearchPage() {
        searchPage.clickDepartureArrivalTimeFilter();
    }

    @Then("should see Departure Time Slider on the Search Page")
    public void shouldSeeDepartureTimeSliderOnTheSearchPage() {
        searchPage.checkDepartureTimeSlider();
    }

    @Then("should see Arrival Time Slider on the Search Page")
    public void shouldSeeArrivalTimeSliderOnTheSearchPage() {
        searchPage.checkArrivalTimeSlider();
    }

    @When("choose Departure Time Left Slider {string} Departure-Arrival Time Filter on the Search Page")
    public void chooseDepartureTimeLeftSliderDepartureArrivalTimeFilterOnTheSearchPage(String arg0) {searchPage.chooseDepartureTimeLeftSliderDepartureArrivalTimeFilter(arg0);}

    @When("choose Departure Time Right Slider {string} Departure-Arrival Time Filter on the Search Page")
    public void chooseDepartureTimeRightSliderDepartureArrivalTimeFilterOnTheSearchPage(String arg0) {searchPage.chooseDepartureTimeRightSliderDepartureArrivalTimeFilter(arg0);}

    @Then("should see Departure Times of the Flights are between {string} and {string} on the Search Page")
    public void shouldSeeDepartureTimesOfTheFlightsAreBetweenAndOnTheSearchPage(String arg0, String arg1) {searchPage.checkDepartureTimesOfTheFlightsAreBetweenAndOnTheSearchPage(arg0,arg1);}

    @When("taps to Airline Filter on the Search Page")
    public void tapsToAirlineFilterOnTheSearchPage() throws InterruptedException {
        //Normalde thread sleep kullanımına karsiyim. Methodlarimin icinde de WebDriverWaitler kullandim. Fakat site seleniumun hizine yetisemediginden dom henuz guncellemeden selenium eski domdan elementi click etmeye calisiyor. Bundan dolayi clickable patliyor. Bu yuzden domun guncellenmesi icin thread sleep ile sure tanimayi tercih ettim
        Thread.sleep(2000);
        searchPage.clickAirlineFilter();}

    @When("taps to {string} Airline Filter on the Search Page")
    public void tapsToChooseAirlineFilterOnTheSearchPage(String arg0) throws InterruptedException {
        //Normalde thread sleep kullanımına karsiyim. Methodlarimin icinde de WebDriverWaitler kullandim. Fakat site seleniumun hizine yetisemediginden dom henuz guncellemeden selenium eski domdan elementi click etmeye calisiyor. Bundan dolayi clickable patliyor. Bu yuzden domun guncellenmesi icin thread sleep ile sure tanimayi tercih ettim
        Thread.sleep(2000);
        searchPage.clickAirlineFromAirlineFilter(arg0);
        Thread.sleep(2000);
    }

    @Then("should see Flights sorted by Ascending Price on the Search Page")
    public void shouldSeeFlightsSortedByAscendingPriceOnTheSearchPage(){searchPage.checkFlightsSortedAscendingPrice();}

    @Then("should see more than zero flights listed on the Search Page")
    public void shouldSeeMoreThanFlightsListedOnTheSearchPage() {
        searchPage.checkFlightsListedMoreThan();
    }


}
