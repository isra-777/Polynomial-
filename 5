package polynomial;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private String expression;
    private boolean hasError;
    private String errorMessage;

    // Create a constructor that will initialize a Polynomial object using the provided expression.
    public Polynomial(String expression) {
        this.expression = expression;
        this.hasError = false;
        this.errorMessage = "";

        // Check if the expression is valid
        if (!isValidExpression(expression)) {
            hasError = true;
            errorMessage = "Invalid polynomial";
        }
    }

    // Check if there was an error while constructing the Polynomial object
    public boolean hasError() {
        return hasError;
    }

    // Evaluate the polynomial expression
    public String evaluate() {
        if (hasError) {
            return errorMessage;
        }

        // Parse and evaluate the polynomial expression
        List<Term> terms = parseTerms(expression);
        List<Term> simplifiedTerms = simplifyTerms(terms);
        List<Term> derivativeTerms = calculateDerivative(simplifiedTerms);

        // Convert the derivative terms back to a string
        return termsToString(derivativeTerms);
    }

    // Validate the polynomial expression using regular expressions
    public static boolean isValidExpression(String expression) {
        // The regex pattern allows terms like "ax^b" or "ax" where 'a' and 'b' are numbers
        Pattern pattern = Pattern.compile("^[\\d]*[xX](\\^[\\d]+)?([+-][\\d]*[xX](\\^[\\d]+)?)*$");
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }

    // Parse the polynomial expression into a list of Term objects
    private List<Term> parseTerms(String expression) {
        List<Term> terms = new ArrayList<>();
        String[] termStrings = expression.split("[\\+\\-]");

        for (String termString : termStrings) {
            terms.add(new Term(termString));
        }

        return terms;
    }

    // Simplify the list of terms by combining like terms
    private List<Term> simplifyTerms(List<Term> terms) {
        List<Term> simplifiedTerms = new ArrayList<>();
        for (Term term : terms) {
            boolean found = false;
            for (Term simplifiedTerm : simplifiedTerms) {
                if (simplifiedTerm.getExponent() == term.getExponent()) {
                    simplifiedTerm.setCoefficient(simplifiedTerm.getCoefficient() + term.getCoefficient());
                    found = true;
                    break;
                }
            }
            if (!found) {
                simplifiedTerms.add(term);
            }
        }
        return simplifiedTerms;
    }

    // Calculate the derivative of the polynomial
    private List<Term> calculateDerivative(List<Term> terms) {
        List<Term> derivativeTerms = new ArrayList<>();
        for (Term term : terms) {
            double coefficient = term.getCoefficient() * term.getExponent();
            int exponent = term.getExponent() - 1;
            if (exponent >= 0) {
                derivativeTerms.add(new Term(coefficient, exponent));
            }
        }
        return derivativeTerms;
    }

    // Convert a list of terms to a string
    private String termsToString(List<Term> terms) {
        StringBuilder result = new StringBuilder();

        for (Term term : terms) {
            if (term.getCoefficient() != 0) {
                result.append(term.toString()).append(" + ");
            }
        }

        if (result.length() >= 3) {
            result.setLength(result.length() - 3); // Remove the trailing "+ "
        }

        return result.toString();
    }

    // Inner class to represent a single term in the polynomial
    private class Term {
        private double coefficient;
        private int exponent;

        // Constructor to initialize a Term object with a string representation
        public Term(String termString) {
            String[] parts = termString.split("x|X|\\^");
            if (parts.length == 1) {
                coefficient = Double.parseDouble(parts[0]);
                exponent = 0;
            } else if (parts.length == 2) {
                if (parts[0].isEmpty()) {
                    coefficient = 1.0;
                } else if (parts[0].equals("-")) {
                    coefficient = -1.0;
                } else {
                    coefficient = Double.parseDouble(parts[0]);
                }
                exponent = 1;
            } else if (parts.length == 3) {
                coefficient = Double.parseDouble(parts[0]);
                exponent = Integer.parseInt(parts[2]);
            }
        }

        // Constructor to initialize a Term object with coefficient and exponent
        public Term(double coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
        }

        public double getCoefficient() {
            return coefficient;
        }

        public void setCoefficient(double coefficient) {
            this.coefficient = coefficient;
        }

        public int getExponent() {
            return exponent;
        }

        // Convert a term back to a string
        @Override
        public String toString() {
            if (exponent == 0) {
                return String.format("%.1f", coefficient);
            } else if (exponent == 1) {
                return String.format("%.1fx", coefficient);
            } else {
                return String.format("%.1fx^%d", coefficient, exponent);
            }
        }
    }
}
