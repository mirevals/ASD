package lab2app.tasks;

import lab2app.models.Student;

import java.util.ArrayList;

public class ArrayListExample {

    public void manipulateArrayList() {
        ArrayList<Student> studentList = new ArrayList<>();

        // Добавление 100000000 объектов
        for (long i = 1; i <= 100000000; i++) {
            studentList.add(new Student(i, "Student " + i));
        }

        // Время добавления элемента в конец
        long startTime = System.nanoTime();
        studentList.add(new Student(100000001L, "Student 100000001"));
        long endTime = System.nanoTime();
        System.out.println("ArrayList добавление в конец: " + (endTime - startTime) + " нс");

        // Время добавления элемента в начало
        startTime = System.nanoTime();
        studentList.add(0, new Student(100000001L, "Student 100000001"));
        endTime = System.nanoTime();
        System.out.println("ArrayList добавление в начало: " + (endTime - startTime) + " нс");

        // Время удаления последнего элемента
        startTime = System.nanoTime();
        studentList.remove(studentList.size() - 1);
        endTime = System.nanoTime();
        System.out.println("ArrayList удаление последнего: " + (endTime - startTime) + " нс");

        // Время удаления первого элемента
        startTime = System.nanoTime();
        studentList.remove(0);
        endTime = System.nanoTime();
        System.out.println("ArrayList удаление первого: " + (endTime - startTime) + " нс");

        // Время взятия центрального элемента
        startTime = System.nanoTime();
        Student middleStudent = studentList.get(50000000);
        endTime = System.nanoTime();
        System.out.println("ArrayList взятие центрального: " + (endTime - startTime) + " нс");

        // Время взятия последнего элемента
        startTime = System.nanoTime();
        Student lastStudent = studentList.get(studentList.size() - 1);
        endTime = System.nanoTime();
        System.out.println("ArrayList взятие последнего: " + (endTime - startTime) + " нс");
    }
}