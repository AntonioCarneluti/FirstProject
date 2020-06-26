package Services;

import Dao.GenericDao;
import Model.ClassModel;

import java.util.List;
import java.util.Optional;

public class ClassService {
    private GenericDao<ClassModel> genericDao = new GenericDao<>();

    public void addClass(ClassModel classModel) {
        genericDao.add(classModel);
    }

    public List<ClassModel> getClasses(ClassModel classModel) {
        List<ClassModel> myClasses = genericDao.getAll(classModel);
        return myClasses;
    }

    public Optional<ClassModel> findByIdOptional(ClassModel classModel, int id) {
        List<ClassModel> classModels = genericDao.getAll(classModel);
        return classModels.stream().filter(classModel1 -> classModel1.getIdClass() == id).findFirst();
    }

    public ClassModel findById(ClassModel classModel, int id) {
        ClassModel classModel1 = genericDao.findById(classModel, id);
        return classModel1;
    }

    public void updateClasses(ClassModel classModel) {
        genericDao.update(classModel);
    }

    public void deleteClasses(ClassModel classModel) {
        genericDao.delete(classModel);
    }


}
