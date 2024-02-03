package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.ElementUtil;

import java.util.List;

public class SearchPage {

    ElementUtil elementUtil = new ElementUtil();

    private final By searchPage = By.id("SearchRoot");
    private final By departureArrivalTimeFilter = By.cssSelector(".ctx-filter-departure-return-time.card-header");
    private final By departureTimeSlider = By.cssSelector("[data-testid='departureDepartureTimeSlider']");
    private final By arrivalTimeSlider = By.cssSelector("[data-testid='departureArrivalTimeSlider']");
    private final By sliderLeft = By.cssSelector(".rc-slider-handle.rc-slider-handle-1");
    private final By sliderRight = By.cssSelector(".rc-slider-handle.rc-slider-handle-2");
    private final By departureTimeInFilter = By.cssSelector(".filter-slider-content");
    private final By flightDetailDepartureTime = By.cssSelector("[data-testid='departureTime']");
    private final By airlineFilter = By.cssSelector(".ctx-filter-airline.card-header");
    private final By filterOptions = By.cssSelector(".filter-label");
    private final By flightsPrice = By.cssSelector(".money-int");
    private final By firstFlightFromListed = By.id("flight-0");


    public void checkSearchPage() {elementUtil.checkElementVisible(searchPage);}

    public void checkDepartureArrivalTimeFilter() {elementUtil.checkElementVisible(departureArrivalTimeFilter);}

    public void clickDepartureArrivalTimeFilter() {elementUtil.click(departureArrivalTimeFilter);}

    public void checkDepartureTimeSlider() {elementUtil.checkElementVisible(departureTimeSlider);}

    public void checkArrivalTimeSlider() {elementUtil.checkElementVisible(arrivalTimeSlider);}

    public void chooseDepartureTimeLeftSliderDepartureArrivalTimeFilter(String text) {
        boolean check = false;
        for(int i = 0; i<46 ; i++){
            elementUtil.swipeRightSlider(sliderLeft, 10, 0);
            if(elementUtil.elementGetText(departureTimeInFilter).contains(text)){
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    public void chooseDepartureTimeRightSliderDepartureArrivalTimeFilter(String text) {
        boolean check = false;
        for(int i = 0; i<46 ; i++){
            elementUtil.swipeLeftSlider(sliderRight, -10, 0);
            if(elementUtil.elementGetText(departureTimeInFilter).contains(text)){
                check = true;
                break;
            }
        }
        Assert.assertTrue(check);
    }

    public void checkDepartureTimesOfTheFlightsAreBetweenAndOnTheSearchPage(String time1, String time2) {
        List<WebElement> elements = elementUtil.presenceElements(flightDetailDepartureTime);
        for(WebElement element : elements){
            elementUtil.isTimeInRange(element.getText(),time1,time2);
        }
    }

    public void clickAirlineFilter() {elementUtil.click(airlineFilter);}

    public void clickAirlineFromAirlineFilter(String airline) {
        elementUtil.getTextEqualsChildElementsFromElements(filterOptions,airline);
    }

    public void checkFlightsSortedAscendingPrice() {
        List<WebElement> elements = elementUtil.presenceElements(flightsPrice);
        for (int i = 0; i < elements.size() - 1; i++) {
            if (Double.parseDouble(elements.get(i).getText()) > Double.parseDouble(elements.get(i + 1).getText())) {
                Assert.fail("Azalandan artana gore sıralanmamis");
            }
        }
    }

    public void checkFlightsListedMoreThan() {elementUtil.checkElementVisible(firstFlightFromListed);}



}
