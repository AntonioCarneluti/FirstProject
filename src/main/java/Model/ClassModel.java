package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Classes")
public class ClassModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClass;
    private String name;

    @OneToMany
    private List<ScheduleModel> scheduleModelList;

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ScheduleModel> getScheduleModelList() {
        return scheduleModelList;
    }

    public void setScheduleModelList(List<ScheduleModel> scheduleModelList) {
        this.scheduleModelList = scheduleModelList;
    }
}
