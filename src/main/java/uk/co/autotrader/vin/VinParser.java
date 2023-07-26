package uk.co.autotrader.vin;

import java.util.Optional;
import java.util.regex.Pattern;

public class VinParser {
    public static final Pattern ISO_3779_PATTERN = Pattern.compile("^[0-9A-HJ-NPR-Z]{17}$");
    public static Optional<StandardVin> parseIso3779(String vinText) {
        if (vinText != null && ISO_3779_PATTERN.matcher(vinText).matches()) {
            WorldManufacturerIdentifier wmi = new WorldManufacturerIdentifier(vinText.substring(0, 3));
            String attributes = vinText.substring(3, 8);
            char checkDigit = vinText.charAt(8);
            VehicleDescriptorSection vds = new VehicleDescriptorSection(attributes, checkDigit);
            char modelYear = vinText.charAt(9);
            char plantCode = vinText.charAt(10);
            String serialNumber = vinText.substring(11, 17);
            VehicleIdentifierSection vis = new VehicleIdentifierSection(modelYear, plantCode, serialNumber);
            return Optional.of(new StandardVin(vinText, wmi, vds, vis));
        } else {
            return Optional.empty();
        }
    }
}
