import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Piotr Szydlowski on 20.01.2022
 */
public class Order {
    private List<Meal> meals = new ArrayList<>();

    public List<Meal> getMeals() {
        return meals;
    }

    public void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    public void removeMealFromOrder(Meal meal) {
        this.meals.remove(meal);
    }

    public void cancel() {
        this.meals.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(meals, order.meals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meals);
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}
