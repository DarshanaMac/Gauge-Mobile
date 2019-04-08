npm install -g npm@latest

npm install -g @getgauge/cli

Create Folder (TestMyApp) and Navigate to Folder

gauge init js # or csharp, dotnet, java, python, ruby

Now You can see project template

Create pom.xml file and add dependency

Open IntelliJ and Install gauge plugin

Then Open project through intelliJ

---------------------------------------------------------------------------
SPEC File

# E-Commaece scenario

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge run specs


## Checkout Product Pass Scenario
* Create User  profile
* Navigate to Product Details Page

## Checkout Product Fail Scenario

* Create User  profile with IncorrectData


-----------------------------------------------------------------------------


@Step("Create User  profile")
    public void CreateProfile() {
        driver.navigate().to("https://Storefront:shaver123@development-web-shavershop.demandware.net/s/Shaver_Shop_au/register");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#dwfrm_profile_customer_firstname")).sendKeys("test");
        driver.findElement(By.cssSelector("#dwfrm_profile_customer_lastname")).sendKeys("test1");
        driver.findElement(By.cssSelector("#dwfrm_profile_customer_email")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("#dwfrm_profile_customer_emailconfirm")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("#RegistrationForm>fieldset:nth-of-type(2)>div:nth-of-type(3)>input")).sendKeys("User@123@gmail.com");
        driver.findElement(By.cssSelector(" #RegistrationForm>fieldset:nth-of-type(2)>div:nth-of-type(4)>input")).sendKeys("User@123@gmail.com");
        driver.findElement(By.cssSelector(" #RegistrationForm>fieldset:nth-of-type(2)>div:nth-of-type(7)>button")).click();
    }
