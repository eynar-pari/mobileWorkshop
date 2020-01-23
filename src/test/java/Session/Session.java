package Session;

import FactoryDevices.FactoryDevices;
import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Session {

    private static Session session=null;
    private AppiumDriver driver=null;

    private Session()  {
        driver= FactoryDevices.make("androidcloud").create();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static Session getSesion()  {
        if (session==null){
            session= new Session();
        }
        return session;
    }

    public AppiumDriver getDriver(){
        return driver;
    }

    public void closeSession(){
        driver.quit();
        session=null;
    }
}
