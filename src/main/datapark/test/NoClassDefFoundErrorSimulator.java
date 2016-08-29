package datapark.test;

/**
 * Created by dpliyuan on 2016/3/4.
 */
public class NoClassDefFoundErrorSimulator {

    public static void main(String[] args) {

        System.out.println("java.lang.NoClassDefFoundError Simulator");

        // Print current Classloader context

        System.out.println("\nCurrent ClassLoader chain: "
                + ClassloaderUtil.getCurrentClassloaderDetail());

        // 1. Create a new instance of CallerClassA

        CallerClassA caller = new CallerClassA();

        // 2. Execute method of the caller

//        caller.doSomething();

        System.out.println("done!");

    }
}
