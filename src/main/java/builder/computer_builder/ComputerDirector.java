package main.java.builder.computer_builder;

public class ComputerDirector {

    public Computer construct(ComputerBuilder builder) {
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();

        return builder.getResult();
    }
}

