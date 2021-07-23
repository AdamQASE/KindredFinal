package io.realworld.angularjs.runners;

import io.cucumber.core.plugin.TestNGFormatter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "io.realworld.angularjs.stepDefinitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
