package Serialization;

import java.util.List;

public class UserAPIemployee {

    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
    public String programme;

    List<String> Courses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }


    // Sub element in Json
    public List getCourses(){
        return Courses;
    }

    public void setCourses(List<String> courses){
        this.Courses = courses;
    }


    public String getEmployeeRecord(){

        return (this.id + " " + this.firstName + " " + this.lastName + " " + this.email +" " + this.programme);
    }




}
