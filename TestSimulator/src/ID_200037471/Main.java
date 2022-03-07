package ID_200037471;

import java.util.Scanner;

public class Main {


			public static void main(String[] args) {
				Scanner input = new Scanner(System.in);

				System.out.println("please enter how many open question your data can have: ");
				int numberOfOpenQuestion; 
				numberOfOpenQuestion=input.nextInt();
				System.out.println("please enter how many American question your data can have: ");
				int numberOfAmericanQuestion; 
				numberOfAmericanQuestion=input.nextInt();
				
				DataBase db1 = new DataBase(numberOfOpenQuestion,numberOfAmericanQuestion);
				
				Question q11 = new AmericanQuestion("what is the second letter in the alphabet" );
				db1.addQuestionToDataBase(q11);
				
				Question q12 = new OpenQuestion("what is the letter in the alphabet", "A" );
				db1.addQuestionToDataBase(q12);
				
				
				
				
						
				
				
				
				
				
				
				Question q1 = new Question("how old are u");
				System.out.println(q1.getQuestionId());
				Question q2 = new Question("how old are u");
				System.out.println(q2.getQuestionId());
				OpenQuestion q3 = new OpenQuestion("how old are u", "five");
				System.out.println(q3.getQuestionId());
			
			
				Question[] question = new Question[3];
				question[0] = new OpenQuestion("how old are you" , "five");
				question[1] = new AmericanQuestion("what is your name:");
				question[2] = new AmericanQuestion("what is your favorite Color:");
				
				
				AmericanQuestionAnswer aqa1 = new AmericanQuestionAnswer("beseder", true);
				AmericanQuestion aq1 = new AmericanQuestion("ma kore:");
				aq1.addAnswerToArray(aqa1);
				
				
				

			}

		}

	}

}
