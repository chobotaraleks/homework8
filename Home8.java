import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Створення масиву з 15 елементами
        int[] array = new int[15];
        Random random = new Random();
        
        // Заповнення масиву випадковими числами від 1 до 100
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }

        // Виведення початкового вигляду масиву
        System.out.println("Початковий вигляд масиву: " + Arrays.toString(array));

        // Сортування масиву за допомогою алгоритму сортування вставкою (Insertion Sort)
        insertionSort(array);

        // Виведення відсортованого масиву
        System.out.println("Відсортований масив: " + Arrays.toString(array));

        // Пошук числа, введеного користувачем
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число для пошуку: ");
        int target = scanner.nextInt();

        // Виконання бінарного пошуку
        int index = binarySearch(array, target);

        // Виведення результату пошуку
        if (index == -1) {
            System.out.println("Число " + target + " не знайдено у відсортованому масиві.");
        } else {
            System.out.println("Індекс числа " + target + " у відсортованому масиві: " + index);
        }

        scanner.close();
    }

    // Метод для сортування вставкою (Insertion Sort)
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Переміщення елементів масиву, що більші за key, на одну позицію вперед
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Метод для бінарного пошуку
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Елемент не знайдено
    }
}

