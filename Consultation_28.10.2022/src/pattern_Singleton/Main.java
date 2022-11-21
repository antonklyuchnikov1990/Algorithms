package pattern_Singleton;

public class Main {
    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection("localhost", "anton", "12345");
        dataBaseConnection.connect();

        DataBaseConnection dataBaseConnection1 = new DataBaseConnection("localhost", "anton", "12345");
        dataBaseConnection1.connect();

        DataBaseRight dataBaseRight = DataBaseRight.getInstance();
        // DataBaseRight dataBaseRight1 = new DataBaseRight(); // Ошибка - нельзя создать объект через new
    }
}
