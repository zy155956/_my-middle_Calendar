package otherTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nike on 06.08.2017.
 */
public class Generics {
    public static void main(String[] args) {
        List<? extends Object> list = new ArrayList<>();
        List<? super Object> list2 = new ArrayList<>();

        //list.add("asd");
        list2.add("sdf");

    }
}
