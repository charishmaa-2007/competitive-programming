import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int seen = 0;
        int duplicates = 0;
        int printed = 0;

        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');

            if ((seen & bit) != 0) {
                duplicates |= bit;
            } else {
                seen |= bit;
            }
        }


        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');

            if ((duplicates & bit) != 0 && (printed & bit) == 0) {
                System.out.print(c + " ");
                printed |= bit;
            }
        }

        if (duplicates == 0) {
            System.out.print("No duplicates");
        }
    }
}
