public class LinearEquation {
    /* Instance Variables */
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    /* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated) */

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    /* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
       the nearest hundredth */

    public double distance() {
        return roundedToHundredth (Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2))));
    }

    /* Calculates and returns the y-intercept of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */

    public double yIntercept() {
        double b = y1 - (slope() * x1);
        b = roundedToHundredth (b);
        return b;
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
       (x2, y2), rounded to the nearest hundredth */

    public double slope() {
        double rise = (y2 - y1);
        double run = (x2 - x1);
        double slope = (rise / run);
        return roundedToHundredth (slope);
    }


    /* Returns a String that represents the linear equation of the line through points
       (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".
    
        When generating the m value (slope), here are examples of "printable" slopes:
           5, -5, 1/2, 6/8 (reducing not required), 8/5, -2/3, -18/7
    
        Here are non-examples of "printable" slopes:
     1/-2 (should be -1/2), -4/-3 (should be 4/3), 8/4 (should be reduced to 2),
           -12/3 (should be -4), 3/3 (should be 1), -6/6 (should be -1)
        
        HINT: Be sure to check if the line is horizontal and return an appropriate string,
        e.g. y = 6
        HINT: Absolute value might be helpful for ensuring proper placement of negative sign!
    
    
        When generating the b value, here are some examples of "printable" y-intercepts:
           + 1.0 	- 2.35	      + 12.5		- 8.0		+ 17.19
         
        Here are non-examples of "printable" y-intercepts:
           - -1.0 	+ -2.35	- -12.5	+ -8.0	     - -17.19	+ 0	- 0
    
        HINT: Absolute value might be helpful for printing negative y-intercepts as
               subtraction!  */

    public String equation() {
        int rise = (y2 - y1);
        int run = (x2 - x1);
        String slopeEq = "";
            if ((slope() == 1)) { // If the slope is 1 then it won't print a value for x.
            slopeEq += ("");
            } else if ((slope() == -1)) { // If the slope is -1 then it'll just print a negative sign before x.
            slopeEq += ("-");
            } else if (rise % run == 0) {
            slopeEq += (rise / run);
            } else if ((rise < 0) && (run < 0)) { // If both the rise and run are negative, then it'll make both positive.
            slopeEq += ((Math.abs(rise)) + "/" + (Math.abs(run)));
            } else if (run < 0) { // If denominator is negative and numerator isn't swap negative signs.
            slopeEq += ((rise * -1) + "/" + (Math.abs(run)));
            } else { // Otherwise just print as rise/run
            slopeEq += (rise + "/" + run);
            }
            if ((yIntercept() > 0) && (slope() == 0)) { // If there is no slope, returns just the y intercept.
            return ("y = " + (int) yIntercept());
            } else if ((yIntercept() < 0) && (slope() == 0)) { // If y intercept is negative, prints it negative.
            return ("y = -" + (int) Math.abs(yIntercept()));
            } else if (yIntercept() > 0) { // If there is a slope and y intercept is positive.
            return ("y = " + slopeEq + "x + " + yIntercept());
            } else if (yIntercept() < 0) { //If there is a slope and y intercept is negative, find abs value and put in - sign.
            return ("y = " + slopeEq + "x - " + Math.abs(yIntercept()));
            } else { // Returns just x if there is no y intercept.
            return ("y = " + slopeEq + "x");
        }
    }

    /* Returns a String of the coordinate point on the line that has the given x value, with
   both x and y coordinates as decimals to the nearest hundredth. */

    public String coordinateForX(double xValue) {
        String corD = "";
        double yValue = (slope() * xValue) + yIntercept();
        yValue = roundedToHundredth(yValue);
        corD += "(" + xValue + ", " + yValue + ")";
        return corD;
    }


    // returns the value toRound rounded to the nearest hundredth

    public double roundedToHundredth(double toRound) {
        return Math.round (toRound * 100.0) / 100.0;
    }


    /* Returns a string that includes all information about the linear equation, each on
       separate lines:
         - The original points: (x1, y1) and (x2, y2)
         - The equation of the line in y = mx + b format
         - The slope of the line, as a decimal
         - The y-intercept of the line
         - The distance between the two points

      */
    public String lineInfo() {
        if ((y2 -  1) == 0) {
            return "";
        } else {
            String coordinates = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
            String equation = "The equation of the line between these points is: " + equation();
            String slope = "The slope of this line is: " + slope();
            String yIntercept = "The y-intercept of the line is: " + yIntercept();
            String distance = "The distance between the two points is: " + distance();
            return (coordinates + "\n" + equation + "\n" + slope + "\n" + yIntercept + "\n" + distance);
        }
    }
}






