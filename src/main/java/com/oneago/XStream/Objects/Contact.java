package com.oneago.XStream.Objects;

public class Contact {
    private String name;
    private String phone;
    private Reference reference;

    public Contact(String name, String phone, Reference reference) {
        this.name = name;
        this.phone = phone;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", reference=" + reference +
                '}';
    }
}
