// Задача 1
// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я: 2
// Иванов: 1242353, 547568

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

//* Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов

public class task1 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in, "cp866");

        
        while (true) {
            System.out.println();
            System.out.print(" Введите команду:\n\t1 - Добавить номер или контакт\n" +
            "\t2 - Показать все записи в телефонной книге\n Ваш выбор: ");

            String choice = sc.nextLine();

            switch (choice) {
                
                case "1":
                    addContact(phoneBook, sc);
                    break;
                case "2":
                    showPhoneBook(phoneBook);
                break;
               
                default:
                    System.out.println("Такой команды нет!");
            }
            
        }

        //sc.close();
    }

    public static void addContact(Map<String, ArrayList<String>> map, Scanner scanner) {
        int index = 1;
        Object[] names = map.keySet().toArray(); // ключ в массив
        
        System.out.println();
        System.out.println("Выберите, кому добавить номер или внечти новый контакт:");
        
        for (Object el: names) {                                // идем по массиву объектов
            System.out.println("\t" + index + ". " + el);   // вывод существующего справочника
            index++;
        }

        System.out.print("\t0. Добавить новый контакт\n Ваш выбор: ");

        int decision = scanner.nextInt();
        scanner.nextLine();

        if (decision <= names.length && decision > 0) {
            System.out.print("Введите номер телефона: ");
            String number = scanner.nextLine();
            map.get(names[decision - 1]).add(number);
        }
        else if (decision == 0) {
            System.out.print("Введите имя нового контакта: ");
            String name = scanner.nextLine();

            System.out.print("Введите номер телефона: ");
            String number = scanner.nextLine();

            ArrayList<String> numbers = new ArrayList<>();
            numbers.add(number);

            map.put(name, numbers);
        }
        else System.out.println("Такого выбора нет!");
    }

    public static void showPhoneBook(Map<String, ArrayList<String>> map) {
        System.out.println();

        for (var el: map.entrySet()) {
            System.out.println(el.getKey() + ":");

            for (String inner: el.getValue()) System.out.println("\t" + inner);
            
            System.out.println();
        }
    }
}