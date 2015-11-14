import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class formatter {
    public static void main(String[] args) {
        String text = "";
        try {
            File file = new File("JobsData.txt");
            Scanner sc = new Scanner(file);
            if (sc.hasNext()){
                text = sc.next();
            }
            text.replaceAll("[^a-zA-Z0-9]+","");
            System.out.print(text);
        } catch (FileNotFoundException ex) {
            System.out.println("Fuck");
        }
   }
}
