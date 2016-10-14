package Demo;

/**
 * Created by yuan on 16-7-31.
 */
public class Person {
    String name;
    int id_card;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    Person(String name,int id_card){
        this.name=name;
        this.id_card=id_card;
    }
}
