package lab2app.tasks;

import lab2app.models.Student;

import java.util.LinkedList;

public class LinkedListExample {

    public void manipulateLinkedList() {
        LinkedList<Student> studentList = new LinkedList<>();

        // Добавление 100000000 объектов
        for (long i = 1; i <= 100000000; i++) {
            studentList.add(new Student(i, "Student " + i));
        }

        // Время добавления элемента в конец
        long startTime = System.nanoTime();
        studentList.add(new Student(100000001L, "Student 100000001"));
        long endTime = System.nanoTime();
        System.out.println("LinkedList добавление в конец: " + (endTime - startTime) + " нс");

        // Время добавления элемента в начало
        startTime = System.nanoTime();
        studentList.addFirst(new Student(100000001L, "Student 100000001"));
        endTime = System.nanoTime();
        System.out.println("LinkedList добавление в начало: " + (endTime - startTime) + " нс");

        // Время удаления последнего элемента
        startTime = System.nanoTime();
        studentList.removeLast();
        endTime = System.nanoTime();
        System.out.println("LinkedList удаление последнего: " + (endTime - startTime) + " нс");

        // Время удаления первого элемента
        startTime = System.nanoTime();
        studentList.removeFirst();
        endTime = System.nanoTime();
        System.out.println("LinkedList удаление первого: " + (endTime - startTime) + " нс");

        // Время взятия центрального элемента
        startTime = System.nanoTime();
        Student middleStudent = studentList.get(50000000);
        endTime = System.nanoTime();
        System.out.println("LinkedList взятие центрального: " + (endTime - startTime) + " нс");

        // Время взятия последнего элемента
        startTime = System.nanoTime();
        Student lastStudent = studentList.getLast();
        endTime = System.nanoTime();
        System.out.println("LinkedList взятие последнего: " + (endTime - startTime) + " нс");
    }
}
