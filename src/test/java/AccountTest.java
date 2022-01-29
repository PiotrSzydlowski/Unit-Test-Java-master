import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * Created by Piotr Szydlowski on 19.01.2022
 */
class AccountTest {

    @Test
    void accountShouldNotBeActiveAfterCreation() {
        Account account = new Account();

        assertThat(account.isActive(), is(false));
    }

    @Test
    void accountShouldBeActiveAfterActivation() {
        Account account = new Account();
        account.activate();

        assertThat(account.isActive(), is(true));
    }

    @Test
    void newlyCreatedAccountShouldDefaultDeliveryAddressSet() {
        Account account = new Account();
        Address address = account.getDefaultDeliveryAddress();

        assertThat(address, is(nullValue()));
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        Account account = new Account();
        Address address = new Address("testowa", "30");
        account.setDefaultDeliveryAddress(address);
        Address defaultDeliveryAddress = account.getDefaultDeliveryAddress();

        assertThat(defaultDeliveryAddress, notNullValue());
    }

    @RepeatedTest(2)
    @Test
    void newAccountWithNotNullAddressShouldBeActive() {
        Address address = new Address("Puławska", "44");
        Account account = new Account(address);
        assumingThat(address != null, () -> assertTrue(account.isActive()));
    }
}