package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class homeSteps {

    HomePage homePage = new HomePage();

    @Given("go to Url")
    public void tapsToUseWatchAdsButtonOnTheExpressScreen() {homePage.goToUrl();}

    @Then("should see Home Page")
    public void shouldSeeHomePage() {
        homePage.checkHomePage();
    }

    @When("taps to Round-Trip CheckBox on the Home Page")
    public void tapsToRoundTripCheckBoxOnTheHomePage() {homePage.clickRoundTripCheckBox();}

    @Then("should see Date of Arrival Text {string} on the Home Page")
    public void shouldSeeDateOfArrivalTextOnTheHomePage(String arg0){
        homePage.checkDateOfArrivalText(arg0);
    }

    @When("write to {string} From Where Textbox on the HomePage")
    public void writeToFromWhereTextboxOnTheHomePage(String arg0) {
        homePage.writeFromWhereTextbox(arg0);
    }

    @Then("should see Airport Options From Where on the HomePage")
    public void shouldSeeAirportOptionsFromWhereOnTheHomePage() {
        homePage.checkAirportOptionsFromWhereBar();
    }

    @Then("should see Airport Options To Where on the HomePage")
    public void shouldSeeAirportOptionsToWhereOnTheHomePage() {
        homePage.checkAirportOptionsBarToWhereBar();
    }

    @When("taps to First Airport From Where on the HomePage")
    public void tapsToFirstAirportFromWhereOnTheHomePage() {
        homePage.clickFirstAirportFromWhere();
    }

    @When("taps to First Airport To Where on the HomePage")
    public void tapsToFirstAirportToWhereOnTheHomePage() {
        homePage.clickFirstAirportToWhere();
    }

    @When("write to {string} To Where Textbox on the HomePage")
    public void writeToToWhereTextboxOnTheHomePage(String arg0) {
        homePage.writeToWhereTextbox(arg0);
    }

    @When("taps to Departure Date on the Home Page")
    public void tapsToDepartureDateOnTheHomePage() throws InterruptedException {
        //Normalde thread sleep kullanımına karsiyim. Methodlarimin icinde de WebDriverWaitler kullandim. Fakat site seleniumun hizine yetisemediginden dom henuz guncellemeden selenium eski domdan elementi click etmeye calisiyor. Bundan dolayi clickable patliyor. Bu yuzden domun guncellenmesi icin thread sleep ile sure tanimayi tercih ettim
        Thread.sleep(1500);
        homePage.clickDepartureDate();
        Thread.sleep(1500);
    }

    @Then("should see Departure Calendar on the Home Page")
    public void shouldSeeDepartureCalendarOnTheHomePage() {
        homePage.checkDepartureCalendar();
    }

    @Then("should see Arrival Calendar on the Home Page")
    public void shouldSeeArrivalCalendarOnTheHomePage() throws InterruptedException {
        //Normalde thread sleep kullanımına karsiyim. Methodlarimin icinde de WebDriverWaitler kullandim. Fakat site seleniumun hizine yetisemediginden dom henuz guncellemeden selenium eski domdan elementi click etmeye calisiyor. Bundan dolayi clickable patliyor. Bu yuzden domun guncellenmesi icin thread sleep ile sure tanimayi tercih ettim
        Thread.sleep(1500);
        homePage.checkArrivalCalendar();
        Thread.sleep(1500);
    }

    @When("choose to Departure Month Date {string} on the Home Page")
    public void chooseToDepartureMonthDateOnTheHomePage(String arg0) {
        homePage.chooseDepartureMonthDate(arg0);
    }

    @When("choose to Day Date Calendar {string} on the Home Page")
    public void chooseToDayDateCalenderOnTheHomePage(String arg0) {
        homePage.chooseDepartureDayDate(arg0);
    }

    @When("taps to Date Of Arrival on the Home Page")
    public void tapsToDateOfArrivalOnTheHomePage() {
        homePage.clickDateOfArrival();
    }

    @When("choose to Arrival Month Date {string} on the Home Page")
    public void chooseToArrivalMonthDateOnTheHomePage(String arg0) {
        homePage.chooseArrivalMonthDate(arg0);
    }

    @When("taps to Number Of Passengers on the Home Page")
    public void tapsToNumberOfPassengersOnTheHomePage() {
        homePage.clickNumberOfPassengers();
    }

    @Then("should see Passengers Panel on the Home Page")
    public void shouldSeePassengersPanelOnTheHomePage() {
        homePage.checkPassengersPanel();
    }


    @When("choose to Adult Passengers Number {int} on the Home Page")
    public void chooseToAdultPassengersNumberOnTheHomePage(int arg0) {
        homePage.chooseAdultPassengersNumber(arg0);
    }


    @When("taps to Done Button Passengers Panel on the Home Page")
    public void tapsToDoneButtonPassengersPanelOnTheHomePage() {
        homePage.clickDoneButtonPassengersPanel();
    }

    @When("taps to Find Cheps Button on the Home Page")
    public void tapsToFindChepsButtonOnTheHomePage() {
        homePage.clickFindChepsButton();
    }

    @When("taps to Login Header on the Home Page")
    public void tapsToLoginHeaderOnTheHomePage() {
        homePage.clickLoginHeader();
    }


}
