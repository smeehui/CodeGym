package ReadAndFindMax;

public class Main {
    public static void main(String[] args) {
        ReaderAndWriter readerAndWriter = new ReaderAndWriter();
        GetMaxValue getMaxValue = new GetMaxValue();
        readerAndWriter.readFile("./data/ints.txt");
        int max = getMaxValue.getMaxValue(readerAndWriter.getIntegerList());
        readerAndWriter.writeToFile("./data/result.txt","Giá trị lớn nhất là: "+max);
    }
}
