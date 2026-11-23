package week10;

  // This program reads a CSV file of student marks, uses a Map to process the data,
// and writes a summary report to a new text file.


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataProcessor {
public static void main(String[] args) {

// We will use a Map to store the processed data.
// Key = Student Name, Value = Status (Pass/Fail)
Map<String, String> results = new HashMap<>();

String inputFile = "week10/students.csv";
String outputFile = "report.txt";

double totalMarks = 0;
int studentCount = 0;

// ============================================================
// STEP 1: READ AND PROCESS THE CSV
// ============================================================
try {


File file = new File(inputFile);
Scanner scanner = new Scanner(file);

// Skip the header if there is one (our file doesn't have one, but good practice).
// scanner.nextLine();

while (scanner.hasNextLine()) {
String line = scanner.nextLine();

// Split the line by comma. The result is an array of strings.
// Example: "101,Alice,85" becomes ["101", "Alice", "85"]
String[] parts = line.split(",");

// Ensure the line has exactly 3 parts to prevent errors.
if (parts.length == 3) {
String id = parts[0];
String name = parts[1];
int marks = Integer.parseInt(parts[2]); // Convert String to int

// Accumulate stats.
totalMarks += marks;
studentCount++;

// Determine pass/fail and store in Map.
if (marks >= 50) {
results.put(name, "PASSED");


} else {
results.put(name, "FAILED");
}
}
}
scanner.close();

} catch (FileNotFoundException e) {
System.out.println("Error: Input file not found.");
return; // Exit the program if we can't read the input.
} catch (NumberFormatException e) {
System.out.println("Error: The file contains non-numeric marks.");
return;
}

// ============================================================
// STEP 2: WRITE THE REPORT TO A NEW FILE
// ============================================================
try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

writer.println("=== EXAMINATION REPORT ===");
writer.println("Total Students Processed: " + studentCount);
writer.println("Class Average: " + (totalMarks / studentCount));
writer.println("--------------------------");

// Iterate through the Map and write results.

for (Map.Entry<String, String> entry : results.entrySet()) {
writer.println("Student: " + entry.getKey() + " | Result: " + entry.getValue());
}

System.out.println("Data processing complete! Check " + outputFile + " for results.");

} catch (IOException e) {
System.out.println("Error writing report file: " + e.getMessage());
}
}
}
  
