public class Calculate {
    private int osis;
    private int[] nums;
    private int[] initialTigerPosition;
    private int[] initialLionPosition;
    private int[] finalTigerPosition;
    private int[] finalLionPosition;

    public Calculate(int osis) {
        this.osis = osis;
        nums = new int[3];
        initialTigerPosition = new int[2];
        initialLionPosition = new int[2];
        finalTigerPosition = new int[2];
        finalLionPosition = new int[2];

        String str = osis + "";
        nums[0] = Integer.parseInt(str.substring(0, 3));
        nums[1] = Integer.parseInt(str.substring(3, 6));
        nums[2] = Integer.parseInt(str.substring(6));

        initialTigerPosition[0] = 0;
        initialTigerPosition[1] = nums[1];

        initialLionPosition[0] = nums[2];
        initialLionPosition[1] = 0;

        finalTigerPosition[0] = nums[0] + nums[2];
        finalTigerPosition[1] = 0;

        finalLionPosition[0] = 0;
        finalLionPosition[1] = nums[0] + nums[1];
    }

    private String linearEquationTiger() {
        String str = "y = ";
        int changeInY1 = finalTigerPosition[1] - initialTigerPosition[1];
        int changeInX1 = finalTigerPosition[0] - initialTigerPosition[0];
        String slope1 = changeInY1 + "/" + changeInX1;
        str += slope1 + "x + " + initialTigerPosition[1];

        return str;
    }
    private String linearEquationLion() {
        String str = "y = ";
        int changeInY2 = finalLionPosition[1] - initialLionPosition[1];
        int changeInX2 = finalLionPosition[0] - initialLionPosition[0];
        String slope2 = changeInY2 + "/" + changeInX2;
        str += slope2 + "x + " + finalLionPosition[1];
        return str;
    }
    private String parametricEquationTigerX() {
        //x equation
        String x1 = finalTigerPosition[0] + "";
        return "x = " + x1 + "/120" + " t";
    }

    private String parametricEquationLionX() {
        //x equation
        String x1 = initialLionPosition[0] + "";
        return "x = " + x1 + " - " + x1 + "/60" + " t";
    }

    private String parametricEquationTigerY() {
        //y equation
        String y1 = initialTigerPosition[1] + "";
        return "y = " + y1 + " - " + y1 + "/120" + " t";
    }
    private String parametricEquationLionY() {
        //y equation
        String y1 = finalLionPosition[1] + "";
        return "y = " + y1 + "/60" + " t";
    }
    private String intersectionPoint() {
        int b2 = finalLionPosition[1];
        int b1 = initialTigerPosition[1];
        double m1 = (double)(finalTigerPosition[1] - initialTigerPosition[1]) / (finalTigerPosition[0] - initialTigerPosition[0]);
        double m2 = (double)(finalLionPosition[1] - initialLionPosition[1]) / (finalLionPosition[0] - initialLionPosition[0]);

        double x = (b2 - b1) / (m1 - m2);
        double y = m1 * x + b1;

        return "(" + x + ", " + y + ")";
    }
    private String intersectionTime() {
        int b2 = finalLionPosition[1];
        int b1 = initialTigerPosition[1];
        double m1 = (double)(finalTigerPosition[1] - initialTigerPosition[1]) / (finalTigerPosition[0] - initialTigerPosition[0]);
        double m2 = (double)(finalLionPosition[1] - initialLionPosition[1]) / (finalLionPosition[0] - initialLionPosition[0]);

        double intersectionX = (b2 - b1) / (m1 - m2);

        //tiger time
        double tigerTime = intersectionX * 120 / finalTigerPosition[0];
        //lion time
        double lionTime = (intersectionX - initialLionPosition[0]) * -60 / initialLionPosition[0];

        return "Tiger time: " + tigerTime + " Lion time: " + lionTime;
    }
    public String distanceFormula() {
        String changeInX = initialLionPosition[0] + " - " + initialLionPosition[0] + " / 60 t - " + finalTigerPosition[0] + " / 120 t";
        String changeInY = initialTigerPosition[1] + " - " + initialTigerPosition[1] + " / 120 t - " + finalLionPosition[1] + " / 60 t";
        return "sqrt (" + changeInX + ")^2 + (" + changeInY + ")^2";
    }
    public String toString() {
        String str = "";
        //info
        str += "Osis: " + osis + "\n";
        str += "Three nums: " + nums[0] + ", " + nums[1] + ", " + nums[2] + "\n";
        str += "Tiger initial position: (" + initialTigerPosition[0] + ", " + initialTigerPosition[1] + ")\n";
        str += "Tiger final position: (" + finalTigerPosition[0] + ", " + finalTigerPosition[1] + ")\n";
        str += "Lion initial position: (" + initialLionPosition[0] + ", " + initialLionPosition[1] + ")\n";
        str += "Lion final position: (" + finalLionPosition[0] + ", " + finalLionPosition[1] + ")\n";
        str += "\n";
        str += "Tiger Linear Equation: " + linearEquationTiger() + "\n";
        str += "Lion Linear Equation: " + linearEquationLion() + "\n";
        str += "\n";
        str += "Parametric X Tiger Equation: " + parametricEquationTigerX() + "\n";
        str += "Parametric Y Tiger Equation: " + parametricEquationTigerY() + "\n";
        str += "Parametric X Lion Equation: " + parametricEquationLionX() + "\n";
        str += "Parametric Y Lion Equation: " + parametricEquationLionY() + "\n";
        //answers
        str += "--------------------------------------------------\n";
        str += "Part A: Point of Intersection: " + intersectionPoint() + "\n";
        str += "Part B: " + intersectionTime() + "\n";
        str += "Part C and D: Put the following formula in desmos and find the minimum: y = " + distanceFormula() + "\n";
        str += "Part E: substitute the time that you got for part C into the parametric equations found in part B";
        return str;
    }
}
