package com.ilaird.learning.day2.ui;

public interface UserInteractor {
    String getResponse();
    void sendError(String message);
    void sendError(StringBuilder message);
    void sendRequest(String prompt);
    void sendRequest(StringBuilder prompt);
    void sendMessage(String message);
    void sendMessage(StringBuilder message);
}
