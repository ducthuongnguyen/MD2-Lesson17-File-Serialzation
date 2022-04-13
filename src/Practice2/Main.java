package Practice2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Thuong", "HD"));
        studentList.add(new Student(5, "Kien", "HN"));
        studentList.add(new Student(2, "Phong", "HN"));
        studentList.add(new Student(4, "Manh", "Ha Nam"));
        writeToObject("students.txt", studentList);
        List<Student> studentData = readData("students.txt");
//        System.out.println(studentData);
        for (Student std: studentData
             ) {
            System.out.println(std);
        }
    }

    public static void writeToObject(String path, List<Student> studentList) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(studentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readData(String path) {
        List<Student> students = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            students = (List<Student>) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
