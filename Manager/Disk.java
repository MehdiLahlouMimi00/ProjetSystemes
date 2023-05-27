package Manager;

import java.util.ArrayList;
import java.util.List;

public abstract class Disk {
    private String diskName = "F";
    private List<User> userList = new ArrayList<>();
    private List<User> adminList = new ArrayList<>();

    public Disk(String name) {
        diskName = name;
    }

    public String getDiskName() {
        return diskName;
    }

    public List<User> getUsers() {
        return userList;
    }

    public List<User> getAdmins() {
        return adminList;
    }

    public boolean addAdmin(String name, String password) {
        User admin = new User(name, password);
        if (!adminList.contains(admin)) {
            adminList.add(admin);
            return true;
        } else {
            return false;
        }
    }

    public boolean addUser(String name, String password) {
        User user = new User(name, password);
        if (!userList.contains(user)) {
            userList.add(user);
            return true;
        } else {
            return false;
        }
    }

    private class User {
        private String name;
        private String password;

        public User(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            User user = (User) obj;
            return name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }
}

