package notJUnit;



import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by Nike on 31.07.2017.
 */
public class Test1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        double numb = 5.5/0.0;
        int b = 13;
        b &= ~(1<<2);
        Integer i = 5;
        Long l = (long)i;
        Short sh = (short)b;
        System.out.println(Integer.toBinaryString(13));
        System.out.println(Integer.toBinaryString(1<<2));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.valueOf(Integer.toHexString(55)));

        i.intValue(); //возвращает примитивный тип
        number(i);
        ThreadGroup group1 = new Thread().getThreadGroup();
        ThreadGroup group2 = Thread.currentThread().getThreadGroup();
        ThreadGroup group3 = new ThreadGroup(group2, "gruop3"); //добавляем в группу подгруппу
        Thread thread1 = new Thread(group1, new Runnable() {
            @Override
            public void run() {

            }
        }); //добавляем новосозданную нить в группу
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
        System.out.println(""+Thread.currentThread().getThreadGroup().getParent().getParent().getName());

        Collection collection = new ArrayList();
        Iterator iter = collection.iterator();
        File file = new File("sdf");
        file.toPath();
        Properties prop = new Properties();
        /*ByteArrayInputStream inArray = new ByteArrayInputStream();
        ByteArrayOutputStream outArray = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream();
        PrintWriter printWriter = new PrintWriter();*/
    }

    public static void number(int integer){}
}
