package com.ilaird.learning.day2.ui;

import java.util.ArrayList;
import java.util.List;

public class CommandLineMenu implements Menu {

    class MenuItem {
        String itemLabel;
        Runnable itemCommand;
    }

    private List<MenuItem> menuItems;
    private UserInteractor interactor;
    private String prompt;

    public CommandLineMenu(UserInteractor interactor, String prompt) {
        this.prompt = prompt;
        this.interactor = interactor;
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(String label, Runnable command) {
        menuItems.add(new MenuItem() {
            {
                itemLabel = label;
                itemCommand = command;
            }
        });
    }

    public void showMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(prompt).append("\n");
        for (int i = 0; i < menuItems.size(); i++)
            sb.append(i + 1)
              .append(") ")
              .append(menuItems.get(i).itemLabel)
              .append("\n");
        sb.append("\n>");
        interactor.sendRequest(sb);
        executeCommand(interactor.getResponse());
    }

    private void executeCommand(String input) {
        int value = -1;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            interactor.sendError("Unable to decode response.");
            return;
        }
        if (value > menuItems.size() || value < 1) {
            interactor.sendError("Unknown option " + value + ".");
        } else {
            MenuItem selected = menuItems.get(value-1);
            selected.itemCommand.run();
        }
    }

}
