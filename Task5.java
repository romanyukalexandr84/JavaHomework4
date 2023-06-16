import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {
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

        ArrayList<Integer> ages = new ArrayList<>();
        for (String[] i : humans) {
            ages.add(Integer.parseInt(i[3]));
        }

        for (int i = 0; i < ages.size(); i++) {
            for (int j = 0; j < ages.size() - 1; j++) {
                if (ages.get(j) > ages.get(j + 1)) {
                    int temp = ages.get(j);
                    ages.set(j, ages.get(j + 1));
                    ages.set(j + 1, temp);
                }
            }
        }

        ArrayList<Integer> indexes = new ArrayList<>();

        for (Integer o : ages) {
            for (String[] i : humans) {
                if (o == Integer.parseInt(i[3]) && i[4].equalsIgnoreCase("м"))
                    indexes.add(humans.indexOf(i));
            }
            for (String[] i : humans) {
                if (o == Integer.parseInt(i[3]) && i[4].equalsIgnoreCase("ж"))
                    indexes.add(humans.indexOf(i));
            }
        }

        System.out.println("Индексы сортировки:");
        for (Integer s : indexes) {
            System.out.printf("%d ", s);
        }
        System.out.println();

        System.out.println("Вывод списка, отсортированного по возрасту и полу:");
        for (Integer s : indexes) {
            System.out.printf("%s %s.%s. %s %s\n",
                    humans.get(s)[0].toUpperCase().charAt(0) +
                    humans.get(s)[0].toLowerCase().substring(1, humans.get(s)[0].length()),
                    humans.get(s)[1].toUpperCase().charAt(0),
                    humans.get(s)[2].toUpperCase().charAt(0), humans.get(s)[3], humans.get(s)[4]);
        }
        iScanner.close();
    }
}

// Пример данных для ввода:
// петров алексей павлович 35 М
// сидорова анна сергеевна 56 Ж
// иванов михаил александрович 20 М
// ковалева надежда игоревна 45 Ж