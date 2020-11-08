package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import stepDefinitions.MasterHooks;

public class LoginandLogout_Page extends MasterHooks {

	// Signin on landingpage
	@FindBy(xpath = "//li[@ng-if = '!UserInfo']//button[@id = 'dropdownMenuButton']")
	WebElement signinDropdown;

	// Customer login
	@FindBy(xpath = "/html/body/header/div[1]/div[1]/div[2]/div/div/div/ul/li[7]/div/div/a[1]")
	WebElement customerloginButton;

	// mobile number
	@FindBy(xpath = "//*[@id='txtMobileNumber1']")
	WebElement mobilenumberBox;

	// password
	@FindBy(xpath = "//label[contains(text(), 'Password ')]/../input[@id = 'txtPassword1']")
	WebElement passwordBox;

	// signin button
	@FindBy(id = "btnLogin")
	WebElement signinButton;
	
	// dropdown menu
	@FindBy(xpath = "//button[@id = 'dropdownMenuButton']//i[contains(text(), 'arrow_drop_down')]")
	WebElement verifyButtonDropdown;

	// verify login
	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	WebElement logoutText;

	// logout
	@FindBy(xpath = "//a[contains(text(), 'Logout')]")
	WebElement logoutButton;

	// logout confirmation
	@FindBy(id = "btnConfirmOKAction")
	WebElement logoutPopUpConfirm;
	

	// ===============================

	public WebElement signinDropdown() {
		return signinDropdown;
	}

	public WebElement customerloginButton() {
		return customerloginButton;
	}

	public WebElement mobilenumberBox() {
		return mobilenumberBox;
	}

	public WebElement passwordBox() {
		return passwordBox;
	}

	public WebElement signinButton() {
		return signinButton;
	}
	
	public WebElement verifyButtonDropdown() {
		return verifyButtonDropdown;
	}
	
	public WebElement logoutText() {
		return logoutText;
	}

	public WebElement logoutButton() {
		return logoutButton;
	}

	public WebElement logoutPopUpConfirm() {
		return logoutPopUpConfirm;
	}
}
