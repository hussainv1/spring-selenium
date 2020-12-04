package com.udemy.spring.springselenium.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.annotation.PostConstruct;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Lazy
@Component
public class ScreenShotUtil {
	
	@Autowired
	private TakesScreenshot driver;
	
	
	//@Value("${screenshot.path}/img.png")
	@Value("${screenshot.path}")
	private Path path;
	
	
	public void takeScreenShot() throws IOException {
		File sourceFile = this.driver.getScreenshotAs(OutputType.FILE);
		//FileCopyUtils.copy(sourceFile, this.path.toFile());
		FileCopyUtils.copy(sourceFile, this.path.resolve("googleResult.png").toFile());
	}
	
	
	@PostConstruct
	private void init() {
		for(int i=0; i < 10; i++ ) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Sleeping ....");
		}
	}

}
