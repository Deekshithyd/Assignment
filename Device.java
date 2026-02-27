import java.util.*;

public class Device {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter S1 (0/1): ");
        int s1 = sc.nextInt();

        System.out.print("Enter S2 (0/1): ");
        int s2 = sc.nextInt();

        int result = s1 + s2;

        switch(result){

            case 0:
                System.out.println("Light is ON");
                break;

            case 1:
                if(s1 == 0)
                    System.out.println("Fan is ON");
                else
                    System.out.println("Motor is ON");
                break;

            case 2:
                System.out.println("All Devices OFF");
                break;

            default:
                System.out.println("Invalid Input");
        }
    }
}

