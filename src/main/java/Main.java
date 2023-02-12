import java.util.ArrayList;
import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Приветствую! Это консольное приложение 'Калькулятор счёта'.\n" +
                "Оно помогает рассчитать сумму, которую должен заплатить каждый участник застолья, " +
                "поделив счет поровну между всеми ними.\n" +
                "На скольких человек следует разделить счет?");

        int personCount = Utils.getPersonCount();

        ArrayList<Dish> dishList = Dish.getDishesList();
        Calculator calculator = new Calculator(personCount, dishList);

        System.out.println("Добавленные блюда:");
        for (Dish dish : dishList) {
            dish.printDishInfo();
        }

        calculator.calculate();

        scanner.close();
    }
}
