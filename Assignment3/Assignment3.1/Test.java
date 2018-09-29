
public class Test {

    public static void main(String[] args) {
        Student Mike0 = new Student("Mike0", 1);
        Student Mike1 = new Student("Mike1", 1);
        Student Mike2 = new Student("Mike2", 1);
        Student Mike3 = new Student("Mike3", 1);
        Student Mike4 = new Student("Mike4", 1);
        Student Mike5 = new Student("Mike5", 1);
        Student Mike6 = new Student("Mike6", 1);
        Student Mike7 = new Student("Mike7", 1);
        Student Mike8 = new Student("Mike8", 1);
        Student Mike9 = new Student("Mike9", 1);
        //Number 11 Student
        Student Mike10 = new Student("Mike10", 1);

        Course program = new Course("program");
        program.registerStudent(Mike0);
        program.registerStudent(Mike1);
        program.registerStudent(Mike2);
        program.registerStudent(Mike3);
        program.registerStudent(Mike4);
        program.registerStudent(Mike5);
        program.registerStudent(Mike6);
        program.registerStudent(Mike7);
        program.registerStudent(Mike8);
        program.registerStudent(Mike9);
        program.registerStudent(Mike10); //This registeration should be rejected.
    }
}
