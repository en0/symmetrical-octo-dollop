package com.ilaird.learning.day2.machine;

import com.ilaird.learning.day2.ui.UserInteractor;

public class SoldOutState implements GumballMachineState {

    private UserInteractor interactor;

    public SoldOutState(UserInteractor interactor) {
        this.interactor = interactor;
    }

    public void setContext(GumballContext context) {
        // context Not Used
    }

    public void insertCoin() {
        interactor.sendMessage("The machine is empty.");
    }

    public void turnCrank() {
        interactor.sendMessage("The crank will not turn.");
    }

    public void collectGumball() {
        interactor.sendMessage("There is no gumball to collect.");
    }

}
