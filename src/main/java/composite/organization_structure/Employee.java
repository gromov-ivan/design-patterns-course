package main.java.composite.organization_structure;

public class Employee extends OrganizationComponent {

    private final double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public void printXml(String indent) {
        System.out.println(indent + "<employee name=\"" + name + "\" salary=\"" + salary + "\" />");
    }
}
