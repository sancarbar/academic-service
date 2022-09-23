import com.model.Course;
import com.model.Professor;
import com.model.Student;
import com.service.AcademicService;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AcademicService academicService = new AcademicService();

        int option = showOptionsMenuAndCaptureOption();
        while (option != 8) {

            switch (option) {
                case 1: {
                    registerNewProfessor(academicService);
                    break;
                }
                case 2: {
                    registerNewCourse(academicService);
                    break;
                }
                case 3: {
                    registerNewStudent(academicService);
                    break;
                }
                case 4: {
                    enrollStudentToCourse(academicService);
                    break;
                }
                case 5: {
                    findAProfessor(academicService);
                    break;
                }
                case 6: {
                    System.out.println("Selected option 6");
                    break;
                }
                case 7: {
                    System.out.println("Selected option 7");
                    break;
                }
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student id: ");
        String studentId = scanner.nextLine();
        Optional<Student> studentById = academicService.findStudentById(studentId);
        if (studentById.isPresent()) {
            Student student = studentById.get();
            System.out.println("Enter the course name: ");
            String courseName = scanner.nextLine();
            Optional<Course> courseByName = academicService.findCourseByName(courseName);
            if (courseByName.isPresent()) {
                Course course = courseByName.get();
                student.enrollToCourse(course);
                System.out.println("Student enrollment successful");
            } else {
                System.out.println("Course with name: " + courseByName + " not found");
            }
        } else {
            System.out.println("Student with id: " + studentId + " not found");
        }
    }

    private static void registerNewStudent(AcademicService academicService) {
        //TODO implement this method
    }

    private static void registerNewCourse(AcademicService academicService) {
        //TODO implement this method
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