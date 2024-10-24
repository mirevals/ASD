package lab2app.tasks;

import lab2app.models.Student;

import java.util.HashSet;

public class HashSetExample {
    public void manipulateHashSet() {
        HashSet<Student> studentSet = new HashSet<>();

        // Добавление 100000000 объектов
        for (long i = 1; i <= 100000000; i++) {
            studentSet.add(new Student(i, "Student " + i));
        }

        // Время добавления элемента (для HashSet, добавление не имеет значения)
        long startTime = System.nanoTime();
        studentSet.add(new Student(100000001L, "Student 100000001"));
        long endTime = System.nanoTime();
        System.out.println("HashSet добавление: " + (endTime - startTime) + " нс");

        // Время проверки наличия элемента
        startTime = System.nanoTime();
        boolean contains = studentSet.contains(new Student(100000001L, "Student 100000001"));
        endTime = System.nanoTime();
        System.out.println("HashSet проверка наличия: " + (endTime - startTime) + " нс");
    }
}
