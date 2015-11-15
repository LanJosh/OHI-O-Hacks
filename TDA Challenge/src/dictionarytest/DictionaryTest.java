package dictionarytest;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DictionaryTest {
    public static void main(String[] args) {
        File file = new File("src/Files/dictionary.txt");
        Set<String> a = new HashSet<String>();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String next = sc.nextLine();
                if (next.length() > 0
                        && (next.charAt(0) == ',' || next.charAt(0) == '&')) {
                    a.add(next.substring(1));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(a.toString());
    }
}
