import java.util.Scanner;

class stringclass{
 public static void main(String args[]){
     Scanner s = new Scanner(System.in);
     System.out.println("Enter college name");
     String colname = s.nextLine();
     System.out.println("Enter name");
     String name = s.nextLine();
     System.out.println("Enter rollno");
     int rollno = s.nextInt();
     System.out.println("Enter cgpa");
     float score = s.nextFloat();
     System.out.println("Enter semester");
     byte sem = s.nextByte();
     System.out.println("Enter Gender");
     char gender = s.next().charAt(0);
     System.out.println("rollno="+rollno);
     System.out.println("sem="+sem);
     System.out.println("Student name = "+name);
     System.out.println("college name="+colname);
     System.out.println("score="+score);
     s.close();
 }
}
