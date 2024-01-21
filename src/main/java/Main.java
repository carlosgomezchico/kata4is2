package PACKAGE_NAME;
public class Main {
    public static void main(String[] args) {
        DatasetLoader loader = new DatasetLoader();
        List<DatasetRecord> records = loader.loadDataFromDB("ruta/a/tu/baseDeDatos.db");

        DataProcessor processor = new DataProcessor();
        // Supongamos que queremos un histograma de edades
        Map<Integer, Integer> histogram = processor.generateAgeHistogram(records);

        DataVisualizer visualizer = new DataVisualizer();
        visualizer.displayHistogram(histogram);
    }
}

