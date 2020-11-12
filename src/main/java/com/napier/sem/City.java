package com.napier.sem;

public class City {
    private int id;
    private String name;
    private String ccode;
    private String district;
    private String population;

    public String getDistrict() {
        return district;
    }

    public String getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public String getCcode() {
        return ccode;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
