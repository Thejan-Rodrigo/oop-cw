import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration(10, 55, 70, 50);

        configuration.saveConfig(configuration);
        configuration.loadConfig();
    }
}