package com.ilaird.learning.day2.machine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import com.ilaird.learning.day2.CallDetails;
import com.ilaird.learning.day2.GumballContextTestDouble;
import com.ilaird.learning.day2.Fixtures.SoldStateBuilder;;

class TestSoldState {

    private Queue<String> outputQueue;
    private SoldStateBuilder builder = new SoldStateBuilder();
    private GumballContextTestDouble context = new GumballContextTestDouble();

    {
        outputQueue = new LinkedList<>();
        builder.withOutputQueue(outputQueue);
        builder.withGumballContext(context);
    }

    @Test
    void cannotInsertCoin() {
        var state = builder.build();
        state.insertCoin();
        String output = outputQueue.poll();
        assertTrue(output.equals("You should collect your gumball first."), output);
    }

    @Test
    void crankWillNotTurn() {
        var state = builder.build();
        state.turnCrank();
        String output = outputQueue.poll();
        assertTrue(output.equals("The crank will not turn."), output);
    }

    @Test
    void canCollectGumball() {
        var state = builder.build();
        state.collectGumball();
        String output = outputQueue.poll();
        assertTrue(output.equals("The gumball is collected."), output);
    }

    @Test
    void stateMovesToNoCoinStateAfterCollectingGumball() {
        var state = builder.build();
        state.collectGumball();
        CallDetails callDetail = context.callList.get(context.callList.size() - 1);
        assertTrue(callDetail.method.equals("setState"), "setState was not called.");
        assertTrue(callDetail.args.contains(context.noCoinState), "setState was with the wrong state.");
    }
}
