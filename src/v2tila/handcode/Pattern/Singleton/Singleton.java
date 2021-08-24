package v2tila.handcode.Pattern.Singleton;

/**
 * Singleton Style
 *
 * @author v2tila on 18:40 2021/8/18
 */

public class Singleton {

    private String name = "v2tila";
    private Singleton(){}

    private static class SingletonInnerClass{
        private static Singleton instance = new Singleton();
    }

    public Singleton getInstance(){
        return SingletonInnerClass.instance;
    }

    public static void main(String[] args){
        Singleton singleton = new Singleton().getInstance();
        System.out.println(singleton.name);
    }

}
