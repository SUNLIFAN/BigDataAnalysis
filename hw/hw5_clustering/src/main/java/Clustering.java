
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;

public class Clustering {
    public static void main(String[] args) throws Exception {
        // load dataset
        Instances dataset = DataSource.read("src/cluster/bmw-browsers.arff");
        SimpleKMeans kmeans = new SimpleKMeans();

        kmeans.setNumClusters(5);

        kmeans.buildClusterer(dataset);

        System.out.println(kmeans);
    }
}
