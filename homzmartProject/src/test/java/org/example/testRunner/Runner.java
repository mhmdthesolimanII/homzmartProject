package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features ="src/main/resources/Features",
                glue="org.example.stepDefs",
                tags= "@smoke",
                plugin=
                        {
                                "pretty",
                                "html:target/report.html"
                        }
        )
public class Runner extends AbstractTestNGCucumberTests {
}
