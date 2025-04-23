package main.java.builder.computer_builder;

public interface ComputerBuilder {
    void buildProcessor();

    void buildRAM();

    void buildHardDrive();

    void buildGraphicsCard();

    void buildOperatingSystem();

    Computer getResult();
}
