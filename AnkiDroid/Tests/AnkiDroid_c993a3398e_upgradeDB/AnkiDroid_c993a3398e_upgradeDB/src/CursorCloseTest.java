import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class CursorCloseTest {
	AppiumDriver driver;

    final String APP_PACKAGE = "com.ichi2.anki";
    final String APP_ACTIVITY = "com.ichi2.anki.DeckPicker";
    
    @Before
    public void SetUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidTestDevice");
        capabilities.setCapability(MobileCapabilityType.VERSION,"4.1.1");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //wait the activity
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, APP_ACTIVITY);

    }

    @Test
    public void TestRun() throws IOException, InterruptedException{
    	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/"
    			+ "android.widget.LinearLayout/android.widget.FrameLayout/"
    			+ "android.widget.FrameLayout/android.widget.FrameLayout/"
    			+ "android.support.v4.widget.DrawerLayout/android.view.View/"
    			+ "android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/"
    			+ "android.widget.RelativeLayout/android.widget.LinearLayout[1]/"
    			+ "android.widget.TextView")).click();
    }
}