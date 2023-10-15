package com.ilaird.learning.day2.machine;

public interface GumballContext {
    void setState(GumballMachineState newState);
    GumballMachineState getNoCoinState();
    GumballMachineState getCoinState();
    GumballMachineState getSoldState();
    GumballMachineState getSoldOutState();
    int getInventory();
    void decrementInventory();
}
