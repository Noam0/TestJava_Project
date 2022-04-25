package ID_200037471;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		/*
		                            How to make the program work for many subjects:
		
		
		Each question should contain the value 'String subject' that represents a particular subject that belongs to a test.
		We would write it in Class 'Question' that Inheritance that to all questions (Open and American).
		In addition in the Test Class we would add 'String subjectOfTest'.
		To make a test we would make method who puts in the testQuestions[] only the question thats fits the test's subject.
		
		
		*/ 
		
		
		Scanner input = new Scanner(System.in);
		boolean exceptionTemp = false;
		int choose = 0;
		System.out.println("Welcome!  please choose Option :");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~{_-MENU-_}~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Enter  1  :  To display all question stockpile");
		System.out.println("Enter  2  :  To add a question to questions stockpile");
		System.out.println("Enter  3  :  To edit question ");
		System.out.println("Enter  4  :  To edit question's answer");
		System.out.println("Enter  5  :  To delete answer from american questions stockpile");
		System.out.println("Enter  6  :  To build a test manually");
		System.out.println("Enter  7  :  To build a test automatically");
		System.out.println("Enter  8  :  To copy new Test");
		System.out.println("Enter  9  :  To exit");
		System.out.println("");
		while (!exceptionTemp) {
		try {
		choose = input.nextInt();
		exceptionTemp = true;
		}catch (InputMismatchException e) {
			System.out.println("you were asked to enter number ! ");
			System.out.println("please enter again :");
			input.nextLine(); // cleans buffer
		}
	}
	
		while (choose < 1 || choose > 9) {
			System.out.println("-ERROR- please enter number between {1-8} from menu :");
			choose = input.nextInt();
		}
		DataBase db1 = new DataBase();
		db1.addingQuestionAutomatically();
		while (choose != 9) {
			switch (choose) {

			case 1:
				// To string data base
				System.out.println(db1);
				break;

			case 2:
				// adding question to the database
				int check=0;
				 exceptionTemp = true;
				while(exceptionTemp) {
				try {
				System.out.println("Enter {1} -to add Open Question  / Enter {2} -to add American Question");
				check = input.nextInt();
				exceptionTemp = false;
				
				}catch (InputMismatchException e) {
					System.out.println("make sure you enterd {1} or {2}, try again:");
					input.nextLine(); // cleans buffer
				  }
				}
				while (check != 1 && check != 2) {
					System.out.println("-ERROR- please make sure you enter {1) or {2}. try again:");
					check = input.nextInt();
				}
				input.nextLine();
				if (check == 1) {
					// Open question input
					System.out.println("Please enter open question text:");
					String openQuestionText = input.nextLine();
					
					System.out.println("Please enter answer's text:");
					String openAnswerText = input.nextLine();
					OpenQuestion openQ = new OpenQuestion(openQuestionText, openAnswerText);
					System.out.println(db1.addQuestionToDataBase(openQ));

				} else {
					// American question input
					boolean TORF = false;
				
					String Answer = null;
					System.out.println("Please enter american question text:");
					String americanQuestionText = input.nextLine();
					AmericanQuestion americanQ = new AmericanQuestion(americanQuestionText);
					// American answer input
						System.out.println("Please enter how many Answers you want to add (1 up to 8):");
					    int numOfAnswers = input.nextInt();
					  
					    while (numOfAnswers < 1 || numOfAnswers > 8) {
						System.out.println("-ERROR- please enter again number between {1-8} :");
						  numOfAnswers = input.nextInt();
					    }
					
				
				
					for (int i = 0; i < numOfAnswers; i++) { 
						System.out.println("Please enter the text of Answer number (" + (i + 1) + "):");
					    Answer = input.next();
                        while(!(exceptionTemp)) {
					    try {
						System.out.println("Please enter if its true or false:");
						TORF = input.nextBoolean();
						exceptionTemp = true;

						  }catch (InputMismatchException e) { 
							System.out.println("you were asked to enter true or false, try again:");
							input.nextLine(); // cleans buffer
						}
                      } 
					 AmericanQuestionAnswer QQA = new AmericanQuestionAnswer(Answer, TORF);
					 System.out.println(americanQ.addAnswerToArray(QQA));
				
                      exceptionTemp = false;  
				} 
					System.out.println(db1.addQuestionToDataBase(americanQ));
			}
				break;

			case 3:

				// edit Question text
				System.out.println(db1);
				System.out.println("please enter question ID number you want to edit: ");
				int idcheck = input.nextInt();
				System.out.println("please enter the new question's text:");
				String newText = input.next();
				System.out.println(db1.editQuestionText(idcheck, newText));
				break;

			case 4:
				// To edit question's answer
				System.out.println(db1);
				
				int idCheck2=0;
				exceptionTemp = true;
				while(exceptionTemp) {
				try {
					System.out.println("please enter qustion id:");
					 idCheck2 = input.nextInt();
					exceptionTemp=false;
				} catch (InputMismatchException e) {
					System.out.println("Please make sure you entered right ID number, try again:");
					input.nextLine(); // cleans buffer
				}
				}
				int countQuestion = db1.getNumOfAllQuestions();
				while(idCheck2<1000 || idCheck2 > (countQuestion+999)) {
					System.out.println("-ERROR- make sure you entered number between {1000-" + (countQuestion+999) + "}" );
					idCheck2 = input.nextInt();
				}
					// change open question answer text
					isQuestion temp = db1.findingQuestionFromId(idCheck2);
					if(temp instanceof OpenQuestion && temp!=null) {	
					System.out.println("please enter your new answer:");
					String openQuestionAnswerText = input.next();
					System.out.println(db1.editOpenQuestionAnswerText(idCheck2, openQuestionAnswerText));
					}
					if(temp instanceof AmericanQuestion && temp!=null ) {
						int answercheck3 = 0;
						boolean trueOrFalseCheck = false; 
						String AmericanQuestionAnswerText = null ;
					while(!(exceptionTemp)) {
					try {
		
					// change American question answer
					
					System.out.println("please enter the index of the answer you want to change: ");
					answercheck3 = input.nextInt();
					System.out.println("please enter your new answer:");
					AmericanQuestionAnswerText = input.next();
					System.out.println("please enter if its true or false:");
					trueOrFalseCheck = input.nextBoolean();
					
					exceptionTemp = true;
					} catch (InputMismatchException e) {
						System.out.println("ERROR- please enter again");
						input.nextLine();
					}
				}
					System.out.println(db1.editAmericanQuestionAnswerText(idCheck2, AmericanQuestionAnswerText, answercheck3,trueOrFalseCheck));
				}
						
					System.out.println("Didn't find question! you may try again:");
	
					
				break;
		
			case 5:
                  // To delete answer from the american questions stockpile
				exceptionTemp = true;
				int idcheck4 = 0;
				int indexcheck = 0;
				System.out.println(db1);
				System.out.println(" ");
				while(exceptionTemp) {
				try {		
		
				System.out.println("please enter question id:");
				idcheck4 = input.nextInt();
				System.out.println("please enter answer's index");
				indexcheck = input.nextInt();
				exceptionTemp = false;
				}catch (InputMismatchException e) { 
					System.out.println("make sure you entered correct id number and correct index of answer");
					input.nextLine();
				}
			}
				isQuestion temp2 =db1.findingQuestionFromId(idcheck4);
				if(temp2 instanceof AmericanQuestion && temp2 != null) {
				System.out.println(db1.editAmericanQuestionAnswerText(idcheck4, null, indexcheck - 1, false));
			}else {
				System.out.println("you didn't entered ID that belongs to american question");
			}
	
				break;

			case 6:
				// build a test manually
				int counter =0;
				System.out.println("How many questions would you like in your test?");
				int numberOfQuestion = input.nextInt();
				Test testTemp = db1.creatingTest(numberOfQuestion);
				while (numberOfQuestion != 0) {
					System.out.println("Enter~~~> {1} - to choose question from question data base:");
					System.out.println("Enter~~~> {2} - if you want to add new question:");
					int check1 = input.nextInt();
					while (check1 != 1 && check1 != 2) {
						System.out.println("-ERROR- make sure you enter {1) or {2},  please enter again:");
						check1 = input.nextInt();
						
					}
					if (check1 == 1) {
						System.out.println("please enter ID number of question: " + "\n");
						if (counter ==0) {
						System.out.println(db1);
						}
						counter ++ ; 
						int questionId = input.nextInt();
						if (testTemp.addQuestionToTest(db1.findingQuestionFromId(questionId))) {
							System.out.println("-ERROR!- {Question Already Exist} OR {you entered wrong ID number} " + "\n");
							numberOfQuestion++;
						}
						numberOfQuestion--;
						System.out.println(
								"-GREAT!- {Question Added Succesfully} " + "~~~~~LEFT:~~>" + numberOfQuestion + "\n");
					} else {

						// adding answer to the database and to test
						System.out.println("Enter {1} -Open Question  / Enter {2} - American Question");
						int check4 = input.nextInt();
						while (check4 != 1 && check4 != 2) {
							System.out.println("-EROR- please enter again:");
							check4 = input.nextInt();
						}
						if (check4 == 1) {
							// Open question input
							System.out.println("Please enter Open question:");
							String openQuestionText = input.next();
							System.out.println("Please enter Answer:");
							String openAnswerText = input.next();
							OpenQuestion openQ = new OpenQuestion(openQuestionText, openAnswerText);
							db1.addQuestionToDataBase(openQ);
							testTemp.addQuestionToTest(openQ);
							numberOfQuestion--;
							System.out.println("-GREAT!- {Question Added Succesfully} " + "~~~~~LEFT:~~>"
									+ numberOfQuestion + "\n");

						} else {
							// American question input
							System.out.println("Please enter American question:");
							String americanQuestionText = input.next();
							AmericanQuestion americanQ = new AmericanQuestion(americanQuestionText);

							System.out.println("Please enter how many Answers (1 up to 8):");
							int numOfAnswers = input.nextInt();
							while (numOfAnswers < 1 || numOfAnswers > 8) {
								System.out.println("-ERROR- please enter again number between {1-8} :");
								numOfAnswers = input.nextInt();
							}
							for (int i = 0; i < numOfAnswers; i++) {
								System.out.println("Please enter Answer number (" + (i + 1) + "):");
								String Answer = input.next();
								System.out.println("Please enter if its true or false:");
								boolean TORF = input.nextBoolean();
								AmericanQuestionAnswer QQA = new AmericanQuestionAnswer(Answer, TORF);
								americanQ.addAnswerToArray(QQA);
							}

								americanQ.adding2AnswersToArray();
			                   db1.addQuestionToDataBase( americanQ);
			                   testTemp.addQuestionToTest(americanQ);
			                   numberOfQuestion--;
			                   System.out.println("-GREAT!- {Question Added Succesfully} " + "~~LEFT:~>" + numberOfQuestion + "\n");
						}

					}

				}
				testTemp.manuallySort();
				System.out.println(testTemp);
				break;

			case 7:
				// making automatic test
				input.nextLine();
				int numOfAllQuestionsInDataBase = db1.getNumOfAllQuestions();
				System.out.println("there are " + numOfAllQuestionsInDataBase + " questions in the question data base");
				System.out.println("Please enter how many questions you want to have on the test");
				int numOfquestionsInTest = input.nextInt();
				while(numOfquestionsInTest > numOfAllQuestionsInDataBase || numOfquestionsInTest<1 ){
					System.out.println("there are only " + numOfAllQuestionsInDataBase + " in the question data base" );
					System.out.println("Try entering a smaller number of questions:");
					numOfquestionsInTest = input.nextInt();
				}
			    Test test;
				//try {
					test = db1.makeAutomaticTest(numOfquestionsInTest);
					System.out.println(test);
					test.toString();
				//} catch (CloneNotSupportedException e) {
					//e.printStackTrace();
					//System.out.println("ERROR cloneException");
			//	}
				break;
			case 8:
				System.out.println(db1.printArrayTests());
				System.out.println("please enter number of test you want to copy");
				int chooseTest = input.nextInt();
				if(chooseTest<=0 || chooseTest>=db1.getNumOfAllTests()) {
					System.out.println("ERROR - please choose rigth Test");
				}
				else {
				db1.makingTestByCoping(chooseTest);
				System.out.println(db1.printArrayTests());
				}
			}
		
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~{_-MENU-_}~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Enter  1  :  To display all questions stockpile ");
			System.out.println("Enter  2  :  To add a question to questions stockpile");
			System.out.println("Enter  3  :  To edit question ");
			System.out.println("Enter  4  :  To edit question's answer");
			System.out.println("Enter  5  :  To delete answer from  American questions stockpile");
			System.out.println("Enter  6  :  To build a test manually");
			System.out.println("Enter  7  :  To build a test automatically");
			System.out.println("Enter  8  :  To copy new Test");
			System.out.println("Enter  9  :  To exit");
			System.out.println("");
			choose = input.nextInt();
		}
		System.out.println("Thank you!! we hope you enjoy");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("There are: "+db1.getNumOfAllTests()+" Tests");
		System.out.println("Exiting the program will delete the tests");
		input.close();
}
	
	
	}