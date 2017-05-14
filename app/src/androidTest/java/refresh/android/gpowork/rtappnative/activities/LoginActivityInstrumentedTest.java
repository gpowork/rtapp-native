package refresh.android.gpowork.rtappnative.activities;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by gpowork on 14/05/2017.
 */

@RunWith(AndroidJUnit4.class)
public class LoginActivityInstrumentedTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("refresh.android.gpowork.rtappnative", appContext.getPackageName());
    }
}
