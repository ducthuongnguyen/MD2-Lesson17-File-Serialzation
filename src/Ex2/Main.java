package Ex2;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        String sourcePath="G:\\Code gym\\Module 2\\Lesson 17\\src\\Ex2\\source.txt";
        String destPath ="G:\\Code gym\\Module 2\\Lesson 17\\src\\Ex2\\dest.txt";
        try {
            copyFileUsingStream(new File(sourcePath), new File(destPath));
            System.out.println("Copy file successful!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

private static void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
         is = new FileInputStream(source);
         os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer))>0){
            os.write(buffer,0,length);
        }
    }
    finally {
        is.close();
        os.close();
    }
}

}
