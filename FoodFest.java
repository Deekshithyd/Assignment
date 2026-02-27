import java.util.*;

public class FoodFest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> stalls = new ArrayList<>();
        Vector<String> dishes = new Vector<>();
        Queue<String> customers = new LinkedList<>();
        Stack<String> visitedStalls = new Stack<>();
        LinkedList<String> history = new LinkedList<>();

        int choice;

        do{
            System.out.println("\n MAGICAL FOOD FESTIVAL");
            System.out.println("1. Add Food Stalls");
            System.out.println("2. Chef Update Dishes");
            System.out.println("3. Customers Join Queue");
            System.out.println("4. Serve Customer");
            System.out.println("5. Track Last Visited Stall");
            System.out.println("6. Show Daily History");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    System.out.print("How many stalls: ");
                    int s = sc.nextInt();
                    sc.nextLine();

                    for(int i=1;i<=s;i++){
                        System.out.print("Enter stall name: ");
                        stalls.add(sc.nextLine());
                    }
                    break;

                case 2:
                    System.out.print("How many dishes: ");
                    int d = sc.nextInt();
                    sc.nextLine();

                    for(int i=1;i<=d;i++){
                        System.out.print("Enter dish: ");
                        dishes.add(sc.nextLine());
                    }
                    break;

                case 3:
                    System.out.print("How many customers: ");
                    int c = sc.nextInt();
                    sc.nextLine();

                    for(int i=1;i<=c;i++){
                        System.out.print("Enter customer: ");
                        customers.add(sc.nextLine());
                    }
                    break;

                case 4:
                    if(!customers.isEmpty()){

                        String cust = customers.poll();

                        System.out.print(
                          cust + " visited stall: "
                        );
                        String stallName = sc.nextLine();

                        visitedStalls.push(stallName);
                        history.add(cust);

                        System.out.println("Served Successfully");
                    }
                    else{
                        System.out.println("No customers");
                    }
                    break;

                case 5:
                    if(!visitedStalls.isEmpty()){
                        System.out.println(
                          "Last Visited Stall: "
                          + visitedStalls.peek()
                        );
                    }
                    else{
                        System.out.println("No visit data");
                    }
                    break;

                case 6:
                    System.out.println("Customer History:");
                    for(String h : history){
                        System.out.println(h);
                    }
                    break;

                case 7:
                    System.out.println("Festival Closed");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        }while(choice != 7);

        sc.close();
    }
}

