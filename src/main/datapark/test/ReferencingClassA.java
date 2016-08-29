package datapark.test;

/**
 * Created by dpliyuan on 2016/3/4.
 */
public class ReferencingClassA {
    private final static String CLAZZ = ReferencingClassA.class.getName();

    static {

        System.out.println("Classloading of " + CLAZZ + " in progress..."
                + ClassloaderUtil.getCurrentClassloaderDetail());

    }
    public ReferencingClassA() {

        System.out.println("Creating a new instance of "
                + ReferencingClassA.class.getName() + "...");
//        Maps.newHashMap();

    }
    public void doSomething() {

        // nothing to do...

    }
}
