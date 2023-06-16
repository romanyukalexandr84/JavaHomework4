import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Task1Task2Task3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        ArrayList<String[]> humans = new ArrayList<>();
        System.out.println("Введите данные в формате [фамилия имя отчество возраст пол] (q - для выхода):");
        while (true) {
            String data = iScanner.nextLine();
            if (data.equals("q"))
                break;
            humans.add(data.split(" "));
        }

        System.out.println("Вывод в формате [Фамилия И.О. возраст пол]:");
        for (String[] i : humans) {
            System.out.printf("%s %s.%s. %s %s\n",
                    i[0].toUpperCase().charAt(0) + i[0].toLowerCase().substring(1, i[0].length()),
                    i[1].toUpperCase().charAt(0),
                    i[2].toUpperCase().charAt(0), i[3], i[4]);
        }

        System.out.println("Нажмите любую клавишу для вывода списка, отсортированного по возрасту (q - для выхода):");
        String command = iScanner.nextLine();
        if (command.equals("q")) {
            System.exit(0);
        } else {
            humans.sort(new Comparator<String[]>() {
                public int compare(String[] o1, String[] o2) {
                    return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
                }
            });
            for (String[] i : humans) {
                System.out.printf("%s %s.%s. %s %s\n",
                        i[0].toUpperCase().charAt(0) + i[0].toLowerCase().substring(1, i[0].length()),
                        i[1].toUpperCase().charAt(0),
                        i[2].toUpperCase().charAt(0), i[3], i[4]);
            }
        }
        iScanner.close();
    }
}

// Пример данных для ввода:
// петров алексей павлович 35 М
// иванов михаил александрович 20 М
// сидорова анна сергеевна 56 Ж
// ковалева надежда игоревна 45 Ж