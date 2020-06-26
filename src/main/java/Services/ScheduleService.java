package Services;

import Dao.GenericDao;
import Model.ScheduleModel;

import java.util.List;
import java.util.Optional;

public class ScheduleService {
    private GenericDao<ScheduleModel> genericDao = new GenericDao<>();

    public void addSchedule(ScheduleModel scheduleModel) {
        genericDao.add(scheduleModel);
    }

    public List<ScheduleModel> getSchedules(ScheduleModel scheduleModel) {
        List<ScheduleModel> mySchedules = genericDao.getAll(scheduleModel);
        return mySchedules;
    }

    public Optional<ScheduleModel> findByIdOptional(ScheduleModel scheduleModel, int id) {
        List<ScheduleModel> scheduleModels = genericDao.getAll(scheduleModel);
        return scheduleModels.stream().filter(scheduleModel1 -> scheduleModel1.getIdSchedule() == id).findFirst();
    }

    public ScheduleModel findById(ScheduleModel scheduleModel, int id) {
        ScheduleModel scheduleModel1 = genericDao.findById(scheduleModel, id);
        return scheduleModel1;
    }

    public void updateSchedule(ScheduleModel scheduleModel) {
        genericDao.update(scheduleModel);
    }

    public void deleteSchedule(ScheduleModel scheduleModel) {
        genericDao.delete(scheduleModel);
    }
}
