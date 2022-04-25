package ID_200037471;


import java.util.Random;

public class AmericanQuestion  extends Question implements Cloneable , isQuestion {

	public enum addAnswerStatus {
		Answer_Already_Exist, No_Place_For_More_Answer, Answer_Added_Succesfully

	}

	private final int MAX_NUM_OF_ANSWERS = 10;
	private int numOfAnswers;
	private AmericanQuestionAnswer[] americanAnswerArray;
	

	public AmericanQuestion(String questionText) {
		super(questionText);
		americanAnswerArray = new AmericanQuestionAnswer[MAX_NUM_OF_ANSWERS];
		numOfAnswers = 0;

	}

	public addAnswerStatus addAnswerToArray(AmericanQuestionAnswer americanQuestionAnswer) {

		if (numOfAnswers == MAX_NUM_OF_ANSWERS) {
			return addAnswerStatus.No_Place_For_More_Answer;
		}

		for (int i = 0; i < numOfAnswers; i++) {
			if (americanAnswerArray[i].equals(americanQuestionAnswer)) {

				return addAnswerStatus.Answer_Already_Exist;
			}
		}

		americanAnswerArray[numOfAnswers++] = americanQuestionAnswer;
		return addAnswerStatus.Answer_Added_Succesfully;

	}

	public void makeRandomArrayAnswers() {
		AmericanQuestionAnswer[] tempAmericanAnswerArray = this.getAnswersArray();
		AmericanQuestionAnswer[] arrayForAutomatic = new AmericanQuestionAnswer[6];
		AmericanQuestionAnswer QQ;
		AmericanQuestionAnswer QQ1;
		String allFalse = "all answers are false ";
		String moreThanOneTrue = "more than one correct answer";
		int counter = 0;

		// shuffel array
		Random rd = new Random();
		for (int i = MAX_NUM_OF_ANSWERS - 1; i > 0; i--) {
			if (tempAmericanAnswerArray[i] != null) {
				int j = rd.nextInt(i + 1);
				while (tempAmericanAnswerArray[j] == null) {
					j = rd.nextInt(i + 1);
				}
				AmericanQuestionAnswer temp = tempAmericanAnswerArray[i];
				tempAmericanAnswerArray[i] = tempAmericanAnswerArray[j];
				tempAmericanAnswerArray[j] = temp;
			}
		}
		// getting new answer array for Automatic test
	int i = 0;
		for (int k = 0; k < tempAmericanAnswerArray.length; k++) {
			if (tempAmericanAnswerArray[k] != null && tempAmericanAnswerArray[k].AnswerText != allFalse
					&& tempAmericanAnswerArray[k].AnswerText != moreThanOneTrue && i < 4) {
				if (tempAmericanAnswerArray[k].isRightOrFalse()) {
					counter++;
				}
				arrayForAutomatic[i] = tempAmericanAnswerArray[k];
				i++;
			}

		}

		if (counter > 1) {
			QQ = new AmericanQuestionAnswer(moreThanOneTrue, true);
			QQ1 = new AmericanQuestionAnswer(allFalse, false);
			arrayForAutomatic[4] = QQ;
			arrayForAutomatic[5] = QQ1;
		}
		if (counter == 0) {
			QQ = new AmericanQuestionAnswer(moreThanOneTrue, false);
			QQ1 = new AmericanQuestionAnswer(allFalse, true);
			arrayForAutomatic[4] = QQ;
			arrayForAutomatic[5] = QQ1;
		}
		if (counter == 1) {
			QQ = new AmericanQuestionAnswer(moreThanOneTrue, false);
			QQ1 = new AmericanQuestionAnswer(allFalse, false);
			arrayForAutomatic[4] = QQ;
			arrayForAutomatic[5] = QQ1;
		}
		this.setAnswersArray(arrayForAutomatic);
	}

	// adding for all questions
	public void adding2AnswersToArray() {
		AmericanQuestionAnswer QQ;
		AmericanQuestionAnswer QQ1;
		String allFalse = "all answers are false ";
		String moreThanOneTrue = "more than one correct answer";
		int counter = 0;
		while (americanAnswerArray[numOfAnswers] == null || americanAnswerArray[numOfAnswers].equals(moreThanOneTrue) ) {

			for (int i = 0; i < numOfAnswers; i++) {
				if (americanAnswerArray[i] != null) {
					if (americanAnswerArray[i].isRightOrFalse()) {
						counter++;
					}

				}
			}
			if (counter > 1) {
				QQ = new AmericanQuestionAnswer(moreThanOneTrue, true);
				QQ1 = new AmericanQuestionAnswer(allFalse, false);
				americanAnswerArray[numOfAnswers] = QQ;
				americanAnswerArray[numOfAnswers + 1] = QQ1;
			}
			if (counter == 0) {
				QQ = new AmericanQuestionAnswer(moreThanOneTrue, false);
				QQ1 = new AmericanQuestionAnswer(allFalse, true);
				americanAnswerArray[numOfAnswers] = QQ;
				americanAnswerArray[numOfAnswers + 1] = QQ1;
			}
			if (counter == 1) {
				QQ = new AmericanQuestionAnswer(moreThanOneTrue, false);
				QQ1 = new AmericanQuestionAnswer(allFalse, false);
				americanAnswerArray[numOfAnswers] = QQ;
				americanAnswerArray[numOfAnswers + 1] = QQ1;
			}
		}

	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof AmericanQuestion))
			return false;
		if (!(super.equals(other)))
			return false;

		return true;
	}
	@Override
	public AmericanQuestion clone() throws CloneNotSupportedException {
		
		 AmericanQuestion temp = (AmericanQuestion)super.clone();
		 AmericanQuestionAnswer[] tempArray = this.getAnswersArray();
		for (int i = 0; i < tempArray.length ; i++) {
			if(tempArray[i] !=null) {
			tempArray[i] = tempArray[i].clone();
			}
		}
		temp.setAnswersArray(tempArray);
		return temp;
	}

	@Override
	public String toString() {
		int k = 1;
		String strAmericanQuestion;
			strAmericanQuestion = getClass().getSimpleName() + ": " + questionText + "\n" + "The answers:" + "\n";
			for (int i = 0; i < americanAnswerArray.length; i++) {
				if (americanAnswerArray[i] != null && americanAnswerArray[i].getAnswerText() != null) {
					strAmericanQuestion += (k) + ") " + americanAnswerArray[i].getAnswerText() + "\n";
				} else {
					k--;
				}
				k++;
			}
			return strAmericanQuestion;
	    }

	public String toStringForDataBase() {
		int k = 1;
		String strAmericanQuestion;

		strAmericanQuestion = getClass().getSimpleName() + ": " + questionText + "\n" + "The answers:" + "\n";
		for (int i = 0; i < americanAnswerArray.length; i++) {
			if (americanAnswerArray[i] != null && americanAnswerArray[i].getAnswerText() != null) {
				strAmericanQuestion += (k) + ") " + americanAnswerArray[i].getAnswerText()
						+ americanAnswerArray[i].toString();
			} else {
				k--;
			}
			k++;
		}
		return strAmericanQuestion;

	}
	
	public int getAnswerLength() {	
		int lengthSum = 0;
		for (int i = 0; i < americanAnswerArray.length; i++) {
			if(americanAnswerArray!=null) {
				lengthSum+=americanAnswerArray[i].AnswerText.length();
			}
			
		}
		return lengthSum;
	}

	public int getNumOfAnswers() {
		return numOfAnswers;
	}
	public String getQuestionText() {
		return questionText; 
	}

	public void setNumOfAnswers(int numOfAnswers) {
		this.numOfAnswers = numOfAnswers;
	}

	public AmericanQuestionAnswer[] getAnswersArray() {
		return americanAnswerArray.clone();
	}

	public void setAnswersArray(AmericanQuestionAnswer[] answersArray) {
		this.americanAnswerArray = answersArray;
	}

	public int getMAX_NUM_OF_ANSWERS() {
		return MAX_NUM_OF_ANSWERS;
	}

	public boolean setAmericanQuestionAnswer(String text, int indexAnswer, boolean TOF) {

		if (!(indexAnswer < 0 || indexAnswer > 10 || americanAnswerArray[indexAnswer] == null)) {

			americanAnswerArray[indexAnswer].setAnswerText(text);
			americanAnswerArray[indexAnswer].setRightOrFalse(TOF);

			return true;
		}
		return false;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@Override
	public void setQuestionAnswer(String s) {
			
	}

}
