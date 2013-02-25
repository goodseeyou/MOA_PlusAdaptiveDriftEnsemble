package experiment;

import moa.DoTask;

public class EnsembleExperiment {
	public static void main(String args[]){
		/*
		 *  initialization 
		 */
		String[] algorithm = {
				"(meta.AccuracyUpdatedEnsemble3 -l (trees.HoeffdingTree))",
				"(meta.AccuracyUpdatedEnsemble3 -l (trees.HoeffdingAdaptiveTree))",
				"(meta.AccuracyUpdatedEnsemble3 -l (bayes.NaiveBayes))"
				/*"(meta.AccuracyUpdatedEnsemble3 -l (trees.HoeffdingTree) -c 21)",
				"(meta.AccuracyUpdatedEnsemble3 -l (trees.HoeffdingAdaptiveTree) -c 21)",
				"(meta.AccuracyUpdatedEnsemble3 -l (bayes.NaiveBayes) -c 21)",*/
				};
		String[] dataPath = {
				"(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_day_open_high_low_volume_closeTag.arff)",
				"(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_hour_open_high_low_volume_closeTag.arff)",
				"(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_minute_open_high_low_volume_closeTag.arff)"
				};
		String instanceLimit = "1000000";
		String[] splitNum = {"21","119","5851"};
		String[] algorithmName = {
				" AUE Hoeffding Tree",
				" AUE Hoeffding Adaptive Tree",
				" AUE Naive Bayes",
				/*"AUE Hoeffding Tree",
				"AUE Hoeffding Adaptive Tree",
				"AUE Naive Bayes"*/
				};
		String[] basePath={
				"(D:\\Dropbox\\Master work\\Ensemble\\result\\day\\3DDM",
				"(D:\\Dropbox\\Master work\\Ensemble\\result\\hour\\3DDM",
				"(D:\\Dropbox\\Master work\\Ensemble\\result\\minute\\3DDM"
				};
		String[][] performancePath = new String[dataPath.length][algorithm.length];
		for(int i=0;i<basePath.length;i++)
			for(int j=0;j<algorithmName.length;j++)
				performancePath[i][j]= basePath[i]+algorithmName[j]+".csv)";
		String[][] predictPath = new String[dataPath.length][algorithm.length];
		for(int i=0;i<basePath.length;i++)
			for(int j=0;j<algorithmName.length;j++)
				predictPath[i][j] = basePath[i]+algorithmName[j]+".pred)";
		
		
		/*
		 *  run task 
		 */
		for(int i=1;i<2;i++){//i<dataPath.length;i++){
			for(int j=0;j<algorithm.length;j++){
				String[] task = {"EvaluatePrequential -l "+algorithm[j]+" -s (ArffFileStream -f "+dataPath[i]+") -i "+instanceLimit+" -f "+splitNum[i]+" -q "+splitNum[i]+" -d "+performancePath[i][j]+" -o "+predictPath[i][j]};
				DoTask.main(task);
			}
		}	
	}
}
