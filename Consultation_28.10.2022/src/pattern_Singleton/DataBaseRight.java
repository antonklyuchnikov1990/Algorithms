package pattern_Singleton;

public class DataBaseRight {

    private static DataBaseRight instance;

    private DataBaseRight() {}

    public static DataBaseRight getInstance() {
        if (instance == null) {
            instance = new DataBaseRight();
        }
        return instance;
    }
}
