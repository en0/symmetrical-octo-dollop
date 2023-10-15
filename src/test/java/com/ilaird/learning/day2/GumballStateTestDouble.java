package com.ilaird.learning.day2;

import java.util.ArrayList;
import java.util.List;

import com.ilaird.learning.day2.machine.GumballContext;
import com.ilaird.learning.day2.machine.GumballMachineState;

public class GumballStateTestDouble implements GumballMachineState {

    public List<CallDetails> callList = new ArrayList<>();

    public void setContext(GumballContext context) {
        callList.add(new CallDetails() {
            {
                method = "setContext";
                args = List.of(context);
            }
        });
    }

    public void insertCoin() {
        callList.add(new CallDetails() {
            {
                method = "insertCoin";
                args = List.of();
            }
        });
    }

    public void turnCrank() {
        callList.add(new CallDetails() {
            {
                method = "turnCrank";
                args = List.of();
            }
        });
    }

    public void collectGumball() {
        callList.add(new CallDetails() {
            {
                method = "collectGumball";
                args = List.of();
            }
        });
    }
}
