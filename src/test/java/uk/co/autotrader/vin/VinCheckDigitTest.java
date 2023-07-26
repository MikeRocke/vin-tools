package uk.co.autotrader.vin;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VinCheckDigitTest {

    @Test
    void calculateCheckDigit_ExampleForX() {
        // Example from https://en.wikibooks.org/wiki/Vehicle_Identification_Numbers_(VIN_codes)/Check_digit
        StandardVin vin = VinParser.parseIso3779("1M8GDM9AXKP042788").get();

        char checkDigit = VinTools.calculateCheckDigit(vin);

        assertThat(checkDigit).isEqualTo('X');
    }

    @Test
    void calculateCheckDigit_ExampleForStraightOnes() {
        // Example from https://en.wikibooks.org/wiki/Vehicle_Identification_Numbers_(VIN_codes)/Check_digit
        StandardVin vin = VinParser.parseIso3779("11111111111111111").get();

        char checkDigit = VinTools.calculateCheckDigit(vin);

        assertThat(checkDigit).isEqualTo('1');
        assertThat(VinTools.validCheckDigit(vin)).isTrue();
    }
}
