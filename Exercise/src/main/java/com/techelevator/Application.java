package com.techelevator;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    /**
     * The main entry point in the application
     * @param args
     */

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    List<Department> departments = new ArrayList<Department>();

    private void createDepartments() {
        departments.add(new Department(1, "Marketing"));
        departments.add(new Department(2, "Sales"));
        departments.add(new Department(3, "Engineering"));
    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        departments.forEach((n) -> System.out.println(n.getName()));
    }

    /**
     * Create employees and add them to the collection of employees
     */

    List<Employee> employees = new ArrayList<Employee>();

    private void createEmployees() {
        LocalDate today = LocalDate.now();
        Employee DeanJohnson = new Employee();
        DeanJohnson.setEmployeeId(1);
        DeanJohnson.setFirstName("Dean");
        DeanJohnson.setLastName("Johnson");
        DeanJohnson.setEmail("djohnson@teams.com");
        DeanJohnson.setSalary(60000.0);
        DeanJohnson.setDepartment(getDepartmentByName("Engineering"));
        DeanJohnson.setHireDate(today);
        employees.add(DeanJohnson);
        employees.add(new Employee(2, "Angie", "Smith", "asmith@teams.com", getDepartmentByName("Engineering"), today));
        employees.add(new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", getDepartmentByName("Marketing"), today));
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        employees.get(1).raiseSalary(10);
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        employees.forEach((n) -> System.out.printf("%s (%s) %s\n", n.getFullName(), moneyFormat.format(n.getSalary()), n.getDepartment().getName()));
    }

    /**
     * Create the 'TEams' project.
     */

    Map<String, Project> projects = new HashMap<String, Project>();

    private void createTeamsProject() {
       Project temp = new Project("TEams", "Project Management Software", 0, 30);
        List<Employee> tempemp = new ArrayList<Employee>();
        for(Employee employee : employees){
            if(employee.getDepartment().getName().equals("Engineering")){
                tempemp.add(employee);
            }
        }
        temp.setTeamMembers(tempemp);
        projects.put("TEams", temp);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project temp = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", 31, 7);
        List<Employee> tempemp = new ArrayList<Employee>();
        for(Employee employee : employees){
            if(employee.getDepartment().getName().equals("Marketing")){
                tempemp.add(employee);
            }
        }
        temp.setTeamMembers(tempemp);
        projects.put("Marketing Landing Page", temp);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        projects.forEach((n, s) -> {
            System.out.printf("%s: %d\n", n , s.getTeamMembers().size());
        });
    }

    private Department getDepartmentByName(String name){
        for(Department department: departments){
            if(department.getName().equals(name)){
                return department;
            }
        }
        return null;
    }

}
