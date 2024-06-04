package Set;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MultiIntervalSetTest extends IntervalSetTest{

	@Override
	public <L> IntervalSet<L> emptyInstance() {
		return new MultiIntervalSet<L>();
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
    	Intervals.add(new Interval<String>(3,4,"a"));
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
	public void testRemove()
	{
		MultiIntervalSet<String> interval = new MultiIntervalSet<String>();
		List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	interval.insert(1, 2, "a");
    	interval.insert(3, 4, "a");
    	Intervals.add(new Interval<String>(3,4,"a"));
    	interval.insert(3, 4, "b");
    	Intervals.add(new Interval<String>(3,4,"b"));
    	assertEquals(interval.getIntervals(),Intervals);
    	interval.remove("a");
    	Intervals.remove(1);
    	Intervals.remove(0);
    	assertEquals(interval.getIntervals(),Intervals);
	}
	/**
	 * ����LΪString����ʱ��getIntervals�����ܷ���ȷִ��
	 * ����IntervalsΪ��ȷ������������Intervals�Ƿ�һ��
	 * */
	@Test 
	public void testIntervals()
	{
		MultiIntervalSet<String> interval = new MultiIntervalSet<String>();
		List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	Intervals.add(new Interval<String>(3,4,"a"));
    	interval.insert(1, 2, "a");
    	interval.insert(3, 4, "a");
    	interval.insert(3, 4, "b");
    	assertEquals(Intervals,interval.intervals("a").getIntervals());
	}
}
