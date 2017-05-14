package refresh.android.gpowork.rtappnative;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import refresh.android.gpowork.rtappnative.settings.GlobalSettings;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by gpowork on 11/05/2017.
 */
@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class MainActivityTest {

    @Spy MainActivity mainActivity;

    @Test
    public void checkIfUserAuthorized() {
        assertFalse(mainActivity.checkIfUserAuthorized());
        verify(mainActivity).retrieveDataFromStorage();
        verify(mainActivity).getPreferences(Context.MODE_PRIVATE);
        when(mainActivity.retrieveDataFromStorage())
                .thenReturn(null);
        assertFalse("If no records then must return false.", mainActivity.checkIfUserAuthorized());
        when(mainActivity.retrieveDataFromStorage())
                .thenReturn(new HashMap<String, Object>());
        assertFalse("If there are empty records then must return false", mainActivity.checkIfUserAuthorized());

        Map<String, Object> map = new HashMap<>();
        map.put(GlobalSettings.USER_LOGIN, null);
        map.put(GlobalSettings.USER_HASHED_PASSWORD, null);

        when(mainActivity.retrieveDataFromStorage())
                .thenReturn(map);
        assertFalse("If there are empty records then must return false", mainActivity.checkIfUserAuthorized());

        map.put(GlobalSettings.USER_LOGIN, "login");
        map.put(GlobalSettings.USER_HASHED_PASSWORD, "hash");

        assertTrue("If there are empty records then must return true", mainActivity.checkIfUserAuthorized());
    }

    @Test
    public void checkIfRunDispatcher() {
        // Check if it calls checkIfUserAuthorized
        mainActivity.runDispatcher();
        verify(mainActivity).checkIfUserAuthorized();
    }

    @Test
    public void checkIfOpenLoginPage() {
        // Check if System show login page when checkIfUserAuthorized returns false
        when(mainActivity.checkIfUserAuthorized())
                .thenReturn(false);
        mainActivity.runDispatcher();
        verify(mainActivity).startLoginActivity();
    }

    @Test
    public void checkIfOpenQCHomePage(){
        when(mainActivity.checkIfUserAuthorized())
                .thenReturn(true);
        mainActivity.runDispatcher();
        verify(mainActivity).startQcProjectsPage();
    }
}
