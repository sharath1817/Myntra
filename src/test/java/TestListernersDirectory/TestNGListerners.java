package TestListernersDirectory;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListernersDirectory.TestListerners.class)
public class TestNGListerners {
    @Test
    public void test1(){
        System.out.println("I am inside Test 1");
    }
    @Test
    public void test2(){
        System.out.println("I am inside Test 2");
        Assert.assertTrue(false);
    }
    @Test
    public void test3(){
        System.out.println("I am inside Test 3");
        throw new SkipException("this tast is skipped");
    }
    @Test
    public void test4(){
        System.out.println("I am inside Test 4");
    }
}
