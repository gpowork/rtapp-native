package refresh.android.gpowork.rtappnative.settings;

/**
 * Created by gpowork on 11/05/2017.
 */

public class GlobalSettings {

    private static final String SERVER_URL = "http://tech4trade.net/";
    private static final String LOGIN_PATH = "ajaxMDLogin.action";
    public static final String KEY_SERVER_URL = "SERVER_URL";
    public static final String KEY_USER_LOGIN = "USER_LOGIN";
    public static final String KEY_USER_HASHED_PASSWORD = "USER_HASHED_PASSWORD";



    public static String getLoginURL() {
        return SERVER_URL + LOGIN_PATH;
    }

    public static String getServerUrl() {
        return SERVER_URL;
    }

}
