
/**
 * Assignment for your lecture 2. Please finish all the questions under 'Assignment'
 * Please try to think the extra credit question. 
 * The deadline of this assignment is 09/21/2018 23:59 PST.
 * Please feel free to contact Amanda and Zane for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month

    // Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
    		//write your code here
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary= salary;

    }
    
    // Getter for `name`. Return the current `name` data
    public String getName() {
    		//write your code here
        return this.name;
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
    		//write your code here
        this.name = name;
    }

    public void raiseSalary(double byPercent){
        this.salary = this.salary * (1 + byPercent);
    }
}

enum Gender {
    MALE,
    FEMALE;
}


public class Assignment2 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public static double socialSecurityTax(Employee employee) {
        //write your code here
        double salary = employee.salary, SocialSecurityTaxRate = 0.062 , SocialSecurityTax = 0;
        if (salary >= 0 && salary <= 8900){
            SocialSecurityTax = SocialSecurityTaxRate * salary;
        }else if (salary > 8900){
            SocialSecurityTax = SocialSecurityTaxRate * 106800;
        }
        return SocialSecurityTax;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public static double insuranceCoverage(Employee employee) {
        //write your code here
        int age = employee.age;
        double salary = employee.salary, insuranceCoverage = 0;
        if (age < 35){
            insuranceCoverage = salary * 0.03;
        }else if (age >=35 && age <=50){
            insuranceCoverage = salary * 0.04;
        }else if (age > 50 && age < 60){
            insuranceCoverage = salary * 0.05;
        }else{
            insuranceCoverage = salary * 0.06;
        }
        return insuranceCoverage;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public static void sortSalary(Employee e1, Employee e2, Employee e3) {
        //write your code here
        String [] nameArray = {e1.name, e2.name, e3.name};
        double [] salaryArray = {e1.salary, e2.salary, e3.salary};
        for (int i = 0; i < salaryArray.length - 1; i++){
            for (int j = 0; j < salaryArray.length -1 - i; j++){
                if (salaryArray[j] > salaryArray[j+1]){
                    swap(salaryArray,j, j+1);
                    swap(nameArray, j, j+1);
                }
            }
        }
        System.out.println(nameArray[0] + " " + nameArray[1] + " " + nameArray[2]);;
    }

    public static void swap(String [] arr, int i , int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(double [] arr, int i , int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public static void tripleSalary(Employee employee) {
        //        //write your code here
        employee.salary = employee.salary * 3;
        System.out.println(employee.salary);
    }


    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        //Employee c = new Employee("Sandy", 30, Gender.MALE, 500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
        //System.out.println(socialSecurityTax(a));
        //System.out.println(insuranceCoverage(a));
        //sortSalary(a, b, c);
        //tripleSalary(a);
        //a.raiseSalary(0.8);
        //System.out.println(a.salary);
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
    /* Java uses only call by value. It creates a copy of references and passes them as valuable to the methods. */
}
