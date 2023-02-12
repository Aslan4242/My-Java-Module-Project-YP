import java.util.ArrayList;

/**
 * Класс для описания расчета суммы, которую должен заплатить каждый человек
 */
public class Calculator {
    int personCount;  // Количество человек
    ArrayList<Dish> dishList; // Список блюд

    Calculator(int personCount, ArrayList<Dish> dishList) {
        this.personCount = personCount;
        this.dishList = dishList;
    }

    /**
     * Считает сумму, которую должен заплатить каждый человек поровну и выводит его в консоль
     */
    public void calculate() {
        String pricesSum = Utils.formatPriceData(getPricesSum());
        System.out.println("Общая стоимость блюд: " + pricesSum + ".");
        System.out.println("Количество персон: " + personCount + ".");
        String result = Utils.formatPriceData(getPricesSum() / personCount);
        System.out.println("Производим расчет...\nКаждый человек должен заплатить: " + result + ".");
    }

    /**
     * Считает общую стоимость всех блюд
     *
     * @return double Общая стоимость всех блюд
     */
    public double getPricesSum() {
        double sum = 0;
        for (Dish dish : this.dishList) {
            sum += dish.price;
        }
        return sum;
    }

}
