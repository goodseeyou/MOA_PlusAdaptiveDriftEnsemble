/*
 *    RuleClassifier.java
 *    Copyright (C) 2012 University of Porto, Portugal
 *    @author P. Kosina, E. Almeida, J. Gama
 *
<<<<<<< HEAD
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program. If not, see <http://www.gnu.org/licenses/>.
=======
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
 *    
 *    
 */

package moa.classifiers.rules;

<<<<<<< HEAD
import java.util.*; 
=======
import java.math.BigDecimal;
import java.util.*; 

>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
import moa.classifiers.AbstractClassifier;
import moa.classifiers.core.attributeclassobservers.*;
import moa.classifiers.core.attributeclassobservers.BinaryTreeNumericAttributeClassObserver.Node;
import moa.core.AutoExpandVector;
import moa.core.DoubleVector;
import moa.core.Measurement;
import moa.core.StringUtils;
import moa.options.FlagOption;
import moa.options.FloatOption;
import moa.options.IntOption;
import moa.options.MultiChoiceOption;
<<<<<<< HEAD
import weka.core.Instance;
import weka.core.Utils;
=======
//import samoa.instances.Instance;
import weka.core.Instance;
import weka.core.Utils;
//import moa.core.Utils;
import java.io.*;

>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f


/**
 * This classifier learn ordered and unordered rule set from data stream.
<<<<<<< HEAD
=======
 * This algorithm also does the detection of anomalies.
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
 * 
 * <p>Learning Decision Rules from Data Streams, IJCAI 2011, J. Gama,  P. Kosina </p>
 *
 * 
 * <p>Parameters:</p>
 * <ul>
 * <li> -p: Minimum value of p </li>
 * <li> -t: Tie Threshold </li>
 * <li> -c: Split Confidence </li>
 * <li> -g: GracePeriod, the number of instances a leaf should observe between split attempts </li>
 * <li> -o: Prediction function to use. Ex:FirstHit </li>
 * <li> -r: Learn ordered or unordered rule </li>
 * </ul>
 * 
 * @author P. Kosina, E. Almeida, J. Gama
<<<<<<< HEAD
 * @version $Revision: 1 $
=======
 * @version $Revision: 2 $
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
 */

public class RuleClassifier extends AbstractClassifier{
	
	  private static final long serialVersionUID = 1L;
	  
	  @Override
	  public String getPurposeString() {
	        return "Rule Classifier.";
	    }
	  
	  protected Instance instance; 
	  
	  protected AutoExpandVector<AttributeClassObserver> attributeObservers;
	  
	  protected AutoExpandVector<AttributeClassObserver> attributeObserversGauss;
	  
<<<<<<< HEAD
	  protected AutoExpandVector<AttributeClassObserver> observersTemp = new AutoExpandVector<AttributeClassObserver>(); 
	  
=======
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
	  protected DoubleVector observedClassDistribution;
	  
	  protected DoubleVector saveBestEntropy = new DoubleVector();		// Saves the best value of entropy, cut_Point and symbol.
	  
	  protected DoubleVector saveBestEntropyNominalAttrib = new DoubleVector();	 	// Saves the best value of entropy and their cut_Point.
	  
<<<<<<< HEAD
	  protected ArrayList<Integer> ruleClassIndex = new ArrayList<Integer>();		// The index of the class for each rule.
	  
	  protected ArrayList<ArrayList<Double>> saveBestValGlobalEntropy = new ArrayList<ArrayList<Double>>();		// For each attribute contains the best value of entropy and its cutPoint.
	  
	  protected ArrayList<Double> saveBestGlobalEntropy = new ArrayList<Double>();		// For each attribute contains the best value of entropy.
	  
	  protected ArrayList<Double> saveTheBest = new ArrayList<Double>();		// Contains the best attribute. 
	  
	  protected ArrayList<ArrayList<Integer>> majority = new ArrayList<ArrayList<Integer>>();		// Distribution of class for each rule.
	  
	  protected ArrayList<String> ruleClassName = new ArrayList<String>();		// Name of the class for each rule.
	  
	  protected  ArrayList<Rule> ruleSet = new ArrayList<Rule>();
	  
	  double minEntropyTemp = Double.MAX_VALUE;
	  
	  double cutPointTemp = 0.0;
	  
	  double minEntropyNominalAttrib = Double.MAX_VALUE;
	  
	  double symbol = 0.0;
	  
	  int numTotalInstance = 0;
	  
	  int numAttributes = 0;
	  
	  int numClass = 0; 
	 
	  Node root;
	  
	  Predicates pred;  
=======
	  protected DoubleVector ruleClassIndex = new DoubleVector();		// The index of the class for each rule.
	  
	  protected DoubleVector saveBestGlobalEntropy = new DoubleVector();
	 
	  protected ArrayList<ArrayList<Double>> saveBestValGlobalEntropy = new ArrayList<ArrayList<Double>>();		// For each attribute contains the best value of entropy and its cutPoint.
	  
	  protected ArrayList<Double> saveTheBest = new ArrayList<Double>();		// Contains the best attribute. 
	  
	  protected ArrayList<Rule> ruleSet = new ArrayList<Rule>();
	  
	 //   protected DoubleVector ruleClassIndexAnomalis = new DoubleVector();
	  protected  ArrayList<Rule> ruleSetAnomalies = new ArrayList<Rule>();
		
	  protected ArrayList<Integer> ruleAnomaliesIndex = new ArrayList<Integer>();
	
	  protected ArrayList<ArrayList<Integer>> caseAnomaly = new ArrayList<ArrayList<Integer>>();
	  
	  protected ArrayList<ArrayList<ArrayList<Double>>> ruleAttribAnomalyStatistics = new ArrayList<ArrayList<ArrayList<Double>>>();
	  
	  protected  ArrayList<Rule> ruleSetAnomaliesSupervised = new ArrayList<Rule>();
	  
	  protected ArrayList<Integer> ruleAnomaliesIndexSupervised = new ArrayList<Integer>();
	  
	  protected ArrayList<ArrayList<Integer>> caseAnomalySupervised = new ArrayList<ArrayList<Integer>>();
	  
	  protected ArrayList<ArrayList<ArrayList<Double>>> ruleAttribAnomalyStatisticsSupervised = new ArrayList<ArrayList<ArrayList<Double>>>();
	  
	  double minEntropyTemp = Double.MAX_VALUE;
	  
	  double cutPointTemp = 0.0;
  
      double minEntropyNominalAttrib = Double.MAX_VALUE;
  
      double symbol = 0.0;
  
      int numInstance = 0;
  
      int numAttributes = 0;
  
      int numClass = 0;
      
      Node root;
  
      Predicates pred;  
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f

	  public FloatOption PminOption = new FloatOption("Pmin",
	            'p', "Percentage of the total number of example seen in the node.",
	             0.1, 0.0, 1.0);
	  
	  public FloatOption splitConfidenceOption = new FloatOption(
	            "splitConfidence",
	            'c',
	            "The allowable error in split decision, values closer to 0 will take longer to decide.",
	            0.000001, 0.0, 1.0);
	  
	  public FloatOption tieThresholdOption = new FloatOption("tieThreshold",
	            't', "Threshold below which a split will be forced to break ties.",
	             0.05, 0.0, 1.0);
	  
<<<<<<< HEAD
	  public IntOption gracePeriodOption = new IntOption(
		        "gracePeriod",'g', "The number of instances a leaf should observe between split attempts.",
		         200, 0, Integer.MAX_VALUE);
	  
	  public MultiChoiceOption predictionFunctionOption = new MultiChoiceOption(
=======
	  public FloatOption anomalyProbabilityThresholdOption = new FloatOption(
				"anomalyprobabilityThreshold",
				'o',
				"The threshold value.",
				0.99, 0.0, 1.0);
		
	 public FloatOption probabilityThresholdOption = new FloatOption(
				"probabilityThreshold",
				'k',
				"The threshold value.",
				0.10, 0.0, 1.0);
		
	 public IntOption anomalyNumInstThresholdOption = new IntOption(
				"anomalyThreshold",
				'i',
				"The threshold value to be used in the anomaly detection.",
				15, 0, Integer.MAX_VALUE);
	  
	 public IntOption gracePeriodOption = new IntOption(
		        "gracePeriod",'g', "The number of instances a leaf should observe between split attempts.",
		         200, 0, Integer.MAX_VALUE);
	  
	 public MultiChoiceOption predictionFunctionOption = new MultiChoiceOption(
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
	            "predictionFunctionOption", 'z', "The prediction function to use.", new String[]{
	            "firstHit", "weightedSum", "weightedMax"}, new String[]{
	            "first Hit",  "weighted Sum", "weighted Max"}, 0);
	  
<<<<<<< HEAD
	  public FlagOption orderedRulesOption = new FlagOption("orderedRules", 'r',
	            "orderedRules."); 
	  
	@Override
	public double[] getVotesForInstance(Instance inst) {
		double[] votes = new double[observedClassDistribution.numValues()];
=======
	 public FlagOption orderedRulesOption = new FlagOption("orderedRules", 'r',
	            "orderedRules.");
	  
	public FlagOption anomalyDetectionOption = new FlagOption("anomalyDetection", 'u',
				"anomaly Detection.");
	
	public FlagOption Supervised = new FlagOption("supervised", 'n',
			"supervised.");
	
	public FlagOption Unsupervised = new FlagOption("unsupervised", 'm',
			"unsupervised.");
		
		
	  
	@Override
	public double[] getVotesForInstance(Instance inst) {
		double[] votes = new double[this.numClass];
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
		switch (this.predictionFunctionOption.getChosenIndex()) {
		case 0:
			votes = firstHit(inst);
			break; 
        case 1:
        	votes = weightedSum(inst);
        	break; 
        case 2:
        	votes = weightedMax(inst);
        	break;
		  }
		return votes; 
	}
	
	@Override
	protected Measurement[] getModelMeasurementsImpl() {
		return null;
		}
	
	@Override
	public void resetLearningImpl() {
		this.observedClassDistribution = new DoubleVector();
        this.attributeObservers = new AutoExpandVector<AttributeClassObserver>();
        this.attributeObserversGauss = new AutoExpandVector<AttributeClassObserver>();	
	}
	
	public double getWeightSeen() {
		return this.observedClassDistribution.sumOfValues(); 
      }

	@Override
	public void trainOnInstanceImpl(Instance inst) {
<<<<<<< HEAD
		int numInstanciaObservers = 0;
		int countRuleFiredTrue = 0;
		int remainder = (int)Double.MAX_VALUE;
		boolean ruleFired = false;
		instance = inst;
		numAttributes = instance.numAttributes()-1;
		numClass = instance.numClasses();
		numTotalInstance = numTotalInstance + 1;
		for (int j = 0; j < ruleSet.size(); j++) {
			if (ruleSet.get(j).ruleEvaluate(inst) == true) {
				countRuleFiredTrue = countRuleFiredTrue + 1;
		    	saveBestValGlobalEntropy = new ArrayList<ArrayList<Double>>();
		    	saveBestGlobalEntropy = new ArrayList<Double>();
			    saveTheBest = new ArrayList<Double>();
			    minEntropyTemp = Double.MAX_VALUE;
				minEntropyNominalAttrib = Double.MAX_VALUE;
				ruleSet.get(j).obserClassDistrib.addToValue((int) inst.classValue(), inst.weight());
				for (int i = 0; i < inst.numAttributes() - 1; i++) {
					int instAttIndex = modelAttIndexToInstanceAttIndex(i, inst);
		            AttributeClassObserver obs = ruleSet.get(j).observers.get(i);		// Nominal and binary tree.
		            AttributeClassObserver obsGauss = ruleSet.get(j).observersGauss.get(i);		// Gaussian.
		            if (obs == null) {
		                obs = inst.attribute(instAttIndex).isNominal() ? newNominalClassObserver()
		                        : newNumericClassObserver();
		                ruleSet.get(j).observers.set(i, obs);     
		            }
		            if (obsGauss == null) {
		                obsGauss = inst.attribute(instAttIndex).isNumeric() ? newNumericClassObserver2():null;
		                ruleSet.get(j).observersGauss.set(i, obsGauss);     
=======
		int countRuleFiredTrue = 0;
		boolean ruleFired = false;
		this.instance = inst;
		this.numAttributes = instance.numAttributes()-1;
		this.numClass = instance.numClasses();
		this.numInstance = numInstance + 1;
		int conta1=0;
		for (int j = 0; j < ruleSet.size(); j++) {
			if (this.ruleSet.get(j).ruleEvaluate(inst) == true) {
				countRuleFiredTrue = countRuleFiredTrue + 1;
				
				double anomaly = 0.0;
				if(this.Supervised.isSet()){
					anomaly = computeAnomalySupervised(this.ruleSet.get(j), j, inst); // compute anomaly (Supervised method)
				}else if(this.Unsupervised.isSet()){
					anomaly = computeAnomalyUnsupervised(this.ruleSet.get(j), j, inst); // compute anomaly (Unsupervised method)
				}
				
				if(anomaly >= this.anomalyProbabilityThresholdOption.getValue()){
				conta1 =conta1+1;
				}
			//	System.out.print(numInstance+";"+anomaly+"\n");
				 try {
		       	        
	           		  File dir = new File("SeaAnomaliesUnsupervised.txt");
	           		  FileWriter fileWriter = new FileWriter(dir, true); 
	           		  PrintWriter printWriter = new PrintWriter(fileWriter);
	              	  printWriter.println(numInstance+";"+anomaly);
	           		  printWriter.flush();
	           		  printWriter.close();      
	           	       
	    			} catch (IOException e) {
	    				e.printStackTrace();
	    			}
				 if((this.ruleSet.get(j).instancesSeen <= this.anomalyNumInstThresholdOption.getValue()) || (anomaly < this.anomalyProbabilityThresholdOption.getValue() && this.anomalyDetectionOption.isSet()) ||!this.anomalyDetectionOption.isSet()){
				this.ruleSet.get(j).obserClassDistrib.addToValue((int) inst.classValue(), inst.weight());
				for (int i = 0; i < inst.numAttributes() - 1; i++) {
					int instAttIndex = modelAttIndexToInstanceAttIndex(i, inst);
					
					if(!inst.isMissing(instAttIndex)){
		            AttributeClassObserver obs = this.ruleSet.get(j).observers.get(i);		// Nominal and binary tree.
		            AttributeClassObserver obsGauss = this.ruleSet.get(j).observersGauss.get(i);		// Gaussian.
		            if (obs == null) {
		                obs = inst.attribute(instAttIndex).isNominal() ? newNominalClassObserver()
		                        : newNumericClassObserver();
		                this.ruleSet.get(j).observers.set(i, obs);     
		            }
		            if (obsGauss == null) {
		                obsGauss = inst.attribute(instAttIndex).isNumeric() ? newNumericClassObserver2():null;
		                this.ruleSet.get(j).observersGauss.set(i, obsGauss);     
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
		            }
		            obs.observeAttributeClass(inst.value(instAttIndex), (int) inst.classValue(), inst.weight());
		            if (inst.attribute(instAttIndex).isNumeric()) {
		            	obsGauss.observeAttributeClass(inst.value(instAttIndex), (int) inst.classValue(), inst.weight());
		            }  
	            }
<<<<<<< HEAD
		    	int count = getCount(inst, ruleSet.get(j).predicateSet);		// Check if a given instance satisfies the rule.
		        if (count == ruleSet.get(j).predicateSet.size()) {
		        	getRuleClass(inst, j);		// For each rule gets the respective classes distributions.
		        }
		        numInstanciaObservers = observersNumberInstance( inst, ruleSet.get(j).observers);		// Number of instances for this rule observers.
		        if (numInstanciaObservers != 0 && gracePeriodOption.getValue() != 0) {
		        	remainder = (numInstanciaObservers) % (gracePeriodOption.getValue());    
		        }
		        if (remainder == 0){
		        	observersTemp = ruleSet.get(j).observers;
			        theBestAttributes(inst,observersTemp);		// The best value of entropy for each attribute.
			    	Collections.sort(saveBestGlobalEntropy); 
		            boolean HB = checkBestAttrib(numInstanciaObservers, inst, ruleSet.get(j).observers);		// Check if the best attribute value is really the best.
		    		if (HB == true) {
		    			double attributeValue = saveTheBest.get(3);
		    			double symbol = saveTheBest.get(2);		// =, <=, > (0.0, -1.0, 1.0).
		    			double value = saveTheBest.get(0);		// Value of the attribute.
		    			pred = new Predicates(attributeValue, symbol, value);
		    			int countPred = 0;
		    			for (int i = 0; i < ruleSet.get(j).predicateSet.size(); i++) {		// Checks if the new predicate is not yet in the predicateSet. 
	    					 if (pred.getSymbol() == 0.0) {		// Nominal Attribute.
	    						 if (ruleSet.get(j).predicateSet.get(i).getAttributeValue() != pred.getAttributeValue()) {
	    							 countPred = countPred + 1;
	    						 }
	    					 }
	    					 else {
	    						 if (ruleSet.get(j).predicateSet.get(i).getAttributeValue() != pred.getAttributeValue() 
	    								 || ruleSet.get(j).predicateSet.get(i).getSymbol() != pred.getSymbol() 
	    								 || ruleSet.get(j).predicateSet.get(i).getValue() != pred.getValue()) {
	    							 countPred = countPred+1;
	    							 }
	    						 }
	    					 }
		    			if (countPred == ruleSet.get(j).predicateSet.size()) {
		    				int countDifPred = 0;
	    					ArrayList<Predicates> predicSetTemp = new ArrayList<Predicates>();
	    					for (int x = 0; x < ruleSet.get(j).predicateSet.size(); x++) {
	    						predicSetTemp.add(ruleSet.get(j).predicateSet.get(x));
	    					 }
	    					predicSetTemp.add(pred);
	    					for (int f = 0; f < ruleSet.size(); f++) {
	    						int countDifPredTemp = 0;
	    						if (ruleSet.get(f).predicateSet.size() == predicSetTemp.size()) {
	    							for(int x = 0; x < ruleSet.get(f).predicateSet.size(); x++) {
	    								if (ruleSet.get(f).predicateSet.get(x).getAttributeValue() == predicSetTemp.get(x).getAttributeValue() 
	    										&& ruleSet.get(f).predicateSet.get(x).getSymbol() == predicSetTemp.get(x).getSymbol() 
	    										&& ruleSet.get(f).predicateSet.get(x).getValue() == predicSetTemp.get(x).getValue()) {
	    									countDifPredTemp = countDifPredTemp+1;
	    									}
	    								}
	    							if (countDifPredTemp == predicSetTemp.size()) {
	    								break;
	    								}else{
	    									countDifPred = countDifPred + 1;
	    									}
	    							}else{
 							countDifPred = countDifPred + 1;
 							}
	    						}
	    					if (countDifPred == ruleSet.size()) {
	    						if (pred.getSymbol() == 0.0) {
	    							ruleSet.get(j).predicateSet.add(pred);
	    	    					majority.get(j).clear(); 
	    		    				ruleSet.get(j).obserClassDistrib = new DoubleVector();
	    			    			ruleSet.get(j).observers = new AutoExpandVector<AttributeClassObserver>();
	    			    			ruleSet.get(j).observersGauss = new AutoExpandVector<AttributeClassObserver>();
	    			    			} else if (pred.getSymbol() == 1.0) {
	    			    				int countIqualPred = 0;
	    			    				for (int f = 0; f < ruleSet.get(j).predicateSet.size(); f++) {
	    			    					if (pred.getAttributeValue() == ruleSet.get(j).predicateSet.get(f).getAttributeValue()
	    			    							&& pred.getSymbol() == ruleSet.get(j).predicateSet.get(f).getSymbol()) {
	    			    						countIqualPred = countIqualPred + 1;
	    			    						if (pred.getValue() > ruleSet.get(j).predicateSet.get(f).getValue()) {
	    			    							ruleSet.get(j).predicateSet.remove(f);
	    	    									ruleSet.get(j).predicateSet.add(pred);
	    	    				    				majority.get(j).clear();
	    	    				    				ruleSet.get(j).obserClassDistrib=new DoubleVector();
	    	    				    				ruleSet.get(j).observers=new AutoExpandVector<AttributeClassObserver>();
	    	    				    				ruleSet.get(j).observersGauss=new AutoExpandVector<AttributeClassObserver>();
	    	    				    				}
	    			    						}
	    			    					}
	    			    				if (countIqualPred == 0) {
	    			    					ruleSet.get(j).predicateSet.add(pred);
	    	    							majority.get(j).clear();
	    	    				    		ruleSet.get(j).obserClassDistrib=new DoubleVector();
	    	    				    		ruleSet.get(j).observers=new AutoExpandVector<AttributeClassObserver>();
	    	    				    		ruleSet.get(j).observersGauss=new AutoExpandVector<AttributeClassObserver>();
	    	    				    		}
	    			    				}else{
	    	    						 int countIqualPred = 0;
	    	    						 for (int f = 0; f < ruleSet.get(j).predicateSet.size(); f++) {
	    	    							 if (pred.getAttributeValue() == ruleSet.get(j).predicateSet.get(f).getAttributeValue()
	    	    									 && pred.getSymbol() == ruleSet.get(j).predicateSet.get(f).getSymbol()) {
	    	    								 countIqualPred = countIqualPred + 1;
	    	    								 if (pred.getValue() < ruleSet.get(j).predicateSet.get(f).getValue()) {
	    	    									 ruleSet.get(j).predicateSet.remove(f);
	    	    									 ruleSet.get(j).predicateSet.add(pred);
	    	    									 majority.get(j).clear();
	    	    				    				 ruleSet.get(j).obserClassDistrib = new DoubleVector();
	    	    				    				 ruleSet.get(j).observers = new AutoExpandVector<AttributeClassObserver>();
	    	    				    				 ruleSet.get(j).observersGauss = new AutoExpandVector<AttributeClassObserver>();
	    	    				    				 }
	    	    								 }
	    	    							 }
	    	    						 if (countIqualPred == 0) {
	    	    							 ruleSet.get(j).predicateSet.add(pred);
	    	    							 majority.get(j).clear();
	    	    				    		 ruleSet.get(j).obserClassDistrib=new DoubleVector();
	    	    				    		 ruleSet.get(j).observers=new AutoExpandVector<AttributeClassObserver>();
	    	    				    		 ruleSet.get(j).observersGauss=new AutoExpandVector<AttributeClassObserver>();
	    	    				    		 }
	    	    						 }
	    						}
	    					}
		    			}
		    		}
		        if (orderedRulesOption.isSet()) {		// Ordered rules
=======
				}
				expandeRule(this.ruleSet.get(j), inst, j); // This function expands the rule
				}
		        if (this.orderedRulesOption.isSet()) {	// Ordered rules
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
		        	break;
		        	}
		        }
			}
		if (countRuleFiredTrue > 0) {
			ruleFired = true;
			}else{
				ruleFired = false;
		    }
<<<<<<< HEAD
		if (ruleFired == false) {
			saveBestValGlobalEntropy = new ArrayList<ArrayList<Double>>();
			saveBestGlobalEntropy = new ArrayList<Double>();
			saveTheBest = new ArrayList<Double>();
			minEntropyTemp = Double.MAX_VALUE;
			minEntropyNominalAttrib = Double.MAX_VALUE;
			this.observedClassDistribution.addToValue((int) inst.classValue(), inst.weight());
			for (int i = 0; i < inst.numAttributes() - 1; i++) {
				int instAttIndex = modelAttIndexToInstanceAttIndex(i, inst);
=======
		if (ruleFired == false) { //If none of the rules cover the example update sufficient statistics of the default rule
			this.observedClassDistribution.addToValue((int) inst.classValue(), inst.weight());
			for (int i = 0; i < inst.numAttributes() - 1; i++) {
				int instAttIndex = modelAttIndexToInstanceAttIndex(i, inst);
				if(!inst.isMissing(instAttIndex)){
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
				AttributeClassObserver obs = this.attributeObservers.get(i);
			    AttributeClassObserver obsGauss = this.attributeObserversGauss.get(i);
			    if (obs == null) {
			    	obs = inst.attribute(instAttIndex).isNominal() ? newNominalClassObserver()
			    			: newNumericClassObserver();
			    	this.attributeObservers.set(i, obs); 
			    	}
			    if (obsGauss == null) {
			    	obsGauss = inst.attribute(instAttIndex).isNumeric() ? newNumericClassObserver2():null;
			    	this.attributeObserversGauss.set(i, obsGauss);
			    	}
			    obs.observeAttributeClass(inst.value(instAttIndex), (int) inst.classValue(), inst.weight());
			    if (inst.attribute(instAttIndex).isNumeric()) {
			    	obsGauss.observeAttributeClass(inst.value(instAttIndex), (int) inst.classValue(), inst.weight());
			    	}
			    }
<<<<<<< HEAD
			numInstanciaObservers=observersNumberInstance( inst, this.attributeObservers);
			if (numInstanciaObservers != 0 && gracePeriodOption.getValue() != 0) {
				remainder = (numInstanciaObservers) % (gracePeriodOption.getValue());
				}
			if (remainder == 0) {
				observersTemp = this.attributeObservers;
				theBestAttributes(inst,observersTemp);  
		    	Collections.sort(saveBestGlobalEntropy);         
	            boolean HB = checkBestAttrib(numInstanciaObservers, inst, this.attributeObservers);
	            if (HB == true) {
	            	int countDifRule = 0;
	            	double attributeValue = saveTheBest.get(3);
	    			double symbol = saveTheBest.get(2);		// =, <=, > : (0.0, -1.0, 1.0).
	    			double value = saveTheBest.get(0);		// Value of the attribute
	    			pred = new Predicates(attributeValue, symbol, value);
	    			Rule Rl = new Rule();		// Create Rule.
	    			Rl.predicateSet.add(pred);
	    			for (int i = 0; i < ruleSet.size(); i++) {
	    				if (ruleSet.get(i).predicateSet.size() == 1) {
	    					if (ruleSet.get(i).predicateSet.get(0).getAttributeValue() != Rl.predicateSet.get(0).getAttributeValue()
	    							|| ruleSet.get(i).predicateSet.get(0).getSymbol() != Rl.predicateSet.get(0).getSymbol()
	    							|| ruleSet.get(i).predicateSet.get(0).getValue() != Rl.predicateSet.get(0).getValue()) {
	    						countDifRule = countDifRule + 1;
	    						}
	    					} else if (ruleSet.get(i).predicateSet.size() > 1){
	    						countDifRule = countDifRule + 1;
	    						}
	    				}
	    			if (countDifRule == ruleSet.size()|| ruleSet.isEmpty()) {
	    				ruleSet.add(Rl);
	    				majority.add(new ArrayList<Integer>());
	    				if (Rl.predicateSet.get(0).getSymbol() == -1.0 ||Rl.predicateSet.get(0).getSymbol() == 1.0) {
	    					double posClassDouble = saveTheBest.get(4); 
	    					int posClassInt = (int)posClassDouble;
	    					ruleClassIndex.add(posClassInt);
	    					String classe = inst.classAttribute().value(posClassInt);
	    					ruleClassName.add(classe);
	    					}
	    				}
	    			this.attributeObservers = new AutoExpandVector<AttributeClassObserver>(); 
	    			this.attributeObserversGauss = new AutoExpandVector<AttributeClassObserver>();
	    			}
	            }
=======
			}
			createRule(inst); //This function creates a rule
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
			}
		}
	
	@Override	
	public void getModelDescription(StringBuilder out, int indent) {
<<<<<<< HEAD
=======
		if(this.anomalyDetectionOption.isSet()){
			if(this.Supervised.isSet()){
				this.printAnomaliesSupervised(out, indent); // Get Model Description (Supervised method)
			}else if(this.Unsupervised.isSet()){
				this.printAnomaliesUnsupervised(out, indent); // Get Model Description (Unsupervised method)
			}
		}else{
			this.getModelDescriptionNoAnomalyDetection(out, indent);  // Get Model Description no Anomaly detection
			
			}
		}
	
	public void printAnomaliesUnsupervised(StringBuilder out, int indent) { // Get Model Description (Unsupervised method)
		
		StringUtils.appendNewline(out);
		StringUtils.appendIndented(out, indent, "**********************UNSUPERVISED*****************");
		StringUtils.appendNewline(out);
		StringUtils.appendNewline(out);
        for (int k = 0; k < this.ruleSetAnomalies.size(); k++) {
        	StringUtils.appendIndented(out, indent, "Case: "+this.caseAnomaly.get(k).get(0)+"   Anomaly Score: "+this.caseAnomaly.get(k).get(1)+"%");
			StringUtils.appendNewline(out); //Ver outra parte default
			StringUtils.appendIndented(out, indent, "Rule "+this.ruleAnomaliesIndex.get(k)+": ");
        	for (int i = 0; i < this.ruleSetAnomalies.get(k).predicateSet.size(); i++) {
        		if (this.ruleSetAnomalies.get(k).predicateSet.size() == 1) {
        			if (this.ruleSetAnomalies.get(k).predicateSet.get(i).getSymbol() == 0.0) {
    					String nam = this.instance.attribute((int)this.ruleSetAnomalies.get(k).predicateSet.get(i).getAttributeValue()).name();
    					String val = this.instance.attribute((int)this.ruleSetAnomalies.get(k).predicateSet.get(i).getAttributeValue()).value((int)this.ruleSetAnomalies.get(k).predicateSet.get(i).getValue());
    					StringUtils.appendIndented(out, indent, nam+" = "+val+" --> "+this.instance.classAttribute().value((int)getRuleMajorityClassIndex(this.ruleSetAnomalies.get(k))));
    					StringUtils.appendNewline(out);
    					} else if (this.ruleSetAnomalies.get(k).predicateSet.get(i).getSymbol() == -1.0){
    						String nam = this.instance.attribute((int)this.ruleSetAnomalies.get(k).predicateSet.get(i).getAttributeValue()).name();
    						StringUtils.appendIndented(out, indent, nam+" <= "+this.ruleSetAnomalies.get(k).predicateSet.get(i).getValue()+" --> "+this.instance.classAttribute().value((int)ruleClassIndex.getValue(ruleAnomaliesIndex.get(k)-1)));
    					    StringUtils.appendNewline(out);
    					    } else {
    					    	String nam = this.instance.attribute((int)this.ruleSetAnomalies.get(k).predicateSet.get(i).getAttributeValue()).name();
    			                StringUtils.appendIndented(out, indent, nam+" > "+this.ruleSetAnomalies.get(k).predicateSet.get(i).getValue()+" --> "+this.instance.classAttribute().value((int)this.ruleClassIndex.getValue(ruleAnomaliesIndex.get(k)-1)));
    					        StringUtils.appendNewline(out);
    					        }
        			} else {
        				if (this.ruleSetAnomalies.get(k).predicateSet.get(i).getSymbol() == 0.0) {
        					String nam = this.instance.attribute((int)this.ruleSetAnomalies.get(k).predicateSet.get(i).getAttributeValue()).name();
    					    String val = this.instance.attribute((int)this.ruleSetAnomalies.get(k).predicateSet.get(i).getAttributeValue()).value((int)this.ruleSetAnomalies.get(k).predicateSet.get(i).getValue());
    					    StringUtils.appendIndented(out, indent, nam+" = "+val+" ");
    					    } else if (this.ruleSetAnomalies.get(k).predicateSet.get(i).getSymbol()==-1.0){
    					    	String nam = this.instance.attribute((int)this.ruleSetAnomalies.get(k).predicateSet.get(i).getAttributeValue()).name();
    					        StringUtils.appendIndented(out, indent, nam+" <= "+this.ruleSetAnomalies.get(k).predicateSet.get(i).getValue()+" ");
    					        } else {
    					        	String nam = this.instance.attribute((int)this.ruleSetAnomalies.get(k).predicateSet.get(i).getAttributeValue()).name();
    					        	StringUtils.appendIndented(out, indent, nam+" > "+this.ruleSetAnomalies.get(k).predicateSet.get(i).getValue()+" ");
    					        	}
        				if (i < this.ruleSetAnomalies.get(k).predicateSet.size() - 1) {
        					StringUtils.appendIndented(out, indent, "and ");
        					} else {
        						int count = getCountNominalAttrib(this.ruleSetAnomalies.get(k).predicateSet);
        						if ((this.ruleSetAnomalies.get(k).predicateSet.get(i).getSymbol() == 0.0) || (count != 0)) {
        							StringUtils.appendIndented(out, indent, " --> "+this.instance.classAttribute().value((int)getRuleMajorityClassIndex(this.ruleSetAnomalies.get(k))));
                    		        StringUtils.appendNewline(out);
                    		        } else {
                    		        	StringUtils.appendIndented(out, indent, " --> "+this.instance.classAttribute().value((int)this.ruleClassIndex.getValue(ruleAnomaliesIndex.get(k)-1)));
                    		            StringUtils.appendNewline(out);
                    		            }
        						}
        				}
        		}
        	for(int z=0; z < this.ruleAttribAnomalyStatistics.get(k).size(); z++) {
        		if(this.ruleAttribAnomalyStatistics.get(k).get(z).size() == 5){
				String s = String.format ("%.3e", this.ruleAttribAnomalyStatistics.get(k).get(z).get(4)); 
				StringUtils.appendIndented(out, indent, instance.attribute(this.ruleAttribAnomalyStatistics.get(k).get(z).get(0).intValue()).name()+"="+round(this.ruleAttribAnomalyStatistics.get(k).get(z).get(1))+"   ("+round(this.ruleAttribAnomalyStatistics.get(k).get(z).get(2))+" +- "+round(this.ruleAttribAnomalyStatistics.get(k).get(z).get(3))+")   P="+s);
				StringUtils.appendNewline(out);
			} else {
				String s = String.format ("%.3e", this.ruleAttribAnomalyStatistics.get(k).get(z).get(2));
				String val = this.instance.attribute(this.ruleAttribAnomalyStatistics.get(k).get(z).get(0).intValue()).value(this.ruleAttribAnomalyStatistics.get(k).get(z).get(1).intValue());
				StringUtils.appendIndented(out, indent, instance.attribute(this.ruleAttribAnomalyStatistics.get(k).get(z).get(0).intValue()).name()+"="+ val+"   P="+s);
				StringUtils.appendNewline(out);
			}
    		
    	}
		StringUtils.appendNewline(out);
	}
			
	}
	
	
public void printAnomaliesSupervised(StringBuilder out, int indent) { // Get Model Description (Supervised method)
		
		StringUtils.appendNewline(out);
		StringUtils.appendIndented(out, indent, "************************SUPERVISED*******************");
		StringUtils.appendNewline(out);
		StringUtils.appendNewline(out);
        for (int k = 0; k < this.ruleSetAnomaliesSupervised.size(); k++) {
        	StringUtils.appendIndented(out, indent, "Case: "+this.caseAnomalySupervised.get(k).get(0)+"   Anomaly Score: "+this.caseAnomalySupervised.get(k).get(1)+"%");
			StringUtils.appendNewline(out); //Ver outra parte default
			StringUtils.appendIndented(out, indent, "Rule "+this.ruleAnomaliesIndexSupervised.get(k)+": ");
        	for (int i = 0; i < this.ruleSetAnomaliesSupervised.get(k).predicateSet.size(); i++) {
        		if (this.ruleSetAnomaliesSupervised.get(k).predicateSet.size() == 1) {
        			if (this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getSymbol() == 0.0) {
    					String nam = this.instance.attribute((int)this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getAttributeValue()).name();
    					String val = this.instance.attribute((int)this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getAttributeValue()).value((int)this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getValue());
    					StringUtils.appendIndented(out, indent, nam+" = "+val+" --> "+this.instance.classAttribute().value((int)getRuleMajorityClassIndex(this.ruleSetAnomaliesSupervised.get(k))));
    					StringUtils.appendNewline(out);
    					} else if (this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getSymbol() == -1.0){
    						String nam = this.instance.attribute((int)this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getAttributeValue()).name();
    						StringUtils.appendIndented(out, indent, nam+" <= "+this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getValue()+" --> "+this.instance.classAttribute().value((int)ruleClassIndex.getValue(ruleAnomaliesIndexSupervised.get(k)-1)));
    					    StringUtils.appendNewline(out);
    					    } else {
    					    	String nam = this.instance.attribute((int)this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getAttributeValue()).name();
    			                StringUtils.appendIndented(out, indent, nam+" > "+this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getValue()+" --> "+this.instance.classAttribute().value((int)this.ruleClassIndex.getValue(ruleAnomaliesIndexSupervised.get(k)-1)));
    					        StringUtils.appendNewline(out);
    					        }
        			} else {
        				if (this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getSymbol() == 0.0) {
        					String nam = this.instance.attribute((int)this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getAttributeValue()).name();
    					    String val = this.instance.attribute((int)this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getAttributeValue()).value((int)this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getValue());
    					    StringUtils.appendIndented(out, indent, nam+" = "+val+" ");
    					    } else if (this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getSymbol()==-1.0){
    					    	String nam = this.instance.attribute((int)this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getAttributeValue()).name();
    					        StringUtils.appendIndented(out, indent, nam+" <= "+this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getValue()+" ");
    					        } else {
    					        	String nam = this.instance.attribute((int)this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getAttributeValue()).name();
    					        	StringUtils.appendIndented(out, indent, nam+" > "+this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getValue()+" ");
    					        	}
        				if (i < this.ruleSetAnomaliesSupervised.get(k).predicateSet.size() - 1) {
        					StringUtils.appendIndented(out, indent, "and ");
        					} else {
        						int count = getCountNominalAttrib(this.ruleSetAnomaliesSupervised.get(k).predicateSet);
        						if ((this.ruleSetAnomaliesSupervised.get(k).predicateSet.get(i).getSymbol() == 0.0) || (count != 0)) {
        							StringUtils.appendIndented(out, indent, " --> "+this.instance.classAttribute().value((int)getRuleMajorityClassIndex(this.ruleSetAnomaliesSupervised.get(k))));
                    		        StringUtils.appendNewline(out);
                    		        } else {
                    		        	StringUtils.appendIndented(out, indent, " --> "+this.instance.classAttribute().value((int)this.ruleClassIndex.getValue(ruleAnomaliesIndexSupervised.get(k)-1)));
                    		            StringUtils.appendNewline(out);
                    		            }
        						}
        				}
        		}
        	for(int z=0; z < this.ruleAttribAnomalyStatisticsSupervised.get(k).size(); z++) {
        		if(this.ruleAttribAnomalyStatisticsSupervised.get(k).get(z).size() == 5){
				String s = String.format ("%.3e", this.ruleAttribAnomalyStatisticsSupervised.get(k).get(z).get(4)); 
				StringUtils.appendIndented(out, indent, instance.attribute(this.ruleAttribAnomalyStatisticsSupervised.get(k).get(z).get(0).intValue()).name()+"="+round(this.ruleAttribAnomalyStatisticsSupervised.get(k).get(z).get(1))+"   ("+round(this.ruleAttribAnomalyStatisticsSupervised.get(k).get(z).get(2))+" +- "+round(this.ruleAttribAnomalyStatisticsSupervised.get(k).get(z).get(3))+")   P="+s);
				StringUtils.appendNewline(out);
			} else {
				String s = String.format ("%.3e", this.ruleAttribAnomalyStatisticsSupervised.get(k).get(z).get(2));
				String val = this.instance.attribute(this.ruleAttribAnomalyStatisticsSupervised.get(k).get(z).get(0).intValue()).value(this.ruleAttribAnomalyStatisticsSupervised.get(k).get(z).get(1).intValue());
				StringUtils.appendIndented(out, indent, instance.attribute(this.ruleAttribAnomalyStatisticsSupervised.get(k).get(z).get(0).intValue()).name()+"="+ val+"   P="+s);
				StringUtils.appendNewline(out);
			}
    		
    	}
		StringUtils.appendNewline(out);
	}
			
	}
	
	
	public void getModelDescriptionNoAnomalyDetection(StringBuilder out, int indent) { // Get Model Description no Anomaly detection
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
		StringUtils.appendNewline(out);
        StringUtils.appendIndented(out, indent, "Number of Rule: " + ruleSet.size());
        StringUtils.appendNewline(out);
        StringUtils.appendNewline(out);
<<<<<<< HEAD
        for (int k = 0; k < ruleSet.size(); k++) {
        	StringUtils.appendIndented(out, indent, "Rule "+(k+1)+": ");
        	for (int i = 0; i < ruleSet.get(k).predicateSet.size(); i++) {
        		if (ruleSet.get(k).predicateSet.size() == 1) {
        			if (ruleSet.get(k).predicateSet.get(i).getSymbol() == 0.0) {
    					String nam = instance.attribute((int)ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    					String val = instance.attribute((int)ruleSet.get(k).predicateSet.get(i).getAttributeValue()).value((int)ruleSet.get(k).predicateSet.get(i).getValue());
    					StringUtils.appendIndented(out, indent, nam+" = "+val+" --> "+getRuleMajorityClass(k,instance));
    					StringUtils.appendNewline(out);
    					} else if (ruleSet.get(k).predicateSet.get(i).getSymbol() == -1.0){
    						String nam=instance.attribute((int)ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    						StringUtils.appendIndented(out, indent, nam+" <= "+ruleSet.get(k).predicateSet.get(i).getValue()+" --> "+ruleClassName.get(k));
    					    StringUtils.appendNewline(out);
    					    } else {
    					    	String nam=instance.attribute((int)ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    			                StringUtils.appendIndented(out, indent, nam+" > "+ruleSet.get(k).predicateSet.get(i).getValue()+" --> "+ruleClassName.get(k));
    					        StringUtils.appendNewline(out);
    					        }
        			} else {
        				if (ruleSet.get(k).predicateSet.get(i).getSymbol() == 0.0) {
        					String nam=instance.attribute((int)ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    					    String val=instance.attribute((int)ruleSet.get(k).predicateSet.get(i).getAttributeValue()).value((int)ruleSet.get(k).predicateSet.get(i).getValue());
    					    StringUtils.appendIndented(out, indent, nam+" = "+val+" ");
    					    } else if (ruleSet.get(k).predicateSet.get(i).getSymbol()==-1.0){
    					    	String nam=instance.attribute((int)ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    					        StringUtils.appendIndented(out, indent, nam+" <= "+ruleSet.get(k).predicateSet.get(i).getValue()+" ");
    					        } else {
    					        	String nam=instance.attribute((int)ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    					        	StringUtils.appendIndented(out, indent, nam+" > "+ruleSet.get(k).predicateSet.get(i).getValue()+" ");
    					        	}
        				if (i < ruleSet.get(k).predicateSet.size() - 1) {
        					StringUtils.appendIndented(out, indent, "and ");
        					} else {
        						int count = getCountNominalAttrib(ruleSet.get(k).predicateSet);
        						if ((ruleSet.get(k).predicateSet.get(i).getSymbol() == 0.0) || (count != 0)) {
        							StringUtils.appendIndented(out, indent, " --> "+getRuleMajorityClass(k,instance));
                    		        StringUtils.appendNewline(out);
                    		        } else {
                    		        	StringUtils.appendIndented(out, indent, " --> "+ruleClassName.get(k));
=======
        for (int k = 0; k < this.ruleSet.size(); k++) {
        	StringUtils.appendIndented(out, indent, "Rule "+(k+1)+": ");
        	for (int i = 0; i < this.ruleSet.get(k).predicateSet.size(); i++) {
        		if (this.ruleSet.get(k).predicateSet.size() == 1) {
        			if (this.ruleSet.get(k).predicateSet.get(i).getSymbol() == 0.0) {
    					String nam = this.instance.attribute((int)this.ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    					String val = this.instance.attribute((int)this.ruleSet.get(k).predicateSet.get(i).getAttributeValue()).value((int)this.ruleSet.get(k).predicateSet.get(i).getValue());
    					StringUtils.appendIndented(out, indent, nam+" = "+val+" --> "+this.instance.classAttribute().value((int)getRuleMajorityClassIndex(this.ruleSet.get(k))));
    					StringUtils.appendNewline(out);
    					} else if (this.ruleSet.get(k).predicateSet.get(i).getSymbol() == -1.0){
    						String nam = this.instance.attribute((int)this.ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    						StringUtils.appendIndented(out, indent, nam+" <= "+this.ruleSet.get(k).predicateSet.get(i).getValue()+" --> "+this.instance.classAttribute().value((int)ruleClassIndex.getValue(k)));
    					    StringUtils.appendNewline(out);
    					    } else {
    					    	String nam = this.instance.attribute((int)this.ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    			                StringUtils.appendIndented(out, indent, nam+" > "+this.ruleSet.get(k).predicateSet.get(i).getValue()+" --> "+this.instance.classAttribute().value((int)this.ruleClassIndex.getValue(k)));
    					        StringUtils.appendNewline(out);
    					        }
        			} else {
        				if (this.ruleSet.get(k).predicateSet.get(i).getSymbol() == 0.0) {
        					String nam = this.instance.attribute((int)this.ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    					    String val = this.instance.attribute((int)this.ruleSet.get(k).predicateSet.get(i).getAttributeValue()).value((int)this.ruleSet.get(k).predicateSet.get(i).getValue());
    					    StringUtils.appendIndented(out, indent, nam+" = "+val+" ");
    					    } else if (this.ruleSet.get(k).predicateSet.get(i).getSymbol()==-1.0){
    					    	String nam = this.instance.attribute((int)this.ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    					        StringUtils.appendIndented(out, indent, nam+" <= "+this.ruleSet.get(k).predicateSet.get(i).getValue()+" ");
    					        } else {
    					        	String nam = this.instance.attribute((int)this.ruleSet.get(k).predicateSet.get(i).getAttributeValue()).name();
    					        	StringUtils.appendIndented(out, indent, nam+" > "+this.ruleSet.get(k).predicateSet.get(i).getValue()+" ");
    					        	}
        				if (i < this.ruleSet.get(k).predicateSet.size() - 1) {
        					StringUtils.appendIndented(out, indent, "and ");
        					} else {
        						int count = getCountNominalAttrib(this.ruleSet.get(k).predicateSet);
        						if ((this.ruleSet.get(k).predicateSet.get(i).getSymbol() == 0.0) || (count != 0)) {
        							StringUtils.appendIndented(out, indent, " --> "+this.instance.classAttribute().value((int)getRuleMajorityClassIndex(this.ruleSet.get(k))));
                    		        StringUtils.appendNewline(out);
                    		        } else {
                    		        	StringUtils.appendIndented(out, indent, " --> "+this.instance.classAttribute().value((int)this.ruleClassIndex.getValue(k)));
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
                    		            StringUtils.appendNewline(out);
                    		            }
        						}
        				}
        		}
        	StringUtils.appendNewline(out);
        	}
        }
	
<<<<<<< HEAD
=======
	
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
	@Override
	public boolean isRandomizable() {
		return false;
	}
	
	public int getCountNominalAttrib(ArrayList<Predicates> predicateSet) {
		int count = 0;
		for (int i = 0; i < predicateSet.size(); i++) {
			if (predicateSet.get(i).getSymbol() == 0.0) {
				count = count + 1;
				break;
			}
		}
		return count;
	}
	
<<<<<<< HEAD
=======
	//Round an number
	protected BigDecimal round(double val){
		BigDecimal value = new BigDecimal(val);
		if(val!=0.0){
			value = value.setScale(3, BigDecimal.ROUND_DOWN);
		}
		return value;
	}
	
	
	//This function initializes the statistics of a rule 
	public void initializeRuleStatistics(Rule rl, Predicates pred, Instance inst) {
		rl.predicateSet.add(pred);
		rl.obserClassDistrib=new DoubleVector();
		rl.observers=new AutoExpandVector<AttributeClassObserver>();
		rl.observersGauss=new AutoExpandVector<AttributeClassObserver>();
		rl.instancesSeen = 0;
		rl.attributeStatistics = new DoubleVector();
		rl.squaredAttributeStatistics = new DoubleVector();
		rl.attributeStatisticsSupervised = new ArrayList<ArrayList<Double>>();
		rl.squaredAttributeStatisticsSupervised = new ArrayList<ArrayList<Double>>();
		rl.attributeMissingValues = new DoubleVector();
	}
	
	// Update rule statistics
	public void updateRuleAttribStatistics(Instance inst, Rule rl, int ruleIndex){
		rl.instancesSeen++; 
		if(rl.squaredAttributeStatisticsSupervised.size() == 0 && rl.attributeStatisticsSupervised.size() == 0){
			for (int s = 0; s < inst.numAttributes() -1; s++) {
				ArrayList<Double> temp1 = new ArrayList<Double>();
				ArrayList<Double> temp2 = new ArrayList<Double>();
				rl.attributeStatisticsSupervised.add(temp1);
				rl.squaredAttributeStatisticsSupervised.add(temp2);
				int instAttIndex = modelAttIndexToInstanceAttIndex(s, inst);
				if(instance.attribute(instAttIndex).isNumeric()){
					for(int i=0; i<inst.numClasses(); i++){
						rl.attributeStatisticsSupervised.get(s).add(0.0);
						rl.squaredAttributeStatisticsSupervised.get(s).add(1.0);
					}
					}
				}
			}
		for (int s = 0; s < inst.numAttributes() -1; s++) {
			int instAttIndex = modelAttIndexToInstanceAttIndex(s, inst);
			if(!inst.isMissing(instAttIndex)){
			if(instance.attribute(instAttIndex).isNumeric()){
			rl.attributeStatistics.addToValue(s, inst.value(s));	
			rl.squaredAttributeStatistics.addToValue(s, inst.value(s) * inst.value(s));
			double sumValue = rl.attributeStatisticsSupervised.get(s).get((int)inst.classValue()) + inst.value(s);
			rl.attributeStatisticsSupervised.get(s).set((int)inst.classValue(), sumValue);
			double squaredSumvalue = rl.squaredAttributeStatisticsSupervised.get(s).get((int)inst.classValue()) + (inst.value(s) * inst.value(s));
			rl.squaredAttributeStatisticsSupervised.get(s).set((int)inst.classValue(), squaredSumvalue);
			}
			}else{
				rl.attributeMissingValues.addToValue(s, 1);
				}
			}
		}
	
	//Compute anomalies unsupervised
	public double computeAnomalyUnsupervised(Rule rl, int ruleIndex, Instance inst) { //Unsupervised
		ArrayList<Integer> caseAnomalyTemp = new ArrayList<Integer>();
	    ArrayList<ArrayList<Double>> AttribAnomalyStatisticTemp2 = new ArrayList<ArrayList<Double>>();
	    double D = 0.0;
		double N = 0.0;
		
		
		if (rl.instancesSeen > this.anomalyNumInstThresholdOption.getValue() && this.anomalyDetectionOption.isSet()) { 
			for (int x = 0; x < inst.numAttributes() - 1; x++) {
				if(!inst.isMissing(x)){
					ArrayList<Double> AttribAnomalyStatisticTemp = new ArrayList<Double>();
					if (inst.attribute(x).isNumeric()) { //Numeric Attributes
						if((rl.instancesSeen - rl.attributeMissingValues.getValue(x)) > 30){
						double mean = computeMean(rl.attributeStatistics.getValue(x), rl.instancesSeen);
						double sd = computeSD(rl.squaredAttributeStatistics.getValue(x),rl.attributeStatistics.getValue(x), rl.instancesSeen);
						double probability = computeProbability(mean, sd, inst.value(x));
						if(probability!=0.0) {
							D = D + Math.log(probability);
							if(probability < this.probabilityThresholdOption.getValue()){  //0.10
								N = N + Math.log(probability);
			            	 	AttribAnomalyStatisticTemp.add((double)x);
			            	    AttribAnomalyStatisticTemp.add(inst.value(x));
				                AttribAnomalyStatisticTemp.add(mean);
				            	AttribAnomalyStatisticTemp.add(sd);
				            	AttribAnomalyStatisticTemp.add(probability);
				            	AttribAnomalyStatisticTemp2.add(AttribAnomalyStatisticTemp);
				            	}
							}
						}
					}else { //Nominal Attributes
							AutoExpandVector<DoubleVector> attribNominal = ((NominalAttributeClassObserver)rl.observers.get(x)).attValDistPerClass; //Attributes values distribution per class
							double numbAttribValue = 0.0;
							double attribVal = inst.value(x); //Attribute value
							for(int i = 0; i < attribNominal.size(); i++){
								if(attribNominal.get(i) != null){
									numbAttribValue = numbAttribValue + attribNominal.get(i).getValue((int)attribVal); 
								}
							}
							double probability = numbAttribValue / rl.instancesSeen;
							if(probability!= 0.0) {
								D = D + Math.log(probability);
								if(probability < this.probabilityThresholdOption.getValue()){  //0.10
									N = N + Math.log(probability);
				            	 	AttribAnomalyStatisticTemp.add((double)x);
				            	    AttribAnomalyStatisticTemp.add(inst.value(x));
					            	AttribAnomalyStatisticTemp.add(probability);
					            	AttribAnomalyStatisticTemp2.add(AttribAnomalyStatisticTemp);
					            	}
								}
							}
					}
				}
			}
		double anomaly=0.0;
		if(D !=0){
		 anomaly = Math.abs(N/D);
		}
		if(anomaly >= this.anomalyProbabilityThresholdOption.getValue()){
			caseAnomalyTemp.add(this.numInstance);
			double val = anomaly * 100;
			caseAnomalyTemp.add((int)val);
			this.caseAnomaly.add(caseAnomalyTemp);
			Rule x = new Rule(this.ruleSet.get(ruleIndex));
			this.ruleSetAnomalies.add(x);
			this.ruleAnomaliesIndex.add(ruleIndex + 1);
			this.ruleAttribAnomalyStatistics.add(AttribAnomalyStatisticTemp2);
			
			
		}
		return anomaly;
	}
	
	
	
	//Compute anomalies unsupervised
		public double computeAnomalySupervised(Rule rl, int ruleIndex, Instance inst) { //Not supervised
			ArrayList<Integer> caseAnomalyTemp = new ArrayList<Integer>();
		    ArrayList<ArrayList<Double>> AttribAnomalyStatisticTemp2 = new ArrayList<ArrayList<Double>>();
		    double D = 0.0;
			double N = 0.0;
			if (rl.instancesSeen > this.anomalyNumInstThresholdOption.getValue() && this.anomalyDetectionOption.isSet()) { 
				for (int x = 0; x < inst.numAttributes() - 1; x++) {
					if(!inst.isMissing(x)){
						ArrayList<Double> AttribAnomalyStatisticTemp = new ArrayList<Double>();
						if (inst.attribute(x).isNumeric()) { //Numeric Attributes
							if((rl.instancesSeen - rl.attributeMissingValues.getValue(x)) > 30){
								double mean = computeMean((double)rl.attributeStatisticsSupervised.get(x).get((int)inst.classValue()), (int)rl.obserClassDistrib.getValue((int)inst.classValue()));
								double sd = computeSD((double)rl.squaredAttributeStatisticsSupervised.get(x).get((int)inst.classValue()), (double)rl.attributeStatisticsSupervised.get(x).get((int)inst.classValue()), (int)rl.obserClassDistrib.getValue((int)inst.classValue()));
								double probability = computeProbability(mean, sd, inst.value(x));
								if(probability!=0.0) {
									D = D + Math.log(probability);
									if(probability < this.probabilityThresholdOption.getValue()){  //0.10
										N = N + Math.log(probability);
					            	 	AttribAnomalyStatisticTemp.add((double)x);
					            	    AttribAnomalyStatisticTemp.add(inst.value(x));
						                AttribAnomalyStatisticTemp.add(mean);
						            	AttribAnomalyStatisticTemp.add(sd);
						            	AttribAnomalyStatisticTemp.add(probability);
						            	AttribAnomalyStatisticTemp2.add(AttribAnomalyStatisticTemp);
						            	}
									}
								}
							}else { //Nominal
								double attribVal = inst.value(x); //Attribute value
								double classVal = inst.classValue(); //Attribute value
								double probability = rl.observers.get(x).probabilityOfAttributeValueGivenClass(attribVal, (int)classVal);
								if(probability!=0.0) {
									D = D + Math.log(probability);
									if(probability < this.probabilityThresholdOption.getValue()){  //0.10
										N = N + Math.log(probability);
					            	 	AttribAnomalyStatisticTemp.add((double)x);
					            	    AttribAnomalyStatisticTemp.add(inst.value(x));
						            	AttribAnomalyStatisticTemp.add(probability);
						            	AttribAnomalyStatisticTemp2.add(AttribAnomalyStatisticTemp);
						            	}
									}
								}
						}
					}
				}
			double anomaly=0.0;
			if(D !=0){
			 anomaly = Math.abs(N/D);
			}
			if(anomaly >= this.anomalyProbabilityThresholdOption.getValue()){
				caseAnomalyTemp.add(this.numInstance);
				double val = anomaly * 100;
				caseAnomalyTemp.add((int)val);
				this.caseAnomalySupervised.add(caseAnomalyTemp);
				Rule y = new Rule(this.ruleSet.get(ruleIndex));
				this.ruleSetAnomaliesSupervised.add(y);
				this.ruleAnomaliesIndexSupervised.add(ruleIndex + 1);
				this.ruleAttribAnomalyStatisticsSupervised.add(AttribAnomalyStatisticTemp2);
			}
			return anomaly;
			}
		
	//Mean
	public  double computeMean(double sum, int size) {
		return sum / size;
	}
		
	//Standard Deviation
	public  double computeSD(double squaredVal, double val, int size) {
		return  Math.sqrt((squaredVal - ((val * val) / size)) / size);
	}
	
	//Attribute probability
	public double computeProbability(double mean, double sd, double value) {
		sd = sd + 0.00001;
		double probability = 0.0;
		double diff = value - mean;
		if (sd > 0.0) {
			 	double k = (Math.abs(value - mean)/sd);
			 	if (k > 1.0) {
			 		probability = 1.0/(k*k);
			 	}
			 	else {
			 		probability=  Math.exp(-(diff * diff / (2.0 * sd * sd)));
			 	}
		 }
		return probability;
	}
	
	//This function creates a rule
	public void createRule(Instance inst) {
		int remainder = (int)Double.MAX_VALUE;
		int numInstanciaObservers = (int)this.observedClassDistribution.sumOfValues();
		if (numInstanciaObservers != 0 && this.gracePeriodOption.getValue() != 0) {
			remainder = (numInstanciaObservers) % (this.gracePeriodOption.getValue());
			}
		if (remainder == 0) {
			this.saveBestValGlobalEntropy = new ArrayList<ArrayList<Double>>();
			this.saveBestGlobalEntropy = new DoubleVector();
			this.saveTheBest = new ArrayList<Double>();
			this.minEntropyTemp = Double.MAX_VALUE;
			this.minEntropyNominalAttrib = Double.MAX_VALUE;
			theBestAttributes(inst, this.attributeObservers);
            boolean HB = checkBestAttrib(numInstanciaObservers, this.attributeObservers, this.observedClassDistribution);
            if (HB == true) {
            //	System.out.print("this.saveTheBest"+this.saveTheBest+"\n");
            	double attributeValue = this.saveTheBest.get(3);
    			double symbol = this.saveTheBest.get(2);		// =, <=, > : (0.0, -1.0, 1.0).
    			double value = this.saveTheBest.get(0);		// Value of the attribute
    			this.pred = new Predicates(attributeValue, symbol, value);
    			Rule Rl = new Rule();		// Create Rule.
    			Rl.predicateSet.add(pred);
    			this.ruleSet.add(Rl);
    			if (Rl.predicateSet.get(0).getSymbol() == -1.0 ||Rl.predicateSet.get(0).getSymbol() == 1.0) {
    				double posClassDouble = this.saveTheBest.get(4);
    				this.ruleClassIndex.setValue(this.ruleSet.size()-1, posClassDouble);	
    				}else{
    						this.ruleClassIndex.setValue(ruleSet.size()-1, 0.0);
    						}
					this.observedClassDistribution = new DoubleVector();
					this.attributeObservers = new AutoExpandVector<AttributeClassObserver>(); 
					this.attributeObserversGauss = new AutoExpandVector<AttributeClassObserver>();
			   	}
            }
	}
	
	//This function This expands the rule
	public void expandeRule(Rule rl, Instance inst, int ruleIndex) {
		int remainder = (int)Double.MAX_VALUE;
		int numInstanciaObservers = (int)rl.obserClassDistrib.sumOfValues();		// Number of instances for this rule observers.
		this.updateRuleAttribStatistics(inst, rl, ruleIndex);
	    if (numInstanciaObservers != 0 && this.gracePeriodOption.getValue() != 0) {
	        	 remainder = (numInstanciaObservers) % (this.gracePeriodOption.getValue());    
	        }
        if (remainder == 0){
        	this.saveBestValGlobalEntropy = new ArrayList<ArrayList<Double>>();
			this.saveBestGlobalEntropy = new DoubleVector();
			this.saveTheBest = new ArrayList<Double>();
			this.minEntropyTemp = Double.MAX_VALUE;
			this.minEntropyNominalAttrib = Double.MAX_VALUE;
	        theBestAttributes(inst, rl.observers);		// The best value of entropy for each attribute.
            boolean HB = checkBestAttrib(numInstanciaObservers, rl.observers, rl.obserClassDistrib);		// Check if the best attribute value is really the best.
    		if (HB == true) {
    			double attributeValue = this.saveTheBest.get(3);
    			double symbol = this.saveTheBest.get(2);		// =, <=, > (0.0, -1.0, 1.0).
    			double value = this.saveTheBest.get(0);		// Value of the attribute.
    			this.pred = new Predicates(attributeValue, symbol, value);
    			int countPred = 0;
    			for (int i = 0; i < rl.predicateSet.size(); i++) {		// Checks if the new predicate is not yet in the predicateSet. 
					 if (this.pred.getSymbol() == 0.0) {		// Nominal Attribute.
						 if (rl.predicateSet.get(i).getAttributeValue() != this.pred.getAttributeValue()) {
							 countPred = countPred + 1;
						 }
					 }
					 else {
						 if (rl.predicateSet.get(i).getAttributeValue() != this.pred.getAttributeValue() 
								 || rl.predicateSet.get(i).getSymbol() != this.pred.getSymbol() 
								 || rl.predicateSet.get(i).getValue() != this.pred.getValue()) {
							 countPred = countPred+1;
							 }
						 }
					 }
    			if (countPred == rl.predicateSet.size()) {
    				int countDifPred = 0;
					ArrayList<Predicates> predicSetTemp = new ArrayList<Predicates>();
					for (int x = 0; x < rl.predicateSet.size(); x++) {
						predicSetTemp.add(rl.predicateSet.get(x));
					 }
					predicSetTemp.add(this.pred);
					for (int f = 0; f < this.ruleSet.size(); f++) {
						int countDifPredTemp = 0;
						if (this.ruleSet.get(f).predicateSet.size() == predicSetTemp.size()) {
							for(int x = 0; x < this.ruleSet.get(f).predicateSet.size(); x++) {
								if (this.ruleSet.get(f).predicateSet.get(x).getAttributeValue() == predicSetTemp.get(x).getAttributeValue() 
										&& this.ruleSet.get(f).predicateSet.get(x).getSymbol() == predicSetTemp.get(x).getSymbol() 
										&& this.ruleSet.get(f).predicateSet.get(x).getValue() == predicSetTemp.get(x).getValue()) {
									countDifPredTemp = countDifPredTemp+1;
									}
								}
							if (countDifPredTemp == predicSetTemp.size()) {
								break;
								}else{
									countDifPred = countDifPred + 1;
									}
							}else{
						countDifPred = countDifPred + 1;
						}
						}
					if (countDifPred == this.ruleSet.size()) {
						if (this.pred.getSymbol() == 0.0) {
							initializeRuleStatistics(rl, pred, inst);
			    			} else if (this.pred.getSymbol() == 1.0) {
			    				int countIqualPred = 0;
			    				for (int f = 0; f < rl.predicateSet.size(); f++) {
			    					if (this.pred.getAttributeValue() == rl.predicateSet.get(f).getAttributeValue()
			    							&& this.pred.getSymbol() == rl.predicateSet.get(f).getSymbol()) {
			    						countIqualPred = countIqualPred + 1;
			    						if (this.pred.getValue() > rl.predicateSet.get(f).getValue()) {
			    							rl.predicateSet.remove(f);
			    							initializeRuleStatistics(rl, pred, inst);
	    				    				}
			    						}
			    					}
			    				if (countIqualPred == 0) {
			    					initializeRuleStatistics(rl, pred, inst);
	    				    		}
			    				}else{
	    						 int countIqualPred = 0;
	    						 for (int f = 0; f < rl.predicateSet.size(); f++) {
	    							 if (this.pred.getAttributeValue() == rl.predicateSet.get(f).getAttributeValue()
	    									 && this.pred.getSymbol() == rl.predicateSet.get(f).getSymbol()) {
	    								 countIqualPred = countIqualPred + 1;
	    								 if (this.pred.getValue() < rl.predicateSet.get(f).getValue()) {
	    									 rl.predicateSet.remove(f);
	    									 initializeRuleStatistics(rl, pred, inst);
	    				    				 }
	    								 }
	    							 }
	    						 if (countIqualPred == 0) {
	    							 initializeRuleStatistics(rl, pred, inst);
	    							 }
	    						 }
						}
					}
    			}
    		}
        }
		
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
	// This function gives the best value of entropy for each attribute
	public void theBestAttributes(Instance instance, 
			AutoExpandVector<AttributeClassObserver> observersParameter) {
		for(int z = 0; z < instance.numAttributes() - 1; z++){
<<<<<<< HEAD
			int instAttIndex = modelAttIndexToInstanceAttIndex(z, instance);
			ArrayList<Double> attribBest = new ArrayList<Double>();
			if(instance.attribute(instAttIndex).isNominal()){
				minEntropyNominalAttrib=Double.MAX_VALUE;	
				AutoExpandVector<DoubleVector> attribNominal = ((NominalAttributeClassObserver)observersParameter.get(z)).attValDistPerClass;
				findBestValEntropyNominalAtt(attribNominal);		// The best value (lowest entropy) of a nominal attribute.
	            attribBest.add(saveBestEntropyNominalAttrib.getValue(0));
	            attribBest.add(saveBestEntropyNominalAttrib.getValue(1));
	            attribBest.add(saveBestEntropyNominalAttrib.getValue(2));
	            saveBestValGlobalEntropy.add(attribBest);
	            saveBestGlobalEntropy.add(saveBestEntropyNominalAttrib.getValue(1));
	            } else {
	            	root=((BinaryTreeNumericAttributeClassObserver)observersParameter.get(z)).root;
					mainFindBestValEntropy(root);		// The best value (lowest entropy) of a numeric attribute.
		            attribBest.add(saveBestEntropy.getValue(0));
		            attribBest.add(saveBestEntropy.getValue(1));
		            attribBest.add(saveBestEntropy.getValue(2));
		            attribBest.add(saveBestEntropy.getValue(4));
		            saveBestValGlobalEntropy.add(attribBest);
		            saveBestGlobalEntropy.add(saveBestEntropy.getValue(1));
		            }
			}
		}
	
	public double  nominalAttributeEntropy(ArrayList<Double> valorDistClassE) {
		double entropy = 0.0;
		double sum = 0.0;
		for (double d : valorDistClassE) {
			if (d > 0.0) {
				entropy -= d * Utils.log2(d);
				sum += d;
				}
			}
		return sum > 0.0 ? (entropy + sum * Utils.log2(sum)) / sum : 0.0;
		}
	
=======
			if(!instance.isMissing(z)){
			int instAttIndex = modelAttIndexToInstanceAttIndex(z, instance);
			ArrayList<Double> attribBest = new ArrayList<Double>();
			if(instance.attribute(instAttIndex).isNominal()){
				this.minEntropyNominalAttrib=Double.MAX_VALUE;	
				AutoExpandVector<DoubleVector> attribNominal = ((NominalAttributeClassObserver)observersParameter.get(z)).attValDistPerClass;
				findBestValEntropyNominalAtt(attribNominal, instance.attribute(z).numValues());		// The best value (lowest entropy) of a nominal attribute.
	            attribBest.add(this.saveBestEntropyNominalAttrib.getValue(0));
	            attribBest.add(this.saveBestEntropyNominalAttrib.getValue(1));
	            attribBest.add(this.saveBestEntropyNominalAttrib.getValue(2));
	            this.saveBestValGlobalEntropy.add(attribBest);
	            this.saveBestGlobalEntropy.setValue(z, this.saveBestEntropyNominalAttrib.getValue(1));
	            } else {
	            	this.root=((BinaryTreeNumericAttributeClassObserver)observersParameter.get(z)).root;
					mainFindBestValEntropy(this.root);		// The best value (lowest entropy) of a numeric attribute.
		            attribBest.add(this.saveBestEntropy.getValue(0));
		            attribBest.add(this.saveBestEntropy.getValue(1));
		            attribBest.add(this.saveBestEntropy.getValue(2));
		            attribBest.add(this.saveBestEntropy.getValue(4));
		            this.saveBestValGlobalEntropy.add(attribBest);
		            this.saveBestGlobalEntropy.setValue(z, this.saveBestEntropy.getValue(1));
		            }
			}else{
				 double value = Double.MAX_VALUE;
				 this.saveBestGlobalEntropy.setValue(z, value);
				 }
			}
	}
	
	// Compute Entropy
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
	public double entropy(DoubleVector ValorDistClassE) {
		double entropy = 0.0;
		double sum = 0.0;
		for (double d : ValorDistClassE.getArrayCopy()) {
			if (d > 0.0) {
				entropy -= d * Utils.log2(d);
				sum += d;
				}
			}
		return sum > 0.0 ? (entropy + sum * Utils.log2(sum)) / sum : 0.0;
		}
	
	// Get the best value of entropy and its cutPoint for a numeric attribute
	public void findBestValEntropy(Node node, DoubleVector classCountL, DoubleVector classCountR,
<<<<<<< HEAD
			boolean status, double minEntropy, ArrayList<Double> parentCCLeft ){
		double classCountLEntropy;		// Entropy of class count left.
		double classCountREntropy;		// Entropy of class count right.
		if (root != null) {
			double numInst = root.classCountsLeft.sumOfValues() + root.classCountsRight.sumOfValues();
=======
			boolean status, double minEntropy, DoubleVector parentCCLeft ){
		if (this.root != null) {
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
			if (node != null) {
				int numClass=0;
				DoubleVector classCountLTemp = new DoubleVector(); 
				DoubleVector classCountRTemp = new DoubleVector(); 
				DoubleVector parentCCL = new DoubleVector();
<<<<<<< HEAD
				ArrayList<Double> parentCCLParameter = new ArrayList<Double> ();
				for (int f = 0; f < node.classCountsLeft.numValues(); f++) {
					parentCCLParameter.add(node.classCountsLeft.getValue(f));
					}
				for (int p = 0; p < parentCCLeft.size(); p++) {
					parentCCL.addToValue(p, parentCCLeft.get(p));
=======
				DoubleVector parentCCLParameter = new DoubleVector();
				for (int f = 0; f < node.classCountsLeft.numValues(); f++) {
					parentCCLParameter.setValue(f, node.classCountsLeft.getValue(f));
					}
				for (int p = 0; p < parentCCLeft.numValues(); p++) {
					parentCCL.addToValue(p, parentCCLeft.getValue(p));
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
					}
				if (classCountL.numValues() >= classCountR.numValues()) {
					numClass = classCountL.numValues();
				} else {
					numClass = classCountR.numValues();
				}
				// Counting the real class count left and the real class count right.
<<<<<<< HEAD
				if (node.cut_point != root.cut_point) {
=======
				if (node.cut_point != this.root.cut_point) {
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
					for (int i = 0; i < numClass; i++) {
						if (status == true) {		// Left node.
							double parentss = parentCCL.getValue(i) - (node.classCountsLeft.getValue(i) 
									+ node.classCountsRight.getValue(i));
						    double left = classCountL.getValue(i) 
						    		- node.classCountsRight.getValue(i) - parentss;
						    double right = classCountR.getValue(i) 
						    		+ node.classCountsRight.getValue(i) + parentss;
						    classCountLTemp.addToValue(i, left);
					        classCountRTemp.addToValue(i, right);
					        }
						if (status == false) {		// Right node.
							double left = classCountL.getValue(i)+ node.classCountsLeft.getValue(i);
							double right = classCountR.getValue(i)- node.classCountsLeft.getValue(i);
							classCountLTemp.addToValue(i, left);
							classCountRTemp.addToValue(i, right);
							}
						}
					} else {
						classCountLTemp = classCountL;
						classCountRTemp = classCountR;
						}
				double classCountLSum = classCountLTemp.sumOfValues();
				double classCountRSum = classCountRTemp.sumOfValues();
<<<<<<< HEAD
				// The entropy value for all nodes except for the root.
				if ((classCountLSum > PminOption.getValue()*numInst) 
						&& (classCountRSum > PminOption.getValue() * numInst)) {
					classCountLEntropy = entropy( classCountLTemp);
					classCountREntropy = entropy(classCountRTemp);
					if (((classCountLSum / numInst) * classCountLEntropy + (classCountRSum / numInst)* classCountREntropy) <= minEntropy) {
						minEntropyTemp = (classCountLSum / numInst) * classCountLEntropy 
								+ (classCountRSum / numInst) * classCountREntropy;
						cutPointTemp = node.cut_point;
						if (classCountLEntropy <= classCountREntropy) {
							symbol = -1.0;
=======
				double numInst = this.root.classCountsLeft.sumOfValues() + this.root.classCountsRight.sumOfValues();
				// The entropy value for all nodes except for the root.
				if ((classCountLSum > this.PminOption.getValue()*numInst) 
						&& (classCountRSum > this.PminOption.getValue() * numInst)) {
					double classCountLEntropy = entropy( classCountLTemp);   // Entropy of class count left.
					double classCountREntropy = entropy(classCountRTemp);    // Entropy of class count right
					if (((classCountLSum / numInst) * classCountLEntropy + (classCountRSum / numInst)* classCountREntropy) <= minEntropy) {
						this.minEntropyTemp = (classCountLSum / numInst) * classCountLEntropy 
								+ (classCountRSum / numInst) * classCountREntropy;
						this.cutPointTemp = node.cut_point;
						if (classCountLEntropy <= classCountREntropy) {
							this.symbol = -1.0;
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
							double value = 0.0;
							double index = 0.0;
							for (int h = 0; h < numClass; h++) {
								if (value <= classCountLTemp.getValue(h)) {
									value = classCountLTemp.getValue(h);
					    			index = (double)h;
					    			}
								}
<<<<<<< HEAD
							saveBestEntropy.setValue(0, cutPointTemp);
					    	saveBestEntropy.setValue(1, classCountLEntropy);
					    	saveBestEntropy.setValue(2, symbol);
					    	saveBestEntropy.setValue(4, index);
					    	} else {
					    		symbol = 1.0;
=======
							this.saveBestEntropy.setValue(0, this.cutPointTemp);
							this.saveBestEntropy.setValue(1, classCountLEntropy);
							this.saveBestEntropy.setValue(2, this.symbol);
							this.saveBestEntropy.setValue(4, index);
					    	} else {
					    		this.symbol = 1.0;
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
					    		double value = 0.0;
					    		double index = 0.0;
					    		for (int h = 0; h < numClass; h++) {
					    			if (value <= classCountRTemp.getValue(h)) {
					    				value = classCountRTemp.getValue(h);
					    				index = (double)h;
					    				}
					    			}
<<<<<<< HEAD
					    		saveBestEntropy.setValue(0, cutPointTemp);
						    	saveBestEntropy.setValue(1, classCountREntropy);
						    	saveBestEntropy.setValue(2, symbol);
						    	saveBestEntropy.setValue(4, index);
=======
					    		this.saveBestEntropy.setValue(0, this.cutPointTemp);
					    		this.saveBestEntropy.setValue(1, classCountREntropy);
					    		this.saveBestEntropy.setValue(2, this.symbol);
					    		this.saveBestEntropy.setValue(4, index);
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
						    	}
						}
					}
				findBestValEntropy(node.left ,classCountLTemp , classCountRTemp,
<<<<<<< HEAD
						true, minEntropyTemp, parentCCLParameter);
				findBestValEntropy(node.right ,classCountLTemp , classCountRTemp,
						false, minEntropyTemp, parentCCLParameter);
=======
						true, this.minEntropyTemp, parentCCLParameter);
				findBestValEntropy(node.right ,classCountLTemp , classCountRTemp,
						false, this.minEntropyTemp, parentCCLParameter);
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
				}
			}
		}
	
<<<<<<< HEAD
	public void mainFindBestValEntropy(Node root) {
		if (root != null) {
			ArrayList<Double> parentClassCL=new  ArrayList<Double>();
=======
	//Best value of entropy 
	public void mainFindBestValEntropy(Node root) {
		if (root != null) {
			DoubleVector parentClassCL = new DoubleVector();
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
			DoubleVector classCountL = root.classCountsLeft; //class count left
			DoubleVector classCountR = root.classCountsRight; //class count left
			double numInst = root.classCountsLeft.sumOfValues() + root.classCountsRight.sumOfValues();
			double classCountLSum = root.classCountsLeft.sumOfValues();
			double classCountRSum = root.classCountsRight.sumOfValues();
			double classCountLEntropy = entropy(classCountL);
			double classCountREntropy = entropy(classCountR);
<<<<<<< HEAD
			minEntropyTemp = ( classCountLSum / numInst) * classCountLEntropy 
					+ (classCountRSum / numInst)* classCountREntropy;
			for (int f = 0; f < root.classCountsLeft.numValues(); f++) {
				parentClassCL.add(root.classCountsLeft.getValue(f));
				}
			findBestValEntropy(root ,classCountL , classCountR, true, minEntropyTemp, parentClassCL);
			}
		}
	
	public void findBestValEntropyNominalAtt(AutoExpandVector<DoubleVector> attrib) {
		double count;
		double sumValue = 0.0;
		int classNumVal = 0;
		ArrayList<ArrayList<Double>> distClassValue =  new ArrayList<ArrayList<Double>>();
		saveBestEntropyNominalAttrib = new DoubleVector();
		for (int v = 0; v < attrib.size(); v++) {
			if (attrib.get(v)!= null) {
				if (attrib.get(v).numValues() > classNumVal) {
					classNumVal=attrib.get(v).numValues();
					}
				}
			}
		for (int d = 0; d < attrib.size(); d++) {		 // For each class gets their values.
			distClassValue.add(new ArrayList<Double>());
			count = 0.0;
			if (attrib.get(d) != null) {
				for (int e = 0; e < classNumVal; e++) {	
	      		double valor = attrib.get(d).getValue(e);
	      		count = count + valor;
	      		distClassValue.get(d).add(valor);
	      		}
				}
			}
		for (int l = 0; l < distClassValue.size(); l++) {
			if (distClassValue.get(l).isEmpty()) {
				for (int h = 0; h < classNumVal; h++){
					distClassValue.get(l).add(0.0);
					}
				}
			}
		for (int i = 0; i < distClassValue.get(0).size(); i++) {
			ArrayList<Double> saveVal = new ArrayList<Double>();
			for (int j = 0; j < distClassValue.size(); j++){
				double valor = distClassValue.get(j).get(i) ;
				saveVal.add(valor);
				}
			sumValue = getSumOfValue(saveVal);
			double entropyVal = nominalAttributeEntropy(saveVal);
			if (entropyVal <= minEntropyNominalAttrib) {
				minEntropyNominalAttrib = entropyVal;
				saveBestEntropyNominalAttrib.setValue(0, i);
				saveBestEntropyNominalAttrib.setValue(1, entropyVal);
				saveBestEntropyNominalAttrib.setValue(2, 0.0);
				}
			}
		}
	
	public double getSumOfValue(ArrayList<Double> values) {
		double sum = 0.0;
		for (int w = 0; w < values.size(); w++) {
			sum = sum + values.get(w);
    		}
		return sum;
		}
=======
			this.minEntropyTemp = ( classCountLSum / numInst) * classCountLEntropy 
					+ (classCountRSum / numInst)* classCountREntropy;
			for (int f = 0; f < root.classCountsLeft.numValues(); f++) {
				parentClassCL.setValue(f, root.classCountsLeft.getValue(f));
				}
			findBestValEntropy(root ,classCountL , classCountR, true, this.minEntropyTemp, parentClassCL);
			}
		}
	
	//Find best value of entropy for nominal attributes
	public void findBestValEntropyNominalAtt(AutoExpandVector<DoubleVector> attrib, int attNumValues) {
		ArrayList<ArrayList<Double>> distClassValue =  new ArrayList<ArrayList<Double>>();
	//	System.out.print("attrib"+attrib+"\n");
		for (int z = 0; z < attrib.size(); z++) {
			distClassValue.add(new ArrayList<Double>());	
		}
		for (int v = 0; v < attNumValues; v++) {
			DoubleVector saveVal = new DoubleVector();
			for (int z = 0; z < attrib.size(); z++) {
				if (attrib.get(z) != null) {
					distClassValue.get(z).add(attrib.get(z).getValue(v));
				} else {
					distClassValue.get(z).add(0.0);
				}
				if(distClassValue.get(z).get(v).isNaN()) {
					distClassValue.get(z).add(0.0);
				}
				saveVal.setValue(z, distClassValue.get(z).get(v));
				}
			double sumValue = saveVal.sumOfValues();
			if (sumValue > 0.0) {
				double entropyVal = entropy(saveVal);
			    if (entropyVal <= this.minEntropyNominalAttrib) {
			    	this.minEntropyNominalAttrib = entropyVal;
			    	this.saveBestEntropyNominalAttrib.setValue(0, v);
			    	this.saveBestEntropyNominalAttrib.setValue(1, entropyVal);
			    	this.saveBestEntropyNominalAttrib.setValue(2, 0.0);
			    	}
			    }
			}
		}
	
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
	
	//Hoeffding Bound 
	public  double ComputeHoeffdingBound(double range, double confidence,
		            double n) {
		return Math.sqrt(((range * range) * Math.log(1.0 / confidence))
		                / (2.0 * n));
		}
	
<<<<<<< HEAD
	public boolean checkBestAttrib(double n, Instance inst,
			AutoExpandVector<AttributeClassObserver> observerss){
		double h0 = globalEntropy(inst, observerss);
		boolean  isTheBest = false;
		double bestEntropy = saveBestGlobalEntropy.get(0);
		double secondBestEntropy = saveBestGlobalEntropy.get(1);
	    double range = Utils.log2(numClass);
		double hoeffdingBound = ComputeHoeffdingBound(range, splitConfidenceOption.getValue(), n);
		if ((h0 > bestEntropy) && ((secondBestEntropy - bestEntropy > hoeffdingBound)
				|| (hoeffdingBound < tieThresholdOption.getValue()))) {
			for (int i = 0; i < saveBestValGlobalEntropy.size(); i++) {
				if (bestEntropy ==(saveBestValGlobalEntropy.get(i).get(1))) {
					saveTheBest.add(saveBestValGlobalEntropy.get(i).get(0)); 
					saveTheBest.add(saveBestValGlobalEntropy.get(i).get(1));
					saveTheBest.add(saveBestValGlobalEntropy.get(i).get(2)); 
					saveTheBest.add((double)i);
					if (saveTheBest.get(2) != 0.0) {
						saveTheBest.add(saveBestValGlobalEntropy.get(i).get(3)); 
						}
=======
	//Check if the best attribute is really the best
	public boolean checkBestAttrib(double n,
			AutoExpandVector<AttributeClassObserver> observerss, DoubleVector observedClassDistribution){
		double h0 = entropy(observedClassDistribution);
		boolean  isTheBest = false;
		double[] entropyValues = getBestSecondBestEntropy(this.saveBestGlobalEntropy);
		double bestEntropy = entropyValues[0];
		double secondBestEntropy = entropyValues[1];
	    double range = Utils.log2(this.numClass);
		double hoeffdingBound = ComputeHoeffdingBound(range, this.splitConfidenceOption.getValue(), n);
		if ((h0 > bestEntropy) && ((secondBestEntropy - bestEntropy > hoeffdingBound)
				|| (hoeffdingBound < this.tieThresholdOption.getValue()))) {
			for (int i = 0; i < this.saveBestValGlobalEntropy.size(); i++) {
				if (bestEntropy ==(this.saveBestValGlobalEntropy.get(i).get(1))) {
					this.saveTheBest.add(this.saveBestValGlobalEntropy.get(i).get(0)); 
					this.saveTheBest.add(this.saveBestValGlobalEntropy.get(i).get(1));
					this.saveTheBest.add(this.saveBestValGlobalEntropy.get(i).get(2)); 
					this.saveTheBest.add((double)i);
					if (this.saveTheBest.get(2) != 0.0) {
						this.saveTheBest.add(this.saveBestValGlobalEntropy.get(i).get(3)); 
						}
					break;
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
					}
				}
			isTheBest = true;
			} else {
				isTheBest = false;
				}
		return isTheBest;
		}
	
<<<<<<< HEAD
	protected int observersNumberInstance(Instance inst, 
			AutoExpandVector<AttributeClassObserver> observerss) {
		int numberInstance = 0;
		for (int z = 0; z < inst.numAttributes() - 1; z++) {
			numberInstance = 0;
			int instAttIndex = modelAttIndexToInstanceAttIndex(z, inst);
			if (inst.attribute(instAttIndex).isNumeric()) {
				Node rootNode = ((BinaryTreeNumericAttributeClassObserver) observerss.get(z)).root;
				if (rootNode != null) {
					numberInstance = (int) (rootNode.classCountsLeft.sumOfValues() + rootNode.classCountsRight.sumOfValues());
					break;
					}
				} else {
					AutoExpandVector<DoubleVector> nominalAttrib = ((NominalAttributeClassObserver) observerss.get(z)).attValDistPerClass;
					for (int d = 0; d < nominalAttrib.size(); d++) {
						if(nominalAttrib.get(d) != null){
							for (int e = 0; e < nominalAttrib.get(d).numValues(); e++) {
								double value = nominalAttrib.get(d).getValue(e);
								numberInstance = numberInstance + (int)value;
								}
							}
						}
					}
			}
		return numberInstance;
		}
	
	protected Integer getCount(Instance inst,  ArrayList<Predicates> PredSet){
		int count = 0;
		for (int y = 0; y < PredSet.size(); y++) {
			int i =(int) (PredSet.get(y).getAttributeValue());
			int instAttIndex = modelAttIndexToInstanceAttIndex(i, inst);
			if (inst.attribute(instAttIndex).isNominal()) {
				if (PredSet.get(y).getSymbol() == 0.0) {
					String val = inst.attribute((int)PredSet.get(y).getAttributeValue()).value((int)PredSet.get(y).getValue());
					if ((val == inst.stringValue(i))
							&& (inst.attribute(i).index() == inst.attribute((int)PredSet.get(y).getAttributeValue()).index())) {
							count = count + 1;
							}
					}
				} else {
					if (PredSet.get(y).getSymbol() == -1.0) {
						if ((inst.value(i) <= PredSet.get(y).getValue()) 
								&& (inst.attribute(i).index() == inst.attribute((int)PredSet.get(y).getAttributeValue()).index())) {
								count = count+1;
								}
						} else if (PredSet.get(y).getSymbol() == 1.0) {
							if((inst.value(i) > PredSet.get(y).getValue()) 
									&& (inst.attribute(i).index() == inst.attribute((int)PredSet.get(y).getAttributeValue()).index())) {
									count = count+1;
									}
							}
					}
			}
		return count;
		}
	
	protected void getRuleClass(Instance inst, int ruleIndex) {
		double classID = inst.classValue();
		int pos = (int)(classID);
		if (majority.get(ruleIndex).isEmpty()) {
			for ( int i = 0; i < inst.numClasses(); i++) {
				majority.get(ruleIndex).add(0);
				}
			}
		majority.get(ruleIndex).set(pos, majority.get(ruleIndex).get(pos) + 1);
		}
	
	protected String getRuleMajorityClass(int ruleIndex, Instance inst) {
		ArrayList<Integer>ruleClassOrdered = new ArrayList<Integer>();
		ArrayList<Integer>ruleClass = new ArrayList<Integer>();
		for (int j = 0; j < majority.get(ruleIndex).size(); j++) {
			ruleClassOrdered.add(majority.get(ruleIndex).get(j));
			ruleClass.add(majority.get(ruleIndex).get(j));
			}
		Collections.sort(ruleClassOrdered);
		int maiorValor = ruleClassOrdered.get(ruleClassOrdered.size()-1);
		int posMaxValor = ruleClass.indexOf(maiorValor);
		String classe = inst.classAttribute().value(posMaxValor);
		return classe;
		}
	
	protected ArrayList<Double> oberversDistrib(Instance inst,
			AutoExpandVector<AttributeClassObserver> observerss) {
		ArrayList<Double> classDistrib=new ArrayList<Double>();
		for (int z = 0; z < inst.numAttributes() - 1; z++) {
			classDistrib = new ArrayList<Double>();
			int instAttIndex = modelAttIndexToInstanceAttIndex(z, inst);
			if (inst.attribute(instAttIndex).isNumeric()) {
				if(observerss.get(z)!=null){
				Node rootNode = ((BinaryTreeNumericAttributeClassObserver) observerss.get(z)).root;
				if (rootNode != null) {
					double sum;
					for (int i = 0; i <rootNode.classCountsRight.numValues(); i++) {
						sum=rootNode.classCountsLeft.getValue(i)+rootNode.classCountsRight.getValue(i);
						classDistrib.add(sum);
						}
					break;
					}
				}
				} else {
					if(observerss.get(z)!=null){
					AutoExpandVector<DoubleVector> atribNominal = ((NominalAttributeClassObserver) observerss.get(z)).attValDistPerClass;
					for (int d = 0; d < atribNominal.size(); d++) {
						double sumValue = 0;
						if (atribNominal.get(d) != null) {
							for (int e = 0; e < atribNominal.get(d).numValues(); e++) {
								double value = atribNominal.get(d).getValue(e);
								sumValue = sumValue + (int)value;
								}
							classDistrib.add(sumValue);
							}
						}
					break;
					}
				}
			}
		return classDistrib;
	}
	

	
	protected double globalEntropy(Instance inst,AutoExpandVector<AttributeClassObserver> observerss) {
		ArrayList<Double> classDistrib = oberversDistrib(inst, observerss);
		double globalEntropy = nominalAttributeEntropy(classDistrib);
		return globalEntropy;
		}
	
	protected double[] oberversDistribProb(Instance inst,
			AutoExpandVector<AttributeClassObserver> observerss) {
		double[] votes = new double[observedClassDistribution.numValues()];
		double sum = 0;
		ArrayList<Double> classDistrib = oberversDistrib(inst, observerss);
		for (int k = 0; k < classDistrib.size(); k++) {
			sum = sum + classDistrib.get(k);
			}
		for (int z = 0; z < classDistrib.size(); z++) {
			votes[z] = classDistrib.get(z) / sum;
=======
	//Get best and second best attributes
	protected double [] getBestSecondBestEntropy(DoubleVector entropy){
		double[] entropyValues = new double[2];
		double best = Double.MAX_VALUE;
		double secondBest = Double.MAX_VALUE;
		for (int i = 0; i < entropy.numValues(); i++) {
			if (entropy.getValue(i) < best) {
				secondBest = best;
				best = entropy.getValue(i);
			} else{
				if (entropy.getValue(i) < secondBest) {
					secondBest = entropy.getValue(i);
				}
			}
			}
		entropyValues[0] = best;
		entropyValues[1] = secondBest;
		
		return entropyValues;
	}
	
	//Get rule majority class index	
	protected double getRuleMajorityClassIndex(Rule r) {
		double maxvalue = 0.0;
		int posMaxValue = 0;
		for (int i = 0; i < r.obserClassDistrib.numValues(); i++) {
			if (r.obserClassDistrib.getValue(i) > maxvalue) {
				maxvalue = r.obserClassDistrib.getValue(i);
				posMaxValue = i;
			}
		}
		return (double)posMaxValue;
	}
		
    //Get observers class distribution probability
	protected double[] oberversDistribProb(Instance inst,
			DoubleVector classDistrib) {
		double[] votes = new double[this.numClass];
		double sum = classDistrib.sumOfValues();
		for (int z = 0; z < this.numClass; z++) {
			votes[z] = classDistrib.getValue(z) / sum;
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
			}
		return votes;
		}
	
	// The following three functions are used for the prediction 
	protected double[] firstHit(Instance inst) {
		boolean fired = false;
		int countFired = 0;
<<<<<<< HEAD
		double[] votes = new double[observedClassDistribution.numValues()];
		for (int j = 0; j < ruleSet.size(); j++) {
			if (ruleSet.get(j).ruleEvaluate(inst) == true) {
				countFired = countFired + 1;
				for (int z = 0; z < majority.get(j).size(); z++) {
					votes[z] = ruleSet.get(j).obserClassDistrib.getValue(z) 
							/ ruleSet.get(j).obserClassDistrib.sumOfValues();
					}
				return votes;
			//	break;
=======
		double[] votes = new double[this.numClass];
		for (int j = 0; j < this.ruleSet.size(); j++) {
			if (this.ruleSet.get(j).ruleEvaluate(inst) == true) {
				countFired = countFired + 1;
				for (int z = 0; z < this.numClass; z++) {
					votes[z] = this.ruleSet.get(j).obserClassDistrib.getValue(z) 
							/ this.ruleSet.get(j).obserClassDistrib.sumOfValues();
					}
				return votes;
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
				}
			}
		if (countFired > 0) {
			fired = true;
			} else {
				fired = false;
				}
		if (fired == false) {
<<<<<<< HEAD
			votes = oberversDistribProb(inst, this.attributeObservers);
=======
			votes = oberversDistribProb(inst, this.observedClassDistribution);
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
			}
		return votes;
		}
	
<<<<<<< HEAD
=======
	//Get the votes using weighted Max
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
	protected double[] weightedMax(Instance inst) {
		int countFired = 0;
		boolean fired = false;
		double highest = 0.0;
<<<<<<< HEAD
		double[] votes = new double[observedClassDistribution.numValues()];
		ArrayList<Double> ruleSetVotes = new ArrayList<Double>();
		ArrayList<ArrayList<Double>> majorityProb = new ArrayList<ArrayList<Double>>();
		for (int j = 0; j < ruleSet.size(); j++) {
			ArrayList<Double> ruleProb = new ArrayList<Double>();
			if (ruleSet.get(j).ruleEvaluate(inst) == true) {
				countFired = countFired+1;
				for (int z = 0; z < majority.get(j).size(); z++) {
					ruleSetVotes.add(ruleSet.get(j).obserClassDistrib.getValue(z) / ruleSet.get(j).obserClassDistrib.sumOfValues());
		    	    ruleProb.add(ruleSet.get(j).obserClassDistrib.getValue(z) / ruleSet.get(j).obserClassDistrib.sumOfValues());
=======
		double[] votes = new double[this.numClass];
		ArrayList<Double> ruleSetVotes = new ArrayList<Double>();
		ArrayList<ArrayList<Double>> majorityProb = new ArrayList<ArrayList<Double>>();
		for (int j = 0; j < this.ruleSet.size(); j++) {
			ArrayList<Double> ruleProb = new ArrayList<Double>();
			if (this.ruleSet.get(j).ruleEvaluate(inst) == true) {
				countFired = countFired+1;
				for (int z = 0; z < this.numClass; z++) {
					ruleSetVotes.add(this.ruleSet.get(j).obserClassDistrib.getValue(z) / this.ruleSet.get(j).obserClassDistrib.sumOfValues());
		    	    ruleProb.add(this.ruleSet.get(j).obserClassDistrib.getValue(z) / this.ruleSet.get(j).obserClassDistrib.sumOfValues());
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
		    	    }
				majorityProb.add(ruleProb);
				}
			}
		if (countFired > 0) {
			fired = true;
			Collections.sort(ruleSetVotes); 
		    highest = ruleSetVotes.get(ruleSetVotes.size() - 1);
		    for (int t = 0; t < majorityProb.size(); t++) {
				 for(int m = 0; m < majorityProb.get(t).size(); m++) {
					 if (majorityProb.get(t).get(m) == highest) {
						 for (int h = 0; h < majorityProb.get(t).size(); h++) {
							 votes[h] = majorityProb.get(t).get(h);
							 }
						 break;
						 }
					 }
				 }
		    } else {
		    	fired = false;
		    	}
		if (fired == false) {
<<<<<<< HEAD
			votes = oberversDistribProb(inst, this.attributeObservers);
=======
			votes = oberversDistribProb(inst, this.observedClassDistribution);
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
			}
		return votes;
		}
	
<<<<<<< HEAD
	protected double[] weightedSum(Instance inst) {
		boolean fired = false;
		int countFired = 0;
		double[] votes = new double[observedClassDistribution.numValues()];
		ArrayList<Double> weightSum = new ArrayList<Double>();
		ArrayList<ArrayList<Double>> majorityProb = new ArrayList<ArrayList<Double>>();
		for (int j = 0; j < ruleSet.size(); j++) {
			ArrayList<Double> ruleProb = new ArrayList<Double>();
			if (ruleSet.get(j).ruleEvaluate(inst) == true) {
				countFired = countFired + 1;
				for (int z = 0; z < majority.get(j).size(); z++) {
					ruleProb.add(ruleSet.get(j).obserClassDistrib.getValue(z) / ruleSet.get(j).obserClassDistrib.sumOfValues());
=======
	//Get the votes using weighted Sum
	protected double[] weightedSum(Instance inst) {
		boolean fired = false;
		int countFired = 0;
		double[] votes = new double[this.numClass];
		ArrayList<Double> weightSum = new ArrayList<Double>();
		ArrayList<ArrayList<Double>> majorityProb = new ArrayList<ArrayList<Double>>();
		for (int j = 0; j < this.ruleSet.size(); j++) {
			ArrayList<Double> ruleProb = new ArrayList<Double>();
			if (this.ruleSet.get(j).ruleEvaluate(inst) == true) {
				countFired = countFired + 1;
				for (int z = 0; z < this.numClass; z++) {
					ruleProb.add(this.ruleSet.get(j).obserClassDistrib.getValue(z) / this.ruleSet.get(j).obserClassDistrib.sumOfValues());
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
					}
				majorityProb.add(ruleProb);
				}
			}
		if (countFired > 0) {
			fired = true;
			for (int m = 0; m < majorityProb.get(0).size(); m++) {
				double sum = 0.0;
				for (int t = 0; t < majorityProb.size(); t++){
					sum = sum + majorityProb.get(t).get(m);
					}
				weightSum.add(sum);
				}
			for (int h = 0; h < weightSum.size(); h++) {
				votes[h] = weightSum.get(h) / majorityProb.size();
				}
			} else {
				fired = false;
				}
		if (fired == false) {
<<<<<<< HEAD
			votes = oberversDistribProb(inst, this.attributeObservers);
=======
			votes = oberversDistribProb(inst, this.observedClassDistribution);
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
			}
		return votes;
		}
	
<<<<<<< HEAD
=======
	
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
	protected AttributeClassObserver newNominalClassObserver() {
		return new NominalAttributeClassObserver();
    }
 
    protected AttributeClassObserver newNumericClassObserver() {
    	return new BinaryTreeNumericAttributeClassObserver();
    }
<<<<<<< HEAD
=======
    
>>>>>>> 11d381b22515b9114312bca4f8718025eae5b72f
    protected AttributeClassObserver newNumericClassObserver2() {
    	return new GaussianNumericAttributeClassObserver();
		    }
    
    public void manageMemory(int currentByteSize, int maxByteSize) {
        // TODO Auto-generated method stub
    }
    }
