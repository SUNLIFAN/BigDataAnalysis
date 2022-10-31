import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DecisionTree {
    public static void main(String[] args) throws Exception {
        // load data
        Instances dataset = DataSource.read("src/dataset/classification/car_data.arff");
        dataset.setClassIndex(dataset.numAttributes() - 1);

        // build model
        J48 j48 = new J48();
        j48.buildClassifier(dataset);

        // print out tree structure
        System.out.println(j48);
    }
}
