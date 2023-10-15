package com.ilaird.learning.day2.machine;

import com.ilaird.learning.day2.ui.UserInteractor;

public class CoinState implements GumballMachineState {

    private GumballContext context;
    private UserInteractor interactor;

    public CoinState(UserInteractor interactor) {
        this.interactor = interactor;
    }

    public void setContext(GumballContext context) {
        this.context = context;
    }

    public void insertCoin() {
        interactor.sendMessage("There is already a coin inserted.");
    }

    public void turnCrank() {
        interactor.sendMessage("The crank turns.");
        int inventory = context.getInventory();
        var newState = inventory > 0 ? context.getSoldState() : context.getSoldOutState();
        context.decrementInventory();
        context.setState(newState);
    }

    public void collectGumball() {
        interactor.sendMessage("There is no gumball to collect.");
    }

}
