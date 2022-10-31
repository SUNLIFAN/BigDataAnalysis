import weka.attributeSelection.PrincipalComponents;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Standardize;


public class PCA {
    public static void main(String[] args) throws Exception {
        // load data
        Instances dataset = DataSource.read("src/dataset/dimension_reduce/cpu.arff");
        dataset.setClassIndex(dataset.numAttributes() - 1);

        // standardize data
        Standardize std = new Standardize();
        std.setInputFormat(dataset);
        dataset = Filter.useFilter(dataset, std);

        // do dimension reduction
        PrincipalComponents reducer = new PrincipalComponents();
        reducer.buildEvaluator(dataset);

        // output result: eigen value and eigen vectors
        System.out.println(reducer);
    }
}
