package entities;

import com.opencsv.bean.CsvBindByName;

public class Employee {
    @CsvBindByName
    private Long id;
    @CsvBindByName
    private String firstName;
    @CsvBindByName
    private String lastName;
    @CsvBindByName
    private String telephone;
    @CsvBindByName
    private String address;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, String telephone, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(!(obj instanceof Employee)){
            return false;
        }

        Employee employee = (Employee) obj;
        return this.id.equals(employee.id) && this.firstName.equals(employee.firstName)
                && this.lastName.equals(employee.lastName) && this.address.equals(employee.address)
                && this.telephone.equals(employee.telephone);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
