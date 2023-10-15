package com.ilaird.learning.day2.machine;

public class FiniteStateGumballMachine implements GumballMachine, GumballContext {

    private int inventory;
    private GumballMachineState currentState;
    public GumballMachineState noCoinState;
    public GumballMachineState coinState;
    public GumballMachineState soldState;
    public GumballMachineState soldOutState;

    public FiniteStateGumballMachine(int initialInventory,
                                     GumballMachineState noCoinState,
                                     GumballMachineState coinState,
                                     GumballMachineState soldState,
                                     GumballMachineState soldOutState) {

        inventory = initialInventory;
        this.noCoinState = noCoinState;
        this.coinState = coinState;
        this.soldState = soldState;
        this.soldOutState = soldOutState;
        currentState = noCoinState;
        currentState.setContext(this);
    }

    public void setState(GumballMachineState newState) {
        newState.setContext(this);
        currentState = newState;
    }

    public GumballMachineState getNoCoinState() {
        return noCoinState;
    }

    public GumballMachineState getCoinState() {
        return coinState;
    }

    public GumballMachineState getSoldState() {
        return soldState;
    }

    public GumballMachineState getSoldOutState() {
        return soldOutState;
    }

    public int getInventory() {
        return inventory;
    }

    public void decrementInventory() {
        if (inventory > 0)
            inventory--;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void turnCrank() {
        currentState.turnCrank();
    }

    public void collectGumball() {
        currentState.collectGumball();
    }
}
