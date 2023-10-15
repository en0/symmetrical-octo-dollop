package com.ilaird.learning.day2.machine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import com.ilaird.learning.day2.CallDetails;
import com.ilaird.learning.day2.GumballContextTestDouble;
import com.ilaird.learning.day2.Fixtures.NoCoinStateBuilder;

class TestNoCoinState {

    private Queue<String> outputQueue;
    private NoCoinStateBuilder builder = new NoCoinStateBuilder();
    private GumballContextTestDouble context = new GumballContextTestDouble();

    {
        outputQueue = new LinkedList<>();
        builder.withOutputQueue(outputQueue);
        builder.withGumballContext(context);
    }

    @Test
    void crankWillNotTurn() {
        NoCoinState state = builder.build();
        state.turnCrank();
        String output = outputQueue.poll();
        assertTrue(output.equals("The crank will not turn."), output);
    }

    @Test
    void noGumballToCollect() {
        NoCoinState state = builder.build();
        state.collectGumball();
        String output = outputQueue.poll();
        assertTrue(output.equals("There is no gumball to collect."), output);
    }

    @Test
    void coinInserted() {
        NoCoinState state = builder.build();
        state.insertCoin();
        String output = outputQueue.poll();
        assertTrue(output.equals("The coin is inserted."), output);
    }

    @Test
    void insertingCoinMovesToCoinState() {
        NoCoinState state = builder.build();
        state.insertCoin();
        CallDetails callDetail = context.callList.get(context.callList.size() - 1);
        assertTrue(callDetail.method.equals("setState"), "setState was not called.");
        assertTrue(callDetail.args.contains(context.coinState), "setState was with the wrong state.");
    }
}
