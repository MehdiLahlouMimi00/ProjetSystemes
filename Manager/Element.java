package Manager;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {

    /*
    Cette classe a pour but de faire de l'héritage pour
    les classes de dossier et fichier.
     */
    private String name;
    public List<Element> elementsList = new ArrayList<>();

    public Element(String name) {
        setName(name);
    }

    public void displayElement() {
        for (Element element : elementsList) {
            System.out.println(element);
        }
    }

    public abstract void create(Element element);

    public abstract void search(Element element);

    public abstract int getSize();

    public abstract void modify(Element element);

    public abstract void delete();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
