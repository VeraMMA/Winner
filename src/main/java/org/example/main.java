package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class main {

    public static void main(String[] args) throws IOException {
        ArrayList <ToyShop> set =new ArrayList<>();
        set.add(new ToyShop(17, "Hello Kitty", 6));
        set.add(new ToyShop(21, "Pokemon", 5));
        set.add(new ToyShop(7, "Teddy Bear", 2));
        set.add(new ToyShop(27, "Batman", 2));
        set.add(new ToyShop(5, "Sailor Moon", 2));


        PriorityQueue <ToyShop> list_draw = new PriorityQueue<>();
        for (ToyShop position : set) {
            int count = position.getCount();
            while (count > 0) {
                int id = (int) (Math.random() * 9 + 1);
                list_draw.add(new ToyShop(position.getId(),position.getName(),position.getCount(), id ));
                count --;
                if (id == 1){
                    System.out.println("Поздравляем, Вы выйграли: " + position.getId() + ", "+ position.getName() + ", " + position.getCount());
                }
            }
        }
        if ( ! Files.isRegularFile(Path.of("receipt.txt"))){
        }
        else {
            Files.delete(Path.of("receipt.txt"));
        }
        Files.createFile(Path.of("receipt.txt"));
        ToyShop element;
        while((element = list_draw.poll())!= null) {
           System.out.println( element.getId() +  "," + " " + element.getName());
            Path path = Paths.get("receipt.txt");
            String text = "ID: "+ element.getId()+ ", " + "name: " + element.getName()+"," + "шанс выйгрыша: " + element.getWeight() + " к одному" +"\n";
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        }

    }
}