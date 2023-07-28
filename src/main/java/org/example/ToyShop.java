package org.example;
public class ToyShop implements Comparable <ToyShop>{

    private int id;
    private String name;
    private int count;
    private int weight;

    public ToyShop (int id, String name_product, int count, int weight){
        this.id  = id;
        this.name = name_product;
        this.count = count;
        this.weight = weight;
    }

    public ToyShop (int vendor_code, String name_product, int count){
        this.id  = vendor_code;
        this.name = name_product;
        this.count = count;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(ToyShop other) {
        if (other == null) {
            return -1;
        }
        int delta = this.weight - other.weight;
        if (delta != 0) {
            return - delta;
        }
        return this.name.compareTo(other.name);
    }
}