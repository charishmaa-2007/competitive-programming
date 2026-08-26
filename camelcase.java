import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] words = sc.nextLine().split(",");
        String pattern = sc.nextLine();

        ArrayList<String> result = new ArrayList<>();

        for (String word : words) {
            StringBuilder abbr = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (Character.isUpperCase(c)) {
                    abbr.append(c);
                }
            }

            if (abbr.toString().startsWith(pattern)) {
                result.add(word);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No match found");
        } else {
            Collections.sort(result);
            
            for (String word : result) {
                System.out.println(word);
            }
        }
    }
}
