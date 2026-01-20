package com.example.Transverra.TripDetailsPackage;

public enum TripTypesEnum {

        OWT("OWT"),        // One Way Transfer
        RT("RT"),          // Return Transfer
        AA("AA"),          // Airport Arrival
        AD("AD"),          // Airport Departure
        HS("HS"),          // Half Day Service
        FS("FS"),          // Full Day Service
        H24("24H");        // 24 Hours Service

        private final String code;

        TripTypesEnum(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        // Optional: Get enum from code
        public static TripTypesEnum fromCode(String code) {
            for (TripTypesEnum type : TripTypesEnum.values()) {
                if (type.code.equals(code)) return type;
            }
            throw new IllegalArgumentException("Unknown TripType code: " + code);
        }
    }


