package moa.classifiers.core.driftdetection;

import weka.core.Instance;
import moa.core.ObjectRepository;
import moa.options.AbstractOptionHandler;
import moa.options.IntOption;
import moa.tasks.TaskMonitor;

public class InerDistributionDriftDetectionMethod extends AbstractOptionHandler implements DriftDetectionMethod {
	private static final long serialVersionUID = 1L;

    public IntOption minNumInstancesOption = new IntOption(
            "minNumInstances",
            'n',
            "The minimum number of instances before permitting detecting change.",
            30, 0, Integer.MAX_VALUE);
    /*
     * SingleclassifierDrift Only give prediction result rather than give instance, this method will need instance to compute distribution
     */
    public InerDistributionDriftDetectionMethod (){
    	//initialize();
    }
	@Override
	public int computeNextVal(boolean prediction) {
		// TODO Auto-generated method stub
		return (int) (Math.random()*10)%3;
	}

	@Override
	public void getDescription(StringBuilder sb, int indent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareForUseImpl(TaskMonitor monitor,
			ObjectRepository repository) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public DriftDetectionMethod copy() {
        return (DriftDetectionMethod) super.copy();
    }
	@Override
	public int computeNextVal(boolean prediction, Instance inst) {
		// TODO Auto-generated method stub
		return 0;
	}
}
