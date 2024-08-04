import java.util.*;

class student {
    private int studentID, Age;
    private String name, department;

    public student(int studentID, int Age,String name, String department) {
        this.studentID = studentID;
        this.Age = Age;
        this.name = name;
        this.department = department;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getname() {
        return name;
    }

    public int getAge() {
        return Age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "\tstudentID: " +studentID + "\tName: " + name + " Age: " + Age + " Department: " + department;
    }

}

class StudentRecordSystem {

    Scanner obj = new Scanner(System.in);
    student[] students = new student[100];
    int count = 0;

   public void addstudent(student student) {
        if (count < students.length) {
            students[count++] = student;
    
            System.out.println("Student added");
        } else {
            System.out.println("Student records full");
        }

    }

    public student getstudent(int studentID)
    {
            for (int i = 0; i < count; i++) {
                if (students[i].getStudentID() == studentID) {
                    return students[i];
                }
            }
            return null;
    }

    public void display() {
        for (int j = 0; j < count; j++) {
            System.out.println(students[j]);
        }

    }

}

public class StudentRecordMGMT {

    public static void main(String[] args) {

        int ch,ag;
        String Name, de;
        int sid = 0;

        Scanner obj = new Scanner(System.in);
        StudentRecordSystem ss = new StudentRecordSystem();

        do {

            System.out.println("--Student Record System--");
            System.out.println("1. Add Student");
            System.out.println("2.view Student");
            System.out.println("3.Search for student");

            System.out.println("Enter your chooice: ");
            ch = obj.nextInt();
            obj.nextLine();

            switch (ch) {
                case 1:
                    System.out.println("Enter your Name: ");
                    Name = obj.nextLine();
                    
                    System.out.println("Enter your department: ");
                    de = obj.nextLine();

                    System.out.println("Enter your StudentId: ");
                    sid = obj.nextInt();

                    System.out.println("Enter your Age: ");
                    ag = obj.nextInt();
                    obj.nextLine();

                    student s = new student(sid, ag, Name, de);
                    ss.addstudent(s);
                    break;
                case 2:
                    ss.display();
                    break;
                case 3:
                    System.out.println("Enter Search id: ");
                    sid = obj.nextInt();
                    student s1 = ss.getstudent(sid);
                    if (s1 != null) {
                        System.out.println("Student found"+s1);
                    }
                    else
                    {
                        System.out.println("Not found");
                    }
                    break;    
                default:
                    break;
            }
        } while (ch >= 1 && ch <= 2);

        
    }
}
 
