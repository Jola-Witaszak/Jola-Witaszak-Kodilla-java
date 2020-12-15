package com.kodilla.task_13_2;

public class Supplier {
    private final String companyName;
    private final String address;

    public Supplier(final String companyName, final String address) {
        this.companyName = companyName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
