import java.util.*;

public class Solution {

    static class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    static Node root = new Node();

    static void insert(String s) {
        Node temp = root;

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';

            if (temp.child[x] == null) {
                temp.child[x] = new Node();
            }

            temp = temp.child[x];
        }

        temp.end = true;
    }

    static boolean search(String s) {
        Node temp = root;

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';

            if (temp.child[x] == null) {
                return false;
            }

            temp = temp.child[x];
        }

        return temp.end;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] words = sc.nextLine().split(",");

        for (int i = 0; i < n; i++) {
            insert(words[i]);
        }

        String s = sc.nextLine();

        System.out.println(search(s) ? 1 : 0);
    }
}
