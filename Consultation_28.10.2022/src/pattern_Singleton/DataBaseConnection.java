package pattern_Singleton;

public class DataBaseConnection {

    private String url;
    private String login;
    private String password;


    public DataBaseConnection(String url, String login, String password) {
        // Организуем подключение к базе дынных по адресу url с помощью login-password
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public void connect() {}
}
