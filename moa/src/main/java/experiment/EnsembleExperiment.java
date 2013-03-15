package experiment;

import moa.DoTask;

public class EnsembleExperiment {
	public static void main(String args[]){
		/*
		 *  initialization 
		 */
		String[] algorithm = {
				"(meta.AccuracyWeightedDDMEnsemble -l (trees.HoeffdingTree)",
				"(meta.AccuracyWeightedDDMEnsemble -l (trees.HoeffdingAdaptiveTree)",
				"(meta.AccuracyWeightedDDMEnsemble -l (bayes.NaiveBayes)"
				/*"(meta.AccuracyUpdatedEnsemble3 -l (trees.HoeffdingTree) -c 21)",
				"(meta.AccuracyUpdatedEnsemble3 -l (trees.HoeffdingAdaptiveTree) -c 21)",
				"(meta.AccuracyUpdatedEnsemble3 -l (bayes.NaiveBayes) -c 21)",*/
				};
		String[] dataPath = {
				"(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_day_open_high_low_volume_closeTag.arff)",
				"(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_hour_open_high_low_volume_closeTag.arff)",
				"(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_minute_open_high_low_volume_closeTag.arff)"
				};
		String[] instanceLimit = {"3598","20269","993257"};
		String[] splitNum = {"21","119","5851"};
		String[] algorithmName = {
				" AWDE Hoeffding Tree",
				" AWDE Hoeffding Adaptive Tree",
				" AWDE Naive Bayes",
				/*"AUE Hoeffding Tree",
				"AUE Hoeffding Adaptive Tree",
				"AUE Naive Bayes"*/
				};
		String[] basePath={
				"(D:\\Dropbox\\Master work\\Ensemble\\AWDE_result\\day\\",
				"(D:\\Dropbox\\Master work\\Ensemble\\AWDE_result\\hour\\",
				"(D:\\Dropbox\\Master work\\Ensemble\\AWDE_result\\minute\\"
				};
		String[][] performancePath = new String[dataPath.length][algorithm.length];
		String[][] weightPath = new String[dataPath.length][algorithm.length];
		for(int i=0;i<basePath.length;i++)
			for(int j=0;j<algorithmName.length;j++){
				performancePath[i][j]= basePath[i]+algorithmName[j]+".csv)";
				weightPath[i][j] = basePath[i]+"Weight Record"+algorithmName[j]+".csv)";
			}
		String[][] predictPath = new String[dataPath.length][algorithm.length];
		for(int i=0;i<basePath.length;i++)
			for(int j=0;j<algorithmName.length;j++)
				predictPath[i][j] = basePath[i]+algorithmName[j]+".pred)";
		
		
		/*
		 *  run task 
		 */
		for(int i=2;i<dataPath.length;i++){
			for(int j=0;j<algorithm.length;j++){
				String[] task = {"EvaluatePrequential -l "+algorithm[j]+" -w "+weightPath[i][j]+" -t "+instanceLimit[i]+") -s (ArffFileStream -f "+dataPath[i]+") -i "+instanceLimit[i]+" -f "+splitNum[i]+" -q "+splitNum[i]}; //+" -d "+performancePath[i][j]+" -o "+predictPath[i][j]};
				System.out.println(task[0]);
				DoTask.main(task);
			}
		}	
	}
}
