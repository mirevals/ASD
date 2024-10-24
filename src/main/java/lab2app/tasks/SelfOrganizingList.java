package lab2app.tasks;

import lab2app.models.Student;

import java.util.LinkedList;

public class SelfOrganizingList {
    private LinkedList<Student> list;

    public SelfOrganizingList() {
        list = new LinkedList<>();
    }

    // Метод для добавления студента
    public void add(Student student) {
        list.add(student);
    }

    // Метод для поиска студента
    public Student search(Long id) {
        for (Student student : list) {
            if (student.getId().equals(id)) {
                // Переместить найденный элемент в начало списка
                list.remove(student);
                list.addFirst(student);
                return student;
            }
        }
        return null; // Студент не найден
    }

    // Метод для удаления студента
    public boolean delete(Long id) {
        for (Student student : list) {
            if (student.getId().equals(id)) {
                list.remove(student);
                return true; // Удаление успешно
            }
        }
        return false; // Студент не найден
    }

    // Метод для получения списка студентов
    public LinkedList<Student> getList() {
        return list;
    }
}
