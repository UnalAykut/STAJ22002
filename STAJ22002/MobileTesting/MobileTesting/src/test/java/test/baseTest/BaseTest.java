package test.baseTest;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.N11Pages;
import pages.kategoriler.*;
import util.DriverFactory;
import util.ElementHelper;

import java.net.MalformedURLException;

public class BaseTest {
    protected AppiumDriver driver;
    protected KategorilerPage kategorilerPage;
    protected N11Pages n11Pages;
    /*Kategorilerin içindeki ana kategoriler*/
    protected AnneBebekKategorilerPage anneBebekKategorilerPage;
    protected ElektronikKategorilerPage elektronikKategorilerPage;
    protected EvcilHayvanUrunleriKategorilerPage evcilHayvanUrunleriKategorilerPage;
    protected EvVeYasamKategorilerPage evVeYasamKategorilerPage;
    protected KitapMuzikFilmOyunKategorilerPage kitapMuzikFilmOyunKategorilerPage;
    protected KozmetikKategorilerPage kozmetikKategorilerPage;
    protected  ModaKategorilerPage modaKategorilerPage;
    protected MucevherSaatKategorilerPage mucevherSaatKategorilerPage;
    protected OtomotivMotosikletKategorilerPage otomotivMotosikletKategorilerPage;
    protected SporOutdoorKategorilerPage sporOutdoorKategorilerPage;
    protected YurtDisiUrunlerKategorilerPage yurtDisiUrunlerKategorilerPage;
    protected ElementHelper elementHelper;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        System.out.println("setUp() metodu çalışıyor");
        this.driver = DriverFactory.initializeDriver( "Android","emulator-5554","com.dmall.mfandroid","com.dmall.mfandroid.activity.base.SplashActivity" );
        if (this.driver == null) {
            throw new RuntimeException("Driver başlatılamadı, driver null!");
        }
        intializePages();
    }

    public void intializePages(){
        elementHelper= new ElementHelper(driver);
        n11Pages = new N11Pages(driver);
        kategorilerPage = new KategorilerPage(driver);
            anneBebekKategorilerPage=new AnneBebekKategorilerPage( driver );
            elektronikKategorilerPage =new ElektronikKategorilerPage( driver );
            evcilHayvanUrunleriKategorilerPage=new EvcilHayvanUrunleriKategorilerPage( driver );
            evVeYasamKategorilerPage=new EvVeYasamKategorilerPage( driver );
            kitapMuzikFilmOyunKategorilerPage=new KitapMuzikFilmOyunKategorilerPage( driver );
            kozmetikKategorilerPage=new KozmetikKategorilerPage( driver );
            modaKategorilerPage=new ModaKategorilerPage( driver );
            mucevherSaatKategorilerPage=new MucevherSaatKategorilerPage( driver );
            otomotivMotosikletKategorilerPage=new OtomotivMotosikletKategorilerPage( driver );
            sporOutdoorKategorilerPage=new SporOutdoorKategorilerPage( driver );
            yurtDisiUrunlerKategorilerPage=new YurtDisiUrunlerKategorilerPage( driver );
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
