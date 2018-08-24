package bot;

import java.util.Random;

public class Wait {

    public static int asUser(){
        Random random = new Random();
        random.nextInt(10000);
        int wait = random.nextInt(10000);
        System.out.println("* wait: " + wait);
        return wait;
    }
}
