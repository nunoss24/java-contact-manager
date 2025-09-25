package io.spotny.contacts.models;

public enum ContactType {
    EMAIL("email"),
    PHONE("phone"),
    ADDRESS("address");

    private final String value;

    ContactType(String value) {
        this.value = value;
    }

    public static ContactType fromString(String value){
        for(ContactType type : ContactType.values()){
            if(type.value.equalsIgnoreCase(value)){
                return type;
            }
        }
        return EMAIL;
    }
    @Override
    public String toString() {
        return value;
    }
}
