import java.io.*;

public class demo {
    public static void main(String[] args) throws IOException {
        File des = new File("demo.txt");
        File target = new File("copy.txt");
        copyFileUsingStream(des,target);
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
