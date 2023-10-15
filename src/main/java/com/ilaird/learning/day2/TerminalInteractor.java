package com.ilaird.learning.day2;

import java.util.Scanner;

import com.ilaird.learning.day2.ui.UserInteractor;

class TerminalInteractor implements UserInteractor {

    private Scanner scanner = new Scanner(System.in);

    public String getResponse() {
        return scanner.nextLine();
    }

    public void sendError(String message) {
        System.out.println(message + "\n");
    }

    public void sendError(StringBuilder message) {
        sendError(message.toString());
    }

    public void sendRequest(String prompt) {
        System.out.print(prompt);
    }

    public void sendRequest(StringBuilder prompt) {
        sendRequest(prompt.toString());
    }

    public void sendMessage(String message) {
        System.out.println(message + "\n");
    }

    public void sendMessage(StringBuilder message) {
        sendMessage(message.toString());
    }
};
