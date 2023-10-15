package com.ilaird.learning.day2.machine;

public class MissingConfigurationException extends Exception {
    public MissingConfigurationException(String configurationName) {
        super("Missing required configuration '" + configurationName + "'.");
    }
}
