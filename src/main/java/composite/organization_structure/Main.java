package main.java.composite.organization_structure;

public class Main {
    public static void main(String[] args) {

        Department company = new Department("Musici");
        Department logisticsDept = new Department("Logistics");
        Department itDept = new Department("IT");

        Employee rita = new Employee("Rita", 3500.00);
        Employee dima = new Employee("Dima", 3500.00);
        Employee ivan = new Employee("Ivan", 4000.00);
        Employee artem = new Employee("Artem", 5000.00);

        logisticsDept.add(rita);
        logisticsDept.add(dima);

        itDept.add(ivan);
        itDept.add(artem);

        company.add(logisticsDept);
        company.add(itDept);

        System.out.println("Total salary: " + company.getTotalSalary());

        System.out.println("\nOrganizational structure in XML:");
        System.out.println();
        company.printXml("");
    }
}
