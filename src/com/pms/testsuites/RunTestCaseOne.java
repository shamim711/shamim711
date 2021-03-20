package com.pms.testsuites;

import java.io.IOException;

import org.junit.Test;

import com.pms.src.Execution;

/*
 * Test case 1 : 
 * Create an account on Amazon India, 
 * Search a product, verify if same product showing on the page, Click on the same product, 
 * Add the product to Cart
 */

public class RunTestCaseOne {
	public static String Browser_Name = "Chrome"; 
	@Test
	public void pickmysolar() throws InterruptedException, IOException {
		Execution ex = new Execution();
		ex.init(Browser_Name,"TC2");
	}
}
