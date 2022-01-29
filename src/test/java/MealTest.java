import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Piotr Szydlowski on 19.01.2022
 */
class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {
        Meal meal = new Meal(35);
        int discountedPrice = meal.getDiscountedPrice(7);

        assertThat(discountedPrice, equalTo(28));
    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        assertThat(meal1, is(sameInstance(meal2)));
    }

    @Test
    void referencesToDifferentObjectShouldNotBeEqual() {
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(10);

        assertThat(meal1, not(sameInstance(meal2)));
    }

    @Test
    void twoMealsShouldBeEqualsWhenPriceAndNameTheSame() {
        Meal meal1 = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pizza");

        assertThat(meal1, equalTo(meal2));
    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrcie() {
        Meal meal = new Meal(10, "Pizza");

        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(11));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 19})
    void mealPricesShouldBeLowerBy20(int price) {
        assertThat(price, lessThan(20));
    }

    @ParameterizedTest
    @MethodSource("createMealsWithNameAndPrice")
    void burgerShouldCorrectNameAndPrice(String name, int price) {
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThanOrEqualTo(10));
    }

    private static Stream<Arguments> createMealsWithNameAndPrice() {
        return Stream.of(
                Arguments.of("Hamburger", 10),
                Arguments.of("Cheeseburger", 12)
        );
    }
}