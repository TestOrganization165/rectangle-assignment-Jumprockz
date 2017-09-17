

import java.util.ArrayList;



public class RectangleTester {
    static ArrayList<TestResult> tests = new ArrayList<>();

    private static Rectangle r1, r2, r3;
    private static String expected, result;
    
    public static void main(String[] args) {
        testConstructors();
        testAreaPerimeter();
        testSetRect();
        testIntersection();
        testTranslate();
        
        TestResult.reportTestResults(tests);
    }

    public static void testConstructors(){
        r1 = new Rectangle();
        expected = "0,0,0,0";
        result = getString(r1);
        tests.add(new TestResult("Constructor 1", expected, result));
        
        r1 = new Rectangle(1, 2, 3, 4);
        expected = "1,2,3,4";
        result = getString(r1);
        tests.add(new TestResult("Constructor 2", expected, result));
    }
    
    public static void testAreaPerimeter(){
        r1 = new Rectangle(0,0,5,3);
        expected = "15";
        result = "" + r1.area();
        tests.add(new TestResult("Area 1", expected, result));
        
        expected = "16";
        result = "" + r1.perimeter();
        tests.add(new TestResult("Perimeter 1", expected, result));
        
        
        r1 = new Rectangle(10,3,10,6);
        expected = "60";
        result = "" + r1.area();
        tests.add(new TestResult("Area 2", expected, result));
        
        expected = "32";
        result = "" + r1.perimeter();
        tests.add(new TestResult("Perimeter 2", expected, result));
        
        
        r1 = new Rectangle(12,2,0,0);
        expected = "0";
        result = "" + r1.area();
        tests.add(new TestResult("Area 0", expected, result));
        
        expected = "0";
        result = "" + r1.perimeter();
        tests.add(new TestResult("Perimeter 0", expected, result));
    }
    
    public static void testSetRect(){
        r1 = new Rectangle();
        r1.setRect(1, 2, 3, 4);
        expected = "1,2,3,4";
        result = getString(r1);
        tests.add(new TestResult("SetRect 1", expected, result));
        
        r2 = new Rectangle(6,7,8,9);
        r1.setRect(r2);
        expected = "6,7,8,9";
        result = getString(r1);
        tests.add(new TestResult("SetRect 2", expected, result));
    }    
    
    public static void testIntersection(){
        r1 = new Rectangle(10, 3, 5, 5);
        r2 = new Rectangle(8, 5, 9, 2);
        expected = "10,5,5,2";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 1a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 1b", expected, result));
        tests.add(new TestResult("Intersection 1c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 1d", "true", "" + r2.intersects(r1)));
        
        r1 = new Rectangle(5, 20, 3, 4);
        r2 = new Rectangle(7, 22, 5, 3);
        expected = "7,22,1,2";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 2a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 2b", expected, result));
        tests.add(new TestResult("Intersection 2c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 2d", "true", "" + r2.intersects(r1)));
        
        r1 = new Rectangle(9,6,7,4);
        r2 = new Rectangle(7,8,6,3);
        expected = "9,8,4,2";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 3a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 3b", expected, result));        
        tests.add(new TestResult("Intersection 3c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 3d", "true", "" + r2.intersects(r1)));
        
        r1 = new Rectangle(11,3,3,5);
        r2 = new Rectangle(9,6,7,4);
        expected = "11,6,3,2";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 4a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 4b", expected, result));  
        tests.add(new TestResult("Intersection 4c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 4d", "true", "" + r2.intersects(r1)));
    
        r1 = new Rectangle(11,30,4,50);
        r2 = new Rectangle(12,31,70,3);
        expected = "12,31,3,3";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 5a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 5b", expected, result));  
        tests.add(new TestResult("Intersection 5c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 5d", "true", "" + r2.intersects(r1)));
    
        r1 = new Rectangle(9,8,100,4);
        r2 = new Rectangle(50,10,3,200);
        expected = "50,10,3,2";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 6a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 6b", expected, result));  
        tests.add(new TestResult("Intersection 6c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 6d", "true", "" + r2.intersects(r1)));

        r1 = new Rectangle(20,10,8,7);
        r2 = new Rectangle(16,12,7,4);
        expected = "20,12,3,4";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 7a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 7b", expected, result));        
        tests.add(new TestResult("Intersection 7c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 7d", "true", "" + r2.intersects(r1)));
        
        r1 = new Rectangle(9,10,6,9);
        r2 = new Rectangle(10,12,3,2);
        expected = "10,12,3,2";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 8a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 8b", expected, result));           
        tests.add(new TestResult("Intersection 8c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 8d", "true", "" + r2.intersects(r1)));

        r1 = new Rectangle(9,10,6,9);
        r2 = new Rectangle(9,10,6,9);
        expected = "9,10,6,9";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 9a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 9b", expected, result));      
        tests.add(new TestResult("Intersection 9c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 9d", "true", "" + r2.intersects(r1)));

        r1 = new Rectangle(6,7,9,6);
        r2 = new Rectangle(6,7,2,3);
        expected = "6,7,2,3";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 10a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 10b", expected, result));         
        tests.add(new TestResult("Intersection 10c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 10d", "true", "" + r2.intersects(r1)));

        r1 = new Rectangle(6,7,9,6);
        r2 = new Rectangle(11,7,4,1);
        expected = "11,7,4,1";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 11a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 11b", expected, result));         
        tests.add(new TestResult("Intersection 11c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 11d", "true", "" + r2.intersects(r1)));

        r1 = new Rectangle(6,7,9,6);
        r2 = new Rectangle(6,7,3,2);
        expected = "6,7,3,2";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 12a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 12b", expected, result));         
        tests.add(new TestResult("Intersection 12c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 12d", "true", "" + r2.intersects(r1)));

        r1 = new Rectangle(6,7,9,6);
        r2 = new Rectangle(12,9,3,4);
        expected = "12,9,3,4";
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 13a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 13b", expected, result));      
        tests.add(new TestResult("Intersection 13c", "true", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 13d", "true", "" + r2.intersects(r1)));
        
        // Remaining are all non-intersecting. Tested with the same Rectangle r1
        r1 = new Rectangle(20,30,8,5);
        expected = "0,0,0,0";
        
        r2 = new Rectangle(14,26,3,2);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 14a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 14b", expected, result));      
        tests.add(new TestResult("Intersection 14c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 14d", "false", "" + r2.intersects(r1)));
    
        r2 = new Rectangle(23,25,2,1);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 15a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 15b", expected, result));      
        tests.add(new TestResult("Intersection 15c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 15d", "false", "" + r2.intersects(r1)));
    
        r2 = new Rectangle(20,27,4,3);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 16a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 16b", expected, result));      
        tests.add(new TestResult("Intersection 16c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 16d", "false", "" + r2.intersects(r1)));

        r2 = new Rectangle(26,29,4,1);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 17a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 17b", expected, result));      
        tests.add(new TestResult("Intersection 17c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 17d", "false", "" + r2.intersects(r1)));
        
        r2 = new Rectangle(31,26,2,2);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 18a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 18b", expected, result));      
        tests.add(new TestResult("Intersection 18c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 18d", "false", "" + r2.intersects(r1)));
        
        r2 = new Rectangle(37,25,4,50);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 19a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 19b", expected, result));      
        tests.add(new TestResult("Intersection 19c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 19d", "false", "" + r2.intersects(r1)));
        
        r2 = new Rectangle(38,31,6,3);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 20a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 20b", expected, result));      
        tests.add(new TestResult("Intersection 20c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 20d", "false", "" + r2.intersects(r1)));
        
        r2 = new Rectangle(28,35,9,18);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 21a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 21b", expected, result));      
        tests.add(new TestResult("Intersection 21c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection d20", "false", "" + r2.intersects(r1)));
        
        r2 = new Rectangle(21,35,5,2);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 22a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 22b", expected, result));      
        tests.add(new TestResult("Intersection 22c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 22d", "false", "" + r2.intersects(r1)));
        
        r2 = new Rectangle(18,35,2,16);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 23a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 23b", expected, result));      
        tests.add(new TestResult("Intersection 23c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 23d", "false", "" + r2.intersects(r1)));
        
        r2 = new Rectangle();
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 24a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 24b", expected, result));      
        tests.add(new TestResult("Intersection 24c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 24d", "false", "" + r2.intersects(r1)));
        
        r2 = new Rectangle(14,40,12,8);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 25a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 25b", expected, result));      
        tests.add(new TestResult("Intersection 25c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 25d", "false", "" + r2.intersects(r1)));
        
        r2 = new Rectangle(14,33,1,6);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 26a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 26b", expected, result));      
        tests.add(new TestResult("Intersection 26c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 26d", "false", "" + r2.intersects(r1)));
        
        r2 = new Rectangle(17,30,3,5);
        result = getString(r1.createIntersection(r2));
        tests.add(new TestResult("Intersection 27a", expected, result));
        result = getString(r2.createIntersection(r1));
        tests.add(new TestResult("Intersection 27b", expected, result));      
        tests.add(new TestResult("Intersection 27c", "false", "" + r1.intersects(r2)));
        tests.add(new TestResult("Intersection 27d", "false", "" + r2.intersects(r1)));
        
        
    }
    
    public static void testTranslate(){
        int deltaX, deltaY, newX, newY;
        deltaX = 12;
        deltaY = 7;
        newX = 32;
        newY = 37;
        r1 = new Rectangle(20, 30, 1, 2);
        r1.translate(deltaX, deltaY);
        expected = newX + "," + newY + "," + "1,2";
        result = getString(r1);
        tests.add(new TestResult("Translate 1", expected, result));
        
        deltaX = 6;
        deltaY = -2;
        newX = 26;
        newY = 28;
        r1 = new Rectangle(20, 30, 1, 2);
        r1.translate(deltaX, deltaY);
        expected = newX + "," + newY + "," + "1,2";
        result = getString(r1);
        tests.add(new TestResult("Translate 2", expected, result));
        
        deltaX = -8;
        deltaY = 4;
        newX = 12;
        newY = 34;
        r1 = new Rectangle(20, 30, 1, 2);
        r1.translate(deltaX, deltaY);
        expected = newX + "," + newY + "," + "1,2";
        result = getString(r1);
        tests.add(new TestResult("Translate 3", expected, result));
        
        deltaX = -2;
        deltaY = -3;
        newX = 18;
        newY = 27;
        r1 = new Rectangle(20, 30, 1, 2);
        r1.translate(deltaX, deltaY);
        expected = newX + "," + newY + "," + "1,2";
        result = getString(r1);
        tests.add(new TestResult("Translate 4", expected, result));
        
        deltaX = 4;
        deltaY = 0;
        newX = 24;
        newY = 30;
        r1 = new Rectangle(20, 30, 1, 2);
        r1.translate(deltaX, deltaY);
        expected = newX + "," + newY + "," + "1,2";
        result = getString(r1);
        tests.add(new TestResult("Translate 5", expected, result));
        
        deltaX = -3;
        deltaY = 0;
        newX = 17;
        newY = 30;
        r1 = new Rectangle(20, 30, 1, 2);
        r1.translate(deltaX, deltaY);
        expected = newX + "," + newY + "," + "1,2";
        result = getString(r1);
        tests.add(new TestResult("Translate 6", expected, result));
        
        deltaX = 0;
        deltaY = 7;
        newX = 20;
        newY = 37;
        r1 = new Rectangle(20, 30, 1, 2);
        r1.translate(deltaX, deltaY);
        expected = newX + "," + newY + "," + "1,2";
        result = getString(r1);
        tests.add(new TestResult("Translate 7", expected, result));
        
        deltaX = 0;
        deltaY = -5;
        newX = 20;
        newY = 25;
        r1 = new Rectangle(20, 30, 1, 2);
        r1.translate(deltaX, deltaY);
        expected = newX + "," + newY + "," + "1,2";
        result = getString(r1);
        tests.add(new TestResult("Translate 8", expected, result));
        
        deltaX = 0;
        deltaY = 0;
        newX = 20;
        newY = 30;
        r1 = new Rectangle(20, 30, 1, 2);
        r1.translate(deltaX, deltaY);
        expected = newX + "," + newY + "," + "1,2";
        result = getString(r1);
        tests.add(new TestResult("Translate 9", expected, result));
        

    
    
    }
    
    
    private static String getString(Rectangle r){
        // This method implicitly tests getX, getY, getWidth, and getHeight
        return "" + r.getX() +","+ r.getY() +","+ r.getWidth() +","+ r.getHeight();
    }

}

/* Holds results of a single result */
class TestResult {

    private final String message;
    private final String expected;
    private final String received;

    public TestResult(String message, String expected, String received) {
        this.message = message;
        this.expected = expected;
        this.received = received;
    }
    
    private boolean passed() {
        return expected.equals(received);
    }
        
    public static void reportTestResults(ArrayList<TestResult> testResults) {
        System.out.println("Results of " + testResults.size() + " tests:");
        boolean errorsFound = false;
        for (TestResult result : testResults) {
            if (!result.passed()) {
                System.out.println("Error: " + result.message);
                System.out.println("\tExpected: \"" + result.expected + "\"");
                System.out.println("\tReceived: \"" + result.received + "\"");
                errorsFound = true;
            }
        }
        
        if(!errorsFound){
            System.out.println("No Errors Found.");
        }
    }    
} // End of class TestResult