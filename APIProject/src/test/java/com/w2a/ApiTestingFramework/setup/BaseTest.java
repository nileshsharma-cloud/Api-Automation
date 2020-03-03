package com.w2a.ApiTestingFramework.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseTest {

	public static Properties prop;

	@BeforeSuite
	public void start() throws IOException {
		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");

		prop.load(fis);
	}

	@BeforeSuite(dependsOnMethods = { "start" })
	public void setup() {

		RestAssured.baseURI = prop.getProperty("baseURI");
		RestAssured.basePath = prop.getProperty("basePath");
	}

	@AfterSuite
	public void teardown() {

	}
}
