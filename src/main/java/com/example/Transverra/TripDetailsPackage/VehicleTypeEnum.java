package com.example.Transverra.TripDetailsPackage;

public enum VehicleTypeEnum {
    TOYOTA("Toyota"),
    HONDA("Honda"),
    FORD("Ford"),
    BMW("BMW"),
    MERCEDES_BENZ("Mercedes-Benz"),
    AUDI("Audi"),
    HYUNDAI("Hyundai"),
    KIA("Kia"),
    NISSAN("Nissan"),
    VOLKSWAGEN("Volkswagen"),
    CHEVROLET("Chevrolet"),
    MAZDA("Mazda"),
    LEXUS("Lexus"),
    VOLVO("Volvo"),
    JEEP("Jeep");

    private final String label;

    VehicleTypeEnum(String label) {
        this.label = label;
    }

    /** Display / DB value */
    public String getLabel() {
        return label;
    }

    /** Convert DB value back to enum */
    public static VehicleTypeEnum fromLabel(String label) {
        for (VehicleTypeEnum type : values()) {
            if (type.label.equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown VehicleType: " + label);
    }
}
