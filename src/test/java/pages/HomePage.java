package pages;

import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import util.ElementUtil;

public class HomePage {

    ElementUtil elementUtil = new ElementUtil();

    private final By homePage = By.id("__next");
    private final By roundTripCheckBox = By.cssSelector("[data-testid='search-round-trip-label']");
    private final By dateOfArrivalText = By.cssSelector("[data-testid='enuygun-homepage-flight-returnDate-label']");
    private final By fromWhereTextbox = By.cssSelector("[data-testid='endesign-flight-origin-autosuggestion-input']");
    private final By airportOptionsFromWhere = By.cssSelector("[data-testid='endesign-flight-origin-autosuggestion-options']");
    private final By airportOptionsToWhere = By.cssSelector("[data-testid='endesign-flight-destination-autosuggestion-options']");
    private final By firstAirportFromWhere = By.cssSelector("[data-testid='endesign-flight-origin-autosuggestion-option-item-0']");
    private final By firstAirportToWhere = By.cssSelector("[data-testid='endesign-flight-destination-autosuggestion-option-item-0']");
    private final By toWhereTextbox = By.cssSelector("[data-testid='endesign-flight-destination-autosuggestion-input']");
    private final By departureDate = By.cssSelector("[data-testid='enuygun-homepage-flight-departureDate-datepicker-popover-button']");
    private final By departureCalendar = By.cssSelector("[data-testid='enuygun-homepage-flight-departureDate-datepicker-popover-panel']");
    private final By arrivalCalendar = By.cssSelector("[data-testid='enuygun-homepage-flight-returnDate-datepicker-popover-panel']");
    private final By departureCalendarDateMonth = By.cssSelector("[data-testid='enuygun-homepage-flight-departureDate-month-name-and-year']");
    private final By arrivalCalendarDateMonth = By.cssSelector("[data-testid='enuygun-homepage-flight-returnDate-month-name-and-year']");
    private final By monthBackBtt = By.cssSelector("[data-testid='enuygun-homepage-flight-departureDate-month-back-button']");
    private final By departureMonthForwardBtt = By.cssSelector("[data-testid='enuygun-homepage-flight-departureDate-month-forward-button']");
    private final By arrivalMonthForwardBtt = By.cssSelector("[data-testid='enuygun-homepage-flight-returnDate-month-forward-button']");
    private final By calendarDay = By.cssSelector("[data-testid='datepicker-active-day']");
    private final By arrivalDate = By.cssSelector("[data-testid='enuygun-homepage-flight-returnDate-datepicker']");
    private final By numberOfPassengers = By.cssSelector("[data-testid='enuygun-homepage-flight-selectPassengerAndCabin']");
    private final By passengersPanel = By.cssSelector("[data-testid='undefined-popover-panel']");
    private final By adultPassengersNumber = By.cssSelector("[data-testid='flight-adult-counter-count']");
    private final By adultPassengersMinusBtt = By.cssSelector("[data-testid='flight-adult-counter-minus-button']");
    private final By adultPassengersPlusBtt = By.cssSelector("[data-testid='flight-adult-counter-plus-button']");
    private final By doneBttPassengersPanel = By.cssSelector("[data-testid='enuygun-homepage-flight-doneBtn']");
    private final By findCheepsBtt = By.cssSelector("[data-testid='enuygun-homepage-flight-submitButton']");
    private final By loginHeader = By.cssSelector("[data-testid='header-membership']");
    private final By random = By.cssSelector(".sc-70f39b27-4.PHAvU");



    public void goToUrl() {elementUtil.goToUrl("https://www.enuygun.com/");}

    public void checkHomePage() {elementUtil.checkElementVisible(homePage);}

    public void clickRoundTripCheckBox() {elementUtil.click(roundTripCheckBox);}

    public void checkDateOfArrivalText(String text) {elementUtil.checkElementGetText(dateOfArrivalText, text);}

    public void writeFromWhereTextbox(String text) {elementUtil.sendKey(fromWhereTextbox, text);}

    public void checkAirportOptionsFromWhereBar() {elementUtil.checkElementVisible(airportOptionsFromWhere);}

    public void checkAirportOptionsBarToWhereBar() {elementUtil.checkElementVisible(airportOptionsToWhere);}

    public void clickFirstAirportFromWhere() {elementUtil.click(firstAirportFromWhere);}

    public void clickFirstAirportToWhere() {elementUtil.click(firstAirportToWhere);}

    public void writeToWhereTextbox(String text) {elementUtil.sendKey(toWhereTextbox, text);}

    public void clickDepartureDate() {
        //Burada randomContainer a tıklama sebebim şudur : Firefoxta departureDate ekran responsiveınden dolayı kuculuyor ve tıklanabılır olmuyor. Bosluga tıklayınca tıklanabılır oluyor. Sisteme bir cozum icin yazilmistir.
        elementUtil.click(random);
        elementUtil.click(departureDate);}

    public void checkDepartureCalendar() {elementUtil.checkElementVisible(departureCalendar);}

    public void checkArrivalCalendar() {elementUtil.checkElementVisible(arrivalCalendar);}

    public void chooseDepartureMonthDate(String text) {
        // 1 yıl sonrasına kadar randevu olusturulabıldıgı ıcın 1 yıl sonrasına kadar monthu arıcak bulamazsa ayı bulamadım dicek
        boolean check = false;
        if(!elementUtil.getTextElementsWithIndex(departureCalendarDateMonth,0).equals(text) && !elementUtil.getTextElementsWithIndex(departureCalendarDateMonth,1).equals(text)){
                for(int i = 0; i<6 ; i++ ){
                    elementUtil.click(departureMonthForwardBtt);
                    if(elementUtil.getTextElementsWithIndex(departureCalendarDateMonth,0).equals(text) || elementUtil.getTextElementsWithIndex(departureCalendarDateMonth,1).equals(text)){
                        check = true;
                        break;
                    }
                }
            Assert.assertTrue("The requested month was not found in the calendar", check);
        }
    }
    public void chooseArrivalMonthDate(String text) {
        // 1 yıl sonrasına kadar randevu olusturulabıldıgı ıcın 1 yıl sonrasına kadar monthu arıcak bulamazsa ayı bulamadım dicek
        boolean check = false;
        if(!elementUtil.getTextElementsWithIndex(arrivalCalendarDateMonth,0).equals(text) && !elementUtil.getTextElementsWithIndex(arrivalCalendarDateMonth,1).equals(text)){
            for(int i = 0; i<6 ; i++ ){
                elementUtil.click(arrivalMonthForwardBtt);
                if(elementUtil.getTextElementsWithIndex(arrivalCalendarDateMonth,0).equals(text) || elementUtil.getTextElementsWithIndex(arrivalCalendarDateMonth,1).equals(text)){
                    check = true;
                    break;
                }
            }
            Assert.assertTrue("The requested month was not found in the calendar", check);
        }
    }

    public void chooseDepartureDayDate(String text) {elementUtil.click(elementUtil.elementWithTextFromTheElements(calendarDay, text));}

    public void clickDateOfArrival() {
        elementUtil.click(arrivalDate);
    }

    public void clickNumberOfPassengers() {
        elementUtil.click(numberOfPassengers);
    }

    public void checkPassengersPanel() {
        elementUtil.checkElementVisible(passengersPanel);
    }

    public void chooseAdultPassengersNumber(int number) {
        //Yolcu sayisi ilk acildiginda 10 danda baslasa else methodu sayesinde istenen degere getiriliyor
        int currentNumber = elementUtil.elementGetTextNumber(adultPassengersNumber);
        if(currentNumber == number) {
            elementUtil.checkElementGetTextNumber(adultPassengersNumber, number);
        }else if (currentNumber < number ) {
            for (int i = 0; i < Math.abs(number - currentNumber); i++) {
                elementUtil.click(adultPassengersPlusBtt);
            }
        }else{
            for (int i = 0; i < Math.abs(currentNumber - number); i++) {
                elementUtil.click(adultPassengersMinusBtt);
            }
        }

    }
    public void clickDoneButtonPassengersPanel() {
        elementUtil.click(doneBttPassengersPanel);
    }

    public void clickFindChepsButton() {
        elementUtil.click(findCheepsBtt);
    }

    public void clickLoginHeader() {
        elementUtil.click(loginHeader);
    }


}
