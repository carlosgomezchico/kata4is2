package PACKAGE_NAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatasetLoader {
    public List<DatasetRecord> loadDataFromDB(String urlDB) {
        List<DatasetRecord> records = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + urlDB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tuTabla");

            while (resultSet.next()) {
                // Asumiendo que la tabla tiene columnas: edad, nombre, ciudad
                DatasetRecord record = new DatasetRecord(
                        resultSet.getInt("edad"),
                        resultSet.getString("nombre"),
                        resultSet.getString("ciudad")
                );
                records.add(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
}

