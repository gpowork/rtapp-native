package refresh.android.gpowork.rtappnative.settings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import refresh.android.gpowork.rtappnative.settings.GlobalSettings;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by gpowork on 11/05/2017.
 */
@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class GlobalSettingsTest {

    @Mock private GlobalSettings globalSettings;

    @Test
    public void checkIfExist() {
        assertNotNull(globalSettings);
        assertNotNull("Static SERVER URL", globalSettings.getServerUrl());
        assertNotNull("Static KEY SERVER URL", globalSettings.KEY_SERVER_URL);
        assertNotNull("User KEY loging name", globalSettings.KEY_USER_LOGIN);
        assertNotNull("User KEY hashed password", globalSettings.KEY_USER_HASHED_PASSWORD);
        assertNotNull("Get Login URL", globalSettings.getLoginURL());
    }
}
