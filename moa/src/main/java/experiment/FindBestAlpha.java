package experiment;

import moa.DoTask;

public class FindBestAlpha {
	public static void main(String args[]){
		for(double alpha=0.8;alpha<1.3;alpha+=0.1){
			callRun(alpha,"_part_before");
			callRun(alpha,"_part_after");
		}
	}
	public static void callRun(double alphaOption,String part){
		/*
		 *  initialization 
		 */
		String[] algorithm = {
				"trees.HoeffdingTree",
				"trees.HoeffdingAdaptiveTree",
				"bayes.NaiveBayes",
				"(drift.SingleClassifierDrift -l trees.HoeffdingTree -d (DDM -a "+String.valueOf(alphaOption)+"))",
				"(drift.SingleClassifierDrift -l trees.HoeffdingAdaptiveTree -d (DDM -a "+String.valueOf(alphaOption)+"))",
				"(drift.SingleClassifierDrift -l bayes.NaiveBayes -d (DDM -a "+String.valueOf(alphaOption)+"))",
				};
		String[] dataPath = {
				"(D:\\Dropbox\\Master work\\ver3 experiment\\FindAlpha\\data set\\ver3_day_open_high_low_volume_closeTag"+part+".arff)",
				"(D:\\Dropbox\\Master work\\ver3 experiment\\FindAlpha\\data set\\ver3_hour_open_high_low_volume_closeTag"+part+".arff)",
				"(D:\\Dropbox\\Master work\\ver3 experiment\\FindAlpha\\data set\\ver3_minute_open_high_low_volume_closeTag"+part+".arff)"
				};
		String instanceLimit = "1000000";
		String[] splitNum = new String[3];
		if(part.equals("_part_after")){
			splitNum[0] ="16";
			splitNum[1] ="52";
			splitNum[2] ="6215";
		}
		else{
			splitNum[0] ="16";
			splitNum[1] ="54";
			splitNum[2] ="6117";
		}
		String[] algorithmName = {
				"Hoeffding Tree",
				"Hoeffding Adaptive Tree",
				"Naive Bayes",
				part+" DDM Drift Hoeffding Tree"+String.valueOf(alphaOption),
				part+" DDM Drift Hoeffding Adaptive Tree"+String.valueOf(alphaOption),
				part+" DDM Drift Naive Bayes"+String.valueOf(alphaOption)
				};
		String[] basePath={
				"(D:\\Dropbox\\Master work\\ver3 experiment\\FindAlpha\\day\\",
				"(D:\\Dropbox\\Master work\\ver3 experiment\\FindAlpha\\hour\\",
				"(D:\\Dropbox\\Master work\\ver3 experiment\\FindAlpha\\minute\\"
				};
		String[][] performancePath = new String[dataPath.length][algorithm.length];
		for(int i=0;i<basePath.length;i++)
			for(int j=0;j<algorithmName.length;j++)
				performancePath[i][j]= basePath[i]+algorithmName[j]+".csv)";
				
		/*
		 *  run task 
		 */
		for(int i=0;i<dataPath.length;i++){
			for(int j=3;j<algorithm.length;j++){
				String[] task = {"EvaluatePrequential -l "+algorithm[j]+" -s (ArffFileStream -f "+dataPath[i]+") -i "+instanceLimit+" -f "+splitNum[i]+" -q "+splitNum[i]+" -d "+performancePath[i][j]};
				DoTask.main(task);
			}
		}	
	}
}
