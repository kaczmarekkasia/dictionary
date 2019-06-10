import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();

        dictionary.addTranslation("uczyć", "teach");
        dictionary.addTranslation("sprawdzać", "check");
        dictionary.addTranslation("rachunek", "check");

        System.out.println(dictionary);

        dictionary.translate("uczyć");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w aplikacji słownik!");

        String flag;

        do {
            System.out.println("Co chcesz zrobić?" + Arrays.toString(Commands.values()));
            flag = scanner.next().toUpperCase();

            if (flag.equalsIgnoreCase("q")) {
                break;
            }
            try {
                Commands command = Commands.valueOf(flag);

                switch (command){
                    case DODAJ:
                        System.out.println("Podaj polskie słowo:");
                        String inPolish = scanner.next();
                        System.out.println("Podaj angielskie tłumaczenie:");
                        String inEnglish = scanner.next();
                        dictionary.addTranslation(inPolish, inEnglish);
                        break;
                    case TŁUMACZ:
                        System.out.println("Jakie słowo chcesz przetłumaczyć na angielski?");
                        String translation=dictionary.translate(scanner.next());
                        if (translation!=null) {
                            System.out.println(translation);
                        } else {
                            System.out.println("Brak tłumaczenia");
                        }
                        break;
                }


            } catch (IllegalArgumentException iae) {
                System.out.println("Nie rozumiem...spróbuj jeszcze raz!");
                continue;
            }

        } while (!flag.equalsIgnoreCase("q"));


    }
}
