import pl.easlyautomate.core.Initializer;

public class Test {


    private static Initializer initializer;
    @org.junit.Test
    public void ABCTEST(){
        System.setProperty("prop.env","PRODUCTION");

        initializer = Initializer.getInstance();
        initializer.startBrowser();
    }

    @org.junit.Test
    public void nextTest(){
        PageOne op = new PageOne(initializer);
        op.DoThis();
    }
}
