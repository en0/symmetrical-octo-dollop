package com.ilaird.learning.day2.machine;

import com.ilaird.learning.day2.ui.UserInteractor;

public class SoldState implements GumballMachineState {

    private GumballContext context;
    private UserInteractor interactor;

    public SoldState(UserInteractor interactor) {
        this.interactor = interactor;
    }

    public void setContext(GumballContext context) {
        this.context = context;
    }

    public void insertCoin() {
        interactor.sendMessage("You should collect your gumball first.");
    }

    public void turnCrank() {
        interactor.sendMessage("The crank will not turn.");
    }

    public void collectGumball() {
        interactor.sendMessage("The gumball is collected.");
        var newState = context.getNoCoinState();
        context.setState(newState);
    }

}
