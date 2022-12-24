package CopyFile;

public class Main {
    public static void main(String[] args) {
        Copier copier = new Copier();
        boolean status = copier.copy("./data/src.zip","./data/dest.zip");
        System.out.println(status?"Success":"Failed");
    }
}
