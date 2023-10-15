package com.ilaird.learning.day2;

import java.util.ArrayList;
import java.util.List;

import com.ilaird.learning.day2.machine.GumballContext;
import com.ilaird.learning.day2.machine.GumballMachineState;

public class GumballContextTestDouble implements GumballContext {

    public List<CallDetails> callList = new ArrayList<>();

    public int inventory = 0;
    public GumballStateTestDouble noCoinState = new GumballStateTestDouble();
    public GumballStateTestDouble coinState = new GumballStateTestDouble();
    public GumballStateTestDouble soldState = new GumballStateTestDouble();
    public GumballStateTestDouble soldOutState = new GumballStateTestDouble();

    public void setState(GumballMachineState newState) {
        callList.add(new CallDetails() {
            {
                method = "setState";
                args = List.of(newState);
            }
        });
    }

    public GumballMachineState getNoCoinState() {
        callList.add(new CallDetails() {
            {
                method = "getNoCoinState";
                args = List.of();
            }
        });
        return noCoinState;
    }

    public GumballMachineState getCoinState() {
        callList.add(new CallDetails() {
            {
                method = "getCoinState";
                args = List.of();
            }
        });
        return coinState;
    }

    public GumballMachineState getSoldState() {
        callList.add(new CallDetails() {
            {
                method = "getSoldState";
                args = List.of();
            }
        });
        return soldState;
    }

    public GumballMachineState getSoldOutState() {
        callList.add(new CallDetails() {
            {
                method = "getSoldOutState";
                args = List.of();
            }
        });
        return soldOutState;
    }

    public int getInventory() {
        callList.add(new CallDetails() {
            {
                method = "getInventory";
                args = List.of();
            }
        });
        return inventory;
    }

    public void decrementInventory() {
        callList.add(new CallDetails() {
            {
                method = "decrementInventory";
                args = List.of();
            }
        });
    }
}
