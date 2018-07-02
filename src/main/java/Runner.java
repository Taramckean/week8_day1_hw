import db.DBFather;
import models.Father;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Father father1 = new Father("Campbelle", "Miller", 42, "Unicycling");
        DBFather.save(father1);


    List<Father> allFathers= DBFather.getAll();

}
}
