package moa.classifiers.meta;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class WeightRecordContener {
	private class WeightRecorder{
		double weight[];
		int classifierID[];
		public WeightRecorder(int idArray[],double weightArray[]){
			this.classifierID = idArray;
			this.weight = weightArray;
		}
	}
	private class ClassifierWeight{
		private int classifierID;
		private ArrayList<Double> weight = new ArrayList<Double>();
		private int startInst;
		private int endInst;
		
		public ClassifierWeight(int id,int currentInst,double initWeight){
			this.classifierID = id;
			this.startInst = currentInst;
			addNewWeight(initWeight);
		}
		public int setEndInst(int inst){
			this.endInst = inst;
			return this.endInst;
		}
		public double addNewWeight(double weight){
			this.weight.add(weight);
			return this.weight.get(this.weight.size()-1);
		}
		public int getStartInst(){
			return this.startInst;
		}
		public int getEndInst(){
			return this.endInst;
		}
		public ArrayList<Double> getWeights(){
			return this.weight;
		}
		public double getWeight(int index){
			return this.weight.get(index);
		}
		
	}
	
	ArrayList<WeightRecorder> weightRecorder;
	ArrayList<ClassifierWeight> classifierWeight;
	int currentUnusedID;
	int currentIDs[];
	int processInsts;
	int weightProcessInsts;
	
	
	public WeightRecordContener(int size){
		this.currentUnusedID=0;
		this.weightRecorder = new ArrayList<WeightRecorder>();
		this.classifierWeight = new ArrayList<ClassifierWeight>();
		this.processInsts=0;
		this.currentIDs = new int[size];
		for(int i=0;i<size;i++)
			this.currentIDs[i] = -1;
		this.weightProcessInsts=0;
		
	}
	
	public void setWeightByInst(double weight[]){
		this.weightRecorder.add(this.processInsts, new WeightRecorder(this.currentIDs,weight));
		for(int i=0;i<weight.length;i++){
			/**/
			if(this.classifierWeight.size()<currentIDs[i]){
				System.out.println(currentIDs[i]+" is null");
				System.exit(0);
			}
			/**/
			this.classifierWeight.get(this.currentIDs[i]).addNewWeight(weight[i]);
			//System.out.print(this.currentIDs[i]+":"+weight[i]+", ");
		}
		//System.out.println();
		this.processInsts++;
	}
	
	public void addNewID(int index,double weight){
		if(this.currentIDs[index]>=0 && this.currentIDs[index]<this.currentUnusedID){
			/**/
			/*System.out.println(index+" "+this.currentIDs[index]);
			System.exit(0);*/
			/**/
			ClassifierWeight temp = this.classifierWeight.get(this.currentIDs[index]);
			temp.setEndInst(this.processInsts);
			/*
			String writer = "";
			writer += currentIDs[index];
			for(int i=0;i<temp.getStartInst();i++)
				writer+=",0";
			for(int i=0;i<temp.getWeights().size();i++){
				writer+= ",";
				writer+=temp.getWeight(i);
			}
			writer+="\n";
			try{
				fw.write(writer);
			}
			catch(IOException e){}
			*/
			/*
			System.out.print(currentIDs[index]);
			for(int i=0;i<temp.getStartInst();i++)
				System.out.print(",");
			for(int i=0;i<temp.getWeights().size();i++)
				System.out.print(","+temp.getWeight(i));
			System.out.println();*/
		}
		this.currentIDs[index] = this.currentUnusedID;
		this.classifierWeight.add(new ClassifierWeight(this.currentIDs[index],this.processInsts,weight));
		this.currentUnusedID++;
		
		/**/
		if(this.classifierWeight.size()!=currentIDs[index]+1){
			System.out.println("not equal!");
			System.exit(0);
		}
		/**/	
		
	}
	
	public void write(String input,int limitSize) throws Exception{
			FileWriter fw = new FileWriter(input);
			input += ".meta.csv";
			FileWriter metaFw = new FileWriter(input);
			metaFw.write("ID,count,mean,stdv,startInst,endInst\n");
			
			
			for(int i=0;i<classifierWeight.size();i++){
				double sum=0;
				double squareSum=0;
				metaFw.write(i+",");
				int beginingSize = classifierWeight.get(i).getStartInst();
				for(int j=0;j<beginingSize;j++){
					fw.write("-1.0,");
				}
				int classifierContentSize=classifierWeight.get(i).weight.size();
				for(int j=0;j<classifierContentSize;j++){
					Double weight = new Double(classifierWeight.get(i).getWeight(j));
					fw.write(String.valueOf(weight));
					if(weight.isInfinite() || weight>(sum/(double)j*3.0))
						weight = (sum+Double.MIN_VALUE)/(double)(j+Double.MIN_VALUE)*3.0; // give a relatedly big number instead of infinite value
					sum+=weight;
					squareSum += Math.pow(weight, 2);
					if(j<classifierContentSize-1)
						fw.write(",");
				}
				int component = limitSize - beginingSize - classifierContentSize;
				for(int k=0;k<component;k++){
					fw.write(",-1.0");
				}
				fw.write("\n");
				double mean = sum / (double) classifierContentSize;
				double stdv = Math.pow((squareSum / (double) classifierContentSize - Math.pow(mean, 2)),0.5);
				metaFw.write(classifierContentSize+","+mean+","+stdv+","+beginingSize+","+classifierWeight.get(i).getEndInst());
				metaFw.write("\n");
				System.out.println("classifier "+i+" finished.");
				mean=0;
				stdv=0;
			}
			fw.close();
			metaFw.close();
        
	}
	
}
