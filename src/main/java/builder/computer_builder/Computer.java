package main.java.builder.computer_builder;

public class Computer {

    private String processor;
    private int ramGB;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    void setProcessor(String p) {
        this.processor = p;
    }

    void setRAM(int gb) {
        this.ramGB = gb;
    }

    void setHardDrive(String h) {
        this.hardDrive = h;
    }

    void setGraphicsCard(String g) {
        this.graphicsCard = g;
    }

    void setOperatingSystem(String o) {
        this.operatingSystem = o;
    }

    @Override
    public String toString() {
        return """
                -------- Computer configuration --------
                CPU           : %s
                RAM           : %d GB
                Drive         : %s
                Graphics      : %s
                OS            : %s
                ----------------------------------------
                """.formatted(processor, ramGB, hardDrive, graphicsCard, operatingSystem);
    }
}
