package lab2app.dataStructures;

import lab2app.models.Student;

public class SkipNode {
    public Student student; // Значение узла
    public SkipNode[] forward; // Ссылки на следующий уровень

    public SkipNode(int level, Student student) {
        this.student = student;
        this.forward = new SkipNode[level + 1]; // Массив ссылок
    }
}