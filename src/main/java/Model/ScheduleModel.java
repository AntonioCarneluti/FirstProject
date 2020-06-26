package Model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Schedules")
public class ScheduleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchedule;
    private Date date;
    private Time startHour;
    private Time endHour;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "scheduleModelList")
    private List<CourseModel> courseModelList;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassModel classModel;

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public Time getEndHour() {
        return endHour;
    }

    public void setEndHour(Time endHour) {
        this.endHour = endHour;
    }

    public List<CourseModel> getCourseModelList() {
        return courseModelList;
    }

    public void setCourseModelList(List<CourseModel> courseModelList) {
        this.courseModelList = courseModelList;
    }

    public ClassModel getClassModel() {
        return classModel;
    }

    public void setClassModel(ClassModel classModel) {
        this.classModel = classModel;
    }


}
