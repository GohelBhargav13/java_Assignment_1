package Programming_assignment;

import java.util.Scanner;

class Student {
    int studentID;
    String name;

    Student(int studentID, String name) {
        this.name = name;
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getname() {
        return name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "StudentId: " + studentID
                + "\nName: " + name;
    }
}

class Grade {
    int studentID, courseID, score = 0;
    char grade;

    public Grade(int studentID, int courseID, char grade) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getCourse() {
        return courseID;
    }

    public char getgrade() {
        return grade;
    }
}

class GradingSystem {
    Student students[] = new Student[100];
    Grade grades[] = new Grade[100];
    int courseCreadits[];
    int studentCounts, gradecount, score = 0;

    public void addstudent(Student student) {
        if (studentCounts < students.length) {
            students[studentCounts++] = student;

            System.out.println("Student Added");
        } else {
            System.out.println("Student list are full");
        }
    }

    double calculateGPA(int studentID) {
        int totalPoints = 0;
        int totalCredits = 0;
        for (int i = 0; i < gradecount; i++) {
            if (grades[i].getStudentID() == studentID) {
                int courseID = grades[i].getCourse();
                char grade = grades[i].getgrade();
                int points = gradetopoint(grade);
                int credits = courseCreadits[courseID];
                totalPoints += points * credits;
                totalCredits += credits;
            }
        }
        if (totalCredits == 0)
            return 0.0;
        return (double) totalPoints / totalCredits;
    }

    void addGrade(Grade grade) {
        if (gradecount < grades.length) {
            grades[gradecount++] = grade;
        } else {
            System.out.println("Grade List are full");
        }
    }

    void addCourseCredits(int courseID, int credits) {
        if (courseID < courseCreadits.length) {
            courseCreadits[courseID] = credits;
        } else {
            System.out.println("Please Enter Valid I'D");
        }
    }

    public int gradetopoint(char grade) {
        if (grade == 'A') {
            return 100;

        }
        if (grade == 'B') {
            return 90;
        }
        if (grade == 'C') {
            return 80;
        }
        if (grade == 'D') {
            return 70;
        }

        return 'F';
    }

    public void display() {
        for (int i = 0; i < studentCounts; i++) {
            System.out.println(students[i]);
        }
    }

    void printGradeReport(int studentID) {
        System.out.println("Grade Report for Student ID: " + studentID);
        for (int i = 0; i < gradecount; i++) {
            if (grades[i].getStudentID() == studentID) {
                System.out.println(grades[i]);
            }
        }
        System.out.println("GPA: " + calculateGPA(studentID));
    }

}

public class GradingSystemMGTM {
    public static void main(String[] args) {

        int stid, ch, coID;
        char grade;
        String Name;
        double gpa;

        Scanner scan = new Scanner(System.in);
        GradingSystem gs = new GradingSystem();

        do {

            System.out.println("--Student Course System--");
            System.out.println("\n1. Add new student");
            System.out.println("2. Add grade for student");
            System.out.println("3. Add course credits");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Print grade report");
            System.out.println("6. Exit");

            System.out.println("Enter Your Choice: ");
            ch = scan.nextInt();
            scan.nextLine();

            switch (ch) {
                case 1:
                    System.out.println("Enter Student ID: ");
                    stid = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Enter Your name: ");
                    Name = scan.nextLine();

                    Student s = new Student(stid, Name);
                    gs.addstudent(s);
                    break;
                case 2:
                    System.out.println("Enter Your StudentID : ");
                    stid = scan.nextInt();

                    System.out.println("Enter Your CourseID: ");
                    coID = scan.nextInt();
                    // scan.nextLine();

                    System.out.println("Enter Your grade: ");
                    grade = scan.next().charAt(0);

                    Grade gg = new Grade(stid, coID, grade);
                    gs.addGrade(gg);

                case 4:
                    System.out.print("Enter Student ID: ");
                    stid = scan.nextInt();
                    gpa = gs.calculateGPA(stid);
                    System.out.println("GPA for Student ID " + stid + ": " + gpa);
                    break;
                case 5:
                    System.out.print("Enter Student ID: ");
                    stid = scan.nextInt();
                    gs.printGradeReport(stid);
                    break;
                case 6:
                    System.out.println("Exited.....");
                    System.exit(0);
                    break;

                default:
                    break;
            }

        } while (ch>=1 && ch<=6);

    }
}
