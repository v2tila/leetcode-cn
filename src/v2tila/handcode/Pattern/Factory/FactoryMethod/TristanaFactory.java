package v2tila.handcode.Pattern.Factory.FactoryMethod;

/**
 * Tristana 's Factory
 *
 * @author v2tila on 21:53 2021/8/18
 */

public class TristanaFactory implements IHeroFactory{
    @Override
    public IHero select() {
        return new Tristana();
    }
}
