import java.util.Scanner;

 class Camelcase {
    public static boolean isCamelCase(String str) {

        if (str.length() == 0 || !Character.isUpperCase(str.charAt(0)))
            return false;

        if (str.contains(" "))
            return false;

        for (int i = 1; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i)))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isCamelCase(input))
            System.out.println("The string is CamelCase.");
        else
            System.out.println("The string is NOT CamelCase.");

        sc.close();
    }
}

