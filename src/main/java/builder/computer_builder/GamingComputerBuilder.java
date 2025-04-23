package main.java.builder.computer_builder;

public class GamingComputerBuilder implements ComputerBuilder {

    private final Computer pc = new Computer();

    @Override
    public void buildProcessor() {
        pc.setProcessor("Intel Core i9");
    }

    @Override
    public void buildRAM() {
        pc.setRAM(32);
    }

    @Override
    public void buildHardDrive() {
        pc.setHardDrive("1 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        pc.setGraphicsCard("NVIDIA RTX 5090");
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
