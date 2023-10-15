package com.ilaird.learning.day2;

import java.util.Queue;

import com.ilaird.learning.day2.ui.UserInteractor;

public class UserInteractorTestDouble implements UserInteractor {

    public Queue<String> inputQueue;
    public Queue<String> outputQueue;

    public UserInteractorTestDouble(Queue<String> inputQueue, Queue<String> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    public String getResponse() {
        return inputQueue.remove();
    }

    public void sendRequest(String prompt) {
        outputQueue.add(prompt);
    }

    public void sendRequest(StringBuilder prompt) {
        sendRequest(prompt.toString());
    }

    public void sendError(String response) {
        outputQueue.add(response);
    }

    public void sendError(StringBuilder response) {
        sendError(response.toString());
    }

    public void sendMessage(String message) {
        outputQueue.add(message);
    }

    public void sendMessage(StringBuilder message) {
        sendMessage(message.toString());
    }

}
