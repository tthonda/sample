package net.tthonda.sample;

import static net.tthonda.sample.InRange.*;
import static net.tthonda.sample.LambdaMatcher.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void testApp() {
		assertThat("test", is("test"));
	}

	@Test
	public void testSum() {
		assertThat(new App().sum(10, 20), is(inRange(0, 100)));
		assertThat(new App().sum(10, 30), is(matches(i -> i <= 0, "negative value")));
	}
}
