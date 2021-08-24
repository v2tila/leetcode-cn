package v2tila.handcode.Pattern.Factory.FactoryMethod;

/**
 * @author v2tila on 22:17 2021/8/18
 */

public class PlayerClient {
    public static void main(String[] args){
        IHeroFactory tristanaFactory = new TristanaFactory();
        IHeroFactory swainFactory = new SwainFactory();

        tristanaFactory.select().speaking();
        swainFactory.select().speaking();
    }
}
