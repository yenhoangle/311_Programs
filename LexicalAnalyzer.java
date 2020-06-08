import java.io.*;
import java.util.*;
import java.net.URL;

public class LexicalAnalyzer {
    public static void main(String[] args) {
        // creating hash maps that act as symbol tables
        HashMap<String, Integer> keywordMap = new HashMap<String, Integer>();
        HashMap<String, Integer> operatorMap = new HashMap<String, Integer>();
        HashMap<String, Integer> separatorMap = new HashMap<String, Integer>();
        HashMap<String, Integer> digitMap = new HashMap<String, Integer>();
        HashMap<String, Integer> characterMap = new HashMap<String, Integer>();

        // initializing keyword map
        keywordMap.put("if", 0);
        keywordMap.put("then", 0);
        keywordMap.put("else", 0);
        keywordMap.put("for", 0);
        keywordMap.put("while", 0);
        keywordMap.put("begin", 0);
        keywordMap.put("end", 0);

        // init operator map
        operatorMap.put("+", 0);
        operatorMap.put("-", 0);
        operatorMap.put("/", 0);
        operatorMap.put("*", 0);
        operatorMap.put("=", 0);
        operatorMap.put("<", 0);
        operatorMap.put(">", 0);
        operatorMap.put("!=", 0);
        operatorMap.put("<=", 0);
        operatorMap.put(">=", 0);

        // init separator map
        separatorMap.put("(", 0);
        separatorMap.put(")", 0);
        separatorMap.put("[", 0);
        separatorMap.put("]", 0);
        separatorMap.put("{", 0);
        separatorMap.put("}", 0);
        separatorMap.put("|", 0);
        separatorMap.put(";", 0);

        // init digit map
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

        // init alphabet character map
        characterMap.put("a", 0);
        characterMap.put("b", 0);
        characterMap.put("c", 0);
        characterMap.put("d", 0);
        characterMap.put("e", 0);
        characterMap.put("f", 0);
        characterMap.put("g", 0);
        characterMap.put("h", 0);
        characterMap.put("i", 0);
        characterMap.put("j", 0);
        characterMap.put("k", 0);
        characterMap.put("l", 0);
        characterMap.put("m", 0);
        characterMap.put("n", 0);
        characterMap.put("o", 0);
        characterMap.put("p", 0);
        characterMap.put("q", 0);
        characterMap.put("r", 0);
        characterMap.put("s", 0);
        characterMap.put("t", 0);
        characterMap.put("u", 0);
        characterMap.put("v", 0);
        characterMap.put("x", 0);
        characterMap.put("y", 0);
        characterMap.put("z", 0);

        //counters
        int keywordCount = 0;
        int operatorCount = 0;
        int separatorCount = 0;
        int digitCount = 0;
        int characterCount = 0;

        URL path = LexicalAnalyzer.class.getResource("input.txt");
        String fileName = path.getFile();
        
        //TODO: prompt for file?

        try {
            File testFile = new File(fileName);
            if (!testFile.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while((currentLine = bufferedReader.readLine()) != null) {
                //making an array of items separated by space delimiter
                String lineArr[] = currentLine.split(" ");
                for (int i = 0; i < lineArr.length; i++) {
                    String key = lineArr[i];
                    if (keywordMap.containsKey(key)) {
                        int val = keywordMap.get(key);
                        keywordMap.put(key, val + 1); //increase token count
                        keywordCount++; //increase overall keyword count
                    }
                    else if (operatorMap.containsKey(key)) {
                        int val = operatorMap.get(key);
                        operatorMap.put(key, val + 1); //increase token count
                        operatorCount++; //increase overall operator count
                    }
                    else if (separatorMap.containsKey(key)) {
                        int val = separatorMap.get(key);
                        separatorMap.put(key, val + 1); //increase token count
                        separatorCount++; //increase overall separator count
                    }
                    else if (digitMap.containsKey(key)) {
                        int val = digitMap.get(key);
                        digitMap.put(key, val + 1); //increase token count
                        digitCount++; //increase overall digit count
                    }
                    else if (characterMap.containsKey(key)) {
                        int val = characterMap.get(key);
                        characterMap.put(key, val + 1); //increase token count
                        characterCount++; //increase overall character count
                    }
                }

            }
            bufferedReader.close(); //to prevent memory leak
            fileReader.close();


        } catch (FileNotFoundException fnf) {
            System.out.println("File Not Found Exception");
        } catch (IOException ioe) {
            System.out.println("IO Exception");
        }

        //printing the results of lexical analysis
        System.out.println("Keywords:");
        for (String key : keywordMap.keySet()) {
            int val = keywordMap.get(key);
            if (val != 0) {
                System.out.println(key + " : " + val);
            }
        }
        System.out.println("-----------------");
        System.out.println("Total numbers of keywords: " + keywordCount);

        System.out.println("Operators: ");
        for (String key : operatorMap.keySet()) {
            int val = operatorMap.get(key);
            if (val != 0) {
                System.out.println(key + " : " + val);
            }
        }
        System.out.println("-----------------");
        System.out.println("Total numbers of operators: " + operatorCount);

        System.out.println("Separators:");
        for (String key : separatorMap.keySet()) {
            int val = separatorMap.get(key);
            if (val != 0) {
                System.out.println(key + " : " + val);
            }
        }
        System.out.println("-----------------");
        System.out.println("Total numbers of separators: " + separatorCount);

        System.out.println("Digits:");
        for (String key : digitMap.keySet()) {
            int val = digitMap.get(key);
            if (val != 0) {
                System.out.println(key + " : " + val);
            }
        }
        System.out.println("-----------------");
        System.out.println("Total numbers of digits: " + digitCount);

        System.out.println("Characters:");
        for (String key : characterMap.keySet()) {
            int val = characterMap.get(key);
            if (val != 0) {
                System.out.println(key + " : " + val);
            }
        }
        System.out.println("-----------------");
        System.out.println("Total numbers of characters: " + characterCount);

    }
}