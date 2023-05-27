package Visualizer;

import java.io.*;

public class Individual {
    public Individual() throws IOException {
    }

    public int id;
    public File users = new File("G://userlogin");
    boolean a = users.createNewFile();
    public File admins = new File("G://adminlogin");
    boolean b = admins.createNewFile();

    public String nom;
    public int password;

    public int login() throws IOException {
        int log = 0;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(users));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while ((line = in.readLine()) != null) {
            if (new StringBuilder().append(id).append(nom).append(password).toString().equals(line)) {
                log += 1;
            }
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return log;
    }

    public void creer_fich(String path) throws IOException {
        int access = login();
        if (access != 0) {
            try {
                File file = new File(path);

                if (file.createNewFile()) {
                    System.out.println("File created");
                } else {
                    System.out.println("File already exists");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("user not found");
        }
    }

    public void mod_fich(String path) throws IOException {
        int access = login();
        if (access != 0) {
            Runtime rs = Runtime.getRuntime();
            try {
                rs.exec("notepad " + path);
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("user not found");
        }
    }

    public void sup_fich(String path) throws IOException {
        int access = login();
        if (access != 0) {
            try {
                File f = new File(path);
                if (f.delete()) {
                    System.out.println(f.getName() + " deleted");
                } else {
                    System.out.println("failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("user not found");
        }
    }

    public void creer_dos(String path) throws IOException {
        int access = login();
        if (access != 0) {
            File file = new File(path);

            if (file.exists()) {
                System.out.println("The folder already exists: " + file.getAbsolutePath());
            } else {
                if (file.mkdir()) {
                    System.out.println("Folder added: " + file.getAbsolutePath());
                } else {
                    System.out.println("Failed: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("user not found");
        }
    }

    public void mod_dos(String path, String action) throws IOException {
        int access = login();
        if (access != 0) {
            File file = new File(path);
            if (action.equals("add_folder")) {
                File file1 = new File(path + "\\");
                if (file1.exists()) {
                    System.out.println("The folder already exists: " + file1.getAbsolutePath());
                } else {
                    if (file.mkdir()) {
                        System.out.println("Add the folder: " + file1.getAbsolutePath());
                    } else {
                        System.out.println("Failed adding the folder: " + file1.getAbsolutePath());
                    }
                }
            } else if (action.equals("add_file")) {
                try {
                    File file1 = new File(path + "\\");
                    if (file1.createNewFile()) {
                        System.out.println("File created!");
                    } else {
                        System.out.println("File already exists");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("user not found");
        }
    }

    public void sup_dos(String path) throws IOException {
        int access = login();
        if (access != 0) {
            try {
                File f = new File(path);
                if (f.delete()) {
                    System.out.println(f.getName() + " deleted");
                } else {
                    System.out.println("failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("user not found");
        }
    }

}
            }
