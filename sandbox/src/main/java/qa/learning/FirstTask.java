package qa.learning;

public class FirstTask {
    public static void main(String[] args) {

        System.out.println("Here we go again");

        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(-3, -4);

        System.out.println("Расстояние между точкой p1 и точкой p2 составляет " + distance(p1, p2)); // calculate with help of function inside this class
        System.out.println(p1.distance(p2)); // calculate with method set in Point class
        System.out.println(p2.distance(p1)); // calculate with method set in Point class
        System.out.println(p1.distance(p3)); // calculate with method set in Point class
        System.out.println(p2.distance(p3)); // calculate with method set in Point class
        System.out.println(p1.distance(p1)); // calculate with method set in Point class


    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)); // function to calculate distance for 2 points
    }
}
