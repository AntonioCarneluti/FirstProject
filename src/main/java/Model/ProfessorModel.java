package Model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Professors")
public class ProfessorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CNP;

    private String firstName;
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "professorModelList")
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
