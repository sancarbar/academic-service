import com.model.Professor;
import com.service.AcademicService;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AcademicService academicService = new AcademicService();

        int option = showOptionsMenuAndCaptureOption();
        while (option != 8) {

            switch (option) {
                case 1 -> registerNewProfessor(academicService);
                case 2 -> registerNewCourse(academicService);
                case 3 -> registerNewStudent(academicService);
                case 4 -> enrollStudentToCourse(academicService);
                case 5 -> findAProfessor(academicService);
                case 6 -> System.out.println("Selected option 6");
                case 7 -> System.out.println("Selected option 7");
            }
            option = showOptionsMenuAndCaptureOption();
        }
    }

    private static void findAProfessor(AcademicService academicService) {
        System.out.println("Enter the id: ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        Optional<Professor> professorOptional = academicService.findProfessorById(id);
        if (professorOptional.isPresent()) {
            System.out.println(professorOptional.get());
        } else {
            System.out.println("Professor with id: " + id + " not found");
        }
    }

    private static void enrollStudentToCourse(AcademicService academicService) {

    }

    private static void registerNewStudent(AcademicService academicService) {

    }

    private static void registerNewCourse(AcademicService academicService) {

    }

    private static void registerNewProfessor(AcademicService academicService) {
        //String id, String name, String email, String phoneNumber
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id: ");
        String id = scanner.nextLine();
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        Professor professor = new Professor(id, name, email, phoneNumber);
        academicService.addProfessor(professor);
    }


    private static int showOptionsMenuAndCaptureOption() {
        System.out.println("*----------------------------------------------*");
        System.out.println("| Please select one of the following options:  |");
        System.out.println("| 1. Register a new Professor                  |");
        System.out.println("| 2. Register a new Course                     |");
        System.out.println("| 3. Register a new Student                    |");
        System.out.println("| 4. Enroll Student to Course                  |");
        System.out.println("| 5. Find  a  Professor                        |");
        System.out.println("| 6. Find  a  Student                          |");
        System.out.println("| 7. Find  a  Course                           |");
        System.out.println("| 8. Exit                                      |");
        System.out.println("*----------------------------------------------*");
        Scanner scanner = new Scanner(System.in);
        int option = 8;
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 8) {
                System.out.println("| The Option selected is not valid. Please try again |");
                showOptionsMenuAndCaptureOption();
            }
        } catch (Exception e) {
            System.out.println("| The Option selected is not valid. Please try again |");
            showOptionsMenuAndCaptureOption();
        }
        return option;
    }
}