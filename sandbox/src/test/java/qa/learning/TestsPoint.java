package qa.learning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsPoint {

    @Test
    public void test1() {
        Point p1 = new Point(1, 2);
        Assert.assertEquals(p1.distance(p1), 0);
    }

    @Test
    public void test2() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Assert.assertEquals(p1.distance(p2), 2.8284271247461903);
    }

    @Test
    public void test3() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Assert.assertEquals(p2.distance(p1), 2.8284271247461903);
    }


}
