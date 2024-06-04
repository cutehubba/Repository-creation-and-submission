package Set;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CommonIntervalSetTest extends IntervalSetTest{

	@Override
	public <L> IntervalSet<L> emptyInstance() {
		return new CommonIntervalSet<L>();
	}
	/**
	 * ����LΪString����ʱ��getIntervals�����ܷ���ȷִ��
	 * ����IntervalsΪ��ȷ������������Intervals�Ƿ�һ��
	 * */
	@Test
	public void testInsert()
	{
		IntervalSet<String> interval = emptyInstance();
		List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	interval.insert(1, 2, "a");
    	assertEquals(interval.getIntervals(),Intervals);
    	interval.insert(3, 4, "a");
    	assertEquals(interval.getIntervals(),Intervals);
    	interval.insert(3, 4, "b");
    	Intervals.add(new Interval<String>(3,4,"b"));
    	assertEquals(interval.getIntervals(),Intervals);
	}
	
	/**
	 * ����LΪString����ʱ��getIntervals�����ܷ���ȷִ��
	 * ����IntervalsΪ��ȷ������������Intervals�Ƿ�һ��
	 * */
	@Test
	public void testStart()
	{
		IntervalSet<String> interval = emptyInstance();
		List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	interval.insert(1, 2, "a");
    	interval.insert(3, 4, "b");
    	Intervals.add(new Interval<String>(3,4,"b"));
    	assertEquals(1,interval.start("a"));
    	assertEquals(3,interval.start("b"));
	}
	
	
	/**
	 * ����LΪString����ʱ��getIntervals�����ܷ���ȷִ��
	 * ����IntervalsΪ��ȷ������������Intervals�Ƿ�һ��
	 * */
	@Test
	public void testEnd()
	{
		IntervalSet<String> interval = emptyInstance();
		List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	interval.insert(1, 2, "a");
    	interval.insert(3, 4, "b");
    	Intervals.add(new Interval<String>(3,4,"b"));
    	assertEquals(2,interval.end("a"));
    	assertEquals(4,interval.end("b"));
	}
	
	/**
	 * ����LΪString����ʱ��getIntervals�����ܷ���ȷִ��
	 * ����IntervalsΪ��ȷ������������Intervals�Ƿ�һ��
	 * */
	@Test 
	public void testRemove()
	{
		IntervalSet<String> interval = emptyInstance();
		List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	Intervals.add(new Interval<String>(3,4,"b"));
    	Intervals.add(new Interval<String>(5,6,"c"));
    	interval.insert(1, 2, "a");
    	interval.insert(3, 4, "b");
    	interval.insert(5, 6, "c");
    	interval.remove("b");
    	Intervals.remove(1);
    	assertEquals(interval.getIntervals(),Intervals);
    	interval.remove("a");
    	Intervals.remove(0);
    	assertEquals(interval.getIntervals(),Intervals);
	}
}
