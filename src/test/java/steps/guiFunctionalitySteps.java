package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class guiFunctionalitySteps {

    final static String URL = "http://localhost:8100";

    WebDriver driver = new OperaDriver();

    // switch to this if you use Chrome
    //WebDriver driver = new ChromeDriver();

    // ------------------------------ CUCUMBER GLUE CODE ----------------------------------

    @Given("^is the URL \"([^\"]*)\"\\.$")
    public void isTheURL(String arg1) throws Throwable {
        openWebsite(driver, arg1);
        assert true;
    }

    @When("^the URL is entered in the browser,$")
    public void theURLIsEnteredInTheBrowser() throws Throwable {
        assert true;
    }

    @Then("^the TaleTime startpage should appear\\.$")
    public void theTaleTimeStartpageShouldAppear() throws Throwable {
        waitForObject(driver, "startPageHeading");
        assert checkIfObjectExistis(driver, "startPageHeading");
        driver.quit();
    }


    @When("^the user clicks on Registration-Button$")
    public void theUserClicksOnRegistrationButton() throws Throwable {
        waitForObject(driver, "registrationButton");
        clickOnObject(driver, "registrationButton");
        assert true;
    }

    @Then("^the Registration-Form should open$")
    public void theRegistrationFormShouldOpen() throws Throwable {
        waitForObject(driver, "createUserButton");
        assert checkIfObjectExistis(driver, "createUserButton");
        driver.quit();
    }

    @Given("^are the following values:$")
    public void areTheFollowingValues(DataTable dataTable) throws Throwable {
        List<List<String>> data = dataTable.raw();
        gotToRegistrationForm(driver);
        for (int i = 1; i < data.size(); i++) {
            String description = data.get(i).get(0).trim();
            String value = data.get(i).get(1).trim();
            // ion-input-2-lbl;

            WebElement element = driver.findElement(By.cssSelector("ion-input[name=\"" + description + "\"] input"));

            element.sendKeys(value);
        }
    }

    /*
      @When("^The button Create was clicked with these values$")
      public void theButtonCreateWasClicked() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @Then("^a new user should exist\\.$")
      public void aNewUserShouldExist() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @Given("^a logged-in user$")
      public void aLoggedInUser() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @When("^a new profile called \"([^\"]*)\" is created$")
      public void aNewProfileCalledIsCreated(String arg1) throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @Then("^a new profile should be available$")
      public void aNewProfileShouldBeAvailable() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @Given("^a existing profile$")
      public void aExistingProfile() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @Given("^a existing User in Database$")
      public void aExistingUserInDatabase() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @When("^User types in his credentials$")
      public void userTypesInHisCredentials() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @Then("^he should logged in$")
      public void heShouldLoggedIn() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @When("^User adds new Storie Titles$")
      public void userAddsNewStorieTitles() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @Then("^the new Stories should be available in the \"([^\"]*)\" section$")
      public void theNewStoriesShouldBeAvailableInTheSection(String arg1) throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @When("^User changes Font-Size to (\\d+)px$")
      public void userChangesFontSizeToPx(int arg1) throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @Then("^Font size is (\\d+)px$")
      public void fontSizeIsPx(int arg1) throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @When("^User changes the Language from \"([^\"]*)\" to \"([^\"]*)\"$")
      public void userChangesTheLanguageFromTo(String arg1, String arg2) throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @Then("^the Application should be in English$")
      public void theApplicationShouldBeInEnglish() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @When("^user types in his pin under \"([^\"]*)\"$")
      public void userTypesInHisPinUnder(String arg1) throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @When("^clicks on Logout in the next page$")
      public void clicksOnLogoutInTheNextPage() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @When("^user typed in hin pin under \"([^\"]*)\"$")
      public void userTypedInHinPinUnder(String arg1) throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @When("^clicks on delete account$")
      public void clicksOnDeleteAccount() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }

      @Then("^he should not able to login again$")
      public void heShouldNotAbleToLoginAgain() throws Throwable {
          // Write code here that turns the phrase above into concrete actions
          throw new PendingException();
      }
  */

    //--------------------------------- START OF HELP-METHODS ------------------------------------------------


    public static void waitForObject(WebDriver driver, String id) {
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(id))));
    }

    public static void clickOnObject(WebDriver driver, String id) {
        driver.findElement(By.id(id)).click();
    }

    public static boolean checkIfObjectExistis(WebDriver driver, String id) {
        WebElement element = driver.findElement(By.id(id));
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public static void openWebsite(WebDriver driver, String arg1) {
        driver.get(arg1);
        driver.manage().window().maximize();
    }

    public static void gotToRegistrationForm(WebDriver driver) {
        openWebsite(driver, URL);
        clickOnObject(driver, "registrationButton");
        waitForObject(driver, "createUserButton");
    }
}