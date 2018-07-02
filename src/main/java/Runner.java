import com.sun.xml.internal.rngom.digested.DPattern;
import db.DBFather;
import db.DBSon;
import models.Father;
import models.Son;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Father father1 = new Father("Campbelle", "Miller", 42, "Unicycling");
        DBFather.save(father1);
        Son son1 = new Son("Richard", "Phillips-Kerr", 15, "Painting squirrels");
        DBSon.save(son1);
        Father father2 = new Father("Darth", "Vader", 47, "Chopping off hands");
        DBFather.save(father2);
        Son son2 = new Son("Luke", "Skywalker", 19, "Losing hands");
        DBSon.save(son2);
        Father father3 = new Father("Mufasa", "Lion", 14, "Being King");
        DBFather.save(father3);
        Son son3 = new Son("Simba", "Lion", 1, "Getting lost");
        DBSon.save(son3);

    List<Father> allFathers= DBFather.getAll();

    List<Father> oldFathers = DBFather.oldFathers();

    DBFather.delete(father2);

    List <Father> listAfterOneDelete = DBFather.getAll();

    Son simba = DBSon.find(son3.getId());

}
}
