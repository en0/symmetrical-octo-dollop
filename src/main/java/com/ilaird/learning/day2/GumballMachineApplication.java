package com.ilaird.learning.day2;

import com.ilaird.learning.day2.machine.GumballMachine;
import com.ilaird.learning.day2.ui.CommandLineMenu;
import com.ilaird.learning.day2.ui.Menu;
import com.ilaird.learning.day2.ui.UserInteractor;

class GumballMachineApplication {

    private Menu menu;
    private boolean isRunning;

    GumballMachineApplication(GumballMachine machine, UserInteractor interactor) {
        menu = new CommandLineMenu(interactor, "What would you like to do?");
        menu.addMenuItem("Insert a coin.", () -> machine.insertCoin());
        menu.addMenuItem("Turn the crank.", () -> machine.turnCrank());
        menu.addMenuItem("Collect the gumball.", () -> machine.collectGumball());
        menu.addMenuItem("Exit.", () -> this.isRunning = false);
    }

    void run() {
        isRunning = true;
        while (isRunning)
            menu.showMenu();
    }
}
