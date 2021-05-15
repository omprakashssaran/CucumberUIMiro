package Pages;

import Utils.BasePage;
import Utils.Browser;
import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/*
 * Created by Om on 14/05/2021.
 * @desc this class will hold some methods for miro dashboard
 * Performed some action on miro board based on the page elements using selenium + cucumber
 */
public class DemoBoard extends BasePage {
    private WebDriver driver;
    static int randomNum = ThreadLocalRandom.current().nextInt();

    public DemoBoard(Browser browser) {

        super(browser.getDriver());
        this.driver = browser.getDriver();

    }

    //PageElements which are used in the Miro board creation and verification
    //By EmailIDForLogin = By.id("email");
    By EmailIDTextbox = By.xpath("//input[@id='email']");
    By passwordTextbox = By.xpath("//input[@id='password']");
    By signInButton = By.className("signup__submit");
    By createBoardButton = By.xpath("//div[@class='basicPanelCard-2ZoB_ serviceCard-2p6AM templatesPanel__card-1RnG6 serviceCard_primary-2j9PO']//div[@class='serviceCard__icon-3J1NI']//*[local-name()='svg']");
    By sharedBoardCreationButton = By.xpath("//button[normalize-space()='Create a shared board']");
    By templateSuggestionBoxCloseButton = By.xpath("//div[@class='closeButton__icon-UZZyp']//*[local-name()='svg']");
    By WhatsNewAlertCloseButton = By.xpath("//div[@class='btn modal-close changes-close']//*[local-name()='svg']");
    By toChoseTamplateFromSuggestionBox = By.className("tpicker-grid-item-template-details-default-view tpicker-grid-item-template-details-default-view--large tpicker-grid-item-template-details__content");
    By UntitledBoardName = By.xpath("//div[@class='board-top-left-panel__title board-top-left-panel__title--editable']");
    By ChangeNameUntitledBoardNameTextBox = By.xpath("//input[@class='board-info-title rtb-input rtb-input--light ng-pristine ng-valid ng-valid-maxlength ng-not-empty ng-touched']");
    //clear and change the board name and click enter.{baordname we can take from string BoardName veriable}
    // document.querySelector("input[class='board-info-title rtb-input rtb-input--light ng-pristine ng-valid ng-valid-maxlength ng-not-empty ng-touched']")
    By ClickAnywhereInBoard = By.xpath("//div[@class='board-info-modal effect-fadein effect-scale md-centered md-container md-show']");
    //rename //input[@placeholder='Type here']
    By WaitToSeeStickerLeftToolBar = By.xpath("//div[@class='board-toolbar']");
    //By clickany =By.xpath("//canvas[@class='retinaSupport']");
    By stickerImage = By.xpath("//p[normalize-space()='ok']/ancestor::div[@class='editor-container sticker-editor-container']");
    By stickerOk = By.xpath("//p[normalize-space()='ok']");
    By embadedImage = By.xpath("//div[@class='preview-area-container']");
    By downloadButton = By.xpath("//div[@class='svg-button board-top-left-panel__export']");
    By imageDownload = By.xpath("//span[normalize-space()='Save as image']");
    By embed = By.xpath("//span[normalize-space()='Embed']");
    By exportImage = By.xpath("//button[normalize-space()='Export']");
    By afterDone = By.xpath("//canvas[@class='retinaSupport']");
    By clickOnStickyNote = By.xpath("//div[@class='toolbar__item toolbar__item--customized AT__toolbar--STICKERS toolbar__item--stickers']//*[local-name()='svg']/*[name()='use']");
    // By clickOnStickyNote= By.className("toolbar__item toolbar__item--customized AT__toolbar--STICKERS toolbar__item--stickers toolbar__item--active");
    By selectColor = By.className("toolbar__panel__item");
    //div[@class='toolbar__panel toolbar__panel--stickers use-ng-animate']//div[5]
    //div[@class='toolbar__panel toolbar__panel--stickers use-ng-animate']//div[5]
    // //div[@class='toolbar__panel toolbar__panel--stickers use-ng-animate']//div[3]
    By clickAnyWhare = By.xpath("//canvas[@class='retinaSupport']");
    By writeOnStickNote = By.xpath("//div[@class='ql-editor ql-blank']//p");
    By sharebutton = By.xpath("//div[@class='board-top-share-button']//button[@id='share-board-button']");
    // By enterEmailIDToShare = By.xpath("//span[@class='email-input email-input--badge-like email-input--with-placeholder']");
    By enterEmailIDTextBoxToShare = By.xpath("//span[@class='share-content__emails-editor-interactive-placeholder']");
    //write the emailID
    By toAddcustomMessage = By.xpath("//div[@placeholder='Add custom message (optional)']");
    By sendInvitationButton = By.xpath("//button[@class='rtb-btn rtb-btn--primary rtb-btn--medium']");
    By doneButton = By.xpath("//button[@class='rtb-btn rtb-btn--primary rtb-btn--small']");

    // Now I have to search the same Board which I created
    //By searchBoard = By.xpath("//span[@tooltip='ok']");
    By searchBoard(String boardName) {
        // return By.xpath("//div[@class='boards-list__title-text'][normalize-space()='"+boardName+"']");
        return By.xpath("//span[@tooltip='" + boardName + randomNum + "']");
    }

    By miroLodder = By.xpath("//*[name()='path' and @id='animation-path']");
    By allBoards = By.xpath("//span[@tooltip]");

    By searchBoard(Integer boardNumber) {
        return By.xpath("(//span[@tooltip])[" + boardNumber + "]");
    }

    //and click on the same board
    //Miro using canvas so we have to verify the sticker via screenshots///or we can verify via name
    By searchButton = By.xpath("//div[@id='search-button']");
    By searchTheStickerByNameTextbox = By.xpath("//input[@placeholder='Search']");
    //By selectTheCreatedStickerByList =By.xpath("//div[@title='"+boardName+"']");
    By selectTheCreatedStickerByList(String stickerName) {
        return By.xpath("//div[@title='" + stickerName + "']");
    }
    By SearchWithWrongName = By.xpath("//div[@class='cnvsSearch_results_noResults']");
    //check its not clickable, if yes then we dont have any sticker with that name, if its clickable then yes we do have sticker
    // to edit the board //div[@class='cm-text']
    // three dots to edit //div[@id='additional']//div[@class='icon-box']
    By stickerEditButton = By.xpath("//div[@id='edit-horiz']//div[@class='cm-text'][normalize-space()='Edit']");
    By boardNameClick = By.xpath("//div[@class='board-top-left-panel__title board-top-left-panel__title--editable']");
    By deleteBoard = By.xpath("//div[contains(text(),'Delete')]");
    By leaveBoard = By.xpath("//div[contains(text(),'Leave')]");
    By deleteConfirmBoard = By.xpath("//button[normalize-space()='Delete']");
    By leaveConfirmationBoard = By.xpath("//button[normalize-space()='Leave']");
    By duplicateBoard = By.xpath("//div[contains(text(),'Duplicate')]");
    // By editTheExistingSticker = By.xpath("//p[normalize-space()='"+boardName+"']");
    By editTheExistingSticker(String stickerName) {
        return By.xpath("//p[normalize-space()='" + stickerName + "']");
    }
    By clickOnThreeDots = By.xpath("//div[@id='additional']//div[@class='icon-box']");
    By deleteExistingSticker = By.xpath("//div[@class='cm-text'][normalize-space()='Delete']");


    /*
     * Created by Om on 14/05/2021.
     * @desc this method is just to navigate the Miro Login page
     */
    @Given("^I navigate to the Open Miro Login Page$")
    public void i_navigate_to_the_Miro_login_page() throws Throwable {

        driver.get("https://miro.com/login/");

    }

    /*
     * Created by Om on 14/05/2021.
     * @desc this method is just to Login via credentials
     */
    @When("^I Login with userName \"([^\"]*)\" and password \"([^\"]*)\" in Miro$")
    public void iLoginWithUserNameAndPasswprdInMiro(String loginEmailID, String loginPassword) throws Throwable {

        clickOn(EmailIDTextbox);
        clearText(EmailIDTextbox);
        enterText(EmailIDTextbox, loginEmailID);
        clickOn(passwordTextbox);
        clearText(passwordTextbox);
        enterText(passwordTextbox, loginPassword);
        clickOn(signInButton);
        CloseAlert(WhatsNewAlertCloseButton);
        LOGGER.info("User" + loginEmailID + " successfully logged in to Miro");

    }

    /*
     * Created by Om on 14/05/2021.
     * @desc this method is just to create an board with sticker
     */
    @Then("^I create an board with name \"([^\"]*)\" and Sticker with name \"([^\"]*)\" in Miro board$")
    public void iCreateAnBoardWithName(String boardName, String stickerName) throws Throwable {
        Actions actions = new Actions(driver);
        CloseAlert(WhatsNewAlertCloseButton);
        clickOn(createBoardButton);
        clickOn(sharedBoardCreationButton);
        CloseAlert(WhatsNewAlertCloseButton);
        //wait.until(ExpectedConditions.elementToBeClickable(templateSuggestionBoxCloseButton));
        clickOn(templateSuggestionBoxCloseButton);
        clickOn(UntitledBoardName);
        clickOn(ChangeNameUntitledBoardNameTextBox);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ChangeNameUntitledBoardNameTextBox));
        WebElement changeTheBoardName = driver.findElement(ChangeNameUntitledBoardNameTextBox);
        //Mouse hover
        //actions.moveToElement(changeTheBoardName).sendKeys(Keys.CONTROL + "a" +Keys.DELETE).perform();
        // String b = Keys.BACK_SPACE.toString();
        // actions.moveToElement(changeTheBoardName).sendKeys(b+b+b+b+b+b+b+b+b+b+ boardName +"\n").perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].value ='';", changeTheBoardName);
        System.out.println("Board Name is :" + boardName + randomNum);
        LOGGER.info("Created board name is :" + boardName + randomNum);

        enterText(ChangeNameUntitledBoardNameTextBox, boardName + randomNum + "\n");
        //clickOn(ClickAnywhereInBoard);

        Thread.sleep(10000);
        WebElement StickyNote = driver.findElement(clickOnStickyNote);
        //Mouse hover
        actions.moveToElement(StickyNote).perform();
        System.out.println("Done Mouse hover on StickyNote");
        actions.moveToElement(StickyNote).click().perform();

        WebElement selectColorOnSticky = driver.findElement(selectColor);
        //Mouse hover
        actions.moveToElement(selectColorOnSticky).perform();
        System.out.println("Done Mouse hover on selectColorOnSticky");
        actions.moveToElement(selectColorOnSticky).doubleClick().perform();
        actions.moveByOffset(100, 100).click().perform();

        //wait.until(ExpectedConditions.elementToBeClickable(writeOnStickNote));
        clickOn(writeOnStickNote);
        enterText(writeOnStickNote, stickerName);

    }
    /*
     * Created by Om on 14/05/2021.
     * @desc this method is just to take the screenshots
     */
    public void screenshot(String boardName, int i) throws Exception {

        String imageUrl = driver.findElement(By.xpath("//div[@class='preview-img-container']//img")).getAttribute("src");
        driver.get(imageUrl);
        Thread.sleep(30000);
            /*System.out.println("URL:"+imageUrl);
            URL url =new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);
            */
        //Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Copy the file to a location
        try {
            FileUtils.copyFile(screenshot, new File("src/test/resources/Files/Screenshots/" + boardName + randomNum + i + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /*
     * Created by Om on 14/05/2021.
     * @desc this method is just to compare the screenshots
     */
    public void screenshotCompare(String boardName) throws Exception {
        BufferedImage expectedImage = ImageIO.read(new File("src/test/resources/Files/Screenshots/" + boardName + randomNum + 1 + ".png"));
        BufferedImage actualImage = ImageIO.read(new File("src/test/resources/Files/Screenshots/" + boardName + randomNum + 2 + ".png"));
        ImageDiffer imgdiffer = new ImageDiffer();
        ImageDiff imgdiff = imgdiffer.makeDiff(expectedImage, actualImage);
        Assert.assertFalse("Images are Different", imgdiff.hasDiff());
    }

    /*
     * Created by Om on 14/05/2021.
     * @desc this method is to share the board with user2
     */
    @Then("^I share the board with another \"([^\"]*)\" user & board \"([^\"]*)\"$")
    public void iShareTheBoardWithAnotherUser(String anotherEmailID, String boardName) throws Throwable {
        clickOn(sharebutton);
        Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        clickOn(enterEmailIDTextBoxToShare);

        Actions actions = new Actions(driver);
        WebElement selectColorOnSticky = driver.findElement(enterEmailIDTextBoxToShare);
        //Mouse hover
        actions.moveToElement(selectColorOnSticky).sendKeys(anotherEmailID).perform();
        System.out.println("Board is shared with the mentioned user: " + anotherEmailID);
        LOGGER.info("Board is shared with the mentioned user: " + anotherEmailID);
        // enterText(enterEmailIDTextBoxToShare,anotherEmailID);
        // Thread.sleep(10000);
        clickOn(toAddcustomMessage);
        enterText(toAddcustomMessage, "Please join the Miro Board");
        //Thread.sleep(10000);
        clickOn(sendInvitationButton);
        //Thread.sleep(10000);
        clickOn(doneButton);
        Thread.sleep(10000);
        clickOn(downloadButton);
        Thread.sleep(3000);
        clickOn(embed);
       /*clickOn(imageDownload);
        Thread.sleep(2000);
        clickOn(exportImage);
        Thread.sleep(5000);
       */
        screenshot(boardName, 1);
    }

    /*
     * Created by Om on 14/05/2021.
     * @desc this method is to verify the sticker in shared board
     */
    @Then("^I will verify the sticker \"([^\"]*)\" in shared board \"([^\"]*)\" with user2$")
    public void iWillVerifyTheStickerInSharedBoardWithUser2(String stickerName, String boardName) throws Throwable {

        clickOn(searchBoard(boardName));
        //  clickOn(searchBoard);
        CloseAlert(WhatsNewAlertCloseButton);
        // Thread.sleep(3000);
        String baseUrl = driver.getCurrentUrl();
        clickOn(downloadButton);
        //  Thread.sleep(3000);
        clickOn(embed);
        screenshot(boardName, 2);
        Thread.sleep(2000);
        screenshotCompare(boardName);
        driver.get(baseUrl);
        clickOn(searchButton);
        CloseAlert(WhatsNewAlertCloseButton);
        clickOn(searchTheStickerByNameTextbox);
        enterText(searchTheStickerByNameTextbox, stickerName);
        // wait.until(ExpectedConditions.elementToBeClickable(selectTheCreatedStickerByList(boardName)));
        clickOn(selectTheCreatedStickerByList(stickerName));
        String actualStickerName = getText(selectTheCreatedStickerByList(stickerName));
        System.out.println("Already created sticker name actual:- " + actualStickerName + " v/s Expected:- " + stickerName);
        LOGGER.info("Already created sticker Name: " + actualStickerName);

        clickOn(stickerEditButton);
        Assert.assertEquals("Same sticker", stickerName, actualStickerName);
        clickOn(editTheExistingSticker(stickerName));
        enterText(editTheExistingSticker(stickerName), "XYZ");
        clickOn(clickOnThreeDots);
        clickOn(deleteExistingSticker);
        //clickOn(SearchWithWrongName);
    }

    /*
     * Created by Om on 14/05/2021.
     * @desc this method is to clear the data
     */
    @Then("^I will clean the created board \"([^\"]*)\" data$")
    public void IWillCreateADataCleaner(String boardName) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(miroLodder));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(miroLodder));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<WebElement> boardList = new ArrayList<>();
        try {
            boardList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(allBoards, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //List<WebElement> boardList = driver.findElements(searchBoard(boardName));
        for (int i = 1; i <= boardList.size(); i++) {
            CloseAlert(WhatsNewAlertCloseButton);
            // clickOn(searchBoard(boardName));
            driver.findElement(searchBoard(1)).click();
            //boardList.get(i).click();
            CloseAlert(WhatsNewAlertCloseButton);
            clickOn(boardNameClick);
            System.out.println("Going to delete the existing board with the name: " + getText(boardNameClick));
            clickOn(deleteBoard);
            clickOn(deleteConfirmBoard);
            System.out.println("Miro board " + getText(boardNameClick) + " is deleted");
        }
    }
}