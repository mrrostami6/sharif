package SharifParty;

import java.util.ArrayList;

public class Sharif {
    private static final double LATITUDE = 35.7036;
    private static final double LONGTITUDE = 51.3515;
    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final ArrayList<Employee> invitedList = new ArrayList<>();

    public double getLATITUDE() {
        return LATITUDE;
    }

    public double getLONGTITUDE() {
        return LONGTITUDE;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void addInvited(Employee employee){
        invitedList.add(employee);
    }

    public ArrayList<Employee> getInvitedList() {
        return invitedList;
    }
}
