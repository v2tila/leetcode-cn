package v2tila.handcode.Pattern.Factory.FactoryMethod;

/**
 * @author v2tila on 22:16 2021/8/18
 */

public class SwainFactory implements IHeroFactory{

    @Override
    public IHero select() {
        return new Swain();
    }
}
