package SharifParty;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean condition = true;
        Scanner scan = new Scanner(System.in);
        while (condition){
            System.out.println("Menu Guide : \n" +
                    "1 --> add employee\n" +
                    "2 --> add husband or wife \n" +
                    "3 --> Is Married ? \n" +
                    "4 --> Is Invited ? \n" +
                    "5 --> Show Invited List \n" +
                    "6 --> exit");
            System.out.println("Enter a Number to continue : ");

            int number = scan.nextInt();
            switch (number){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    addHusbandOrWife();
                    break;
                case 3:
                    isMarried();
                    break;
                case 4:
                    isInvited();
                    break;
                case 5:
                    showInvitedList();
                    break;
                case 6:
                    condition = false;
                    break;
                default:
                    System.out.println("Please enter a valid number : ");
            }
        }

    }

    public static void addEmployee(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first name : ");
        String firstName = scan.next();
        System.out.println("Enter last name : ");
        String lastName = scan.next();
        System.out.println("Enter id : ");
        int id = scan.nextInt();
        System.out.println("Enter sex : ");
        String sex = scan.next();
        System.out.println("Enter latitude : ");
        double latitude = scan.nextDouble();
        System.out.println("Enter longtitude : ");
        double longtitude = scan.nextDouble();
        Employee employee = new Employee(firstName, lastName, id, sex.charAt(0), latitude, longtitude);
        System.out.println("Successful add...");
    }

    public static void addHusbandOrWife(){
        Scanner scan = new Scanner(System.in);
        Employee employee = null;
        Sharif sharif = new Sharif();
        System.out.println("enter id you want to add husband or wife : ");
        int id = scan.nextInt();
        for (Employee e : sharif.getEmployees()) {
            if(e.getId() == id) {
                employee = e;
                break;
            }
        }
        if (employee != null) {
            System.out.println("Enter husband or wife id : ");
            employee.addWifeOrHusband(scan.nextInt());
        }
        else
            System.out.println("There is no one with this id. please firs add this employee.");


    }

    public static void isMarried(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter id : ");
        boolean married = Employee.isMarried(scan.nextInt());
        if (married)
            System.out.println("Yes it's married...");
        else
            System.out.println("No it's not married...");
    }

    public static void isInvited(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter id : ");
        boolean invited = Employee.isInvited(scan.nextInt());
        if (invited)
            System.out.println("Yes it's invited...");
        else
            System.out.println("No it's not invited...");
    }

    public static void showInvitedList(){
        Sharif sharif = new Sharif();
        int counter = 1;
        for (Employee employee : sharif.getInvitedList()) {
            System.out.println("number " + counter + " : \n");
            System.out.printf("First Name : %s \nLast Name : %s \nSex : %c \nDistance : %.2f KM\n%n",
                    employee.getFirstName(), employee.getLastName(), employee.getSex(), employee.getDistance());
            counter++;
        }
        if (counter == 1)
            System.out.println("Invited List Is Empty...");
    }

}
