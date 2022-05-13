package org.fb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoFbLogIn extends BaseClassFb {
	public PojoFbLogIn() {
		PageFactory.initElements(driver, this);
	}
	@FindAll({
		@FindBy(id="email"),
		@FindBy(name="email")
	})
	private WebElement email;
	@FindAll({
		@FindBy(id="pass"),
		@FindBy(name="pass")
	})
	private WebElement password;
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	@FindAll({
		@FindBy(xpath="//button[@value='1']"),
		@FindBy(name="login")
	})
	private WebElement logIn;
	public WebElement getLogIn() {
		return logIn;
	}
	@FindBy(xpath="//div[contains(text(),'We couldn')]")
	private WebElement getText;
	public WebElement getGetText() {
		return getText;
	}

}

