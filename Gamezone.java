import java.util.*;

class Wallet {
    private int balance;

    void addMoney(int amt) {
        balance += amt;
    }

    void deductMoney(int amt) {
        balance -= amt;
    }

    int getBalance() {
        return balance;
    }
}

abstract class Game {

    abstract int credits();

    void start(Scanner sc) {
        System.out.print("Press 1 to START the game: ");
        if (sc.nextInt() == 1)
            System.out.println("Game Started...");
        else
            System.out.println("Game not started.");
    }

    void stop(Scanner sc) {
        while (true) {

            System.out.print("Press 0 to STOP the game: ");
            int btn = sc.nextInt();

            if (btn == 0) {
                System.out.println("Game Stopped...");
                break;
            } else {
                System.out.println("Game still running...");
            }
        }
    }
}
class Racing extends Game {
    int credits() { return 40; }
}

class Shooting extends Game {
    int credits() { return 60; }
}

class VRAdventure extends Game {
    int credits() { return 100; }
}

public class Gamezone{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Wallet w = new Wallet();
        Game g = null;

        // Wallet money
        System.out.print("Add Money to Wallet: ");
        int money = sc.nextInt();
        w.addMoney(money);

        System.out.println("\nWallet Balance: " + w.getBalance());

        int choice;

        // 🎮 MENU LOOP (No invalid message)
        while (true) {

            System.out.println("\n===== GAME MENU =====");
            System.out.println("1. Racing       (40 credits)");
            System.out.println("2. Shooting     (60 credits)");
            System.out.println("3. VR Adventure (100 credits)");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1) {
                g = new Racing();
                break;
            }
            else if (choice == 2) {
                g = new Shooting();
                break;
            }
            else if (choice == 3) {
                g = new VRAdventure();
                break;
            }
            // No invalid message — just repeat
        }

        int cost = g.credits();
        System.out.println("Credits Required: " + cost);

        // Low balance check
        if (w.getBalance() < cost) {
            System.out.println("Low Balance! Cannot start the game.");
            return;
        }

        w.deductMoney(cost);

        g.start(sc);
        g.stop(sc);

        System.out.println("Remaining Balance: " + w.getBalance());

        sc.close();
    }
}
