package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Students")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CNP;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentModelList")
    private List<CourseModel> courseModelList;


    public int getCNP() {
        return CNP;
    }

    public void setCNP(int CNP) {
        this.CNP = CNP;
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

    public List<CourseModel> getCourseModelList() {
        return courseModelList;
    }

    public void setCourseModelList(List<CourseModel> courseModelList) {
        this.courseModelList = courseModelList;
    }
}
