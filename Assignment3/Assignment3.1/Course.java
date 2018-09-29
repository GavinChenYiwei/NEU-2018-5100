import java.sql.SQLOutput;
import java.util.ArrayList;

public class Course {
    private String name;
    private int numberOfStudent;
    private ArrayList<Student> registeredStudents = new ArrayList<>();
    private int maxStudents = 10;

    public Course(String name){
        this.name = name;
    }

    public ArrayList<Student> getStudents(){
        return this.registeredStudents;
    }

    public boolean isFull(){
        if (registeredStudents.size() < 10)
            return false;
        else
            return true;
    }

    public int getNumberOfStudent(){
        return this.numberOfStudent;
    }

    public String getName(){
        return this.name;
    }

    public void registerStudent(Student student){
        if (this.isFull()) {
            System.out.println("Registed Failed");
            throw new RuntimeException("The course is full");
        }else if(registeredStudents.contains(student)){
            System.out.println("Registed Failed");
            throw new RuntimeException("You have already registed this course");
        }
        else {
            registeredStudents.add(student);
            System.out.println("Registed Success");
            return;
        }
    }

}
