package com.ilaird.learning.day2;

import com.ilaird.learning.day2.machine.CoinState;
import com.ilaird.learning.day2.machine.NoCoinState;
import com.ilaird.learning.day2.machine.SoldState;
import com.ilaird.learning.day2.ui.UserInteractor;
import com.ilaird.learning.day2.machine.SoldOutState;
import com.ilaird.learning.day2.machine.FiniteStateGumballMachineBuilder;
import com.ilaird.learning.day2.machine.GumballMachine;
import com.ilaird.learning.day2.machine.MissingConfigurationException;

public class Main {

    public static void main(String[] args) {

        var interactor = new TerminalInteractor();
        GumballMachine machine = buildGumballMachine(2, interactor);

        if (machine == null) {
            interactor.sendError("Unable to continue. Exiting...");
            return;
        }

        var app = new GumballMachineApplication(machine, interactor);
        app.run();
    }

    private static GumballMachine buildGumballMachine(int inventory, UserInteractor interactor) {
        try {
            return new FiniteStateGumballMachineBuilder()
                .withCoinState(new CoinState(interactor))
                .withNoCoinState(new NoCoinState(interactor))
                .withSoldState(new SoldState(interactor))
                .withSoldOutState(new SoldOutState(interactor))
                .withInventory(inventory)
                .build();

        } catch(MissingConfigurationException ex) {
            interactor.sendError("Unable to create a gumball machine. " + ex.getMessage());
        }

        return null;
    }
}
