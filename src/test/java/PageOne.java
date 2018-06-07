import pl.easlyautomate.core.CoreMethodsImpl;
import pl.easlyautomate.core.Initializer;
import pl.easlyautomate.coreinterface.CoreMethods;

public class PageOne {

    private CoreMethods initializer;
    public PageOne(Initializer initializer){
        //this.initializer = new CoreMethodsImpl(initializer);
    }

    public PageOne DoThis(){
       // initializer.PrintDriver();
        return this;
    }
}
