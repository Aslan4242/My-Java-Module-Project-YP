import java.util.Locale;

public class Utils {

    /**
     * Получаем количесто человек от пользователя
     *
     * @return int Количесто человек
     */
    public static int getPersonCount() {
        while (true) {
            String personCount = Main.scanner.next().replace(',', '.');

            if (!isNumber(personCount)) {
                System.out.println("Некорректное значение. Введите число!");
            } else {
                if (!isInteger(personCount)) {
                    System.out.println("Некорректное значение. Введите целое число!");
                } else {
                    int personCountInt = (int) Double.parseDouble(personCount);
                    if (personCountInt == 1) {
                        System.out.println("Вы один. Нет смысла в использовании Калькулятора счёта.");
                    } else if (personCountInt < 1) {
                        System.out.println("Некорректное значение. Число меньше 1");
                    } else {
                        System.out.println("Отлично!");
                        return personCountInt;
                    }
                }
            }
        }
    }

    /**
     * Форматирует строку с ценой блюда, оставляя только два числа после запятой и добавляя название валюты
     *
     * @param price Стоимость блюда
     * @return String Форматированная строка
     */
    public static String formatPriceData(double price) {
        String formattedPrice = String.format(Locale.US, "%.2f ", price);
        String rubleWord;
        int lastDigitInPrice = (int) (Math.abs(price) % 10); // последняя цифра
        int preLastDigitInPrice = (int) (Math.abs(price) % 100 / 10); // предпоследняя цифра
        if (preLastDigitInPrice == 1) {
            rubleWord = "рублей";
        } else {
            switch (lastDigitInPrice) {
                case (1):
                    rubleWord = "рубль";
                    break;
                case (2):
                case (3):
                case (4):
                    rubleWord = "рубля";
                    break;
                default:
                    rubleWord = "рублей";
            }
        }

        return formattedPrice + rubleWord;
    }

    /**
     * Проверяет, что введенная строка является числом
     *
     * @param strNum Введенная строка
     * @return boolean: true - число, false - не число
     */
    public static boolean isNumber(String strNum) {
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Проверяет, что введенная строка является целым числом
     *
     * @param strNum Введенная строка
     * @return boolean: true - целое число, false - нецелое число
     */
    public static boolean isInteger(String strNum) {
        double number = Double.parseDouble(strNum);
        if (number % 1 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
