package CopyFileBinary;

public class Main {
    public static void main(String[] args) {
        String source = "/Users/smeenguyen/Downloads/src.dmg";
        String destination = "/Users/smeenguyen/Downloads/EVKeyMac/src.dmg";
        BinaryCopy.copy(source, destination);
    }
}
