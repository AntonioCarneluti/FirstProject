package UI;

import java.util.Scanner;

public class ProjectManagementUI {
    private ClassUI classUI = new ClassUI();
    private  CourseUI courseUI = new CourseUI();
    private ProfessorUI professorUI = new ProfessorUI();
    private ScheduleUI scheduleUI = new ScheduleUI();
    private StudentUI studentUI = new StudentUI();
    Scanner scanner = new Scanner(System.in);

    public void runProject(){
        int option = -1;
        while (option != 0){
            System.out.println("*****************************");
            System.out.println("Welcome to our University!");
            System.out.println("*****************************");
            try {
                System.out.print("Loading");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.println(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("What are you looking for?");
            System.out.println("-----------------------");
            System.out.println("1.Students.");
            System.out.println("2.Professors.");
            System.out.println("3.Classes.");
            System.out.println("4.Courses.");
            System.out.println("5.Schedules.");
            System.out.println("0.Exit.");

            option = scanner.nextInt();
            scanner.nextLine();

            if (option ==1){
                studentUI.startStudentApp();
            }
            else if (option ==2){
                professorUI.startProfessorApp();
            }
            else if (option ==3){
                classUI.startClassApp();
            }
            else if (option ==4){
                courseUI.startCourseApp();
            }
            else if (option ==5){
                scheduleUI.startScheduleApp();
            }
        }
    }
}
