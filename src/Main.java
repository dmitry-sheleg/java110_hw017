import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");
            System.out.println("5. Удалить дела по ключевому слову");

            String input = scanner.nextLine();
            int operation = Integer.parseInt(input);
            if (operation == 0) {
                System.out.println("Программа завершена.");
                break;
            } else {
                switch (operation) {
                    case 1:
                        System.out.println("Введите название задачи:");
                        list.add(scanner.nextLine());
                        System.out.println("Добавлено!");
                        break;
                    case 2:
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Введите номер для удаления:");
                        int index = Integer.parseInt(scanner.nextLine());
                        if (index > 0 && index <= list.size()) {
                            list.remove(index - 1);
                            System.out.println("Удалено!");
                        } else {
                            System.out.println("Задачи с таким номером не существует");
                        }
                        break;
                    case 4:
                        System.out.println("Введите задачу для удаления:");
                        String task = scanner.nextLine();
                        if (list.contains(task)) {
                            list.remove(task);
                            System.out.println("Удалено!");
                        } else {
                            System.out.println("Задачи с таким названием не существует");
                        }
                        break;
                    case 5:
                        System.out.println("Введите ключевое слово для удаления:");
                        String keyword = scanner.nextLine();

                        Iterator<String> iterator = list.iterator();
                        int count = 0;
                        while (iterator.hasNext()) {
                            if (iterator.next().contains(keyword)) {
                                iterator.remove();
                                count++;
                            }
                        }
                        if (count == 0) {
                            System.out.println("Задач с таким ключевым словом не найдено");
                        } else {
                            System.out.println("Удалено дел: " + count);
                        }
                        break;
                    default:
                        System.out.println("Недопустимая операция");
                }
            }
            System.out.println("Ваш список дел:");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, list.get(i));
            }
            System.out.println();
        }
    }
}
