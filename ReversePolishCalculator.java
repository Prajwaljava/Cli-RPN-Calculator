//Include library

import java.util.Stack;

import java.util.Scanner;

//Define a class ReversePolishCalculator

public class ReversePolishCalculator

{

     //Define boolean method nextIsOperator()

     public boolean nextIsOperator(String next)

     {

          //Return true if expression contains operators

return (next.equals("+") || next.equals("-") || next.equals("*") || next.equals("/"));

     }

     //Define calculate()

     public Integer calculate(String input)

     {

          //Call trim()

          input = input.trim();

          //Define next

          String next;

          //Define a stack of integers

          Stack<Integer> valueStack = new Stack<Integer>();

          //Define a scanner variable

          Scanner lscan = new Scanner(input);

          //Loop until end of input

          while (lscan.hasNext())

          {

              //Store value to next

              next = lscan.next();

              //If operator is present

              if (nextIsOperator(next))

              {

                   //If value is greater than 1

                   if (valueStack.size() > 1)

                   {

                        //If operator is +

                        if (next.equals("+"))

                        {

                                //Perform operation

valueStack.push((Integer) valueStack.pop()

                             + (Integer) valueStack.pop());

                        }

                        //If operator is -

                        else if (next.equals("-"))

                        {

                             //Perform operation

valueStack.push(-(Integer) valueStack.pop()

                             + (Integer) valueStack.pop());

                        }

                        //If operator is *

                        else if (next.equals("*"))

                        {

                             //Perform operation

valueStack.push((Integer) valueStack.pop()* (Integer) valueStack.pop());

                        }

                        //If operator is /

                        else if (next.equals("/"))

                        {

                             //Get operands

                             Integer lfirst = valueStack.pop();

Integer lsecond = valueStack.pop();

                             //If denominator is 0

                             if (lfirst == 0)

                             {

                                  //Display message

System.out.println("Error!! Divide by zero!!.");

                             }

                             //If denominator is non zero

                             else

                             {

                                  //Perform operation

valueStack.push(lsecond / lfirst);

                             }

                        }

                   }

                   //If format is not proper

                   else

                   {

                        //Display message

                        System.out.println("Format error !!");

                   }

              }

              //If error in format

              else

              {

                   //Try block

                   try

                   {

                        //Push value to stack

                                                 valueStack.push(Integer.parseInt(next));

                   }

                   //Catch block

                   catch (NumberFormatException c)

                   {

                        //Display message

System.out.println("This was not properly formatted");

                   }

              }

          }

          //If value greater than 1

          if (valueStack.size() > 1)

          {

              //Display message

              System.out.println("Format error!!");

              //Return 0

              return 0;

          }

          //Return value

          return valueStack.pop();

     }

     //Define main method

     public static void main(String[] args)

     {

          //Define scanner variable

          Scanner lkeyboard = new Scanner(System.in);

          //Define lrpCal

ReversePolishCalculator lrpCal = new ReversePolishCalculator();

          //Set value as false

          boolean lquit = false;

          //Loop until false

          while (lquit == false)

          {

              //Display message

System.out.println("Enter RPN expression or \"quit\" to quit");

              //Receive user input and store value

              String input = lkeyboard.nextLine();

              //If input is lquit

              if (input.equalsIgnoreCase("quit"))

              {

                   //Display message

                   System.out.println("Goodbye");

                   //Break

                   break;

              }

              //Try block

              try

              {

                   //Display result

                   System.out.println(lrpCal.calculate(input));

              }   

              //Catch block

              catch (Exception e)

              {

              }

          }

     }

}