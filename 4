package polynomial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java polynomial.Main input.txt output.txt");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             FileWriter writer = new FileWriter(outputFileName)) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // Remove spaces from the input line
                line = line.replaceAll("\\s", "");

                // Check for invalid characters
                if (!Polynomial.isValidExpression(line)) {
                    writer.write("Invalid polynomial\n");
                    continue;
                }

                // Create a Polynomial object
                Polynomial polynomial = new Polynomial(line);

                // Check for errors in the Polynomial constructor
                if (polynomial.hasError()) {
                    writer.write("Invalid polynomial\n");
                    continue;
                }

                // Evaluate the polynomial
                String result = polynomial.evaluate();

                // Write the result to the output file
                writer.write(result + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
