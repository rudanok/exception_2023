import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Homework_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел в следующем формате: Фамилия Имя Отчество дата_рождения (дд.мм.гггг) номер_телефона пол (m/f):");
        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
            System.err.println("Ошибка: введено " + data.length + " параметров, требуется 6.");
            return;
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4] ;
        String gender = data[5];

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        try {
            sdf.setLenient(false);
            sdf.parse(birthDate);
        } catch (ParseException e) {
            System.err.println("Ошибка: неверный формат даты рождения. Используйте формат dd.MM.yyyy");
            return;
        }

        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: неверный формат номера телефона. Введите беззнаковое целое число без форматирования.");
            return;
        }

        if (!gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("m")) {
            System.err.println("Ошибка: неверный формат пола. Введите символ латиницей 'f' или 'm'.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(surname + ".txt", true))) {
            writer.write(String.join("", "<" + surname + ">", "<" + name + ">", "<" + patronymic + ">", "<" + birthDate + ">", "<" + phoneNumber + ">", "<" + gender + ">"));
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Проблема с чтением-записью в файл:");
            e.printStackTrace();
        }
    }
}