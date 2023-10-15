package com.ilaird.learning.day2.machine;

import org.junit.jupiter.api.Test;

import com.ilaird.learning.day2.GumballStateTestDouble;
import com.ilaird.learning.day2.Fixtures.FiniteStateGumballMachineBuilderBuilder;

import static org.junit.jupiter.api.Assertions.*;

class TestFiniteStateGumballMachineBuilder {

    FiniteStateGumballMachineBuilderBuilder builder =
        new FiniteStateGumballMachineBuilderBuilder();

    @Test
    void builderShouldThrowWhenMissingNoCoinState() {
        var unit = builder.build();
        MissingConfigurationException ex = assertThrows(
            MissingConfigurationException.class,
            () -> { unit.build(); }
        );
        var expected = "Missing required configuration 'noCoinState'.";
        var actual = ex.getMessage();
        assertTrue(expected.equals(actual));
    }

    @Test
    void builderShouldThrowWhenMissingCoinState() {
        var unit = builder.build();
        unit.withNoCoinState(new GumballStateTestDouble());
        MissingConfigurationException ex = assertThrows(
            MissingConfigurationException.class,
            () -> { unit.build(); }
        );
        var expected = "Missing required configuration 'coinState'.";
        var actual = ex.getMessage();
        assertTrue(expected.equals(actual));
    }

    @Test
    void builderShouldThrowWhenMissingSoldState() {
        var unit = builder.build();
        unit.withNoCoinState(new GumballStateTestDouble());
        unit.withCoinState(new GumballStateTestDouble());
        MissingConfigurationException ex = assertThrows(
            MissingConfigurationException.class,
            () -> { unit.build(); }
        );
        var expected = "Missing required configuration 'soldState'.";
        var actual = ex.getMessage();
        assertTrue(expected.equals(actual));
    }

    @Test
    void builderShouldThrowWhenMissingSoldOutState() {
        var unit = builder.build();
        unit.withNoCoinState(new GumballStateTestDouble());
        unit.withCoinState(new GumballStateTestDouble());
        unit.withSoldState(new GumballStateTestDouble());
        MissingConfigurationException ex = assertThrows(
            MissingConfigurationException.class,
            () -> { unit.build(); }
        );
        var expected = "Missing required configuration 'soldOutState'.";
        var actual = ex.getMessage();
        assertTrue(expected.equals(actual));
    }

    @Test
    void builderShouldThrowWhenMissingInventory() {
        var unit = builder.build();
        unit.withNoCoinState(new GumballStateTestDouble());
        unit.withCoinState(new GumballStateTestDouble());
        unit.withSoldState(new GumballStateTestDouble());
        unit.withSoldOutState(new GumballStateTestDouble());
        MissingConfigurationException ex = assertThrows(
            MissingConfigurationException.class,
            () -> { unit.build(); }
        );
        var expected = "Missing required configuration 'inventory'.";
        var actual = ex.getMessage();
        assertTrue(expected.equals(actual));
    }

    @Test
    void builderCanBuildTheFiniteStateGumballMachine() {
        try {
            var unit = builder.build();
            unit.withNoCoinState(new GumballStateTestDouble());
            unit.withCoinState(new GumballStateTestDouble());
            unit.withSoldState(new GumballStateTestDouble());
            unit.withSoldOutState(new GumballStateTestDouble());
            unit.withInventory(100);
            var fst = unit.build();
            assertNotNull(fst);
        } catch (MissingConfigurationException ex) {
            fail("Unexpected exception: " + ex.getMessage());
        }
    }
}
