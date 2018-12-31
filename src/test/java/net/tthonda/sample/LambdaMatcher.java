package net.tthonda.sample;

import java.util.function.Predicate;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class LambdaMatcher<T> extends TypeSafeMatcher<T> {

	private Predicate<T> predicate;
	private String message;

	public LambdaMatcher(Predicate<T> predicate, String message) {
		this.predicate = predicate;
		this.message = message;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText(this.message);
	}

	@Override
	protected boolean matchesSafely(T item) {
		return this.predicate.test(item);
	}

	public static <T> Matcher<T> matches(Predicate<T> predicate, String message) {
		return new LambdaMatcher<>(predicate, message);
	}
}
