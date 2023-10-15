package com.ilaird.learning.day2.machine;

public interface GumballMachineState {
    void insertCoin();
    void turnCrank();
    void collectGumball();
    void setContext(GumballContext context);
}
