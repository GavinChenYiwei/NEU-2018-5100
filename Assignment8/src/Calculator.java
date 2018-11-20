import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

enum operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}

public class Calculator extends JFrame {
    private JTextField resultTextField;
    private JButton add, subtract, multiply, divide, compute, clear;

    private JButton numbers[];
    private Font font;

    int num = 0;
    int result = 0;
    Stack<Integer> numberInput = new Stack<>();

    operation o = operation.ADD;

    class OperationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == add) {
                o = operation.ADD;
                numberInput.push(num);
            }
            if (e.getSource() == subtract) {
                o = operation.SUBTRACT;
                numberInput.push(num);
            }
            if (e.getSource() == multiply) {
                o = operation.MULTIPLY;
                numberInput.push(num);
            }
            if (e.getSource() == divide) {
                o = operation.DIVIDE;
                numberInput.push(num);
            }
            num = 0;
        }
    }

    class NumberInputListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == numbers[0]){
                num = num * 10 + 0;
            }
            if (e.getSource() == numbers[1]){
                num = num * 10 + 1;
            }
            if (e.getSource() == numbers[2]){
                num = num * 10 + 2;
            }
            if (e.getSource() == numbers[3]){
                num = num * 10 + 3;
            }
            if (e.getSource() == numbers[4]){
                num = num * 10 + 4;
            }
            if (e.getSource() == numbers[5]){
                num = num * 10 + 5;
            }
            if (e.getSource() == numbers[6]){
                num = num * 10 + 6;
            }
            if (e.getSource() == numbers[7]){
                num = num * 10 + 7;
            }
            if (e.getSource() == numbers[8]){
                num = num * 10 + 8;
            }
            if (e.getSource() == numbers[9]){
                num = num * 10 + 9;
            }
            resultTextField.setText(num + "");
        }
    }

    class ClearACListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            num = 0;
            numberInput.clear();
            result = 0;
            resultTextField.setText("");
        }
    }

    class ComputeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            numberInput.push(num);
            if (o == operation.ADD) {
                if(numberInput.isEmpty())
                    result = 0;
                else if (numberInput.size() == 1)
                    result = numberInput.peek();
                else{
                    int num = numberInput.pop();
                    result = numberInput.peek() + num;
                    numberInput.push(result);
                }
            }
            if (o == operation.SUBTRACT) {
                if(numberInput.isEmpty())
                    result = 0;
                else if (numberInput.size() == 1)
                    result = numberInput.peek();
                else{
                    int num = numberInput.pop();
                    result = numberInput.peek() - num;
                    numberInput.push(result);
                }
            }
            if (o == operation.DIVIDE) {
                if(numberInput.isEmpty())
                    result = 0;
                else if (numberInput.size() == 1)
                    result = numberInput.peek();
                else{
                    int num = numberInput.pop();
                    result = numberInput.peek() / num;
                    numberInput.push(result);
                }
            }
            if (o == operation.MULTIPLY) {
                if(numberInput.isEmpty())
                    result = 0;
                else if (numberInput.size() == 1)
                    result = numberInput.peek();
                else{
                    int num = numberInput.pop();
                    result = numberInput.peek() * num;
                    numberInput.push(result);
                }
            }
            num = 0;
            resultTextField.setText(result + "");

        }

    }

    public Calculator() {
        createComponents();
        setLayout();
        addComponents();
        addBehaviors();
        display();
    }

    private void addBehaviors() {
        ComputeListener cl = new ComputeListener();
        compute.addActionListener(cl);

        OperationListener ol = new OperationListener();
        add.addActionListener(ol);
        subtract.addActionListener(ol);
        multiply.addActionListener(ol);
        divide.addActionListener(ol);
        NumberInputListener nl = new NumberInputListener();
        for (int i = 0; i <=9 ; i++) {
            numbers[i].addActionListener(nl);
        }
        ClearACListener acl = new ClearACListener();
        clear.addActionListener(acl);
    }

    private void display() {
        setSize(600, 600);
        setVisible(true);

    }

    private void addComponents() {
        Container c = getContentPane();
        c.add(resultTextField);

        JPanel panel = new JPanel();
        panel.add(add);
        panel.add(subtract);
        panel.add(multiply);
        panel.add(divide);
        c.add(panel);

        panel = new JPanel();
        panel.add(compute);
        panel.add(clear);
        c.add(panel);

        JPanel p = new JPanel();
        p.add(numbers[1]);
        p.add(numbers[2]);
        p.add(numbers[3]);
        p.add(numbers[4]);

        c.add(p);

        p = new JPanel();
        p.add(numbers[5]);
        p.add(numbers[6]);
        p.add(numbers[7]);
        p.add(numbers[8]);

        c.add(p);

        p = new JPanel();
        p.add(numbers[9]);
        p.add(numbers[0]);

        c.add(p);

    }

    private void setLayout() {
        GridLayout gl = new GridLayout(6, 1);
        Container c = this.getContentPane();
        c.setLayout(gl);

    }

    private void createComponents() {
        font = new Font("TimesRoman", Font.PLAIN, 36);
        resultTextField = new JTextField(10);
        resultTextField.setFont(font);

        add = new JButton("+");
        add.setFont(font);
        subtract = new JButton("-");
        subtract.setFont(font);
        multiply = new JButton("x");
        multiply.setFont(font);
        divide = new JButton("%");
        divide.setFont(font);
        compute = new JButton("=");
        compute.setFont(font);
        clear = new JButton("AC");
        clear.setFont(font);

        numbers = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(i + "");
            numbers[i].setFont(font);
        }

    }

    public static void main(String[] args) {
        Calculator c = new Calculator();

    }
}
