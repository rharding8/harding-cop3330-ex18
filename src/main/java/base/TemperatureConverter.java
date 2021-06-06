/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Harding
 */

package base;

import java.util.Scanner;

public class TemperatureConverter {
  Scanner input = new Scanner(System.in);

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
    double output;
    System.out.print("Please enter the temperature in ");
    if (unitString.equalsIgnoreCase("c")) {
      System.out.print("Fahrenheit: ");
      double f = input.nextDouble();
      output = (f - 32) * 5 / 9;
      return String.format("The temperature in Celsius is %.2f.", output);
    }
    else if (unitString.equalsIgnoreCase("f")) {
      System.out.print("Celsius: ");
      double c = input.nextDouble();
      output = (c * 9 / 5) + 32;
      return String.format("The temperature in Fahrenheit is %.2f.", output);
    }
    else {
      return "ERROR: Temperature Format invalid, Run Program Again!";
    }
  }
}
