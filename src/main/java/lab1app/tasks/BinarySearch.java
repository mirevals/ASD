package lab1app.tasks;

public class BinarySearch {
    // Итеративный способ
    public int binarySearchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Рекурсивный способ
    public int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                return binarySearchRecursive(array, target, mid + 1, right);
            } else {
                return binarySearchRecursive(array, target, left, mid - 1);
            }
        }
        return -1;
    }
}