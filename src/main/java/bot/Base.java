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

    public static int getSize(){
        return  userList.size();
    }

    public static void saveUsers() {
        try {
            FileOutputStream fos = null;
            ObjectOutputStream out = null;
            fos = new FileOutputStream(BaseName);
            out = new ObjectOutputStream(fos);

            for (int i = 0; i < userList.size(); ++i) {

                out.writeObject(userList.get(i));
            System.out.println(userList.get(i).email + " saved");
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

            for (;;) {
                try {
                    userList.add((User) in.readObject());
                    System.out.println("restored");
                } catch (EOFException exc) {
                    System.out.println("all users are restored");
                    break;
                }
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(userList.size() + " number of users");
        System.out.println();
    }

    private static void initUsers() {
        userList = new ArrayList<>();

//        User user1 = new User("donovanalexia33@gmailcom", "Qa5557575");
//        User user2 = new User("prodkin.nick@gmail.com", "Qa5557575");
//        User user3 = new User("eva.thomposon@gmail.com", "e1v2a3t4");

//        userList.add(user1);
////        System.out.println(user1.email + " - inited");
//        userList.add(user2);
////        System.out.println(user2.email + " - inited");
//        userList.add(user3);
////        System.out.println(user3.email + " - inited");
//        System.out.println("base inited.");

    }


    public static void showUsers() {
        System.out.println("current base:");
        System.out.println( userList.size());
        for (int i = 0; i < userList.size(); ++i) {
            System.out.print(userList.get(i).name);
            System.out.print(" " + userList.get(i).soname);
            System.out.print(" " +userList.get(i).email);
            System.out.println(" " + userList.get(i).password);
            //System.out.print(userList.get(i).dateOfBirth);
//            System.out.println(i);;
        }
    }

    public static User getRandomUser() {
        int temp = new Random().nextInt(1);
        System.out.println(temp);
        int temp1 = Math.abs(temp);
        User u = userList.get(0);
        return u;
    }

    public static void generateNewUsers(int number) {
        BaseNameList baseNameList = new BaseNameList();
        BaseSonameList baseSonameList = new BaseSonameList();



        for (int i = 0; i < number; ++i) {
            User u = new User("","","","");

            u.name = baseNameList.getRandomName();
            u.soname = baseSonameList.getRandomSoname();
            u.email = (u.name + "." + u.soname + Math.abs((new Random().nextInt() / 121))).toLowerCase();
            u.password = u.name + new Random().nextInt() + u.soname;
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

    public static void addNewUser(){
        String email = "donovanalexia33@gmail.com";
        String name = "Alexia";
        String soname = "Donovan";
        String pass = "Qa5557575";

        User user1 = new User(name, soname, email, pass);
        if (userList == null){
            userList = new ArrayList<>();
        }
        userList.add(user1);
        System.out.println("list size = " +  userList.size());
        System.out.println();
    }



}


