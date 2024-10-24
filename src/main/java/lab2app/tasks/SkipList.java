package lab2app.tasks;

import lab2app.dataStructures.SkipNode;
import lab2app.models.Student;

import java.util.Random;

public class SkipList {
    private static final double PROBABILITY = 0.5; // Вероятность увеличения уровня
    private final SkipNode header; // Заголовок списка
    private final int maxLevel; // Максимальный уровень
    private int currentLevel; // Текущий уровень
    private final Random random; // Генератор случайных чисел

    public SkipList(int maxLevel) {
        this.maxLevel = maxLevel;
        this.currentLevel = 0;
        this.header = new SkipNode(maxLevel, null); // Заголовок списка
        this.random = new Random();
    }

    // Метод для вставки элемента
    public void insert(Student student) {
        SkipNode[] update = new SkipNode[maxLevel + 1]; // Массив для обновления ссылок
        SkipNode current = header;

        // Поиск места для вставки
        for (int i = currentLevel; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].student.getId() < student.getId()) {
                current = current.forward[i];
            }
            update[i] = current; // Сохраняем текущий узел для обновления
        }

        current = current.forward[0]; // Переходим на следующий уровень

        // Если элемент не найден, добавляем его
        if (current == null || !current.student.getId().equals(student.getId())) {
            int newLevel = randomLevel(); // Получаем случайный уровень для нового узла
            if (newLevel > currentLevel) {
                for (int i = currentLevel + 1; i <= newLevel; i++) {
                    update[i] = header; // Обновляем заголовок для нового уровня
                }
                currentLevel = newLevel; // Увеличиваем уровень
            }

            // Создание нового узла и обновление ссылок
            SkipNode newNode = new SkipNode(newLevel, student);
            for (int i = 0; i <= newLevel; i++) {
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }
    }

    // Метод для поиска элемента
    public Student search(Long id) {
        SkipNode current = header;

        // Поиск элемента в списке
        for (int i = currentLevel; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].student.getId() < id) {
                current = current.forward[i];
            }
        }

        current = current.forward[0]; // Переходим на следующий уровень
        return (current != null && current.student.getId().equals(id)) ? current.student : null; // Проверяем, найден ли элемент
    }

    // Метод для удаления элемента
    public boolean delete(Long id) {
        SkipNode[] update = new SkipNode[maxLevel + 1];
        SkipNode current = header;

        // Поиск элемента для удаления
        for (int i = currentLevel; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].student.getId() < id) {
                current = current.forward[i];
            }
            update[i] = current; // Сохраняем текущий узел для обновления
        }

        current = current.forward[0]; // Переходим на следующий уровень

        // Если элемент найден, удаляем его
        if (current != null && current.student.getId().equals(id)) {
            for (int i = 0; i <= currentLevel; i++) {
                if (update[i].forward[i] != current) break;
                update[i].forward[i] = current.forward[i]; // Обновляем ссылки
            }

            // Уменьшаем уровень, если необходимо
            while (currentLevel > 0 && header.forward[currentLevel] == null) {
                currentLevel--;
            }
            return true; // Удаление успешно
        }
        return false; // Элемент не найден
    }

    // Метод для получения случайного уровня
    private int randomLevel() {
        int level = 0;
        while (level < maxLevel && random.nextDouble() < PROBABILITY) {
            level++;
        }
        return level;
    }
}