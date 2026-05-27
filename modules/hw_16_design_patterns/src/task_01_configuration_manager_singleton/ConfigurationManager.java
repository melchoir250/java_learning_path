package task_01_configuration_manager_singleton;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private String storagePath;
    private String logLevel;

    private ConfigurationManager() {
        this.dbUrl = "jdbc:postgresql://localhost:5432/my_db";
        this.dbUser = "admin";
        this.dbPassword = "super_secret_password";
        this.storagePath = "/var/www/uploads";
        this.logLevel = "INFO";
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
}
