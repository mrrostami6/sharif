package SharifParty;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int id;
    private char sex;
    private double latitude;
    private double longtitude;
    private boolean married = false;
    private double distance;
    private Employee wifeOrHusband;

    public Employee(String firstName, String lastName, int id, char sex, double latitude, double longtitude) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.sex = sex;
        this.latitude = latitude;
        this.longtitude = longtitude;
        Sharif sharif = new Sharif();
        sharif.addEmployee(this);
        setDistance();
    }

    private void setDistance() {
        Sharif sharif = new Sharif();
        double distance;
        double latitude = Math.toRadians(this.getLatitude());
        double longtitude = Math.toRadians(this.getLongtitude());
        double sharifLatitude = Math.toRadians(sharif.getLATITUDE());
        double sharifLongtitude = Math.toRadians(sharif.getLONGTITUDE());

        double result = (Math.sin(latitude) * Math.sin(sharifLatitude));
        result += (Math.cos(latitude) * Math.cos(sharifLatitude)) * (Math.cos(sharifLongtitude - longtitude));
        distance = result * 6378.8;
        this.distance = distance;

    }

    public double getDistance() {
        return distance;
    }

    public static boolean isMarried(int id) {
        Sharif sharif = new Sharif();
        for (Employee employee : sharif.getEmployees()) {
            if (employee.getId() == id)
                return employee.married;
        }
        return false;
    }

    public static boolean isInvited(int id) {
        Sharif sharif = new Sharif();
        for (Employee e : sharif.getInvitedList()) {
            if (e.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addWifeOrHusband(int id) {
        Sharif sharif = new Sharif();
        boolean exist = false;
        for (Employee employee : sharif.getEmployees()) {
            if (employee.getId() == id) {
                this.setMarried(true);
                employee.setMarried(true);
                this.wifeOrHusband = employee;
                employee.setWifeOrHusband(this);
                System.out.println("successful add...");
                exist = true;
                if (this.distance < 30)
                    sharif.addInvited(this);
                break;
            }
        }
        if (!exist)
            System.out.println("There is no one with this id. Please first add this employee .");
    }

    private void setWifeOrHusband(Employee employee){
        this.wifeOrHusband = employee;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }
}
