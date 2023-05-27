package Manager;

import java.util.ArrayList;
import java.util.List;

public class Shortcut extends Element {
    Element target;
    public List<Element> elementsList;

    public Shortcut(Element element) {
        super(element.getName());
        this.target = element;
        this.elementsList = new ArrayList<>();
    }

    public void create(Element shortcut) {
        for (Element element : elementsList) {
            if ((shortcut.getName()).equals(element.getName()) && (element instanceof Shortcut)) {
                System.out.println("The shortcut already exists");
            }
            elementsList.add(shortcut);
        }
    }

    public void search(Element shortcut) {
        for (Element element : elementsList) {
            if ((shortcut.getName()).equals(element.getName()) && (element instanceof Shortcut)) {
                System.out.println("The shortcut exists");
            }
        }
        System.out.println("The shortcut does not exist");
    }

    public int getSize() {
        return 0;
    }

    public void modify(Element shortcut) {
        for (Element element : elementsList) {
            if ((shortcut.getName()).equals(element.getName()) && (element instanceof Shortcut)) {
                element.setName(shortcut.getName());
                System.out.println("The shortcut has been modified");
            }
        }
    }

    public void delete() {
        for (int i = 0; i < elementsList.size(); i++) {
            if ((this.getName()).equals(elementsList.get(i).getName()) && (elementsList.get(i) instanceof Shortcut)) {
                elementsList.remove(i);
                System.out.println("The shortcut has been deleted");
            }
        }
    }
}
