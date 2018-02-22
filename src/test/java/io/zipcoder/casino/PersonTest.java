package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {



   @Test
    public void constructorTest() {
       Person testPesron = new Person("Joe");
       String expected = "Joe";
       String actual = testPesron.getName();
       Assert.assertEquals(expected, actual);
   }
}
