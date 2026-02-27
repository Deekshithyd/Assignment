/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deekshith
 */
class student
{
    int rollno, sem;
    String name, address;
    void getdata(int r, int s, String n, String a)
    {
        rollno = r;
        sem = s;
        name = n;
        address = a;
    }
    void putdata()
    {
        System.out.println(rollno+"\t"+name+"\t"+sem+"\t"+address);
    }
}
public class StudentDemo {
    public static void main(String args[])
    {
        student s1 = new student();
        student s2 = new student();
        s1.getdata(111,7,"abc","bangalore");
        s2.getdata(222,7,"xyz","Mangalore");
        s1.putdata();
        s2.putdata();
    }
}
