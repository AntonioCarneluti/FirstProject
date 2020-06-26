package UI;

import Model.ClassModel;
import Model.ScheduleModel;
import Services.ClassService;
import Services.ScheduleService;

import java.util.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ScheduleUI {
    private ScheduleModel scheduleModel = new ScheduleModel();
    private ScheduleService scheduleService = new ScheduleService();
    private ClassModel classModel = new ClassModel();
    private ClassService classService = new ClassService();
    private ClassUI classUI = new ClassUI();
    Scanner scanner = new Scanner(System.in);

    public void startScheduleApp() {
        int option = -1;
        while (option != 0) {
            System.out.println("Welcome to Schedule Management!");
            System.out.println("-------------------------------");
            System.out.println("What are you looking for?");
            System.out.println("1.Add schedule.");
            System.out.println("2.View schedules.");
            System.out.println("3.Find specific schedule.");
            System.out.println("4.Update schedules");
            System.out.println("5.Delete schedule.");
            System.out.println("0.Back");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                addSchedule();
            } else if (option == 2) {
                viewSchedules();
            } else if (option == 3) {
                findSchedule();
            } else if (option == 4) {
                updateScheduleInfo();
            } else if (option == 5) {
                deleteSchedule();
            }
        }
    }


    private void addSchedule() {
        System.out.println("Enter schedule date");
        System.out.println("Date format is yyyy-MM-dd");
        String myDate = scanner.nextLine();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = (Date) dateFormat.parse(myDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        scheduleModel.setDate(date);

        System.out.println("Enter start hour:");
        System.out.println("Time format is hh:mm:ss");
        String startHour = scanner.nextLine();
        Time startTime = Time.valueOf(startHour);
        scheduleModel.setStartHour(startTime);

        System.out.println("Enter end hour:");
        System.out.println("Time format is hh:mm:ss");
        String endHour = scanner.nextLine();
        Time endTime = Time.valueOf(endHour);
        scheduleModel.setEndHour(endTime);

        System.out.println("Enter class");
        classUI.viewClasses();
        int id = scanner.nextInt();
        scanner.nextLine();
        Optional<ClassModel> classModelOptional = classService.findByIdOptional(classModel, id);
        if (!classModelOptional.isPresent()) {
            System.out.println("Class not found!");
        } else {
            ClassModel foundClass = classModelOptional.get();
            scheduleModel.setClassModel(foundClass);
            scheduleService.addSchedule(scheduleModel);
            System.out.println("***Schedule added***");
        }
    }

    public void viewSchedules() {
        List<ScheduleModel> scheduleModelList = scheduleService.getSchedules(scheduleModel);
        scheduleModelList.forEach(scheduleModel1 -> System.out.println("Id:" + scheduleModel1.getIdSchedule() + "\n"
                + scheduleModel1.getDate() + " " + scheduleModel1.getStartHour() + " " + scheduleModel1.getEndHour() + " class " + scheduleModel1.getClassModel().getName() + "\n***"));
    }

    //update Vineri >> la sout am adaugat si un schedulemodel.getclassModel.getName();
    private void findSchedule() {
        System.out.println("Enter schedule id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Optional<ScheduleModel> scheduleModelOptional = scheduleService.findByIdOptional(scheduleModel, id);
        if (!scheduleModelOptional.isPresent()) {
            System.out.println("Schedule not available!");
        } else {
            ScheduleModel scheduleModel = scheduleModelOptional.get();
            System.out.println("***");
            System.out.println("Found: " + scheduleModel.getIdSchedule() + "\n" + scheduleModel.getDate() + scheduleModel.getStartHour() + scheduleModel.getEndHour() + scheduleModel.getClassModel().getName());
            System.out.println("***");
        }
    }

    private void updateScheduleInfo() {
        viewSchedules();
        System.out.println("Enter Schedule Id for update:");
        int scheduleId = scanner.nextInt();
        scanner.nextLine();
        Optional<ScheduleModel> scheduleModelOptional = scheduleService.findByIdOptional(scheduleModel, scheduleId);
        if (!scheduleModelOptional.isPresent()) {
            System.out.println("Schedule not available!");
        } else {
            ScheduleModel scheduleModel = scheduleModelOptional.get();
            int update = -1;
            System.out.println("What do you want to update?");
            System.out.println("1.Date.");
            System.out.println("2.Start hour.");
            System.out.println("3.End hour.");
            update = scanner.nextInt();
            scanner.nextLine();
            if (update == 1) {
                System.out.println("Enter new Date:");
                System.out.println("Date format is yyyy-MM-dd");
                String myNewDate = scanner.nextLine();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                Date date = null;
                try {
                    date = (Date) dateFormat.parse(myNewDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                scheduleModel.setDate(date);
                scheduleService.updateSchedule(scheduleModel);
            } else if (update == 2) {
                System.out.println("Enter new Start hour:");
                System.out.println("Time format is hh:mm:ss");
                String newStartHour = scanner.nextLine();
                Time startTime = Time.valueOf(newStartHour);
                scheduleModel.setStartHour(startTime);
                scheduleService.updateSchedule(scheduleModel);
            } else if (update == 3) {
                System.out.println("Enter new End hour:");
                System.out.println("Time format is hh:mm:ss");
                String newEndHour = scanner.nextLine();
                Time startTime = Time.valueOf(newEndHour);
                scheduleModel.setStartHour(startTime);
                scheduleService.updateSchedule(scheduleModel);
            } else if (update == 4) {
                classUI.viewClasses();
                System.out.println("Enter new classId:");
                int classId = scanner.nextInt();
                scanner.nextLine();
                Optional<ClassModel> classModelOptional = classService.findByIdOptional(classModel, classId);
                if (!classModelOptional.isPresent()) {
                    System.out.println("Class not found!");
                } else {
                    ClassModel classModel1 = classModelOptional.get();
                    List<ScheduleModel> scheduleModelList = scheduleService.getSchedules(scheduleModel);
                    scheduleModel.setClassModel(classModel1);
                    scheduleModelList.add(scheduleModel);
                    classService.updateClasses(classModel1);
                    scheduleService.updateSchedule(scheduleModel);
                    System.out.println("***Updated***");
                }
            }
        }
    }

    private void deleteSchedule() {
        System.out.println("Enter schedule Id for delete:");
        int scheduleId = scanner.nextInt();
        scanner.nextLine();
        Optional<ScheduleModel> scheduleModelOptional = scheduleService.findByIdOptional(scheduleModel, scheduleId);
        if (!scheduleModelOptional.isPresent()) {
            System.out.println("Schedule not available!");
        } else {
            ScheduleModel scheduleModel = scheduleModelOptional.get();
            scheduleService.deleteSchedule(scheduleModel);
            System.out.println("***Deleted***");
        }
    }

}
