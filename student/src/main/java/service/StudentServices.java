package service;


import model.Course;
import model.Student;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServices {

    private static final List<Student> students= new ArrayList<>();
    private final SecureRandom random = new SecureRandom();

    static {
        //Initialize Data
        Course courseOne = new Course("Course1", "Spring", "10 Steps",
                List.of("Learn Maven", "Import Project", "First Example", "Second Example"));

        Course courseTwo = new Course("Course2", "Spring MVC", "10 Examples",
                List.of("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course courseThree = new Course("Course3", "Spring Boot", "6K Students",
                List.of("Learn Maven", "Learn Spring",
                        "Learn Spring MVC", "First Example", "Second Example"));
        Course courseFour = new Course("Course4", "Maven", "Most popular maven course on internet!",
                List.of("Pom.xml", "Build Life Cycle", "Parent POM", "Importing into Eclipse"));

        Student ranga = new Student("Student1", "Ranga Karanam", "Hiker, Programmer and Architect",
                new ArrayList<>(List.of(courseOne, courseTwo, courseThree, courseFour)));

        Student satish = new Student("Student2", "Satish T", "Hiker, Programmer and Architect",
                new ArrayList<>(List.of(courseOne, courseTwo, courseThree, courseFour)));

        students.add(ranga);
        students.add(satish);
    }

    public List<Student> retriveAllStudents(){
        return students;
    }

    public Student retriveStudent(String studentId){

        for(Student student:students){
            if(student.getId().equals(studentId)){
                return student;
            }
        }
        return null;
    }

    public List<Course> retriveCourses(String studentId){
        Student student= retriveStudent(studentId);
        if(studentId.equalsIgnoreCase("Student1")){
            throw  new RuntimeException("something went wrong");
        }
        return  student==null? null: student.getCourses();

    }

    public Course retriveCourse(String studentId, String courseId){

        Student student= retriveStudent(studentId);
        if(student==null){
            return null;
        }

        for(Course course : student.getCourses()){
            if(course.getId().equals(courseId)){
                return  course;
            }
        }
        return null;
    }

    public Course addCourse(String studentId, Course course){
        Student student= retriveStudent(studentId);

        if (student==null){
            return  null;
        }
        String randomId = new BigInteger(130, random).toString(32);
        course.setId(randomId);

        student.getCourses().add(course);
        return course;
    }



}
