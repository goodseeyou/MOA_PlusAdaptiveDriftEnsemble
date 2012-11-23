package experiment;

import moa.DoTask;

public class OwnExperiment {
	public static void main(String args[]){
		/*
		 *  initialization 
		 */
		String[] algorithm = {"trees.HoeffdingTree","trees.HoeffdingAdaptiveTree","bayes.NaiveBayes","(drift.SingleClassifierDrift -l trees.HoeffdingTree)","(drift.SingleClassifierDrift -l trees.HoeffdingAdaptiveTree)","(drift.SingleClassifierDrift -l bayes.NaiveBayes)"};
		String[] dataPath = {"(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_day_open_high_low_volume_closeTag.arff)","(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_hour_open_high_low_volume_closeTag.arff)","(D:\\Dropbox\\Master work\\ver3 experiment\\data set\\ver3_minute_open_high_low_volume_closeTag.arff)"};
		String instanceLimit = "1000000";
		String[] splitNum = {"21","119","5851"};
		String[] algorithmName = {"Hoeffding Tree","Hoeffding Adaptive Tree","Naive Bayes","Drift Hoeffding Tree","Drift Hoeffding Adaptive Tree","Drift Naive Bayes"};
		String[] basePath={"(D:\\Dropbox\\Master work\\ver3 experiment\\result\\day\\","(D:\\Dropbox\\Master work\\ver3 experiment\\result\\hour\\","(D:\\Dropbox\\Master work\\ver3 experiment\\result\\minute\\"};
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
		for(int i=0;i<dataPath.length;i++){
			for(int j=0;j<algorithm.length;j++){
				String[] task = {"EvaluatePrequential -l "+algorithm[j]+" -s (ArffFileStream -f "+dataPath[i]+") -i "+instanceLimit+" -f "+splitNum[i]+" -q "+splitNum[i]+" -d "+performancePath[i][j]+" -o "+predictPath[i][j]};
				DoTask.main(task);
			}
		}	
	}
}
