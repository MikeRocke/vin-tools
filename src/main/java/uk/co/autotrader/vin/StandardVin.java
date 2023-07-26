package uk.co.autotrader.vin;

public record StandardVin(String vinText, WorldManufacturerIdentifier wmi, VehicleDescriptorSection vds, VehicleIdentifierSection vis) {
}
