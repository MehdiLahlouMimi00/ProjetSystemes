package Visualizer;

import java.io.*;

public class Admin extends Individual {

    public Admin(int ID, String name, int pass) throws IOException {
        userId = ID;
        username = name;
        password = pass;
    }

    @Override
    public int login() throws IOException {
        int log = 0;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(admins));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        while ((line = in.readLine()) != null) {
            if (userId + username + password == line) {
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

    public void addUser(int ID, String name, int pass) throws IOException {
        int access = login();
        if (access != 0) {
            try (FileWriter f = new FileWriter("userlogin", true);
                 BufferedWriter b = new BufferedWriter(f);
                 PrintWriter p = new PrintWriter(b);) {

                p.println(new StringBuilder().append('\n').append(ID).append(name).append(pass).toString());

            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }

    public void deleteUser(int ID, String name, int pass) throws IOException {
        int access = login();
        if (access != 0) {
            File inputFile = new File("G:/userlogin");
            File tempFile = new File("G:/myTempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = new StringBuilder().append(ID).append(name).append(pass).toString();
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);
        }
    }

    public void addAdmin(int ID, String name, int pass) throws IOException {
        int access = login();
        if (access != 0) {
            try (FileWriter f = new FileWriter("userlogin", true);
                 BufferedWriter b = new BufferedWriter(f);
                 PrintWriter p = new PrintWriter(b);) {

                p.println(new StringBuilder().append('\n').append(ID).append(name).append(pass).toString());

            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }

    public void deleteAdmin(int ID, String name, int pass) throws IOException {
        int access = login();
        if (access != 0) {
            File inputFile = new File("G:/userlogin");
            File tempFile = new File("G:/myTempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = new StringBuilder().append(ID).append(name).append(pass).toString();
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);
        }
    }
}
