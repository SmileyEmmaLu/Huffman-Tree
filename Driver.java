import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner s = new Scanner(new File("word.txt"));
        String words = s.nextLine();

        HuffmanTree dog = new HuffmanTree(words);
        System.out.println(dog.getSize());
        System.out.println(dog.toString());


    }

}
