package experiment;

import moa.DoTask;

public class Ver4Experiment {
	public static void main(String args[]){
		
		String algorithms[] = {
				"trees.HoeffdingTree",
				"trees.HoeffdingAdaptiveTree",
				"bayes.NaiveBayes",
				"(drift.SingleClassifierDrift -l trees.HoeffdingTree)",
				"(drift.SingleClassifierDrift -l trees.HoeffdingAdaptiveTree)",
				"(drift.SingleClassifierDrift -l bayes.NaiveBayes)",
				"(meta.AccuracyWeightedEnsemble -l (trees.HoeffdingTree) -c 21)",
				"(meta.AccuracyWeightedEnsemble -l (trees.HoeffdingAdaptiveTree) -c 21)",
				"(meta.AccuracyWeightedEnsemble -l (bayes.NaiveBayes) -c 21)",
				"(meta.AccuracyUpdatedEnsemble1 -l (trees.HoeffdingTree) -c 21)",
				"(meta.AccuracyUpdatedEnsemble1 -l (trees.HoeffdingAdaptiveTree) -c 21)",
				"(meta.AccuracyUpdatedEnsemble1 -l (bayes.NaiveBayes) -c 21)",
				"(meta.AccuracyWeightedDDMEnsemble -l (trees.HoeffdingTree))",
				"(meta.AccuracyWeightedDDMEnsemble -l (trees.HoeffdingAdaptiveTree))",
				"(meta.AccuracyWeightedDDMEnsemble -l (bayes.NaiveBayes))"
				};	
		String algorithmName[] = {
				"Hoeffding Tree",
				"Hoeffding Adaptive Tree",
				"Naive Bayes",
				"Drift Hoeffding Tree",
				"Drift Hoeffding Adaptive Tree",
				"Drift Naive Bayes",
				"AWE Hoeffding Tree",
				"AWE Hoeffding Adaptive Tree",
				"AWE Hoeffding Naive Bayes",
				"AUE Hoeffding Tree",
				"AUE Hoeffding Adaptive Tree",
				"AUE Naive Bayes",
				"ADE Hoeffding Tree",
				"ADE Hoeffding Adaptive Tree",
				"ADE Naive Bayes"
		};
		
		for(int i=0;i<algorithmName.length;i++){
			System.out.println("----------------------------------");
			System.out.println(algorithmName[i]);
			String[] task = {"EvaluateModel -m (LearnModel -l "+algorithms[i]+" -s (ArffFileStream -f (D:\\Dropbox\\Master work\\ver4 experiment\\training.arff))) -s (ArffFileStream -f (D:\\Dropbox\\Master work\\ver4 experiment\\testing.arff))"};
			DoTask.main(task);
			System.out.println("----------------------------------");
		}
		
	}
}
