package Manager;

import Manager.Element;

import java.util.ArrayList;
import java.util.List;

public class File extends Element {

    public int size;
    private String name;
    public List<Element> elementsList;

    public File(String name, int size, List<Element> elementsList) {
        super(name);
        this.size = size;
        this.elementsList = elementsList;
    }

    public void displayElement() {
        for (Element element : elementsList) {
            System.out.println(element);
        }
    }

    public void create(Element file) {
        for (Element element : elementsList) {
            if ((file.getName()).equals(element.getName()) && (element instanceof File)) {
                System.out.println("The file already exists");
            }
            elementsList.add(file);
        }
    }

    public void search(Element file) {
        for (Element element : elementsList) {
            if ((file.getName()).equals(element.getName()) && (element instanceof File)) {
                System.out.println("The file exists");
            }
        }
        System.out.println("The file does not exist");
    }

    public int getSize() {
        return size;
    }

    public void modify(Element file) {
        for (Element element : elementsList) {
            if ((file.getName()).equals(element.getName()) && (element instanceof File)) {
                element.setName(file.getName());
                System.out.println("The file has been modified");
            }
        }
    }

    public void delete() {
        for (int i = 0; i < elementsList.size(); i++) {
            if ((this.getName()).equals(elementsList.get(i).getName()) && (elementsList.get(i) instanceof File)) {
                elementsList.remove(i);
                System.out.println("The file has been deleted");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

