import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {
    public static void main(String[] args) {
        File file = new File("Origin.dat");
        File copy = new File("Copy.dat");

        try {
            copyFile(file, copy);
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void copyFile(File file, File copy) throws Exception {
        if (!file.exists()) {
            throw new Exception("File not found");
        }

        if (copy.exists()) {
            throw new Exception("File already exists");
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(copy);

        int byteCount = 0;

        while (fileInputStream.read() != -1) {
            fileOutputStream.write(fileInputStream.read());
            byteCount++;
        }

        System.out.println("Copy complete!");
        System.out.println("File size: " + byteCount + " bytes");
    }
}
