package com.ilaird.learning.day2.machine;

import com.ilaird.learning.day2.ui.UserInteractor;

public class NoCoinState implements GumballMachineState {

    private GumballContext context;
    private UserInteractor interactor;

    public NoCoinState(UserInteractor interactor) {
        this.interactor = interactor;
    }

    public void setContext(GumballContext context) {
        this.context = context;
    }

    public void insertCoin() {
        interactor.sendMessage("The coin is inserted.");
        var newState = context.getCoinState();
        context.setState(newState);
    }

    public void turnCrank() {
        interactor.sendMessage("The crank will not turn.");
    }

    public void collectGumball() {
        interactor.sendMessage("There is no gumball to collect.");
    }

}
