package ID_200037471;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test implements Cloneable , Printable {

	private static String testType;  //automatic or manually
	private int testId;
	public static int testIdGenerator = 1;
	private List<isQuestion> testQuestions;
	private int numberOfQuestions;
	private int numberOfQuestionsCounter;

	public Test(int numberOfQuestions , String testType) {
		testId = testIdGenerator++;
		testQuestions = new ArrayList<isQuestion>();
		this.numberOfQuestions = numberOfQuestions;
		this.testType = testType;
		numberOfQuestionsCounter = 0;
	}

	public  boolean addQuestionToTest (isQuestion question) throws CloneNotSupportedException{
		
		for (int i = 0; i < numberOfQuestionsCounter ; i++) {
			if (testQuestions.contains(question)) {
				return true;
			}
		}
		if (numberOfQuestions >= numberOfQuestionsCounter) {
			if( question instanceof AmericanQuestion ) {
				AmericanQuestion AQuestion = (AmericanQuestion)question;
				AQuestion = AQuestion.clone();
				AQuestion.makeRandomArrayAnswers();
				testQuestions.add(numberOfQuestionsCounter++ , AQuestion);
			}else if (question instanceof isQuestion) {
				
				testQuestions.add(numberOfQuestionsCounter++ , question.clone());
			}
		}
		return false;
	}
	

	public static String getTestType() {
		return testType;
	}
	

	@Override
	public Test clone() throws CloneNotSupportedException {
		Test temp = (Test)super.clone();
		List<isQuestion> arrayTemp = testQuestions;
		for (int i = 0; i < arrayTemp.size() ; i++) {
			if(testQuestions.get(i)!=null) {
			arrayTemp.set(i, testQuestions.get(i).clone()); // how can i clone Question if i dont interface Question only Open And American .
		}
	}
		temp.setTestQuestions(arrayTemp);
		return temp;
		
		
	}

	@Override
	public String toString() {
		String strTest;
		strTest = " Test number : {" + testId  + "}    ~~~~~" + testType + "~~~~~" + "\n" + "questions : " + "\n";
		for (int i = 0; i < testQuestions.size() ; i++) {
			isQuestion question = testQuestions.get(i);
			if(question!=null) {
				strTest += question.getQuestionId() + "}" + question.toString() + "\n";
			}
		}
		     return strTest;
  }
	
	public  void manuallySort() {
		Comparator<isQuestion> nComparator=(Comparator<isQuestion>) new ManuallyComperator();
		Collections.sort(testQuestions,nComparator);
		
	}
	public void automaticSortnew () {
		Comparator<isQuestion> nComparator=(Comparator<isQuestion>) new AutomaticComperator();
		Collections.sort(testQuestions,nComparator);
	}
	
	

	public void setTestQuestions(List<isQuestion> testQuestions) {
		this.testQuestions = testQuestions;
	}

	public void automaticSort () {
		char firstCharText;
		char firstCharText1;
		int k;
		for (int i = testQuestions.size()-1 ; i >= 0 ; i--) {
		  for (int j = 1 ; j <= i ; j++) {
			if(testQuestions.get(j-1)!=null && testQuestions.get(j)!=null ) {
			String textTemp = testQuestions.get(j-1).getQuestionText();
			String textTemp1 = testQuestions.get(j).getQuestionText();
		    firstCharText = textTemp.charAt(0);
		    firstCharText1 = textTemp1.charAt(0);
		    firstCharText = Character.toLowerCase( firstCharText);
		    firstCharText1 = Character.toLowerCase( firstCharText1);
			k = 0;
			if(firstCharText>firstCharText1 || Character.isDigit( firstCharText)) {
				Collections.swap(testQuestions,j-1,j);
			}
			while(firstCharText==firstCharText1 && firstCharText != '?' && firstCharText1!= '?' ) {
		        firstCharText = textTemp.charAt(k);
				firstCharText1 = textTemp1.charAt(k);
				firstCharText = Character.toLowerCase( firstCharText);
				firstCharText1 = Character.toLowerCase( firstCharText1);
				k++;
			}
			if(firstCharText>firstCharText1 && k>0) {
				Collections.swap(testQuestions,j-1,j);
			   }
			
			}	
		}
		  
	}
  }
}


