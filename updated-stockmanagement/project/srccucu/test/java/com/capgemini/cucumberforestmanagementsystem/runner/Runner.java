package com.capgemini.cucumberforestmanagementsystem.runner;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = ".//Feature", glue = "com.capgemini.cucumberforestmanagementsystem.stepdefinition", plugin = {
		"pretty", "html:target/cucumber" }, monochrome = true)
public class Runner {

	
}
