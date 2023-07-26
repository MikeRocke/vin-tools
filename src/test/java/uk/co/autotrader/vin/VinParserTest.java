package uk.co.autotrader.vin;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class VinParserTest {

    @Test
    void parseIso3779_parsesStructureFromValidText() {
        WorldManufacturerIdentifier wmi = new WorldManufacturerIdentifier("ABC");
        VehicleDescriptorSection vds = new VehicleDescriptorSection("12345", 'X');
        VehicleIdentifierSection vis = new VehicleIdentifierSection('9', 'A', "012345");
        StandardVin expected = new StandardVin("ABC12345X9A012345", wmi, vds, vis);

        Optional<StandardVin> vin = VinParser.parseIso3779("ABC12345X9A012345");

        assertThat(vin).isPresent();
        assertThat(vin.get()).isEqualToComparingFieldByFieldRecursively(expected);
    }
}
