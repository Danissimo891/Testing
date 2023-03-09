package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main { //Программа вывода информации праздников
    public static void main(String[] args) {
        int month = 0;
        String[] data = new String[12];
        data[0] = "1 января - 'Новый год' \n6 января - 'Рождественский сочельник' \n7 января - 'Рождественский христово' \n14 января - 'Старый новый год'";
        data[1] = "20 февраля - 'Масленица' \n12 февраля - 'День Дарвина'";
        data[2] = "3 марта - 'Всемирный день писателя' \n8 марта - 'Международный женский день'";
        data[3] = "1 апреля - 'День смеха' \n4 апреля - 'День Интернета'";
        data[4] = "1 мая - 'Праздник труда, Первое мая' \n9 мая - 'День Победы'";
        data[5] = "1 июня - 'Международный день защиты детей' \n10 июня - 'Всемирный день мороженого'";
        data[6] = "4 июля - 'День отдыха от праздников' \n5 июля - 'День трудоголиков'";
        data[7] = "8 августа - 'Всемирный день кошек' \n19 августа - 'Всемирный день фотографии'";
        data[8] = "1 сентября - 'День знаний' \n6 сентября - 'День рыжих'";
        data[9] = "1 октября - 'День учителя '\n2 октября - 'Международный день врача '";
        data[10] = "10 ноября - 'Всемирный день молодежи'\n13 ноября - 'Всемирный день доброты'";
        data[11] = "1 декабря - 'День невролога'\n8 декабря - 'Международный день художника'";
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Выберите месяц:");
        System.out.println("[1]: Январь \n[2]: Февраль \n[3]: Март \n[4]: Апрель \n[5]: Май \n[6]: Июнь \n[7]: Июль \n[8]: Август \n[9]: Сентябрь \n[10]: Октябрь \n[11]: Ноябрь \n[12]: Декабрь");
        System.out.println("Для завершения вывода информации введите exit");
        while (true) {

            System.out.print("Ваш выбор: ");
            try {
                String enter = reader.readLine();
                if (enter.equals("exit")) {
                    break;
                }
                month = Integer.parseInt(enter);
                if (month > 0 && month < 13) {
                    System.out.println("Праздники:");
                    System.out.println(data[month-1]);
                }

                if (month < 1 || month > 12) {
                    System.out.println("Данного месяца не существует!");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: неверный формат данных");
            }
        }
    }

}