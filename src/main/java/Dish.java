import java.util.ArrayList;

/**
 * Класс для описания блюда из меню
 */
public class Dish {
    String name;  // Название блюда
    double price; // Стоимость блюда

    Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Получает список блюд с их стоимостью и сохраняет их в список
     *
     * @return ArrayList Список блюд с их стоимостью
     */
    public static ArrayList<Dish> getDishesList() {
        String stopCommand = "Завершить";
        ArrayList<Dish> dishList = new ArrayList<>();

        System.out.println("Введите название блюда");

        while (true) {
            String userInput = Main.scanner.next(); // Предполагается, что название блюда может состоять из чисел и символов

            if (userInput.equalsIgnoreCase(stopCommand)) {
                break;
            } else {
                double dishPrice = getDishPrice();

                dishList.add(new Dish(userInput, dishPrice));

                System.out.println("Блюдо успешно добавлено в список");
                System.out.println("Если хотите добавить еще одно блюдо, то введите его название. " +
                        "\nЕсли хотите завершить процесс добавления блюд, то введите слово '" + stopCommand + "'.");
            }
        }

        return dishList;
    }

    /**
     * Выводит в консоль информацию о блюде и его стоимости
     */
    public void printDishInfo() {
        System.out.println("Блюдо: " + this.name + ", стоимость: " + Utils.formatPriceData(this.price));
    }

    /**
     * Получает стоимость блюда от пользователя
     *
     * @return double Стоимость блюда
     */
    public static double getDishPrice() {
        System.out.println("Введите стоимость блюда.");
        while (true) {
            String price = Main.scanner.next().replace(',', '.');

            if (!Utils.isNumber(price)) {
                System.out.println("Некорректное значение. Введите число!");
            } else if (Double.parseDouble(price) < 0) { // Предполагается, что блюдо может быть бесплатным :)
                System.out.println("Некорректное значение. Стоимость блюда не может быть отрицательной");
            } else {
                return Double.parseDouble(price);
            }
        }
    }
}
