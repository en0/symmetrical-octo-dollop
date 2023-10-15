package com.ilaird.learning.day2.machine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

import com.ilaird.learning.day2.Fixtures.SoldOutStateBuilder;;

class TestSoldOutState {

    private Queue<String> outputQueue;
    private SoldOutStateBuilder builder = new SoldOutStateBuilder();

    {
        outputQueue = new LinkedList<>();
        builder.withOutputQueue(outputQueue);
    }

    @Test
    void cannotInsertCoin() {
        var state = builder.build();
        state.insertCoin();
        String output = outputQueue.poll();
        assertTrue(output.equals("The machine is empty."), output);
    }

    @Test
    void crankWillNotTurn() {
        var state = builder.build();
        state.turnCrank();
        String output = outputQueue.poll();
        assertTrue(output.equals("The crank will not turn."), output);
    }

    @Test
    void cannotCollectGumball() {
        var state = builder.build();
        state.collectGumball();
        String output = outputQueue.poll();
        assertTrue(output.equals("There is no gumball to collect."), output);
    }
}
