package main.java.composite.organization_structure;

public abstract class OrganizationComponent {

    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract double getTotalSalary();

    public void add(OrganizationComponent component) {
    }

    public void remove(OrganizationComponent component) {
    }

    public abstract void printXml(String indent);
}
