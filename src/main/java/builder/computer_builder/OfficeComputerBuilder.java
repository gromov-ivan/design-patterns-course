package main.java.builder.computer_builder;

public class OfficeComputerBuilder implements ComputerBuilder {

    private final Computer pc = new Computer();

    @Override
    public void buildProcessor() {
        pc.setProcessor("Intel Core i5");
    }

    @Override
    public void buildRAM() {
        pc.setRAM(16);
    }

    @Override
    public void buildHardDrive() {
        pc.setHardDrive("256 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        pc.setGraphicsCard("Integrated UHD Graphics");
    }

    @Override
    public void buildOperatingSystem() {
        pc.setOperatingSystem("Windows 11");
    }

    @Override
    public Computer getResult() {
        return pc;
    }
}
