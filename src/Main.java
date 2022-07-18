
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char action;
    static int variable1;
    static int variable2;

      public static void main(String[] args) {
          //System.out.println("Hello world!");
          System.out.println("Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.");
          System.out.println("Числа должны быть от 1 до 10 включительно. Оба числа должны быть либо римскими либо арабскими.");
          System.out.println("Доступные операции: Сложение (+), Вычитание (-), Умножение(*) и деление (/)");

          while (true) {
              Scanner scanner = new Scanner(System.in);
              String input = scanner.nextLine();

              String newInput = input.replaceAll(" ", "");//убираем пробелы, чтобы читал ввод с пробелами и без
              String input1 = newInput.replaceAll("[^A-Za-z0-9]", " ");//заменяем операцию на зпт
              String[] inputValues = input1.split(" ");// делим строку на подстроки и заносим в массив
              int count = 0;
              String choice = "";
              action = ' ';

              for (int i = 0; i < input.length(); i++) { //определяем операцию
                  if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                      count = count + 1;
                      if (i == 0) { //если операция стоит перед первым операндом
                          System.err.println("Ошибка: неправильный ввод данных.");
                          System.exit(0);
                      } else {
                          action = input.charAt(i);
                          if (count != 1) {
                              System.err.println("Ошибка: формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *).");
                              System.exit(0);
                          }
                      }
                  }
              }
              //System.out.println(action);
              RomanToArab romanToArab = new RomanToArab();
              if (inputValues.length == 2) { //проверям, что 2 переменных
                  romanToArab.str1 = inputValues[0];
                  romanToArab.str2 = inputValues[1];
              } else {
                  System.err.println("Ошибка: неверный ввод данных");
                  System.exit(0);
              }

              if (romanToArab.convertFirst() > 0 && romanToArab.convertSecond() > 0) {
                  variable1 = romanToArab.convertFirst();
                  variable2 = romanToArab.convertSecond();

                  choice = "roman";
                  if (action == '-' && (variable1 - variable2) < 0) {
                      System.err.println("Ошибка: в римской системе нет отрицательных чисел.");
                      System.exit(0);
                  }
              }else if (romanToArab.convertFirst() > 0 && romanToArab.convertSecond() == 0) {
                      System.err.println("Ошибка: неверный ввод данных.");
                      System.exit(0);
                  } else if (romanToArab.convertFirst() == 0 && romanToArab.convertSecond() > 0) {
                      System.err.println("Ошибка: неверный ввод данных.");
                      System.exit(0);

                  } else if (Integer.parseInt(romanToArab.str1) >= 0 && Integer.parseInt(romanToArab.str2) >= 0) {
                      variable1 = Integer.parseInt(romanToArab.str1);
                      variable2 = Integer.parseInt(romanToArab.str2);
                      choice = "arab";

                  } else {
                      System.err.println("Ошибка: неправильный ввод данных.");
                      System.exit(0);
                  }
                  if (variable1 > 10 || variable2 > 10 || variable1 < 1 || variable2 < 1) {
                      System.err.println("Ошибка: числа должны быть от 1 до 10 включительно.");
                      System.exit(0);
                  }
                  romanToArab.result = Integer.parseInt(Main.calc(variable1, variable2, action));

                  if (choice.equals("roman")) {
                      System.out.println(romanToArab.convertResult());
                  } else if (choice.equals("arab")) {
                      System.out.println(Main.calc(variable1, variable2, action));
                  } else {
                      System.out.println("Ошибка: неправильный ввод данных.");
                      System.exit(0);
                  }
              }

          }


public static String calc(int variable1, int variable2, char action){
          int result;


    switch (action) {
        case '+' -> {
            result = variable1 + variable2;
            return Integer.toString(result);
        }
        case '-' -> {
            result = variable1 - variable2;
            return Integer.toString(result);
        }
        case '/' -> {
            result = variable1 / variable2;
            return Integer.toString(result);
        }
        case '*' -> {
            result = variable1 * variable2;
            return Integer.toString(result);
        }
        default -> {
            System.err.println("Неверно введён оператор");
            System.exit(0);
            return null;


        }
    }


    }
}