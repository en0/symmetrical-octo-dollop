package com.ilaird.learning.day2.machine;

import org.junit.jupiter.api.Test;

import com.ilaird.learning.day2.GumballStateTestDouble;

import static org.junit.jupiter.api.Assertions.*;

class TestFiniteStateGumballMachine {

    int initialInventory = 10;
    GumballStateTestDouble noCoinState = new GumballStateTestDouble();
    GumballStateTestDouble coinState = new GumballStateTestDouble();
    GumballStateTestDouble soldState = new GumballStateTestDouble();
    GumballStateTestDouble soldOutState = new GumballStateTestDouble();
    FiniteStateGumballMachineBuilder builder = new FiniteStateGumballMachineBuilder();

    {
        builder
            .withInventory(initialInventory)
            .withNoCoinState(noCoinState)
            .withCoinState(coinState)
            .withSoldState(soldState)
            .withSoldOutState(soldOutState);
    }

    @Test
    void getInventoryShouldReturnInitialInventory() {
        try {
            var unit = builder.build();
            assertEquals(unit.getInventory(), initialInventory);
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void decrementInventoryShouldSubtractOneFromInventory() {
        try {
            var unit = builder.build();
            unit.decrementInventory();
            assertEquals(unit.getInventory(), initialInventory - 1);
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void decrementInventoryShouldNotAllowInventoryToBeLessThanZero() {
        try {
            var unit = builder
                .withInventory(0)
                .build();
            unit.decrementInventory();
            assertEquals(unit.getInventory(), 0);
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void getNoCoinStateShouldReturnNoCoinState() {
        try {
            var unit = builder.build();
            var state = unit.getNoCoinState();
            assertEquals(state, noCoinState);
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void getCoinStateShouldReturnCoinState() {
        try {
            var unit = builder.build();
            var state = unit.getCoinState();
            assertEquals(state, coinState);
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void getSoldStateShouldReturnSoldState() {
        try {
            var unit = builder.build();
            var state = unit.getSoldState();
            assertEquals(state, soldState);
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void getSoldOutStateShouldReturnSoldOutState() {
        try {
            var unit = builder.build();
            var state = unit.getSoldOutState();
            assertEquals(state, soldOutState);
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void insertCoinShouldCallTheLastSetState() {
        var testState = new GumballStateTestDouble();
        try {
            var unit = builder.build();
            unit.setState(testState);
            unit.insertCoin();
            assertTrue(testState.callList.get(testState.callList.size() - 1).method.equals("insertCoin"));
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void turnCrankShouldCallTheLastSetState() {
        var testState = new GumballStateTestDouble();
        try {
            var unit = builder.build();
            unit.setState(testState);
            unit.turnCrank();
            assertTrue(testState.callList.get(testState.callList.size() - 1).method.equals("turnCrank"));
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void collectGumballShouldCallTheLastSetState() {
        var testState = new GumballStateTestDouble();
        try {
            var unit = builder.build();
            unit.setState(testState);
            unit.collectGumball();
            assertTrue(testState.callList.get(testState.callList.size() - 1).method.equals("collectGumball"));
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void setStateCallsSetContextOnAddedState() {
        var testState = new GumballStateTestDouble();
        try {
            var unit = builder.build();
            unit.setState(testState);
            var details = testState.callList.get(testState.callList.size() - 1);
            assertTrue(details.method.equals("setContext"));
            assertTrue(details.args.contains(unit));
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void noCoinStateIsTheInitialState() {
        try {
            var unit = builder.build();
            unit.insertCoin();
            assertTrue(noCoinState.callList.get(noCoinState.callList.size() - 1).method.equals("insertCoin"));
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }

    @Test
    void noCoinStateHasContextSetAfterInitialization() {
        try {
            var unit = builder.build();
            var details = noCoinState.callList.get(noCoinState.callList.size() - 1);
            assertTrue(details.method.equals("setContext"));
            assertTrue(details.args.contains(unit));
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }
}

