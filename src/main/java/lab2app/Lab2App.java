package lab2app;

import lab2app.models.Student;
import lab2app.tasks.*;

import java.util.*;

public class Lab2App {
    public static void main(String[] args) {
        final int NUM_STUDENTS = 100_000;
        List<Student> arrayList = new ArrayList<>();
        List<Student> linkedList = new LinkedList<>();
        HashSet<Student> hashSet = new HashSet<>();
        HashMap<Long, Student> hashMap = new HashMap<>();

        // Создание студентов и добавление в коллекции
        for (long i = 1; i <= NUM_STUDENTS; i++) {
            Student student = new Student(i, "Student " + i);
            arrayList.add(student);
            linkedList.add(student);
            hashSet.add(student);
            hashMap.put(student.getId(), student);
        }

        // Измерение времени добавления элемента в конец
        long startTime = System.nanoTime();
        arrayList.add(new Student(100_001L, "New Student"));
        long endTime = System.nanoTime();
        System.out.println("ArrayList добавление в конец: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.add(0, new Student(100_001L, "New Student"));
        endTime = System.nanoTime();
        System.out.println("LinkedList добавление в начало: " + (endTime - startTime) + " ns");

        // Измерение времени удаления последнего элемента
        startTime = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        endTime = System.nanoTime();
        System.out.println("ArrayList удаление последнего: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.remove(linkedList.size() - 1);
        endTime = System.nanoTime();
        System.out.println("LinkedList удаление последнего: " + (endTime - startTime) + " ns");

        // Измерение времени удаления первого элемента
        startTime = System.nanoTime();
        arrayList.remove(0);
        endTime = System.nanoTime();
        System.out.println("ArrayList удаление первого: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedList.remove(0);
        endTime = System.nanoTime();
        System.out.println("LinkedList удаление первого: " + (endTime - startTime) + " ns");

        // Взятие центрального элемента
        startTime = System.nanoTime();
        Student middleStudent = arrayList.get(50_000 - 1); // Индекс 50_000
        endTime = System.nanoTime();
        System.out.println("ArrayList получение центрального: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        Student lastStudent = arrayList.get(arrayList.size() - 1);
        endTime = System.nanoTime();
        System.out.println("ArrayList получение последнего: " + (endTime - startTime) + " ns");

        ////////////////////////////////////////////////////////
        SkipList skipList = new SkipList(4); // Создаем список с максимальным уровнем 4

        // Добавление студентов
        for (long i = 1; i <= 10; i++) {
            skipList.insert(new Student(i, "Student " + i));
        }

        // Поиск студента
        System.out.println("Поиск студента с ID 5:");
        Student studentInSkipList = skipList.search(5L); // Изменено имя переменной
        if (studentInSkipList != null) {
            System.out.println("Найден: " + studentInSkipList.getName());
        } else {
            System.out.println("Студент не найден.");
        }

        // Удаление студента
        System.out.println("\nУдаление студента с ID 3:");
        boolean isDeletedFromSkipList = skipList.delete(3L);
        System.out.println(isDeletedFromSkipList ? "Студент удален." : "Студент не найден.");

        // Поиск удаленного студента
        System.out.println("Поиск студента с ID 3:");
        Student studentDeletedFromSkipList = skipList.search(3L); // Изменено имя переменной
        if (studentDeletedFromSkipList != null) {
            System.out.println("Найден: " + studentDeletedFromSkipList.getName());
        } else {
            System.out.println("Студент не найден.");
        }

        /////////////////////////////////////////////////////////
        SelfOrganizingList sol = new SelfOrganizingList();

        // Добавление студентов
        for (long i = 1; i <= 10; i++) {
            sol.add(new Student(i, "Student " + i));
        }

        // Поиск студента
        System.out.println("Поиск студента с ID 5:");
        Student studentInSOL = sol.search(5L); // Изменено имя переменной
        if (studentInSOL != null) {
            System.out.println("Найден: " + studentInSOL.getName());
        } else {
            System.out.println("Студент не найден.");
        }

        // Вывод списка студентов
        System.out.println("\nСписок студентов после поиска:");
        for (Student student : sol.getList()) {
            System.out.println(student.getName());
        }

        // Удаление студента
        System.out.println("\nУдаление студента с ID 3:");
        boolean isDeletedFromSOL = sol.delete(3L);
        System.out.println(isDeletedFromSOL ? "Студент удален." : "Студент не найден.");

        // Вывод списка студентов после удаления
        System.out.println("\nСписок студентов после удаления:");
        for (Student student : sol.getList()) {
            System.out.println(student.getName());
        }
    }
}