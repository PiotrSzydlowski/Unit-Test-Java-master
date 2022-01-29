import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Piotr Szydlowski on 24.01.2022
 */

@DisplayName("Test cases for Cart")
class CartTest {

    @DisplayName("Cart is able to process 1000 orders in 100 ms")
    @Test
    void simulateLargeOrder() {
        Cart cart = new Cart();
        assertTimeout(Duration.ofMillis(100), cart::simulateLargeOrder);
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart() {
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(0),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertAll(
                () -> assertThat(cart.getOrders(), notNullValue()),
                () -> assertThat(cart.getOrders(), hasSize(1))
        );
    }
}