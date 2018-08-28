package bot;


import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Base {

    public static List<User> generatedUsers = new ArrayList<>();

    public static List<User> userList;

    static String BaseName = "userBase.ser";
    public static String lastUser;

    public static int getSize() {
        return userList.size();
    }

    public static void saveUsers() {
        try {
            FileOutputStream fos = null;
            ObjectOutputStream out = null;
            fos = new FileOutputStream(BaseName);
            out = new ObjectOutputStream(fos);

            for (int i = 0; i < userList.size(); ++i) {
                out.writeObject(userList.get(i));
            }

            out.close();
            //userList = null;
        } catch (Exception ex) {
            System.out.println("Users not saved.");
        }
        System.out.println("base saved.");
    }

    public static void restoreUserBase() {
        userList = new ArrayList<>();
        try {
            FileInputStream fis = null;
            ObjectInputStream in = null;
            fis = new FileInputStream(BaseName);
            in = new ObjectInputStream(fis);

            for (; ; ) {
                try {
                    userList.add((User) in.readObject());
                    //System.out.println("restored");
                } catch (EOFException exc) {
                    System.out.println("all users are restored");
                    break;
                }
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("number of users = " + userList.size());
    }

    private static void initUsers() {
        userList = new ArrayList<>();
    }


    public static void showUsers() {
        System.out.println("showUsers:");
        //System.out.println( userList.size());
        for (int i = 0; i < userList.size(); ++i) {
            System.out.print(userList.get(i).name);
            System.out.print(" " + userList.get(i).soname);
            System.out.print(" " + userList.get(i).email);
            System.out.println(" " + userList.get(i).password);
        }
    }

    public static User getRandomUser(Boolean isFirstTime) {

        if (isFirstTime) {

            int r = new Random().nextInt(userList.size());
            Base.lastUser = userList.get(r).email;
            System.out.println("getRandomUser: " + Base.lastUser);
            return userList.get(r);

        } else {
            int r = new Random().nextInt(userList.size());

            while (Base.lastUser.equals(userList.get(r).email)){
                r = new Random().nextInt(userList.size());
            }
            Base.lastUser = userList.get(r).email;
            System.out.println("getRandomUser: " + Base.lastUser);
            return userList.get(r);
        }


    }

    public static void generateNewUsers(int number) {
        System.out.println("generateNewUsers:");

        BaseNameList baseNameList = new BaseNameList();
        BaseSonameList baseSonameList = new BaseSonameList();


        for (int i = 0; i < number; ++i) {
            User u = new User("", "", "", "");

            u.name = baseNameList.getRandomName();
            u.soname = baseSonameList.getRandomSoname();
            u.email = (u.name + "." + u.soname + Math.abs((new Random().nextInt() / 121))).toLowerCase();
            u.password = "Qa5557575";
            u.language = "RU";

            int min = 1;
            int minYear = 1970;
            int day = ThreadLocalRandom.current().nextInt(min, min + 26);
            int month = ThreadLocalRandom.current().nextInt(min, min + 10);
            int year = ThreadLocalRandom.current().nextInt(minYear, minYear + 40);


            u.dateOfBirth = new GregorianCalendar();
            u.dateOfBirth.set(year, month, day);
            userList.add(u);

            System.out.print(" name: " + u.name);
            System.out.print(" soname: " + u.soname);
            System.out.print(" email: " + u.email);
            System.out.println(" pass: " + u.password);
        }
    }

    public static void addNewUser() {
        System.out.println("addNewUser:");

        String email = "donovanalexia33@gmail.com";
        String name = "Alexia";
        String soname = "Donovan";
        String pass = "Qa5557575";

        User user1 = new User(name, soname, email, pass);
        if (userList == null) {
            userList = new ArrayList<>();
        }
        userList.add(user1);
        System.out.println("list size = " + userList.size());
        System.out.println();
    }

    public static void add3NewUsers() {
        System.out.println("add3NewUsers:");

        String email1 = "donovanalexia33@gmail.com";
        String name1 = "Alexia";
        String soname1 = "Donovan";
        String pass1 = "Qa5557575";

        String email2 = "eleanor.takeshi12004092@gmail.com";
        String name2 = "Eleanor";
        String soname2 = "Takeshi";
        String pass2 = "Qa5557575";

        String email3 = "eveline.nelie14556487@gmail.com";
        String name3 = "Eveline";
        String soname3 = "Nelie";
        String pass3 = "Qa5557575";


        User user1 = new User(name1, soname1, email1, pass1);
        User user2 = new User(name2, soname2, email2, pass2);
        User user3 = new User(name3, soname3, email3, pass3);

        if (userList == null) {
            userList = new ArrayList<>();
        }
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        System.out.println("list size = " + userList.size());
    }


}


