package Services;

import Dao.GenericDao;
import Model.StudentModel;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private GenericDao<StudentModel> genericDao = new GenericDao<>();

    public void addStudent(StudentModel studentModel) {
        genericDao.add(studentModel);
    }

    public List<StudentModel> getStudents(StudentModel studentModel) {
        List<StudentModel> myStudents = genericDao.getAll(studentModel);
        return myStudents;
    }

    public Optional<StudentModel> findByIdOptional(StudentModel studentModel , int id){
        List<StudentModel> studentModels = genericDao.getAll(studentModel);
        return studentModels.stream().filter(studentModel1 -> studentModel1.getCNP() == id).findFirst();
    }


    public StudentModel findById(StudentModel studentModel, int id) {
        StudentModel studentModel1 = genericDao.findById(studentModel, id);
        return studentModel1;
    }

    public void updateStudent(StudentModel studentModel) {
        genericDao.update(studentModel);
    }

    public void deleteStudent(StudentModel studentModel) {
        genericDao.delete(studentModel);
    }


}
