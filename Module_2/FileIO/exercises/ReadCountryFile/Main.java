package ReadCountryFile;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndParse readAndParse = new ReadAndParse();
        List<String> rawData = readAndParse.readFile("./data/countries.txt");
        System.out.printf(readAndParse.parse(rawData));
    }
}
