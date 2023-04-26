import java.util.Scanner;

/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
*/

public class Homework_2 {
    public static void main(String[] args) {

        // задание 1
        inputFloatNumber();
        // задание 2
        task_2();
        // задание 3
        try {
            task_3();   
        } catch (Exception e) {
            System.out.printf("Что-то пошло не так: " + e);
        }

    }

    // задание 1
    public static void inputFloatNumber() {

        System.out.printf("Введите дробное число (через запятую): ");
        boolean success = false;
        while (!success) {
            try {
                Scanner in = new Scanner(System.in);
                Float number = in.nextFloat();
                System.out.println("Вы ввели: " + number);
                in.close();
                success = true;
            } catch (Exception e) {
                System.out.println("Неверное значение! Введите дробное число: ");
            }
        }
    }

    // задание 2
    public static void task_2() {

        // добавлена эта строка
        int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }

    // задание 3 (изменён порядок catch)
    public static void task_3() throws Exception {

        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws ArithmeticException {
        System.out.println(a + b);
    }
     
}
