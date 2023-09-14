public class Polynomial {
    private double[] coefficients;

    // No-argument constructor
    public Polynomial() {
        coefficients = new double[]{0};
    }

    // Constructor with an array of coefficients
    public Polynomial(double[] coeffs) {
        coefficients = coeffs;
    }

    // Method to add two polynomials
    public Polynomial add(Polynomial newcoeffs) {
        int highDegree = Math.max(coefficients.length, newcoeffs.coefficients.length);
        double[] resultCoeffs = new double[highDegree];

        for (int i = 0; i < highDegree; i++) {
            double term1 = 0;
            if (i < coefficients.length) {
                term1 = coefficients[i];
            }
            double term2 = 0;
            if (i < newcoeffs.coefficients.length) {
                term2 = newcoeffs.coefficients[i];
            }
            resultCoeffs[i] = term1 + term2;
        }

        return new Polynomial(resultCoeffs);
    }

    // Method to evaluate the polynomial for a given value of x
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    // Method to check if a given value is a root of the polynomial
    public boolean hasRoot(double x) {
        return evaluate(x) == 0;
    }
}