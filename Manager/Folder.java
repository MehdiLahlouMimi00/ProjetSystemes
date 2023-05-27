package Manager;

import Manager.Element;

import java.util.ArrayList;
import java.util.List;

public abstract class Folder extends Element{

    public int size;
    private String name;
    public List<Element> elementsList;


    public Folder(String name) {
        super(name);
    }

    public void displayElement() {
        for (Element element : elementsList) {
            System.out.println(element);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSize() {
        int i = 0;
        for (Element element : elementsList) {
            i += element.getSize();
        }

        return i;
    }



    public void Create(Element folder) {
        for (Element element : elementsList) {
            if ((folder.getName() == element.getName()) && (element instanceof Folder)) {
                System.out.println("The folder already exists");
            }
            else {
                elementsList.add(folder);
            }
        }
    }

    public void search(Element folder) {
        for (Element element : elementsList) {
            if ((folder.getName()).equals(element.getName()) && (element instanceof File)) {
                System.out.println("The file exists");
            }
        }
        System.out.println("The file does not exist");
    }


    public void modify(Element folder) {
        for (Element element : elementsList) {
            if ((folder.getName()).equals(element.getName()) && (element instanceof Folder)) {
                element.setName(folder.getName());
                System.out.println("The folder has been modified");
            }
        }
    }

    public void delete() {
        for (int i = 0; i < elementsList.size(); i++) {
            if ((this.getName()).equals(elementsList.get(i).getName()) && (elementsList.get(i) instanceof Folder)) {
                elementsList.remove(i);
                System.out.println("The folder has been deleted");
            }
        }
    }



}
