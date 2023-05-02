package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Holidays {
    public static void deleteHolidayFromFile(File file, String holidayName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(holidayName)) {
                    lines.add(line);
                }
            }
            reader.close();
            FileWriter writer = new FileWriter(file);
            for (String str : lines) {
                writer.write(str + "\n");
            }
            writer.close();
            System.out.println("Праздник \"" + holidayName + "\" удален из файла.");
        } catch (IOException e) {
            System.out.println("Ошибка удаления праздника из файла.");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String funcPrint = "Функции программы: \n[1] - Просмотр праздников;\n[2] - Добавление праздников;\n[3] - Удаление праздников;\n[exit] - Выход из программы;";
        System.out.println(funcPrint);
        System.out.print("Ваш выбор: ");
        Scanner scannerFunction = new Scanner(System.in);
        String choice = scannerFunction.nextLine(); //Выбор функции
        while (choice.equals("1") == false & choice.equals("2") == false & choice.equals("3") == false & choice.equals("exit") == false) {
            System.out.println("Нет такой функции!");
            choice = scannerFunction.nextLine();
        }
        String chosenMonth;

        File fileMonths = new File("months.txt");
        Scanner scannerMonths = new Scanner(fileMonths);
        ArrayList<String> months = new ArrayList<String>();
        while (scannerMonths.hasNextLine()) {
            String month = scannerMonths.nextLine();
            months.add(month);
        }
        scannerMonths.close();

        ArrayList<String> holidays = new ArrayList<String>();
        File fileHolidays = new File("holidays.txt");
        while (choice.equals("exit") == false) {
            switch (choice) {
                case "1": //Просмотр праздников

                    //Вывод месяцев на экран
                    System.out.println("Список месяцев:");

                    for (int i = 0; i < months.size(); i++) {
                        System.out.println(months.get(i));
                    }
                    Scanner scannerSelect = new Scanner(System.in);
                    System.out.print("Выберите месяц: ");
                    while (true) {
                        try {
                            chosenMonth = scannerSelect.nextLine();
                            if (months.indexOf(chosenMonth) != -1) {
                                break;
                            } else
                                System.out.println("Данного месяца не существует!");
                        } catch (Exception e) {
                            System.out.println("Ошибка: неверный формат данных");
                        }
                    }
//Чтение праздников

                    Scanner scannerHolidays = new Scanner(fileHolidays);
                    System.out.println("Праздники:");
                    int k = 1;
                    while (scannerHolidays.hasNextLine()) {
                        String line = scannerHolidays.nextLine();
                        String[] parts = line.split(","); // образуем массив в котором [0] элемент - месяц (до знака ",") , [1] - название праздника
                        if (parts[0].equals(chosenMonth)) {
                            System.out.println("[" + k + "] - " + parts[1]);
                            holidays.add(line);
                            k++;
                        }
                    }
                    System.out.println(funcPrint);
                    System.out.println("Выберите функцию: ");
                    choice = scannerFunction.nextLine();
                    while (choice.equals("1") == false & choice.equals("2") == false & choice.equals("3") == false & choice.equals("exit") == false) {
                        System.out.println("Нет такой функции!");
                        System.out.print("Ваш выбор: ");
                        choice = scannerFunction.nextLine();
                    }
                    break;
                case "2": //Добавление праздников
                    Scanner scannerInput = new Scanner(System.in);
                    String nameOfHoliday = "";
                    System.out.print("Введите название месяца: ");
                    chosenMonth = scannerInput.nextLine();
                    while (months.contains(chosenMonth) == false) {
                        System.out.println("Вы ввели несуществующий месяц!");
                        System.out.print("Введите название месяца: ");
                        chosenMonth = scannerInput.nextLine();
                    }
                    System.out.print("Введите название праздника: ");
                    nameOfHoliday = scannerInput.nextLine();
                    String newHoliday = chosenMonth + "," + nameOfHoliday;
                    holidays.add(newHoliday);
                    try {
                        FileWriter writer = new FileWriter(fileHolidays, true);
                        PrintWriter printer = new PrintWriter(writer);
                        printer.println(newHoliday);
                        printer.close();
                    } catch (IOException e) {
                        System.out.println("Ошибка записи в файл");

                    }
                    System.out.println(funcPrint);
                    System.out.println("Выберите функцию: ");
                    choice = scannerFunction.nextLine();
                    while (choice.equals("1") == false & choice.equals("2") == false & choice.equals("3") == false & choice.equals("exit") == false) {
                        System.out.println("Нет такой функции!");
                        System.out.print("Ваш выбор: ");
                        choice = scannerFunction.nextLine();
                    }
                    break;
                case "3":
//Удаление праздников
                    System.out.print("Введите название месяца: ");
                    scannerInput = new Scanner(System.in);
                    chosenMonth = scannerInput.nextLine();
                    while (months.contains(chosenMonth) == false) {
                        System.out.println("Вы ввели несуществующий месяц!");
                        System.out.print("Введите название месяца: ");
                        chosenMonth = scannerInput.nextLine();
                    }
                    System.out.print("Введите номер праздника: ");
                    int numberOfHoliday = scannerInput.nextInt();
                    nameOfHoliday = holidays.get(numberOfHoliday-1);
                    System.out.println(nameOfHoliday);
                    if (holidays.contains(nameOfHoliday)) {
                        deleteHolidayFromFile(fileHolidays,nameOfHoliday);
                        holidays.remove(nameOfHoliday);
                    } else {
                        System.out.println("Праздник не найден!");
                    }
                    System.out.println(funcPrint);
                    System.out.println("Выберите функцию: ");
                    choice = scannerFunction.nextLine();
                    while (choice.equals("1") == false & choice.equals("2") == false & choice.equals("3") == false & choice.equals("exit") == false) {
                        System.out.println("Нет такой функции!");
                        System.out.print("Ваш выбор: ");
                        choice = scannerFunction.nextLine();
                    }
                    break;
            }
        }
    }
}