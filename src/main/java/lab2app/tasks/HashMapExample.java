package lab2app.tasks;

import lab2app.models.Student;

import java.util.HashMap;

public class HashMapExample {
    public void manipulateHashMap() {
        HashMap<Long, Student> studentMap = new HashMap<>();

        // Добавление 100000000 объектов
        for (long i = 1; i <= 100000000; i++) {
            studentMap.put(i, new Student(i, "Student " + i));
        }

        // Время добавления элемента
        long startTime = System.nanoTime();
        studentMap.put(100000001L, new Student(100000001L, "Student 100000001"));
        long endTime = System.nanoTime();
        System.out.println("HashMap добавление: " + (endTime - startTime) + " нс");

        // Время взятия элемента по ключу
        startTime = System.nanoTime();
        Student student = studentMap.get(50000000L);
        endTime = System.nanoTime();
        System.out.println("HashMap взятие по ключу: " + (endTime - startTime) + " нс");

        // Время удаления элемента
        startTime = System.nanoTime();
        studentMap.remove(100000000L);
        endTime = System.nanoTime();
        System.out.println("HashMap удаление: " + (endTime - startTime) + " нс");
    }
}
