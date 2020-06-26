package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCourse;
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_students", catalog = "firstproject",
            joinColumns = {
                    @JoinColumn(name = "idCourse", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "CNP", nullable = false, updatable = false)
            }
    )
    private List<StudentModel> studentModelList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_professors", catalog = "firstproject",
            joinColumns = {
                    @JoinColumn(name = "idCourse", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "CNP", nullable = false, updatable = false)
            }
    )
    private List<ProfessorModel> professorModelList;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_schedules", catalog = "firstproject",
            joinColumns = {
                    @JoinColumn(name = "idCourse", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "idSchedule", nullable = false, updatable = false)
            }
    )
    private List<ScheduleModel> scheduleModelList;


    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentModel> getStudentModelList() {
        return studentModelList;
    }

    public void setStudentModelList(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }

    public List<ProfessorModel> getProfessorModelList() {
        return professorModelList;
    }

    public void setProfessorModelList(List<ProfessorModel> professorModelList) {
        this.professorModelList = professorModelList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ScheduleModel> getScheduleModelList() {
        return scheduleModelList;
    }

    public void setScheduleModelList(List<ScheduleModel> scheduleModelList) {
        this.scheduleModelList = scheduleModelList;
    }
}
