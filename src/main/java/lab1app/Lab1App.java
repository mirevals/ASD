package lab1app;

import lab1app.tasks.PrimeNumbersFinder;
import lab1app.tasks.BinaryArrayProcessor;
import lab1app.tasks.CamelCaseSplitter;
import lab1app.tasks.PalindromeChecker;
import lab1app.tasks.BinarySearch;

public class Lab1App {
    public static void main(String[] args) {
        System.out.println("Привет, меня зовут Регина. Я учу Java в группе ИУ3-31Б. Это мой проект lab1-app!");

        // Группа А № 1: Проверка палиндрома
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        System.out.println("Является ли 'madam' палиндромом? " + palindromeChecker.isPalindrome("madam"));

        // Группа В № 1: Нахождение N первых простых чисел
        PrimeNumbersFinder primeNumbersFinder = new PrimeNumbersFinder();
        System.out.println("Первые 10 простых чисел: " + primeNumbersFinder.findPrimeNumbers(10));

        // Группа В № 2: Обработка двоичного массива
        BinaryArrayProcessor binaryArrayProcessor = new BinaryArrayProcessor();
        int[] biArr = {1, 1, 0};
        boolean[] result = binaryArrayProcessor.isDivisibleByN(biArr, 6);
        System.out.print("Результаты деления массива на 6: ");
        for (boolean res : result) {
            System.out.print(res + " ");
        }

        // Группа В № 3: Разделение camelCase строки
        CamelCaseSplitter camelCaseSplitter = new CamelCaseSplitter();
        System.out.println("\nРазделение CamelCase: " + camelCaseSplitter.splitCamelCase("camelCaseExample"));

        // Основное задание: Бинарный поиск
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Бинарный поиск (итеративно) для 4: " + binarySearch.binarySearchIterative(sortedArray, 4));
        System.out.println("Бинарный поиск (рекурсивно) для 4: " + binarySearch.binarySearchRecursive(sortedArray, 4, 0, sortedArray.length - 1));
    }
}