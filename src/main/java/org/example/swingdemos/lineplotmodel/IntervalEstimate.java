package org.example.swingdemos.lineplotmodel;


import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class IntervalEstimate {
    //https://en.wikipedia.org/wiki/68%E2%80%9395%E2%80%9399.7_rule
    //In statistics, the 68–95–99.7 rule, also known as the empirical rule, is a shorthand used to remember
    // the percentage of values that lie within an interval estimate in a normal distribution: 68%, 95%, and 99.7% of
    // the values lie within one, two, and three standard deviations of the mean, respectively.

    //Not the same thing as confidence intervall
    //https://en.wikipedia.org/wiki/Confidence_interval

    private final static Logger logger = Logger.getLogger(IntervalEstimate.class.getName());

    HashMap<Integer,Double> levelToNofStdMap =new HashMap<>();

    public IntervalEstimate() {
        levelToNofStdMap.put(99,3d);
        levelToNofStdMap.put(95,2d);
        levelToNofStdMap.put(69,1d);

    }

    public List<Double> calc(List<Double> data, Integer confidenceLevel) {
        List<Double> confIntervall=new ArrayList<>();
        DoubleSummaryStatistics stats = data.stream().mapToDouble(a -> a).summaryStatistics();

        if (stats.getCount()==0 | stats.getCount()==1)
            logger.warning("ConfidenceIntervall calcConfidenceIntervall: few or zero data points");

        double nofStd;
        if (levelToNofStdMap.get(confidenceLevel)==null) {
            logger.warning("ConfidenceIntervall calcConfidenceIntervall: confidenceLevel not defined. Setting to 2.");
            nofStd=2;
        }
        else
            nofStd = levelToNofStdMap.get(confidenceLevel);

        Double squaredDifferenceSum  = data.stream().mapToDouble(n -> (n-stats.getAverage())*(n-stats.getAverage())).sum();
        Double variance=stats.getCount()==0?0:squaredDifferenceSum /stats.getCount();
        Double standardDeviation =Math.sqrt(variance);

        logger.warning("m:"+stats.getAverage()+"std:"+standardDeviation+", nofStd:"+nofStd+", getCount:"+stats.getCount());

        double temp=stats.getCount()==0?0:nofStd*standardDeviation;
        confIntervall.add(stats.getAverage()-temp );
        confIntervall.add(stats.getAverage()+temp);
        return confIntervall;

    }
}
