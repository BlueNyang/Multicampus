package game_project.info;

/**
 * AppInfo class provides static information about the application.
 */
public class AppInfo {
    public static final String APP_NAME = "Game Project";
    public static final String APP_VERSION = "1.0.0";
    public static final String APP_AUTHOR = "BlueNyang(GyuTae Ahn)";
    public static final String APP_DESCRIPTION = "A simple game project to demonstrate Java programming.";
    public static final String APP_WEBSITE = "https://www.bluenyang.kr";
    public static final String GITHUB_URL = "https://github.com/BlueNyang";

    // Private constructor to prevent instantiation
    private AppInfo() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Returns a formatted string containing the application information.
     * @return A string with the application name, version, author, description, and website.
     */
    public static String getAppInfo() {
        return String.format("%s v%s by %s%n  - %s\nDeveloper Website: %s%nGitHub: %s",
                APP_NAME, APP_VERSION, APP_AUTHOR, APP_DESCRIPTION, APP_WEBSITE, GITHUB_URL);
    }
}
