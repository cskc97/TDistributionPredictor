import java.util.ArrayList;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class Predictor {
	
	public static double predictionValue(ArrayList<Double> scores)
	{	
		
		double tPercentValue = 2.132; //assuming 4 degrees of freedom and 95% lower bound confidence interval.
		int sampleSize=  scores.size(); //n value
		
		TDistribution tdistribution = new TDistribution((scores.size()-1));
		
		
		
		
		double t_percentage=tdistribution.density(tPercentValue); //t value
		
		//need to get mean and standard deviation
		
				
		double[] values_array = new double[sampleSize];
		
		
		for(int counter=0;counter<scores.size();counter++)
		{
			values_array[counter]=scores.get(counter).doubleValue();
			
		}	
		
		Mean mean = new Mean();
		
		double meanVal = mean.evaluate(values_array); //mean
		
		StandardDeviation standardDeviation = new StandardDeviation();
		
		double stdDevVal = standardDeviation.evaluate(values_array); //standard deviation
		
		//Going to calculate lower bound
		
		double lowerBound = meanVal - (t_percentage*stdDevVal)*(1+(1/sampleSize));
		
		return lowerBound;
		
		
		
		
		
		
		
	
	}
	
	
	

	
	
	
	
	public static void main(String[] args)
	{	
		ArrayList<Double> scores = new ArrayList<Double>();
		scores.add(Double.valueOf(98));
		scores.add(Double.valueOf(95));
		scores.add(Double.valueOf(96));
		scores.add(Double.valueOf(93));
		scores.add(Double.valueOf(92));
		
		double value5 = 2.132;
		
		System.out.println("You will get at least "+ Math.round(Predictor.predictionValue(scores)) + " in your next exam");
		
	}
	
	
}


