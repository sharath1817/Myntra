package TestListernersDirectory;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListerners.class)
public class TestNGListerners2 {
    @Test
    public void test5(){
        System.out.println("I am inside Test 5");
    }
    @Test
    public void test6(){
        System.out.println("I am inside Test 6");
        Assert.assertTrue(false);
    }
    @Test
    public void test7(){
        System.out.println("I am inside Test 7");
        throw new SkipException("this tast is skipped");
    }
    @Test
    public void test8(){
        System.out.println("I am inside Test 8");
    }
}
