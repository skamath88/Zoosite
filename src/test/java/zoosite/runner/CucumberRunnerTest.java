package zoosite.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"}, 
				features = {"src/test/java/zoosite/features/"},
				glue ={"zoosite/steps/"}
					)


public class CucumberRunnerTest {

}
