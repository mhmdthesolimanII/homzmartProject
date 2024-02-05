package org.example.stepDefs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_homzmart;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.example.stepDefs.Hooks.driver;
public class D01_homzmart {
    public P01_homzmart homzmart = new P01_homzmart();
    public SoftAssert soft = new SoftAssert();
    public Faker faker = new Faker();
    public JavascriptExecutor js = (JavascriptExecutor) driver;
    String generatedEmail;
    @Given("user is on the registration page")
    public void userIsOnTheRegistrationPage() throws InterruptedException {
        homzmart.homeScreenSignIn.click();
        Thread.sleep(1500);
        homzmart.dontHaveAnAccount.click();
        soft.assertEquals(driver.getCurrentUrl(), "https://homzmart.com/en/register");

    }
    @When("user enters valid registration information")
    public void userEnterValidRegistrationInformation() throws InterruptedException {
        generatedEmail = faker.internet().emailAddress();
        System.out.println("Generated email: " + generatedEmail);
        homzmart.firstName.sendKeys(faker.name().firstName());
        homzmart.lastName.sendKeys(faker.name().lastName());
        homzmart.phoneNumber.sendKeys("1022009197");
        homzmart.email.sendKeys(generatedEmail);
        String fakePassword = faker.internet().password();
        homzmart.password.sendKeys(fakePassword);
        homzmart.confirmPassword.sendKeys(fakePassword);
        homzmart.registerFormSignUpButton.click();
    }
    @And("user sign out and register with same email")
    public void userSignOutAndRegisterWithSameEmail() throws InterruptedException {
        Thread.sleep(5000);
        homzmart.homePageSignOut.click();
        Thread.sleep(500);
        homzmart.homePageSignOutDropDownSignOut.click();
        homzmart.homeScreenSignIn.click();
        Thread.sleep(1500);
        homzmart.dontHaveAnAccount.click();
        homzmart.firstName.sendKeys(faker.name().firstName());
        homzmart.lastName.sendKeys(faker.name().lastName());
        homzmart.phoneNumber.sendKeys("1022009197");
        homzmart.email.sendKeys(generatedEmail);
        String fakePassword = faker.internet().password();
        homzmart.password.sendKeys(fakePassword);
        homzmart.confirmPassword.sendKeys(fakePassword);
        homzmart.registerFormSignUpButton.click();
    }
    @Then("user should see an error message saying Email address already exists")
    public void userShouldSeeAnErrorMessageSayingEmailAddressAlreadyExists() throws InterruptedException {
        Thread.sleep(1500);
        soft.assertTrue(homzmart.emailAlreadyExist.isDisplayed());
    }
    @When("user enters a not valid phone number")
    public void userEntersANotValidPhoneNumber() throws InterruptedException {
        driver.get("https://homzmart.com/en/register");
        homzmart.firstName.sendKeys(faker.name().firstName());
        homzmart.lastName.sendKeys(faker.name().lastName());
        homzmart.phoneNumber.sendKeys("4444444444");
        homzmart.email.sendKeys(faker.internet().emailAddress());
        String fakePassword = faker.internet().password();
        homzmart.password.sendKeys(fakePassword);
        homzmart.confirmPassword.sendKeys(fakePassword);
        homzmart.registerFormSignUpButton.click();
    }
    @Then("user should see an error message indicates that Mobile is required")
    public void userShouldSeeAnErrorMessageIndicatesThatMobileIsRequired() throws InterruptedException {
        soft.assertTrue(homzmart.mobileIsRequired.isDisplayed());
    }
    @When("user fills all required data leaves confirm password placeholder empty")
    public void userFillsAllRequiredDataLeavesConfirmPasswordPlaceholderEmpty() throws InterruptedException {
        homzmart.phoneNumber.clear();
        homzmart.phoneNumber.sendKeys("1022009197");
        String fakePassword = faker.internet().password();
        homzmart.password.sendKeys(fakePassword);
        homzmart.confirmPassword.clear();
        homzmart.registerFormSignUpButton.click();
    }
    @Then("user should see an error message indicates that Confirm Password is required")
    public void userShouldSeeAnErrorMessageIndicatesThatConfirmPasswordIsRequired() {
        soft.assertTrue(homzmart.confirmPasswordIsRequired.isDisplayed());
    }
    @When("the user fills in the registration fields with an unconventional email")
    public void theUserFillsInTheRegistrationFieldsWithAnUnconventionalEmail() throws InterruptedException {
        driver.get("https://homzmart.com/en");
        homzmart.homeScreenSignIn.click();
        Thread.sleep(1500);
        homzmart.dontHaveAnAccount.click();
        homzmart.firstName.sendKeys("Micheal");
        homzmart.lastName.sendKeys("Jackson");
        homzmart.phoneNumber.sendKeys("1022009197");
        int randomNumber = faker.number().numberBetween(1, 1000000);
        String randomEmail = "email@emaillllllllllllll" + randomNumber + ".comcomcom";
        homzmart.email.sendKeys(randomEmail);
        String fakePassword = faker.internet().password();
        homzmart.password.sendKeys(fakePassword);
        homzmart.confirmPassword.sendKeys(fakePassword);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement notValidEmailAlert = wait.until(ExpectedConditions.visibilityOf(homzmart.notValidEmailAlert));

            // BUG: The Website accepts signup with invalid Email.
            soft.assertTrue(!notValidEmailAlert.isDisplayed(), "user can sign up with an invalid email");
        } catch (Exception e) {
            System.out.println("Alert not displayed. Allowing the user signup.");
        } finally {
            homzmart.registerFormSignUpButton.click();
        }
    }
    @Given("I am on the website homepage")
    public void iAmOnTheWebsiteHomepage() {
        driver.getCurrentUrl();
        soft.assertEquals(driver.getCurrentUrl(), "https://homzmart.com/en/");
    }
    @When("I click on the Furniture category")
    public void iClickOnTheFurnitureCategory() throws InterruptedException {
        homzmart.furnitureCategory.click();
        Thread.sleep(2000);
        WebElement productToHover = homzmart.image;
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(productToHover).perform();
    }
    @Then("I should see a list of products related to beds and beech")
    public void iShouldSeeAListOfProductsRelatedToLivingRoomFurniture() throws InterruptedException {
        List<WebElement> productTitles = homzmart.productsTitle;
        for (WebElement title : productTitles) {
            String titleText = title.getText().toLowerCase();
            if (titleText.contains("bed") && titleText.contains("beech")) {
                System.out.println("Product title matches: " + titleText);
            }
        }
        Thread.sleep(2000);
    }
    @And("I should be able to filter the products by price and other attributes")
    public void iShouldBeAbleToFilterTheProductsByPriceBrandAndOtherAttributes() throws InterruptedException {
        homzmart.priceFromLowToHigh.click();
        soft.assertTrue(homzmart.priceFromLowToHigh.isSelected());
        homzmart.filterWhiteColor.click();
        soft.assertTrue(homzmart.filterWhiteColor.isSelected());
        homzmart.categoryMetalCenterTables.click();
        soft.assertTrue(homzmart.categoryMetalCenterTables.isSelected());
        if (!homzmart.applyButton.isDisplayed()) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", homzmart.applyButton);
        }
        homzmart.applyButton.click();
        Thread.sleep(2500);
        if (!homzmart.steel.isDisplayed()) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", homzmart.steel);
        }
        homzmart.steel.click();
        soft.assertTrue(homzmart.steel.isSelected());
        homzmart.applyButton.click();
        Thread.sleep(2500);
        List<WebElement> productTitles = homzmart.checkProductTitlesRelatedToSteel;
        for (WebElement title : productTitles) {
            String titleText = title.getText().toLowerCase();
            if (titleText.contains("steel")) {
                System.out.println("Product title matches: " + titleText);
            }
        }
    }
    @Given("I am on a product page")
    public void iAmOnAProductPage() throws InterruptedException {
        homzmart.furnitureCategory.click();
        Thread.sleep(3000);
        WebElement productToHover = homzmart.image;
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(productToHover).perform();
        homzmart.product.click();
    }
    @Then("I should see a large image of the product")
    public void iShouldSeeALargeImageOfTheProduct() throws InterruptedException {
        Thread.sleep(4000);
        soft.assertTrue(homzmart.productPhotos.isDisplayed());
    }
    @Then("I should see the product name, price, and description")
    public void iShouldSeeTheProductNamePriceAndDescription() throws InterruptedException {
        homzmart.productName.getText();
        if (homzmart.productName.getText().equals("Bed 120×160×195 cm - Beige - ENG.FUR.36")) {
            System.out.println("The product name is displayed");
        }
        homzmart.productPrice.getText();
        if (homzmart.productPrice.getText().equals("3,999.00")) {
            System.out.println("The product price is displayed");
        }
        homzmart.showFullDescription.click();
        List<WebElement> productDescriptionItems = homzmart.descriptionItemsList;
        for (WebElement items : productDescriptionItems) {
            String descriptionItemsText = items.getText().toLowerCase();
            if (items.isDisplayed()) {
                System.out.println(descriptionItemsText);
            }
        }
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/5);");
            Thread.sleep(2000);
        homzmart.showFullSpecs.click();
        List<WebElement> SpecsItemsList = homzmart.SepcsItemsList;
        for (WebElement items : SpecsItemsList) {
            String specsItemsText = items.getText().toLowerCase();
            if (items.isDisplayed()) {
                System.out.println(specsItemsText);
            }
        }
    }
    @And("I should be able to read customer reviews and ratings")
    public void iShouldBeAbleToReadCustomerReviewsAndRatings() throws InterruptedException {
        homzmart.seeAllReviews.click();
        Thread.sleep(5000);
        List<WebElement>customerReviews = homzmart.customersReviews;
        for (WebElement reviews:customerReviews){
            String reviewsText = reviews.getText();
            if(reviews.isDisplayed()){
                System.out.println(reviewsText);
            }
        }
        if (homzmart.ratings.isDisplayed()){
            System.out.println("Ratings are displayed");
        }
    }
    @Given("I am on the IKEA homepage")
    public void iAmOnTheIKEAHomepage() {
        driver.getCurrentUrl();
        soft.assertEquals(driver.getCurrentUrl(), "https://homzmart.com/en/");
    }
    @When("I enter shelf in the search bar")
    public void iEnterShelfInTheSearchBar() throws InterruptedException {
        homzmart.searchBar.sendKeys("Shelf");
        Thread.sleep(3000);
        homzmart.searchBar.sendKeys(Keys.ENTER);
    }
    @Then("I should see a list of products that match the search term")
    public void iShouldSeeAListOfProductsThatMatchTheSearchTerm() throws InterruptedException {
    Thread.sleep(3000);
        List<WebElement> productTitles = homzmart.productsTitle;
    for (WebElement title: productTitles){
        String titleText = title.getText();
        if (titleText.contains("Shelf")){
            System.out.println(titleText);
            }
        }
    }
    @Given("I am browsing the Living Room category")
    public void iAmBrowsingTheLivingRoomCategory() throws InterruptedException {
        WebElement productToHover = homzmart.furnitureCategory;
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(productToHover).perform();
        Thread.sleep(1500);
        homzmart.roomSets.click();
    }
    @When("I click Add to cart on a product")
    public void iClickAddToCartOnAProduct() throws InterruptedException {
        Thread.sleep(5000);
        WebElement productToHover = homzmart.productToAddToCard;
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(productToHover).perform();
        homzmart.productToAddToCard.click();
        Thread.sleep(5000);
        homzmart.AddToCard.click();;
    }
    @Then("I should see success message of the added item")
    public void iShouldSeeSuccessMessageOfTheAddedItem() throws InterruptedException {
        Thread.sleep(2500);
        if(homzmart.itemAddedToCardMessage.isDisplayed()){
            String successMessage=homzmart.itemAddedToCardMessage.getText();
            System.out.println("The success message is : "+successMessage);
        }
    }
    @And("the product should be added to my cart")
    public void theProductShouldBeAddedToMyCart() throws InterruptedException {
        homzmart.cartIcon.click();
        Thread.sleep(1500);
        if(homzmart.cartItemContent.isDisplayed()){
           String itemContentText=homzmart.cartItemContent.getText();
            System.out.println("TheItemAddedIs: "+itemContentText);
        }
    }
    @And("I should see the updated cart total")
    public void iShouldSeeTheUpdatedCartTotal() {
        if(homzmart.cartSubtotal.isDisplayed()){
            String subtotalText = homzmart.cartSubtotal.getText();
            System.out.println("The cart subtotal text is: "+subtotalText);
        }
    }
    @Given("I have a product in my cart")
    public void iHaveAProductInMyCart() throws InterruptedException {
        homzmart.storage.click();
        Thread.sleep(2500);
        WebElement productToHover = homzmart.secondProductToAdd;
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(homzmart.secondProductToAdd).perform();
        Thread.sleep(2500);
        homzmart.secondProductToAdd.click();
        Thread.sleep(3500);
        homzmart.AddToCard.click();
        Thread.sleep(2000);
        homzmart.cartIcon.click();
        Thread.sleep(2000);
        homzmart.goToCart.click();
        Thread.sleep(2600);
    }
    @When("I change the quantity to two and the cart total should be updated accordingly")
    public void iChangeTheQuantityToTwoAndTheCartTotalShouldBeUpdatedAccordingly() throws InterruptedException {
        String subtotalWithLetters = homzmart.subtotal.getText();
        String subtotalNumbersOnly = subtotalWithLetters.replaceAll("EGP","");
        System.out.println(subtotalNumbersOnly);
        // Get the price of one item
        WebElement productPriceElement = homzmart.productPriceForOnePiece;
        String productPriceText = productPriceElement.getText().replaceAll("EGP ", "");
        int productPriceOfOnePiece = Integer.parseInt(productPriceText);
        // Generate a random number of clicks
        int numberOfClicks = new Random().nextInt(10);
        for (int i = 0; i < numberOfClicks; i++) {
            homzmart.increaseQuantity.click();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Calculate the subtotal according to the number of clicks
        int subtotalAccordingToClicks = (numberOfClicks * productPriceOfOnePiece)+productPriceOfOnePiece;
        // Print the updated total price
        System.out.println("The Total Price After Increasing The Amount Is = " + subtotalAccordingToClicks);
    }
    @Given("I have a item in my cart")
    public void iHaveAItemInMyCart() throws InterruptedException {
        homzmart.storage.click();
        Thread.sleep(2500);
        WebElement productToHover = homzmart.secondProductToAdd;
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(homzmart.secondProductToAdd).perform();
        Thread.sleep(2500);
        homzmart.secondProductToAdd.click();
        Thread.sleep(3500);
        homzmart.AddToCard.click();
        Thread.sleep(2000);
        homzmart.cartIcon.click();
        Thread.sleep(2000);
        homzmart.goToCart.click();
        Thread.sleep(2600);
    }
    @When("I click Remove on the product")
    public void iClickRemoveOnTheProduct() throws InterruptedException {
        homzmart.removeProductButton.click();
        Thread.sleep(3000);
    }
    @Then("the product should be removed from my cart")
    public void theProductShouldBeRemovedFromMyCart() {
        if(homzmart.YourShoppingCartIsEmptyText.isDisplayed()){
            System.out.println("The product have been deleted successfully");
        }
    }
    @Given("I have items in my cart")
    public void iHaveItemsInMyCart() throws InterruptedException {
        homzmart.storage.click();
        Thread.sleep(2500);
        WebElement productToHover = homzmart.secondProductToAdd;
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(homzmart.secondProductToAdd).perform();
        Thread.sleep(2500);
        homzmart.secondProductToAdd.click();
        Thread.sleep(3500);
        homzmart.AddToCard.click();
        Thread.sleep(2000);
        homzmart.cartIcon.click();
        Thread.sleep(2000);
        homzmart.goToCart.click();
        Thread.sleep(2600);
    }
    @When("I proceed to checkout")
    public void iProceedToCheckout() {
    homzmart.addAddressButton.click();
    }
    @Then("I should be able to enter my shipping information without creating an account")
    public void iShouldBeAbleToEnterMyShippingInformationWithoutCreatingAnAccount() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement shippingAddressForm = wait.until(ExpectedConditions.visibilityOf(homzmart.shippingAddressForm));

            // BUG: The Website directs user to login first before filling the shipping address.
            soft.assertTrue(!shippingAddressForm.isDisplayed(), "user can not fill shipping address unless logins first");
        } catch (Exception e) {
            System.out.println("user can not fill shipping address unless logins first");
        } finally {
            driver.get("https://homzmart.com/en/");
        }
    }
    @Given("I am logged in to my Homzmart account")
    public void iAmLoggedInToMyHomzmartAccount() throws InterruptedException {
        homzmart.homeScreenSignIn.click();
        Thread.sleep(4000);
        homzmart.dontHaveAnAccount.click();
        Thread.sleep(5000);
        homzmart.firstName.sendKeys(faker.name().firstName());
        homzmart.lastName.sendKeys(faker.name().lastName());
        homzmart.phoneNumber.sendKeys("1022445197");
        homzmart.email.sendKeys(faker.internet().emailAddress());
        String fakePassword = faker.internet().password();
        homzmart.password.sendKeys(fakePassword);
        homzmart.confirmPassword.sendKeys(fakePassword);
        homzmart.registerFormSignUpButton.click();
        Thread.sleep(5000);
    }
    @When("I go to checkout")
    public void iGoToCheckout() throws InterruptedException {
        homzmart.storage.click();
        Thread.sleep(2500);
        WebElement productToHover = homzmart.secondProductToAdd;
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(homzmart.secondProductToAdd).perform();
        Thread.sleep(2500);
        homzmart.secondProductToAdd.click();
        Thread.sleep(5000);
        homzmart.AddToCard.click();
        Thread.sleep(4000);
        homzmart.cartIcon.click();
        Thread.sleep(2000);
        homzmart.goToCart.click();
        Thread.sleep(2600);
        homzmart.addAddressButton.click();
        Thread.sleep(2000);
        homzmart.addAddresssFirstName.sendKeys("Mohammed");
        homzmart.addAddressLastName.sendKeys("Sameer");
        homzmart.AddAddressDetailed.sendKeys("Velit quo recusandae");
        homzmart.unitNumber.sendKeys("15");
        homzmart.floor.sendKeys("15");
        homzmart.AddAddressPhoneNumber.sendKeys("1154688974");
        new Actions(Hooks.driver).click(homzmart.AddAddressCity).sendKeys("Cairo").sendKeys(Keys.ENTER).perform();
        new Actions(Hooks.driver).click(homzmart.AddAddressRegion).sendKeys("Mokattam").sendKeys(Keys.ENTER).perform();
        homzmart.AddAddressSaveButton.click();
        homzmart.homzmartLogo.click();
        Thread.sleep(2500);
        homzmart.cartIcon.click();
        Thread.sleep(2000);
        homzmart.goToCart.click();
        Thread.sleep(2600);
        homzmart.addAddressButton.click();
        Thread.sleep(4500);
    }
    @Then("I should see my stored shipping information")
    public void iShouldSeeMyStoredShippingInformation() {
        WebElement addressInformation = homzmart.addressInformation;
        if(homzmart.addressInformation.isDisplayed()){
            System.out.println("The user address information is displayed correctly");
            homzmart.addressInformation.getText();
            System.out.println("The address is : "+homzmart.addressInformation.getText());
        }
    }
    @And("I should be able to see payment methods")
    public void iShouldBeAbleToSeePaymentMethods() throws InterruptedException {
        homzmart.proceedToPayment.click();
        Thread.sleep(2500);
        String paymentList = homzmart.paymentList.getText();
        if(homzmart.paymentList.isDisplayed()){
            System.out.println("The payment list is displayed");
            System.out.println(paymentList);
        }
    }

    @Given("I am on the Homzmart homepage")
    public void iAmOnTheHomzmartHomepage() {
        driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
    }

    @When("I click on the Contact Us link")
    public void iClickOnTheContactUsLink() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",homzmart.contactUs);
        Thread.sleep(1500);
        homzmart.contactUs.click();
        Thread.sleep(3500);
    }

    @Then("I should see a variety of contact options, such as phone number, email address")
    public void iShouldSeeAVarietyOfContactOptionsSuchAsPhoneNumberEmailAddress() {
    if(homzmart.letsTalk.isDisplayed()){
        String contactUsText = homzmart.letsTalk.getText();
        System.out.println("Contact us info are displayed and they're :"+""+contactUsText);
    }
    }
}