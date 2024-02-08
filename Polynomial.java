package polynomial;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private String expression;
    private boolean hasError;
    private String errorMessage;

    public Polynomial(String expression) {
        this.expression = expression;
        this.hasError = !isValidExpression(expression);
        this.errorMessage = hasError ? "Invalid polynomial" : "";
    }

    public boolean hasError() {
        return hasError;
    }

    public String evaluate() {
        if (hasError) {
            return errorMessage;
        }

        List<Term> terms = parseTerms(expression);
        List<Term> simplifiedTerms = simplifyTerms(terms);
        List<Term> derivativeTerms = calculateDerivative(simplifiedTerms);

        return termsToString(derivativeTerms);
    }

    public static boolean isValidExpression(String expression) {
        Pattern pattern = Pattern.compile("^[\\d]*[xX](\\^[\\d]+)?([+-][\\d]*[xX](\\^[\\d]+)?)*$");
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }

    private List<Term> parseTerms(String expression) {
        List<Term> terms = new ArrayList<>();
        String[] termStrings = expression.split("[\\+\\-]");

        for (String termString : termStrings) {
            terms.add(new Term(termString));
        }

        return terms;
    }

    private List<Term> simplifyTerms(List<Term> terms) {
        List<Term> simplifiedTerms = new ArrayList<>();
        for (Term term : terms) {
            updateSimplifiedTerms(simplifiedTerms, term);
        }
        return simplifiedTerms;
    }

    private void updateSimplifiedTerms(List<Term> simplifiedTerms, Term term) {
        for (Term simplifiedTerm : simplifiedTerms) {
            if (simplifiedTerm.getExponent() == term.getExponent()) {
                simplifiedTerm.setCoefficient(simplifiedTerm.getCoefficient() + term.getCoefficient());
                return;
            }
        }
        simplifiedTerms.add(term);
    }

    private List<Term> calculateDerivative(List<Term> terms) {
        List<Term> derivativeTerms = new ArrayList<>();
        for (Term term : terms) {
            int exponent = term.getExponent() - 1;
            if (exponent >= 0) {
                derivativeTerms.add(new Term(term.getCoefficient() * term.getExponent(), exponent));
            }
        }
        return derivativeTerms;
    }

    private String termsToString(List<Term> terms) {
        StringBuilder result = new StringBuilder();

        for (Term term : terms) {
            if (term.getCoefficient() != 0) {
                result.append(term).append(" + ");
            }
        }

        if (result.length() >= 3) {
            result.setLength(result.length() - 3); // Remove the trailing "+ "
        }

        return result.toString();
    }

    private static class Term {
        private double coefficient;
        private int exponent;

        public Term(String termString) {
            String[] parts = termString.split("x|X|\\^");
            coefficient = (parts.length > 0 && !parts[0].isEmpty()) ? Double.parseDouble(parts[0]) : 1.0;
            exponent = (parts.length > 1) ? Integer.parseInt(parts[1]) : 0;
        }

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

        @Override
        public String toString() {
            return (exponent == 0) ? String.format("%.1f", coefficient) :
                    (exponent == 1) ? String.format("%.1fx", coefficient) :
                            String.format("%.1fx^%d", coefficient, exponent);
        }
    }
}
