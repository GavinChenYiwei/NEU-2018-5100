import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class StudentsApplication extends JFrame {
    private JTable studentsTable;
    private Label roll, first, last, gender;
    private JTextField rollField, firstField, lastField;
    private JList<String> genderList;
    private JButton add;
    private Font font;
    private String[] genderArray = {"true", "false"};
    static Students s;

    public StudentsApplication(Students students) {
        StudentsTableModel model = new StudentsTableModel(students);
        studentsTable = new JTable(model);
        JScrollPane jsp = new JScrollPane(studentsTable);

        Container con = getContentPane();


        //Create Components
        font = new Font("TimesRoman", Font.PLAIN, 18);
        rollField = new JTextField(3);
        rollField.setFont(font);
        firstField = new JTextField(10);
        firstField.setFont(font);
        lastField = new JTextField(10);
        lastField.setFont(font);

        roll = new Label("ID: ");
        roll.setFont(font);
        first = new Label("firstname: ");
        first.setFont(font);
        last = new Label("lastname: ");
        last.setFont(font);
        gender = new Label("gender: ");
        gender.setFont(font);

        genderList = new JList<>(genderArray);

        add = new JButton("add");
        add.setFont(font);

        // Set Layout and add Components
        jsp.setBorder(BorderFactory.createTitledBorder("Student List"));

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Add Student Information"));
        con.setLayout(new BoxLayout(con,BoxLayout.Y_AXIS));
        con.add(jsp);
        con.add(panel);
        panel.add(roll);
        panel.add(rollField);
        panel.add(first);
        panel.add(firstField);
        panel.add(last);
        panel.add(lastField);
        panel.add(gender);
        panel.add(genderList);
        panel.add(add);

        // add behavior
        AddListener al = new AddListener();
        add.addActionListener(al);


        setSize(400, 400);
        setVisible(true);
    }

    class AddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String roll = rollField.getText();
            String firstname = firstField.getText();
            String lastname = lastField.getText();
            boolean gender = genderList.getSelectedIndex() == 0 ? true : false;
            s.addStudent(new Student(Integer.valueOf(roll),firstname,lastname,gender));
            studentsTable.updateUI();
        }
    }

    public static void main(String[] args) {
        s = new Students();
        s.addStudent(new Student(100, "Divya", "Sharma", true));
        s.addStudent(new Student(101, "Mihir", "Salunke", false));
        new StudentsApplication(s);

    }

}

class Students {
    private Collection<Student> students = new ArrayList<Student>();

    public Collection<Student> getStudents() {
        return students;

    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public int getNumberOfStudents() {
        return getStudents().size();
    }

}

class Student {
    int roll;
    String first;
    String last;
    boolean gender = false;

    public Student(int roll, String first, String last, boolean gender) {
        this.roll = roll;
        this.first = first;
        this.last = last;
        this.gender = gender;
    }
}

class StudentsTableModel implements TableModel {

    private Students students;

    public StudentsTableModel(Students students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.getNumberOfStudents();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ROLL";
        }
        if (columnIndex == 1) {
            return "First";
        }
        if (columnIndex == 2)
            return "Last";
        if (columnIndex == 3)
            return "Gender";
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return Boolean.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Collection<Student> s = students.getStudents();
        int row = -1;
        for (Student student : s) {
            row++;
            if (row == rowIndex) {
                if (columnIndex == 0) {
                    return student.roll + "";
                }
                if (columnIndex == 1) {
                    return student.first;
                }
                if (columnIndex == 2) {
                    return student.last;
                }
                if (columnIndex == 3) {
                    return student.gender;
                }
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

}
