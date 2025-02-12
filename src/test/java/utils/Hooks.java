package utils;

import io.cucumber.java.After;

public class Hooks {

    @After
    public void afterEachScenario() {
        // Code to execute after each scenario, like cleanup
        System.out.println("Scenario completed! Performing cleanup...");
    }
}

