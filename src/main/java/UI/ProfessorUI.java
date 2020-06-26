package UI;

import Model.ProfessorModel;
import Services.ProfessorService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProfessorUI {

    private ProfessorModel professorModel = new ProfessorModel();
    private ProfessorService professorService = new ProfessorService();
    Scanner scanner = new Scanner(System.in);

    public void startProfessorApp() {
        int option = -1;
        while (option != 0) {
            System.out.println("Welcome to Professors Management!");
            System.out.println("-------------------------------");
            System.out.println("What are you looking for?");
            System.out.println("1.Add professor.");
            System.out.println("2.View professor.");
            System.out.println("3.Find specific professor.");
            System.out.println("4.Update professors");
            System.out.println("5.Delete professor.");
            System.out.println("0.Back");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                addProfessor();
            } else if (option == 2) {
                viewProfessors();
            } else if (option == 3) {
                findProfessor();
            } else if (option == 4) {
                updateProfessorInfo();
            } else if (option == 5) {
                deleteProfessor();
            }
        }
    }

    private void addProfessor() {
        System.out.println("First name:");
        String firstName = scanner.nextLine();
        System.out.println("Last name:");
        String lastName = scanner.nextLine();
        professorModel.setFirstName(firstName);
        professorModel.setLastName(lastName);
        professorService.addProfessor(professorModel);
        System.out.println("***Professor added***");
    }

    public void viewProfessors() {
        List<ProfessorModel> professorModelList = professorService.getProfessors(professorModel);
        professorModelList.forEach(professorModel1 -> System.out.println("CNP: " + professorModel1.getCNP() + "\n"
                + professorModel1.getFirstName() + " " + professorModel1.getLastName() + "\n******"));
    }


    private void findProfessor() {
        System.out.println("Enter professor's CNP:");
        int cnp = scanner.nextInt();
        scanner.nextLine();
        Optional<ProfessorModel> optionalProfessorModel = professorService.findByIdOptional(professorModel, cnp);
        if (!optionalProfessorModel.isPresent()) {
            System.out.println("Professor missing!");
        } else {
            ProfessorModel professorModel = optionalProfessorModel.get();
            System.out.println("*****");
            System.out.println("Found: " + professorModel.getCNP() + "\n" + professorModel.getFirstName() + " " + professorModel.getLastName());
            System.out.println("*****");
        }
    }


    private void updateProfessorInfo() {
        viewProfessors();
        System.out.println("Enter professor's CNP for update:");
        int cnp = scanner.nextInt();
        scanner.nextLine();
        Optional<ProfessorModel> optionalProfessorModel = professorService.findByIdOptional(professorModel, cnp);
        if (!optionalProfessorModel.isPresent()) {
            System.out.println("Incorrect CNP!");
        } else {
            ProfessorModel professorModel = optionalProfessorModel.get();
            int update = -1;
            System.out.println("What do you want to update?");
            System.out.println("1.First name.");
            System.out.println("2.Last name.");
            update = scanner.nextInt();
            scanner.nextLine();
            if (update == 1) {
                System.out.println("Enter new first name:");
                String newFirst = scanner.nextLine();
                professorModel.setFirstName(newFirst);
                professorService.updateProfessor(professorModel);
            } else if (update == 2) {
                System.out.println("Enter new last name:");
                String newLast = scanner.nextLine();
                professorModel.setLastName(newLast);
                professorService.updateProfessor(professorModel);
            }
        }
    }

    private void deleteProfessor() {
        viewProfessors();
        System.out.println("Enter CNP for delete:");
        int cnp = scanner.nextInt();
        scanner.nextLine();
        Optional<ProfessorModel> optionalProfessorModel = professorService.findByIdOptional(professorModel, cnp);
        if (!optionalProfessorModel.isPresent()) {
            System.out.println("Incorrect CNP!");
        } else {
            ProfessorModel professorModel = optionalProfessorModel.get();
            professorModel.setCNP(cnp);
            professorService.deleteProfessor(professorModel);
            System.out.println("***Professor Deleted***");
        }
    }

}
