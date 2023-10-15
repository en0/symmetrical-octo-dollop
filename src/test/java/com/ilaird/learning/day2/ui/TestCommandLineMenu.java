package com.ilaird.learning.day2.ui;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import com.ilaird.learning.day2.Fixtures.CommandLineMenuBuilder;;

class TestCommandLineMenu {

    private Queue<String> inputQueue;
    private Queue<String> outputQueue;
    private CommandLineMenuBuilder builder = new CommandLineMenuBuilder();

    {
        inputQueue = new LinkedList<>();
        outputQueue = new LinkedList<>();
        builder
            .withPrompt("Unittest Prompt")
            .withInputQueue(inputQueue)
            .withOutputQueue(outputQueue);

        inputQueue.add("0");
    }

    ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Test
    void canAddMenuItems() {

        Menu menu = builder.build();
        menu.addMenuItem("Menu Item One", () -> {});
        menu.showMenu();

        assertTrue(outputQueue.poll().contains("Menu Item One"));
    }

    @Test
    void showMenuIncludesPrompt() {

        Menu menu = builder
            .withPrompt("Hello prompt")
            .build();

        menu.showMenu();
        assertTrue(outputQueue.poll().contains("Hello prompt"));
    }

    @Test
    void showMenuDisplaysMenuWithNumbersAndPrompt() {

        String expected = "Prompt String\n" +
                          "1) option one\n" +
                          "2) option two\n" +
                          "3) option three\n" +
                          "\n>";

        Menu menu = builder
            .withPrompt("Prompt String")
            .build();
        menu.addMenuItem("option one", () -> {});
        menu.addMenuItem("option two", () -> {});
        menu.addMenuItem("option three", () -> {});
        menu.showMenu();
        assertTrue(outputQueue.poll().equals(expected));
    }

    @Test
    void canExecuteMenuCommand() {

        boolean[] commandExecuted = new boolean[3];
        inputQueue.clear();

        Menu menu = builder.build();
        menu.addMenuItem("Option one", () -> commandExecuted[0] = true);
        menu.addMenuItem("Option two", () -> commandExecuted[1] = true);
        menu.addMenuItem("Option three", () -> commandExecuted[3] = true);

        inputQueue.add("2");
        menu.showMenu();
        assertTrue(commandExecuted[1]);
    }


    @Test
    void otherCommandsNotExecuted() {

        boolean[] commandExecuted = new boolean[3];
        inputQueue.clear();

        Menu menu = builder.build();
        menu.addMenuItem("Option one", () -> commandExecuted[0] = true);
        menu.addMenuItem("Option two", () -> commandExecuted[1] = true);
        menu.addMenuItem("Option three", () -> commandExecuted[3] = true);

        inputQueue.add("2");
        menu.showMenu();
        assertFalse(commandExecuted[0]);
        assertFalse(commandExecuted[2]);
    }
}
