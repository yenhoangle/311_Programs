import java.io.*;
import java.util.*;

public class LexicalAnalyzer {

    public void readFile(String fileName) throws IOException {
        try {
            File testFile = new File(fileName);
            if (!testFile.exists()) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File Not Found");
        }

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

    }

    public static void main(String[] args) {
        // creating hash maps that act as symbol tables
        HashMap<String, Integer> keyWordMap = new HashMap<String, Integer>();
        HashMap<String, Integer> integerMap = new HashMap<String, Integer>();
        HashMap<String, Integer> digitMap = new HashMap<String, Integer>();
        HashMap<String, Integer> specialMap = new HashMap<String, Integer>();
        HashMap<String, Integer> characterMap = new HashMap<String, Integer>();
        //initializing keyword map
        keyWordMap.put("if", 0);
        keyWordMap.put("then", 0);
        keyWordMap.put("else", 0);
        keyWordMap.put("begin", 0);
        keyWordMap.put("end", 0);
        //init integer map
        //init digit map
        digitMap.put("0", 0);
        digitMap.put("1", 0);
        digitMap.put("2", 0);
        digitMap.put("3", 0);
        digitMap.put("4", 0);
        digitMap.put("5", 0);
        digitMap.put("6", 0);
        digitMap.put("7", 0);
        digitMap.put("8", 0);
        digitMap.put("9", 0);
        //init special character map
        //init character map

    }
}