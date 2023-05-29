package Task_6;

import java.util.Objects;

public class Laptop {

    private static int counter = 0;

    private int id;
    private String name;
    private String brand;
    private String color;
    private int price;
    private String screen;
    private String gpu;

    private int ram_size;
    private int storage_size;

    private String os;
    private String cpu;


    public Laptop(String name, String brand, String color, String screen, String gpu, String cpu, int ram_size, int storage_size,   String os, int price) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.screen = screen;
        this.gpu = gpu;
        this.cpu = cpu;
        this.ram_size = ram_size;
        this.storage_size = storage_size;
        this.os = os;
        this.price = price;
        this.setId();
    }


    public int getRam_size() {
        return ram_size;
    }

    public String getColor() {
        return color;
    }

    public String getOs() {
        return os;
    }

    public int getStorage_size() {
        return storage_size;
    }

    private void setId() {
        this.id = counter++;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.cpu + ", " + this.gpu + ", " + this.screen + ", " + this.color + " - " + this.price + " руб";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Laptop){
            return this.name.equals(((Laptop) obj).name) && this.color.equals(((Laptop) obj).color) && this.screen.equals(((Laptop) obj).screen)
                    && this.gpu.equals(((Laptop) obj).gpu) && this.cpu.equals(((Laptop) obj).cpu) && this.price == ((Laptop) obj).price
                    && this.ram_size == ((Laptop) obj).ram_size && this.storage_size == ((Laptop) obj).storage_size
                    && this.os.equals(((Laptop) obj).os);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.color, this.screen, this.gpu, this.cpu, this.ram_size, this.storage_size, this.os,  this.price);
    }

}
