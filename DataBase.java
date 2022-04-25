package ID_200037471;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class DataBase {

  public enum addQuestionStatus {
	Question_Added_Succesfully, Question_Already_Exist ,Question_Changed_Succesfully , Didnt_Find_The_Question , Answer_Changed_Succesfully,Index_Out_Of_Bounds
	}

	private List<isQuestion> allQuestionsArray;
	private List<Test> allTestsArray;
	private int numOfAllQuestions;
	private int numOfAllTests;


	public DataBase() {
	    allTestsArray = new ArrayList<Test>();
		allQuestionsArray = new ArrayList<isQuestion>();
		numOfAllQuestions = 0;
		numOfAllTests = 0;

	}

	public addQuestionStatus addQuestionToDataBase(isQuestion question) {
		if (allQuestionsArray.contains(question)) {
				return addQuestionStatus.Question_Already_Exist;
	} 
		if(question instanceof AmericanQuestion) {
			AmericanQuestion AQuestion = (AmericanQuestion)question;
		AQuestion.adding2AnswersToArray();
	}
				allQuestionsArray.add(question);
				numOfAllQuestions++;
				return addQuestionStatus.Question_Added_Succesfully;
       }

	public addQuestionStatus editQuestionText(int questionId , String text) {

		for (int i = 0; i < allQuestionsArray.size() ; i++) {
			if (questionId == allQuestionsArray.get(i).getQuestionId()) {
				allQuestionsArray.get(i).setQuestionText(text);
			 return addQuestionStatus.Question_Changed_Succesfully;
			}
		}
		return addQuestionStatus.Didnt_Find_The_Question;	
	}

	public addQuestionStatus editOpenQuestionAnswerText(int questionId, String text) {
		
		if (numOfAllQuestions + 1000 < questionId || questionId< 1000  ) {
			return addQuestionStatus.Didnt_Find_The_Question;
		}else {
		for (int i = 0; i < numOfAllQuestions ; i++) {
			if (allQuestionsArray.get(i) instanceof OpenQuestion && questionId == allQuestionsArray.get(i).getQuestionId()) {
				allQuestionsArray.get(i).setQuestionAnswer(text);
				return addQuestionStatus.Answer_Changed_Succesfully;
			}
		}
		return addQuestionStatus.Didnt_Find_The_Question;
		}
	}

	public addQuestionStatus editAmericanQuestionAnswerText(int questionId, String text, int indexAnswer, boolean TOF) {

		if (numOfAllQuestions + 1000 < questionId || questionId< 1000  ) {
			return addQuestionStatus.Didnt_Find_The_Question;
		}else {
		boolean flag = true;
		int i = 0;
		for ( i = 0; i < numOfAllQuestions && flag ; i++) {
			if (allQuestionsArray.get(i) instanceof AmericanQuestion && questionId == allQuestionsArray.get(i).getQuestionId())  
			    flag = false;
			
			}
			    AmericanQuestion americanQuestion = (AmericanQuestion)allQuestionsArray.get(i-1);
				if(americanQuestion.setAmericanQuestionAnswer(text, indexAnswer, TOF)) {
				return addQuestionStatus.Answer_Changed_Succesfully;
			}
			    return 	addQuestionStatus.Index_Out_Of_Bounds;
			
		}
	}
	
	public isQuestion findingQuestionFromId(int questionId) {

		for (int i = 0; i < allQuestionsArray.size(); i++) {
			if(allQuestionsArray.get(i)==null) {
				System.out.println("Error no match!");
			  return null;
			}
			if (questionId == allQuestionsArray.get(i).getQuestionId()) {
				return allQuestionsArray.get(i);
			}
		}
		System.out.println("Error no match!");
		  return null;
	}
	
	public List<Test> getAllTestsArray() {
		return allTestsArray;
	}

	public int getNumOfAllTests() {
		return numOfAllTests;
	}
	public int getNumOfAllQuestions() {
		return numOfAllQuestions;
	}
    public String printArrayTests() {
	   String printTests = " ";
	    for (int i = 0; i < allTestsArray.size(); i++) {
		 if(allTestsArray.get(i)!=null) {
		 printTests+=allTestsArray.get(i).toString();
		}
	}
	return printTests;
	
}

	@Override
	public String toString() {
		String strDataBase;
		strDataBase = "~~~~~~~~~~~~DataBase questions:~~~~~~~~~~~~" + "\n" + "\n";

		for (int i = 0; i < allQuestionsArray.size(); i++) {
			if (allQuestionsArray.get(i) != null) {
				if (allQuestionsArray.get(i) instanceof OpenQuestion) {
					OpenQuestion openQuestion = (OpenQuestion) allQuestionsArray.get(i);

					strDataBase += openQuestion.questionId + ")" + openQuestion.toString() + "\n" + "Answer: "
							+ openQuestion.getQuestionAnswer() + "\n" + "\n";
				}
		if (allQuestionsArray.get(i) instanceof AmericanQuestion) {
		  AmericanQuestion americanQuestion = (AmericanQuestion) allQuestionsArray.get(i);

					strDataBase += americanQuestion.questionId +")" + americanQuestion.toStringForDataBase() + "\n";
							
				}
			}
		}
		return strDataBase;
	}
		                                                          
	public Test creatingTest(int numberOfQuestionInTest) {

		Test test = new Test(numberOfQuestionInTest , "manual");
		allTestsArray.add(numOfAllTests++, test); 
		return test;

	}

	public Test makeAutomaticTest(int numberOfQuestionInTest) throws CloneNotSupportedException {
		Test test = new Test(numberOfQuestionInTest , "automatic");
		Random r = new Random();
		int randomId;
    // making random by collections
		for (int i = 0; i < numberOfQuestionInTest ; i++) {
			randomId = 1000 + r.nextInt(numOfAllQuestions);
			isQuestion temp = this.findingQuestionFromId(randomId);
		if(test.addQuestionToTest(temp)|| temp == null) {
			i--;
		}
	}
		test.automaticSortnew();
		allTestsArray.add(numOfAllTests++, test);
		return test;
	}
		public void makingTestByCoping (int testIndex) throws CloneNotSupportedException {
			testIndex+=-1;
			if(allTestsArray.size()>testIndex&&testIndex>=0&&allTestsArray.get(testIndex)!=null) {
			Test newTest = allTestsArray.get(testIndex).clone();
			allTestsArray.add(newTest);
		}
	}
	public void addingQuestionAutomatically() {

		//first Open questions:
		OpenQuestion Q1 = new OpenQuestion("What is the exact radius of the earth?", "6,371 km");
		OpenQuestion Q2 = new OpenQuestion("How many times Argentina won the  World Cup Tournament?", "2");
		OpenQuestion Q3 = new OpenQuestion("What was Freddie Mercury‘s real name?", "Farrokh Bulsara");
		OpenQuestion Q4 = new OpenQuestion("Believe it or not, Jimi Hendrix only had one Top 40 hit Which song was it?","All Along The WatchOver");
		OpenQuestion Q5 = new OpenQuestion("What's the capital of Brazil?" , "Brasilia" );	
		
		
		AmericanQuestion Q6 = new AmericanQuestion("Solve this equation - e^pi*i - 1 = ? ");
		//this american question answers:
		AmericanQuestionAnswer A1 = new AmericanQuestionAnswer("1", false);
		AmericanQuestionAnswer A2 = new AmericanQuestionAnswer("0", true);
		AmericanQuestionAnswer A3 = new AmericanQuestionAnswer("2", true);
		AmericanQuestionAnswer A6 = new AmericanQuestionAnswer("4", true);
		AmericanQuestionAnswer A4 = new AmericanQuestionAnswer("55", false);
		AmericanQuestionAnswer A5 = new AmericanQuestionAnswer("6", false);
		
		//adding answer to the question
		Q6.addAnswerToArray(A1);
		Q6.addAnswerToArray(A2);
		Q6.addAnswerToArray(A3);
		Q6.addAnswerToArray(A4);
		Q6.addAnswerToArray(A5);
		Q6.addAnswerToArray(A6);
		
		
		AmericanQuestion Q7 = new AmericanQuestion("what five colours are the Olympic rings?");
		//this american question answers:
		AmericanQuestionAnswer AB1 = new AmericanQuestionAnswer("Red, Pink, White, blue and yellow", false);
		AmericanQuestionAnswer AB2 = new AmericanQuestionAnswer("black, blue, red, green, grey", false);
		AmericanQuestionAnswer AB3 = new AmericanQuestionAnswer("blue, black, red, yellow, green", true);
		AmericanQuestionAnswer AB4 = new AmericanQuestionAnswer("yellow, pink, black, red, blue ", false);
		AmericanQuestionAnswer AB5 = new AmericanQuestionAnswer("black, grey, white, blue, yellow", false);
		AmericanQuestionAnswer AB6 = new AmericanQuestionAnswer("all rings are black and white", false);
		
	//adding answer to the question
		Q7.addAnswerToArray(AB1);
		Q7.addAnswerToArray(AB2);
		Q7.addAnswerToArray(AB3);
		Q7.addAnswerToArray(AB4);
		Q7.addAnswerToArray(AB5);
		Q7.addAnswerToArray(AB6);
		
	
	//adding all questions to data base
		addQuestionToDataBase(Q1);
		addQuestionToDataBase(Q2);
		addQuestionToDataBase(Q3);
		addQuestionToDataBase(Q4);
		addQuestionToDataBase(Q5);
		addQuestionToDataBase(Q6);
		addQuestionToDataBase(Q7);

	}
}
