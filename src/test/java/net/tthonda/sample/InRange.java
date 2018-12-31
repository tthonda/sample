package net.tthonda.sample;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * hamcrestのカスタムMatcher. 整数が指定の範囲内に含まれるかを確認する.
 *
 * @author tthonda
 */
public class InRange extends TypeSafeMatcher<Integer> {

	private int lower;
	private int upper;

	public InRange(int lower, int upper) {
		this.lower = lower;
		this.upper = upper;
	}

	public void describeTo(Description description) {
		description.appendText("value is out of range");
	}

	@Override
	protected boolean matchesSafely(Integer item) {
		return item >= lower && item <= upper;
	}

	public static Matcher<Integer> inRange(int lower, int upper) {
		return new InRange(lower, upper);
	}

}
