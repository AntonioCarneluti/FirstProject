package UI;

import Model.ClassModel;
import Services.ClassService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClassUI {
    private ClassModel classModel = new ClassModel();
    private ClassService classService = new ClassService();
    Scanner scanner = new Scanner(System.in);
    public void startClassApp(){
        int option = -1 ;
        while (option != 0){
            System.out.println("Welcome to Classes Management!");
            System.out.println("-------------------------------");
            System.out.println("What are you looking for?");
            System.out.println("1.Add class.");
            System.out.println("2.View classes.");
            System.out.println("3.Find specific classes.");
            System.out.println("4.Update classes");
            System.out.println("5.Delete class.");
            System.out.println("0.Back");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1){
                addClass();
            }
            else if (option == 2){
                viewClasses();
            }
            else if (option ==3){
                findClass();
            }
            else if (option == 4){
                updateClassInfo();
            }
            else if (option == 5){
                deleteClass();
            }
        }
    }


    private void addClass() {
        System.out.println("Enter class name");
        String name = scanner.nextLine();
        classModel.setName(name);
        classService.addClass(classModel);
        System.out.println("***Class added***");
    }

    public void viewClasses() {
        List<ClassModel> classModelList = classService.getClasses(classModel);
        classModelList.forEach(classmodel1 -> System.out.println("Class Id: " + classmodel1.getIdClass() + "\n"
                + classmodel1.getName() + "\n******"));
    }


    private void findClass() {
        System.out.println("Enter class id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Optional<ClassModel> classModelOptional = classService.findByIdOptional(classModel , id);
        if (!classModelOptional.isPresent()) {
            System.out.println("Class unavailable!");
        } else {
            ClassModel classModel1 = classModelOptional.get();
            System.out.println("*****");
            System.out.println("Found: " + classModel1.getIdClass() + "\n" + classModel1.getName());
            System.out.println("*****");
        }
    }

    private void updateClassInfo() {
        viewClasses();
        System.out.println("Enter class id for update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Optional<ClassModel> optionalClassModel = classService.findByIdOptional(classModel, id);
        if (!optionalClassModel.isPresent()){
            System.out.println("Incorrect id!");
        }
        else{
            ClassModel classModel = optionalClassModel.get();
            System.out.println("Enter new class name");
            String newName = scanner.nextLine();
            classModel.setName(newName);
            classService.updateClasses(classModel);
        }
    }
    private void deleteClass() {
        viewClasses();
        System.out.println("Enter class id for delete:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Optional<ClassModel> optionalClassModel = classService.findByIdOptional(classModel, id);
        if (!optionalClassModel.isPresent()){
            System.out.println("Incorrect id!");
        }
        else{
            ClassModel classModel = optionalClassModel.get();
            classService.deleteClasses(classModel);
            System.out.println("***Class Deleted***");
        }

    }



}
