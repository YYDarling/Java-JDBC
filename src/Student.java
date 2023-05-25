/**
 * @title: Student
 * @Auther: Yun
 * @Date: 5/25/23 15:10
 * @Version 1.0
 */

public class Student {
    Integer sid;
    String name_s;
    String sex;

    public Student(Integer sid, String name_s, String sex) {
        this.sid = sid;
        this.name_s = name_s;
        this.sex = sex;
    }

    public void say(){
        System.out.println("Name："+name_s+", Student_ID："+sid+", Sex："+sex);
    }
}
