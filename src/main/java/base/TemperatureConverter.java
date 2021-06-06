/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Harding
 */

package base;

import java.util.Scanner;

public class TemperatureConverter {
  Scanner input = new Scanner(System.in);
  final String cString = "Celsius";
  final String fString = "Fahrenheit";

  public static void main(String[] args) {
    TemperatureConverter temp = new TemperatureConverter();
    String units = temp.getUnits();
    System.out.println(temp.convert(units));
  }

  public String getUnits(){
    System.out.printf("Press C to convert from Fahrenheit to Celsius.%nPress F to convert from Celsius to Fahrenheit.%n");
    System.out.print("Your choice: ");
    return input.next();
  }

  public String convert(String unitString) {
    String out = "The temperature in ";
    double output;
    if (unitString.equalsIgnoreCase("c")) {
      out = out + cString + " is";
      output = (convertVal(fString) - 32) * 5 / 9;
    }
    else if (unitString.equalsIgnoreCase("f")) {
      out = out + fString + " is";
      output = (convertVal(cString) * 9 / 5) + 32;
    }
    else {
      System.out.println("ERROR: Temperature Format invalid, Start over!");
      String units = getUnits();
      return convert(units);
    }
    return String.format("%s %.2f.", out, output);
  }

  public double convertVal(String fromString) {
    System.out.printf("Please enter the temperature in %s: ", fromString);
    String n = input.next();
    try {
      Double.parseDouble(n);
    }
    catch (NumberFormatException e) {
      System.out.println("ERROR: Invalid Input, Try Again!");
      return convertVal(fromString);
    }
    return Double.parseDouble(n);
  }
}
