package com.ilaird.learning.day2.machine;

public class FiniteStateGumballMachineBuilder {

    private Integer inventory;
    private GumballMachineState noCoinState;
    private GumballMachineState coinState;
    private GumballMachineState soldState;
    private GumballMachineState soldOutState;

    public FiniteStateGumballMachineBuilder withInventory(int inventory) {
        this.inventory = inventory;
        return this;
    }

    public FiniteStateGumballMachineBuilder withNoCoinState(GumballMachineState state) {
        noCoinState = state;
        return this;
    }

    public FiniteStateGumballMachineBuilder withCoinState(GumballMachineState state) {
        coinState = state;
        return this;
    }

    public FiniteStateGumballMachineBuilder withSoldState(GumballMachineState state) {
        soldState = state;
        return this;
    }

    public FiniteStateGumballMachineBuilder withSoldOutState(GumballMachineState state) {
        soldOutState = state;
        return this;
    }

    public FiniteStateGumballMachine build() throws MissingConfigurationException {

        if (noCoinState == null)
            throw new MissingConfigurationException("noCoinState");
        else if (coinState == null)
            throw new MissingConfigurationException("coinState");
        else if (soldState == null)
            throw new MissingConfigurationException("soldState");
        else if (soldOutState == null)
            throw new MissingConfigurationException("soldOutState");
        else if (inventory == null)
            throw new MissingConfigurationException("inventory");

        return new FiniteStateGumballMachine(
            inventory,
            noCoinState,
            coinState,
            soldState,
            soldOutState
        );
    }

}

