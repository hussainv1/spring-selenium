package com.udemy.spring.springselenium.config;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

@Lazy
@Configuration
@Profile("remote")
public class RemoteWebDriverConfig {
	
	@Value("${selenium.grid.url}")
	private URL path;
	
	
	@Value("${default.timeout:30}")
	private int timeout;
	
	
	@Bean
	@ConditionalOnProperty(name="browser", havingValue = "firefox")
	public WebDriver remoteFirefoxDriver() {
		return new RemoteWebDriver(this.path, DesiredCapabilities.firefox());
	}
	
	@Bean
	@ConditionalOnMissingBean
	public WebDriver remoteChromeDriver() {
		return new RemoteWebDriver(this.path, DesiredCapabilities.chrome());
	}
	
	
	@Bean
	public WebDriverWait webDriverWait(WebDriver driver) {
		return new WebDriverWait(driver, this.timeout);
	}
	
	

}
