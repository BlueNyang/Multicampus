package com.mc.algorithm.dDatastructure.dto;

import java.util.Objects;

public class School implements Comparable<School> {
    private final String name;
    private final String address;
    private final String level;

    public School(String name, String address, String level) {
        super();
        this.name = name;
        this.address = address;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return level;
    }

    @Override
    public String toString() {
        return "School { name=" + name + ", address=" + address + ", level=" + level + " }";
    }

    @Override
    public int compareTo(School o) {
        return this.level.compareTo(o.level) == 0 ? -this.name.compareTo(o.name) : this.level.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name)
                && Objects.equals(address, school.address)
                && Objects.equals(level, school.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, level);
    }
}
