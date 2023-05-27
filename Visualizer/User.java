package Visualizer;

import java.io.IOException;

public class User extends Individual {

    public User(int ID, String name, int pass) throws IOException {
        id = ID;
        nom = name;
        password = pass;
    }
}