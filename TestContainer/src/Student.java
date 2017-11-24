//创建了一个学生的类,但是没用到.

public class Student {
    private String name;
    private int number;
    private int studentNum;
    private String sex;
    private int classNum;
    private int grate;
    private String major;
    private String colleage;
    private int year;
    private String status;

    public Student(String name, int number, int studentNum, String sex, int classNum, int grate, String major, String colleage, int year, String status) {
        this.name = name;
        this.number = number;
        this.studentNum = studentNum;
        this.sex = sex;
        this.classNum = classNum;
        this.grate = grate;
        this.major = major;
        this.colleage = colleage;
        this.year = year;
        this.status = status;
    }

    public void info(){
        System.out.println(this.name + " " + this.number);
    }
}