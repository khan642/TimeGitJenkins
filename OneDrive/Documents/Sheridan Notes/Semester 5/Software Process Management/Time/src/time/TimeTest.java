package time;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.api.Test;

class TimeTest {
	
	@Test
	public void testGetTotalSecondsGood()
	{
	int seconds = Time.getTotalSeconds("05:05:05");
	assertTrue("The seconds were not calculated properly", seconds==18305);
	}
	
	@Test
	public void testGetTotalSecondsBad()
	{
	assertThrows(
			StringIndexOutOfBoundsException.class,
			()-> {Time.getTotalSeconds("10:00");});				
	}

	@Test
    void testGetTotalSecondsBoundary() {
        // Boundary test (empty time string)
        assertThrows(
            StringIndexOutOfBoundsException.class,
            () -> { Time.getTotalSeconds(""); }
        );

        // Boundary test (minimal valid input)
        int secondsForMinimalInput = Time.getSeconds("00:00:00");
        assertEquals(0, secondsForMinimalInput, "Seconds for minimal input should be 0.");

        // Boundary test (maximal valid input)
        int secondsForMaximalInput = Time.getSeconds("23:59:59");
        assertEquals(59, secondsForMaximalInput, "Seconds for maximal input should be 59.");
    }
	
	
	@Test
    void testGetSecondsGood() {
        // Good test
        int seconds = Time.getSeconds("12:30:45");
        assertEquals(45, seconds, "Seconds were not extracted properly for a valid input.");
    }
	
	@Test
    void testGetSecondsBad() {
        // Bad test (invalid time format)
        assertThrows(
        		StringIndexOutOfBoundsException.class,
            () -> { Time.getSeconds(""); }
        );

//        // Bad test (short time string)
//        assertThrows(
//            StringIndexOutOfBoundsException.class,
//            () -> { Time.getSeconds("12:34"); }
//        );
    }
	
	@Test
    void testGetSecondsBoundary() {
        // Boundary test (empty time string)
        assertThrows(
            StringIndexOutOfBoundsException.class,
            () -> { Time.getSeconds(""); }
        );
    }

	@Test
    void testGetTotalMinutesGood() {
        // Good test
        int minutes = Time.getTotalMinutes("05:15:30");
        assertEquals(15, minutes, "The minutes were calculated properly for a valid input.");
    }

	 @Test
	    void testGetTotalMinutesBad() {
	        // Bad test (invalid time format)
	        assertThrows(NumberFormatException.class,
	        		()->{Time.getTotalMinutes("10:00:00:00");});
	    }

    @Test
    void testGetTotalMinutesBoundary() {
        // Boundary test (empty time string)
        assertThrows(
            StringIndexOutOfBoundsException.class,
            () -> { Time.getTotalMinutes(""); }
        );

        // Boundary test (minimal valid input)
        int minutesForMinimalInput = Time.getTotalMinutes("00:00:00");
        assertEquals(0, minutesForMinimalInput, "Minutes for minimal input should be 0.");

        // Boundary test (maximal valid input)
        int minutesForMaximalInput = Time.getTotalMinutes("23:59:59");
        assertEquals(59, minutesForMaximalInput, "Minutes for maximal input should be 1439.");
    }

    @Test
    void testGetTotalHoursGood() {
        // Good test
        int hours = Time.getTotalHours("12:30:45");
        assertEquals(12, hours, "The hours were not calculated properly for a valid input.");
    }

    @Test
    void testGetTotalHoursBad() {
        // Bad test (invalid time format)
        assertThrows(
        		StringIndexOutOfBoundsException.class,
            () -> { Time.getTotalHours(""); }
        );
    }

    @Test
    void testGetTotalHoursBoundary() {
        // Boundary test (empty time string)
        assertThrows(
            StringIndexOutOfBoundsException.class,
            () -> { Time.getTotalHours(""); }
        );

        // Boundary test (minimal valid input)
        int hoursForMinimalInput = Time.getTotalHours("00:00:00");
        assertEquals(0, hoursForMinimalInput, "Hours for minimal input should be 0.");

        // Boundary test (maximal valid input)
        int hoursForMaximalInput = Time.getTotalHours("23:59:59");
        assertEquals(23, hoursForMaximalInput, "Hours for maximal input should be 23.");
    }
    
    @Test
    void testGetMilisecondsGood() {
    	int miliseconds = Time.getMilliseconds("12:05:05:05");
    	assertEquals(05, miliseconds, "The miliseconds were calculated properly");
    }
    
    @Test
    void testGetMilisecondsBad() {
    	assertThrows(
    			NumberFormatException.class,
    			() -> {Time.getMilliseconds("invalid_time_format");});
    }
    
    @Test
    void testGetTotalMIlisecondsBoundry() {
    	assertThrows(
    			StringIndexOutOfBoundsException.class,
    			() -> {Time.getMilliseconds("");} 
    			);
    	
    	int milisecondsForMinimalInput = Time.getMilliseconds("00:00:00:00");
    	assertEquals(0, milisecondsForMinimalInput, "Miliseconds for minimal input should be 0.");
    	
    	int milisecondsForMaximalInput = Time.getMilliseconds("23:59:59:59");
    	assertEquals(59, milisecondsForMaximalInput, "Miliseconds for maximal input should be 59.");
    }

}
