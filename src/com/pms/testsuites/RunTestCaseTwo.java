package com.pms.testsuites;

import java.io.IOException;

import org.junit.Test;

import com.pms.src.Execution;

/*
 * Test case 2 : 
 * Negative scenarios to check on Registration page 
 * where user clicks submit button without filling any personal details
 * Selenium code to verify if all alerts are visible on page e.g. Enter your name
 */

public class RunTestCaseTwo {
	public static String Browser_Name = "Chrome";
	@Test
	public void pickmysolar() throws InterruptedException, IOException {
		Execution ex = new Execution();
		ex.init(Browser_Name,"TC2");
	}

}
