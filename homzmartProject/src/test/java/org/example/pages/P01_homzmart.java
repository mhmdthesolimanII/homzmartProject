package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import javax.swing.text.html.CSS;
import java.lang.invoke.CallSite;
import java.security.cert.CertStoreSpi;
import java.util.List;

public class P01_homzmart {
    public P01_homzmart() {
        PageFactory.initElements(Hooks.driver, this);
    }
@FindBy (css = "div[class=\"userMenu__loggedOut\"]")
public WebElement homeScreenSignIn;
@FindBy(css = "a[href=\"/en/register\"]")
public WebElement dontHaveAnAccount;
@FindBy(css = "input[placeholder=\"First Name\"]")
    public WebElement firstName;
@FindBy(css = "input[placeholder=\"Last Name\"]")
    public WebElement lastName;
@FindBy(css = "input[maxlength=\"10\"]")
    public WebElement phoneNumber;
@FindBy(css = "input[placeholder=\"Password\"]")
    public WebElement password;
@FindBy(css = "input[placeholder=\"Confirm Password\"]")
    public WebElement confirmPassword;
@FindBy(css = "input[placeholder=\"Email\"]")
    public WebElement email;
@FindBy(css = "div[class=\"text-wrapper\"]")
    public WebElement registerFormSignUpButton;
@FindBy(id = "HEADER_USER_LIST")
    public WebElement homePageSignOut;
@FindBy(id = "HEADER_SIGN_OUT_BUTTON")
    public WebElement homePageSignOutDropDownSignOut;
@FindBy(css = "div[class=\"toastify on warning toastify-right toastify-top\"]")
    public WebElement emailAlreadyExist;
@FindBy(css = "span[class=\"app-alert\"]")
    public WebElement mobileIsRequired;
@FindBy(css = "div[class=\"input-wrapper hz-mt-20\"] span[data-v-ed3ed3ae]")
    public WebElement confirmPasswordIsRequired;
@FindBy(css = "span[role=\"alert\"]")
public WebElement notValidEmailAlert;
@FindBy(css = "h3[class=\"productCard__nameText\"]")
public List<WebElement> productsTitle;
@FindBy(id = "HEADER_MENU_BAR_CATEGORY_0")
    public WebElement furnitureCategory;
@FindBy(css = "img[src=\"https://eg-rv.homzmart.net/catalog/product/c/o/cou.fu1-2_1.jpg\"]")
    public WebElement image;
@FindBy(css = "#\\31  > rect")
    public WebElement priceFromLowToHigh;
@FindBy(css = "#app-root > div:nth-child(3) > div:nth-child(3) > div > div.listing__container.row > div.listing__filters.col-lg-3.col-xl-3 > div:nth-child(3) > div:nth-child(1) > div.collapsible-content__container > div > div > div:nth-child(1) > svg")
    public WebElement filterWhiteColor;
@FindBy(css = "#app-root > div:nth-child(3) > div:nth-child(3) > div > div.listing__container.row > div.listing__filters.col-lg-3.col-xl-3 > div:nth-child(3) > div:nth-child(2) > div.collapsible-content__container > div > div > div:nth-child(1) > svg > rect")
    public WebElement categoryMetalCenterTables;
@FindBy(css = "div[class=\"listing__filters_group_img\"] button[class=\"apply\"]")
    public WebElement applyButton;
@FindBy(css = "#app-root > div:nth-child(3) > div:nth-child(3) > div > div.listing__container.row > div.listing__filters.col-lg-3.col-xl-3 > div:nth-child(3) > div:nth-child(4) > div.collapsible-content__container > div > div > div > svg > rect")
    public WebElement steel;
@FindBy(css = "h3[class=\"productCard__nameText\"]")
    public List<WebElement> checkProductTitlesRelatedToSteel;
@FindBy(css = "img[src=\"https://eg-rv.homzmart.net/catalog/product/7/0/70_1_18.jpg\"]")
    public WebElement product;
@FindBy(css = "div[class=\"carousel__item\"]")
   public WebElement productPhotos;
@FindBy(css = "div[class=\"name-with-rating\"] p:nth-child(1)")
    public WebElement productName;
@FindBy(css = "div[class=\"productPrices__container price-section-PDP\"] div[class=\"productPrices__prices\"] div[class=\"productPrices__specialPrice\"] p")
    public WebElement productPrice;
@FindBy(css = "span[class=\"see_more\"]")
    public WebElement showFullDescription;
@FindBy(css = "li[class=\"menu__item\"]:nth-child(2)")
    public WebElement myAccount;
@FindBy(css = "span[class=\"html_desciption\"] ul li")
    public List<WebElement> descriptionItemsList;
@FindBy(css = "div[class=\"specification_container pdp-new-section-responsive-line\"] span[class=\"see_more_text hz-fs-12\"]")
    public WebElement showFullSpecs;
@FindBy(css = "div[class=\"specification_body\"] div[data-v-77cdf9cb]")
    public List<WebElement> SepcsItemsList;
@FindBy(css = "p[class=\"hz-fs-12 see-all-reviews\"]")
    public WebElement seeAllReviews;
@FindBy(css = "div:nth-child(1) div[class=\"review-content-description\"] p")
    public List<WebElement> customersReviews;
@FindBy(css = "div[class=\"reviews-progress\"]")
    public WebElement ratings;
@FindBy(css = "#HEADER_MAIN_SEARCH_INPUT_FIELD")
    public WebElement searchBar;
@FindBy(css = "div[class=\"siteMenu__linksContainer\"] a[href=\"/en/c/furniture/room-sets\"]")
    public WebElement roomSets;
@FindBy(css = "div[class=\"listing__card\"] div[class=\"productCard__container card-item\"]:nth-child(3) h3")
    public WebElement productToAddToCard;
@FindBy(css = "button[class=\"button-with-icon default-bg fullWidth\"]")
    public WebElement AddToCard;
@FindBy(css = "div[class=\"toastify on success toastify-center toastify-top\"]")
    public WebElement itemAddedToCardMessage;
@FindBy(css = "div[class=\"cart__container\"]")
    public WebElement cartIcon;
@FindBy(css = "div[class=\"cartItem__info\"]")
    public WebElement cartItemContent;
@FindBy(css = "div[class=\"cart__subtotal hz-mb-20\"]")
    public WebElement cartSubtotal;
@FindBy(css = "a[href=\"/en/checkouts/cart\"]")
    public WebElement goToCart;
@FindBy(css = "div[class=\"cartItemQty__iconWrapper\"]:nth-child(3)")
    public WebElement increaseQuantity;
@FindBy(css = "b[data-v-6602584a]:nth-child(2)")
    public WebElement subtotal;
@FindBy(css = "div[class=\"cartItem__Prices\"] span:nth-child(1)")
    public WebElement productPriceForOnePiece;
@FindBy(css = "div[class=\"siteMenu__container\"] a[href=\"/en/c/storage\"]")
    public WebElement storage;
@FindBy(css = "div[class=\"listing__card\"] div[class=\"productCard__container card-item\"]:nth-child(1)")
    public WebElement secondProductToAdd;
@FindBy(css = "div[class=\"deleteItem\"]")
    public WebElement removeProductButton;
@FindBy(css = "h3[data-v-ff318e31]")
    public WebElement YourShoppingCartIsEmptyText;
@FindBy(css = "div[class=\"button__container button__container--full\"]")
    public WebElement addAddressButton;
@FindBy(css = "form[data-v-364acb25]")
    public WebElement loginForm;
@FindBy(css = "div[class=\"checkout__wide-column\"] form")
public WebElement shippingAddressForm;
@FindBy(css = "input[placeholder=\"Enter your first name\"]")
    public WebElement addAddresssFirstName;
@FindBy(css = "input[placeholder=\"Enter your last name\"]")
    public WebElement addAddressLastName;
@FindBy(css = "textarea[placeholder=\"Ex.B12\"]")
    public WebElement AddAddressDetailed;
@FindBy(css = "input[placeholder=\"Ex.B12\"]")
    public WebElement unitNumber;
@FindBy(css = "input[placeholder=\"Ex.3rd Floor\"]")
    public WebElement floor;
@FindBy(css = "input[placeholder=\"1xxxxxxxxx\"]")
    public WebElement AddAddressPhoneNumber;
@FindBy(css = "div[style=\"padding: 24px; box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 10px; border-radius: 16px;\"] div[class=\"hz-inputs-group\"]:nth-child(5) div[class=\"input-wrapper hz-mt-20\"]:nth-child(1) div[class=\"multiselect__tags\"]")
    public WebElement AddAddressCity;
@FindBy(css = "div[style=\"padding: 24px; box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 10px; border-radius: 16px;\"] div[class=\"hz-inputs-group\"]:nth-child(5) div[class=\"input-wrapper hz-mt-20\"]:nth-child(2) div[class=\"multiselect__tags\"]")
    public WebElement AddAddressRegion;
@FindBy(css = "div[class=\"hz-mt-43 form-action\"] div[class=\"hz-button-icon-wrapper\"]:nth-child(1)")
    public WebElement AddAddressSaveButton;
@FindBy(css = "div[class=\"checkout__logo\"]")
    public WebElement homzmartLogo;
@FindBy(css = "div[class=\"addressCard__wrapper addressCard__wrapper--active\"]")
    public WebElement addressInformation;
@FindBy(css = "div[class=\"button__effects\"]:nth-child(2)")
    public WebElement proceedToPayment;
@FindBy(css = "div[class=\"paymentList__container\"]")
    public WebElement paymentList;
@FindBy(css = "a[href=\"/en/contact-us\"]")
    public WebElement contactUs;
@FindBy(css = "div[class=\"talk\"]")
    public WebElement letsTalk;
}