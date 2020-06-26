package Services;

import Dao.GenericDao;
import Model.CourseModel;

import java.util.List;
import java.util.Optional;

public class CourseService {

    private GenericDao<CourseModel> genericDao = new GenericDao<>();

    public void addCourse (CourseModel courseModel) {
        genericDao.add(courseModel);
    }

    public List<CourseModel> getCourses(CourseModel courseModel) {
        List<CourseModel> myCourses = genericDao.getAll(courseModel);
        return myCourses;
    }

    public Optional<CourseModel> findByIdOptional(CourseModel courseModel , int id){
        List<CourseModel> courseModels = genericDao.getAll(courseModel);
        return courseModels.stream().filter(courseModel1 -> courseModel1.getIdCourse() == id).findFirst();
    }

    public CourseModel findById(CourseModel courseModel, int id) {
        CourseModel courseModel1 = genericDao.findById(courseModel, id);
        return courseModel1;
    }

    public void updateCourse(CourseModel courseModel) {
        genericDao.update(courseModel);
    }

    public void deleteCourse(CourseModel courseModel) {
        genericDao.delete(courseModel);
    }


}
