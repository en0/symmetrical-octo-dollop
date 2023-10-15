package com.ilaird.learning.day2.machine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import com.ilaird.learning.day2.CallDetails;
import com.ilaird.learning.day2.GumballContextTestDouble;
import com.ilaird.learning.day2.Fixtures.CoinStateBuilder;

class TestCoinState {

    private Queue<String> outputQueue;
    private CoinStateBuilder builder = new CoinStateBuilder();
    private GumballContextTestDouble context = new GumballContextTestDouble();

    {
        outputQueue = new LinkedList<>();
        builder.withOutputQueue(outputQueue);
        builder.withGumballContext(context);
    }

    @Test
    void cannotInsertCoin() {
        CoinState state = builder.build();
        state.insertCoin();
        String output = outputQueue.poll();
        assertTrue(output.equals("There is already a coin inserted."), output);
    }

    @Test
    void crankWillTurn() {
        CoinState state = builder.build();
        state.turnCrank();
        String output = outputQueue.poll();
        assertTrue(output.equals("The crank turns."), output);
    }

    @Test
    void noGumballToCollect() {
        CoinState state = builder.build();
        state.collectGumball();
        String output = outputQueue.poll();
        assertTrue(output.equals("There is no gumball to collect."), output);
    }

    @Test
    void turnCrankMovesSoldStateIfInventoryExists() {
        CoinState state = builder.build();
        context.inventory = 1;
        state.turnCrank();
        CallDetails callDetail = context.callList.get(context.callList.size() - 1);
        assertTrue(callDetail.method.equals("setState"), "setState was not called.");
        assertTrue(callDetail.args.contains(context.soldState), "setState was with the wrong state.");
    }

    @Test
    void turnCrankMovesToSoldOutStateIfNoMoreInventoryExists() {
        CoinState state = builder.build();
        context.inventory = 0;
        state.turnCrank();
        CallDetails callDetail = context.callList.get(context.callList.size() - 1);
        assertTrue(callDetail.method.equals("setState"), "setState was not called.");
        assertTrue(callDetail.args.contains(context.soldOutState), "setState was with the wrong state.");
    }

    @Test
    void turnCrankDecrementsInventory() {
        CoinState state = builder.build();
        context.inventory = 1;
        state.turnCrank();
        CallDetails callDetail = context.callList.get(context.callList.size() - 2);
        assertTrue(callDetail.method.equals("decrementInventory"), "Inventory not decremented.");
    }
}
