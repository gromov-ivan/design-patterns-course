package main.java.builder.computer_builder;

public class Main {
    public static void main(String[] args) {

        ComputerDirector director = new ComputerDirector();

        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        Computer gamingRig = director.construct(gamingBuilder);
        System.out.println(gamingRig);

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        Computer officePC = director.construct(officeBuilder);
        System.out.println(officePC);
    }
}
