package com.ilaird.learning.day2;

import java.util.LinkedList;
import java.util.Queue;

import com.ilaird.learning.day2.machine.NoCoinState;
import com.ilaird.learning.day2.machine.SoldOutState;
import com.ilaird.learning.day2.machine.SoldState;
import com.ilaird.learning.day2.machine.CoinState;
import com.ilaird.learning.day2.machine.FiniteStateGumballMachineBuilder;
import com.ilaird.learning.day2.machine.GumballContext;
import com.ilaird.learning.day2.ui.CommandLineMenu;
import com.ilaird.learning.day2.ui.Menu;

public final class Fixtures {

    public static class CommandLineMenuBuilder {

        private String prompt = "";
        private Queue<String> outputQueue = new LinkedList<>();
        private Queue<String> inputQueue = new LinkedList<>();

        /**
         * Sets the prompt message to be displayed by the {@link CommandLineMenu} during testing.
         *
         * @param prompt The prompt message to set.
         * @return The {@link CommandLineMenuBuilder} instance for method chaining.
         */
        public CommandLineMenuBuilder withPrompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        /**
        * Sets the input queue for the {@link CommandLineMenu} during testing.
        *
        * @param inputQueue The input queue to set.
        * @return This {@link CommandLineMenuBuilder} instance for method chaining.
        */
        public CommandLineMenuBuilder withInputQueue(Queue<String> inputQueue) {
            this.inputQueue = inputQueue;
            return this;
        }

        /**
        * Sets the output queue for the {@link CommandLineMenu} during testing.
        *
        * @param outputQueue The output queue to set.
        * @return This {@link CommandLineMenuBuilder} instance for method chaining.
        */
        public CommandLineMenuBuilder withOutputQueue(Queue<String> outputQueue) {
            this.outputQueue = outputQueue;
            return this;
        }

        /**
        * Builds a {@link CommandLineMenu} instance for testing, configured with the specified options.
        *
        * @return A {@link CommandLineMenu} instance with the specified configuration.
        */
        public Menu build() {
            UserInteractorTestDouble interactor = new UserInteractorTestDouble(inputQueue, outputQueue);
            return new CommandLineMenu(interactor, prompt);
        }
    }

    public static class NoCoinStateBuilder {

        private Queue<String> outputQueue;
        private GumballContext context;

        /**
        * Sets the output queue for the {@link NoCoinState} during testing.
        *
        * @param outputQueue The output queue to set.
        * @return This {@link NoCoinStateBuilder} instance for method chaining.
        */
        public NoCoinStateBuilder withOutputQueue(Queue<String> outputQueue) {
            this.outputQueue = outputQueue;
            return this;
        }

        /**
        * Sets the {@link GumballContext} for the {@link NoCoinState} during testing.
        *
        * @param context The {@link GumballContext} to set.
        * @return This {@link NoCoinStateBuilder} instance for method chaining.
        */
        public NoCoinStateBuilder withGumballContext(GumballContext context) {
            this.context = context;
            return this;
        }

        /**
        * Builds a {@link NoCoinState} instance for testing, configured with the specified options.
        *
        * @return A {@link NoCoinState} instance with the specified configuration.
        */
        public NoCoinState build() {
            UserInteractorTestDouble interactor = new UserInteractorTestDouble(new LinkedList<>(), outputQueue);
            var state = new NoCoinState(interactor);
            state.setContext(context);
            return state;
        }
    }

    public static class CoinStateBuilder {

        private Queue<String> outputQueue;
        private GumballContext context;

        /**
        * Sets the output queue for the {@link CoinState} during testing.
        *
        * @param outputQueue The output queue to set.
        * @return This {@link CoinStateBuilder} instance for method chaining.
        */
        public CoinStateBuilder withOutputQueue(Queue<String> outputQueue) {
            this.outputQueue = outputQueue;
            return this;
        }

        /**
        * Sets the {@link GumballContext} for the {@link SoldState} during testing.
        *
        * @param context The {@link GumballContext} to set.
        * @return This {@link CoinStateBuilder} instance for method chaining.
        */
        public CoinStateBuilder withGumballContext(GumballContext context) {
            this.context = context;
            return this;
        }

        /**
        * Builds a {@link CoinState} instance for testing, configured with the specified options.
        *
        * @return A {@link CoinState} instance with the specified configuration.
        */
        public CoinState build() {
            UserInteractorTestDouble interactor = new UserInteractorTestDouble(new LinkedList<>(), outputQueue);
            var state = new CoinState(interactor);
            state.setContext(context);
            return state;
        }
    }

    public static class SoldStateBuilder {

        private Queue<String> outputQueue;
        private GumballContext context;

        /**
        * Sets the output queue for the {@link SoldState} during testing.
        *
        * @param outputQueue The output queue to set.
        * @return This {@link SoldStateBuilder} instance for method chaining.
        */
        public SoldStateBuilder withOutputQueue(Queue<String> outputQueue) {
            this.outputQueue = outputQueue;
            return this;
        }

        /**
        * Sets the {@link GumballContext} for the {@link SoldState} during testing.
        *
        * @param context The {@link GumballContext} to set.
        * @return This {@link SoldStateBuilder} instance for method chaining.
        */
        public SoldStateBuilder withGumballContext(GumballContext context) {
            this.context = context;
            return this;
        }

        /**
        * Builds a {@link SoldState} instance for testing, configured with the specified options.
        *
        * @return A {@link SoldState} instance with the specified configuration.
        */
        public SoldState build() {
            UserInteractorTestDouble interactor = new UserInteractorTestDouble(new LinkedList<>(), outputQueue);
            var state = new SoldState(interactor);
            state.setContext(context);
            return state;
        }
    }

    public static class SoldOutStateBuilder {

        private Queue<String> outputQueue;

        /**
        * Sets the output queue for the {@link SoldOutState} during testing.
        *
        * @param outputQueue The output queue to set.
        * @return This {@link SoldOutStateBuilder} instance for method chaining.
        */
        public SoldOutStateBuilder withOutputQueue(Queue<String> outputQueue) {
            this.outputQueue = outputQueue;
            return this;
        }

        /**
        * Builds a {@link SoldOutState} instance for testing, configured with the specified options.
        *
        * @return A {@link SoldOutState} instance with the specified configuration.
        */
        public SoldOutState build() {
            UserInteractorTestDouble interactor = new UserInteractorTestDouble(new LinkedList<>(), outputQueue);
            return new SoldOutState(interactor);
        }
    }

    public static class FiniteStateGumballMachineBuilderBuilder {
        /**
        * Builds a {@link FiniteStateGumballMachineBuilder} instance for testing, configured with the specified options.
        *
        * @return A {@link FiniteStateGumballMachineBuilder} instance with the specified configuration.
        */
        public FiniteStateGumballMachineBuilder build() {
            return new FiniteStateGumballMachineBuilder();
        }
    }
}
