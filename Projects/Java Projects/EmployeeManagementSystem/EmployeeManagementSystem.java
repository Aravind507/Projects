package EmployeeManagementSystem;

import java.util.HashMap;
import java.util.Scanner;


class Employee {
    private String name = null;
    private String gender;
    private long phoneNumber;
    private String emailId = null;

    public Employee(String name, String gender, long phoneNumber, String emailId) {
        super();
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
                + "]";
    }

}


public class EmployeeManagementSystem {
    static HashMap<Integer, Employee> emp = new HashMap<Integer, Employee>();

    static private int empId;
    static private String name = null;
    static private String gender;
    static private long phoneNumber;
    static private String emailId = null;

    protected static void userInput(Scanner scan) {

        do {
            System.out.println("----------------SELECT THE OPTION----------------\n" + "1.Add new Employee\n"
                    + "2.Update Employee details\n" + "3.Delete Employee\n" + "4.View Employee details\n"
                    + "5.View all Employees list\n" + "6.Exit\n");
            System.out.println("Enter a number :");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    newEmployee(scan);
                    System.out.println("Employee added successfully....\n");
                    break;
                case 2:
                    update(scan);
                    System.out.println("Employee details updated successfully....\n");
                    break;
                case 3:
                    delete(scan);
                    System.out.println("Employee deleted successfully....\n");
                    break;
                case 4:
                    getEmployee(scan);
                    System.out.println();
                    break;
                case 5:
                    display();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("----Thank you----");
                    System.exit(0);
                default:
                    System.out.println("ENTER A VALID NUMBER ");
            }
        } while (true);

    }

    //	Adding employee
    private static void newEmployee(Scanner scan) {
        System.out.println("Enter ID : ");
        empId = scan.nextInt();
        System.out.println("Enter Name : ");
        name = scan.next();
        System.out.println("Enter Gender : ");
        gender = scan.next();
        System.out.println("Enter phone Number : ");
        phoneNumber = scan.nextLong();
        System.out.println("Enter Email Id: ");
        emailId = scan.next();
        emp.put(empId, new Employee(name, gender, phoneNumber, emailId));
    }

    //	Update employee
    private static void update(Scanner scan) {
        System.out.println("Enter employee id : ");
        int id = scan.nextInt();
        Employee employee = emp.get(id);
        System.out.println(
                "Enter the option to update : " + "\n1.Name" + "\n2.gender" + "\n3.phoneNumber" + "\n4.email id");
        int temp = scan.nextInt();
        if (temp >= 4) {
            System.out.println("Enter a valid move :");
        } else {
            switch (temp) {
                case 1:
                    System.out.println("Enter the new Employee name :");
                    employee.setName(scan.next());
                    break;
                case 2:
                    System.out.println("Enter the  Employee gender :");
                    employee.setGender(gender);
                    break;
                case 3:
                    System.out.println("Enter the new Phone Number :");
                    employee.setPhoneNumber(scan.nextInt());
                    break;
                case 4:
                    System.out.println("Enter the new Email id  :");
                    employee.setEmailId(emailId);
                    break;
                default:
                    System.out.println("Enter a Valid move ");
            }
        }
        emp.put(id, employee);
    }

    //	Deleting employee
    private static void delete(Scanner scan) {

        System.out.println("Enter Employee Id to remove :");
        int id = scan.nextInt();
        if (emp.containsKey(id)) {
            emp.remove(id);
        } else {
            System.out.println("Enter a valid Id");
        }

    }

    //	Getting Employee
    private static void getEmployee(Scanner scan) {
        System.out.println("Enter Employee id : ");
        int id = scan.nextInt();
        if (emp.containsKey(id)) {
            System.out.println(emp.get(id).toString());
        }
    }

    //	display employees
    private static void display() {
        System.out.println("Id\t Name\t Gender\tphoneNumber\temail id");
        for (Integer i : emp.keySet()) {
            System.out.print(+i + "\t" + emp.get(i).getName() + "\t" + emp.get(i).getGender() + "\t" + emp.get(i).getPhoneNumber() + "\t" + emp.get(i).getEmailId());
            System.out.println();
        }
    }

}