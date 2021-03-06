package experiment;

import moa.DoTask;

public class EnsembleExperiment {
	public static void main(String args[]){
		/*
		 *  initialization 
		 */
		String[] algorithm = {
//				"(meta.AccuracyWeightedDDMEnsemble -l (trees.HoeffdingTree)",
				"(meta.AccuracyWeightedEnsemble -l (trees.HoeffdingTree) -c ",
				"(meta.AccuracyWeightedEnsemble -l (trees.HoeffdingAdaptiveTree) -c ",
				"(meta.AccuracyWeightedEnsemble -l (bayes.NaiveBayes) -c ",
				"(meta.AccuracyUpdatedEnsemble1 -l (trees.HoeffdingTree) -c ",
				"(meta.AccuracyUpdatedEnsemble1 -l (trees.HoeffdingAdaptiveTree) -c ",
				"(meta.AccuracyUpdatedEnsemble1 -l (bayes.NaiveBayes) -c ",
				};
		String[] dataPath = {
				"(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_day_open_high_low_volume_closeTag.arff)",
				"(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_hour_open_high_low_volume_closeTag.arff)",
				"(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_minute_open_high_low_volume_closeTag.arff)"
				};
		String[] instanceLimit = {"3598","20269","993257"};
		String[] splitNum = {"21","119","5851"};
		String[] tmpSplitNum = {"17","95","4681"}; //smaller than a month num
		String[] algorithmName = {
				/*
				" AWDE Hoeffding Tree",
				" AWDE Hoeffding Adaptive Tree",
				" AWDE Naive Bayes",
				*/
				"AWE Hoeffding Tree",
				"AWE Hoeffding Adaptive Tree",
				"AWE Naive Bayes",
				"AUE Hoeffding Tree",
				"AUE Hoeffding Adaptive Tree",
				"AUE Naive Bayes"
				};
		String[] basePath={
				"(D:\\Dropbox\\Master work\\Ensemble\\result\\day\\",
				"(D:\\Dropbox\\Master work\\Ensemble\\result\\hour\\",
				"(D:\\Dropbox\\Master work\\Ensemble\\result\\minute\\"
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
		for(int i=0;i<dataPath.length;i++){
			for(int j=0;j<algorithm.length;j++){
				String[] task = {"EvaluatePrequential -l "+algorithm[j]+tmpSplitNum[i]+") -s (ArffFileStream -f "+dataPath[i]+") -i "+instanceLimit[i]+" -f "+splitNum[i]+" -q "+splitNum[i]+" -d "+performancePath[i][j]+" -o "+predictPath[i][j]};
				/**
				 *	weight record 
				 */
				//String[] task = {"EvaluatePrequential -l "+algorithm[j]+" -w "+weightPath[i][j]+" -t "+instanceLimit[i]+") -s (ArffFileStream -f "+dataPath[i]+") -i "+instanceLimit[i]+" -f "+splitNum[i]+" -q "+splitNum[i]}; 
				System.out.println(task[0]);
				DoTask.main(task);
			}
		}	
	}
}
