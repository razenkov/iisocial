package bot;

import java.util.Random;

public class BaseSonameList {
    public String getRandomSoname() {
        String soname;
        int numberOfList = new Random().nextInt(2);
            if(numberOfList == 0){
                List1 list1 = new List1();
                soname = list1.list1[new Random().nextInt(list1.list1.length)];
            } else if (numberOfList == 1){
                List2 list2 = new List2();
                soname = list2.list2[new Random().nextInt(list2.list2.length)];
            } else {
                List3 list3 = new List3();
                soname = list3.list3[new Random().nextInt(list3.list3.length)];
            }
        return soname;
    }
}
