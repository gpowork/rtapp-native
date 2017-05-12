package refresh.android.gpowork.rtappnative.refresh.android.gpowork.rtappnative.settings;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
        assertNotNull("Static SERVER URL", globalSettings.SERVER_URL);
        assertNotNull("User loging name", globalSettings.USER_LOGIN);
        assertNotNull("User hashed password", globalSettings.USER_HASHED_PASSWORD);
    }
}
