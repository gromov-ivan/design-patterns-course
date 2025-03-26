package main.java.composite.organization_structure;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {

    private final List<OrganizationComponent> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        children.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }

    @Override
    public double getTotalSalary() {
        double sum = 0;
        for (OrganizationComponent child : children) {
            sum += child.getTotalSalary();
        }
        return sum;
    }

    @Override
    public void printXml(String indent) {
        System.out.println(indent + "<department name=\"" + name + "\">");

        String childIndent = indent + "    ";
        for (OrganizationComponent child : children) {
            child.printXml(childIndent);
        }
        System.out.println(indent + "</department>");
    }
}
