package CopyFile;

import java.util.List;

public class Copier {
    private final FileIO file = new FileIO();
    public boolean copy(String src, String dest) {
        try {
            List<String> source = file.readFile(src);
            file.writeFile(dest, source);
            return true;
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra");
            return false;
        }
    }
}
