import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Piotr Szydlowski on 24.01.2022
 */
class AddressTest {

    @ParameterizedTest
    @CsvSource({"Fabryczna, 10", "Armi Krajowej, 57/1", "'Romk, Tomka, Atomka', 40"})
    void givenAddressesShouldNotBeEmptyAndHaveProperName(String street, String number){
        assertThat(street, notNullValue());
        assertThat(number, notNullValue());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv")
    void addressesFromCsvFileShouldNotBeEmptyAndHaveProperName(String street, String number){
        assertThat(street, notNullValue());
        assertThat(number, notNullValue());
    }
}