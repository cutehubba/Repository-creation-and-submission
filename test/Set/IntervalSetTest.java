package Set;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public abstract class IntervalSetTest {
	
	public abstract <L> IntervalSet<L> emptyInstance();

	/**
	 * ����LΪString����ʱ��getIntervals�����ܷ���ȷִ��
	 * ����IntervalsΪ��ȷ������������Intervals�Ƿ�һ��
	 * */
    @Test 
    public void testGetIntervals()
    {
    	IntervalSet<String> interval = emptyInstance();
    	List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	interval.insert(1, 2, "a");
    	assertEquals(interval.getIntervals(),Intervals);
    	Intervals.add(new Interval<String>(3,4,"b"));
    	interval.insert(3, 4, "b");
    	assertEquals(interval.getIntervals(),Intervals);
    }
    /**
	 * ����LΪString����ʱ��labels�����ܷ���ȷִ��
	 * ����labelsΪ��ȷ������������labels�Ƿ�һ��
	 * */
    @Test 
    public void testLabels()
    {
    	IntervalSet<String> interval = emptyInstance();
    	Set<String> labels = new HashSet<>();
    	interval.insert(1, 2, "a");
    	labels.add("a");
    	assertEquals(interval.labels(),labels);
    	interval.insert(3, 4, "b");
    	labels.add("b");
    	assertEquals(interval.labels(),labels);
    }
    
    /**
   	 * ����LΪString����ʱ��sort�����ܷ���ȷִ��
   	 * ����IntervalsΪ��ȷ������������Intervals�Ƿ�һ��
   	 * */
    @Test 
    public void testSort()
    {
    	IntervalSet<String> interval = emptyInstance();
    	List<Interval<String>> Intervals = new ArrayList<>();
    	interval.insert(1, 2, "a");
    	interval.insert(5, 6, "c");
    	interval.insert(3, 4, "b");
    	Intervals.add(new Interval<String>(1,2,"a"));
    	Intervals.add(new Interval<String>(3,4,"b"));
    	Intervals.add(new Interval<String>(5,6,"c"));
    	interval.sort();
    	assertEquals(Intervals,interval.getIntervals());
    }



}
