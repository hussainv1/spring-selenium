package com.udemy.spring.springselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import io.github.bonigarcia.wdm.WebDriverManager;

@Lazy
@Configuration
@Profile("!remote")
public class WebDriverConfig {

	@Value("${default.timeout:30}")
	private int timeout;
	
	

	//@Primary
	@Bean
	@ConditionalOnProperty(name="browser", havingValue = "firefox")
	public WebDriver firefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	

	@Bean
	@ConditionalOnMissingBean
	public WebDriver chromeDriver() {
		WebDriverManager.chromedriver().version("87.0.4280.20").setup();
		return new ChromeDriver();
	}
	


	@Bean
	public WebDriverWait webdriverWait(WebDriver driver) {
		return new WebDriverWait(driver, this.timeout);
	}

}
