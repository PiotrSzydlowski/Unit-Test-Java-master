import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Piotr Szydlowski on 20.01.2022
 */
class OrderTest {

    private Order order;

    @BeforeEach
    void initializeOrder(){
        order = new Order();
    }

    @AfterEach
    void clenUp(){
        order.cancel();
    }

    @Test
    void testAssertArrayEquals(){
        int[] ints1 = {1,2,3};
        int[] ints2 = {1,2,3};

        assertArrayEquals(ints1, ints2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder(){
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize(){
        order.addMealToOrder(new Meal(7, "Pizza"));

        assertThat(order.getMeals(), hasSize(1));
    }

    @Test
    void addingMealToOrderShouldHasMealInOrder(){
        Meal meal = new Meal(10, "Burger");
        order.addMealToOrder(meal);

        assertThat(order.getMeals(), contains(meal));
    }

    @Test
    void addingMealToOrderShouldHasCorrectPrice(){
        Meal meal = new Meal(7, "Soup");
        order.addMealToOrder(meal);

        assertThat(order.getMeals().get(0).getPrice(), equalTo(7));
    }

    @Test
    void removingMealFromOrderShouldDecreasingOrderSize(){
        Meal meal = new Meal(14, "Chips");
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder(){
        Meal meal1 = new Meal(17, "Burger");
        Meal meal2 = new Meal(10, "Sandwich");
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        assertThat(order.getMeals(), contains(meal1, meal2));
    }

    @Test
    void testIfTwoMealsListAreTheSame(){
        Meal meal1 = new Meal(17, "Burger");
        Meal meal2 = new Meal(10, "Sandwich");
        List<Meal> meals1 = Arrays.asList(meal1, meal2);
        List<Meal> meals2 = Arrays.asList(meal1, meal2);

        assertThat(meals1, is(meals2));
    }

}