import java.io.File;

// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
// Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
// и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
// Если длины массивов не равны, необходимо как-то оповестить пользователя.

public class Homework_1 {

    public static void main(String[] args) {
        //метод 1: размер массива
        int[] arr = {};
        System.out.println(ShowArray(arr));
        //метод 2: размер файла
        System.out.println(getFileSize(new File("123")));
        //метод 3: сумма элементов квадратного массива
        int[][] arrBin = {{1, 0, 0}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(sumSquareArray(arrBin));
        //метод 4: разность массивов
        int[] arr1 = { 2, 3, 4 };
        int[] arr2 = { 1, 2, 3, 4 };
        System.out.println(divOfArrays(arr1, arr2));
    }

    //метод 1: размер массива
    public static int ShowArray(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        return arr.length;
    }

    //метод 2: размер файла
    public static long getFileSize(File file) {
        if (!file.exists()) {
            return -1;
        }
        return file.length();
    }

    //метод 3: сумма элементов квадратного массива
    public static int sumSquareArray(int[][] arr) {
        if (arr.length != arr[0].length) {
            throw new RuntimeException("Массив дожен быть квадратным!");
        };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 1) {
                    throw new RuntimeException("Должны быть только 0 или 1!");
                }
                sum += arr[i][j];
            }
        }
        return sum;
    }

    //метод 4: разность массивов
    public static int[] divOfArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны!");
        }
        int[] sumArr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            sumArr[i] = arr1[i] - arr2[i];
        }
        return sumArr;
    }

}