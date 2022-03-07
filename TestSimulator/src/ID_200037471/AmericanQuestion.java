package ID_200037471;

import java.util.Arrays;

public class AmericanQuestion extends Question {
	
	public enum addAnswerStatus {
		Answer_Added_Succesfully, Answer_Already_Exist, No_Place_For_More_Answer
	}

	private final int MAX_NUM_OF_ANSWERS = 10;
	private int numOfAnswers;
	private AmericanQuestionAnswer[] answersArray;

	public AmericanQuestion(String questionText,int numOfAnswers ) {
		super(questionText);
		
		this.numOfAnswers = numOfAnswers;
		answersArray = new AmericanQuestionAnswer[MAX_NUM_OF_ANSWERS];
		
	
	}
	
	

	public addAnswerStatus addAnswerToArray(AmericanQuestionAnswer americanQuestionAnswer) {
		if (numOfAnswers == MAX_NUM_OF_ANSWERS) {
			return addAnswerStatus.No_Place_For_More_Answer;
		} else if ((findAmericanAnswer(americanQuestionAnswer)==false)) {
			return addAnswerStatus.Answer_Already_Exist;
		} else {
			answersArray[numOfAnswers++] = americanQuestionAnswer;
			return addAnswerStatus.Answer_Added_Succesfully;
		}

	}

	public boolean findAmericanAnswer(AmericanQuestionAnswer americanQuestionAnswer) {
		boolean flag = true;
		for (int i = 0; i < answersArray.length && flag; i++) {
			if (answersArray[i].getAnswerText().equals(americanQuestionAnswer.getAnswerText())) {
				flag = false;

			}
			

		}
		return flag;
	}


	
	public String toString() {
		return super.toString() + "AmericanQuestion [MAX_NUM_OF_ANSWERS=" + MAX_NUM_OF_ANSWERS + ", numOfAnswers=" + numOfAnswers
				+ ", answersArray=" + Arrays.toString(answersArray) + "]";
	}

	public int getNumOfAnswers() {
		return numOfAnswers;
	}

	public void setNumOfAnswers(int numOfAnswers) {
		this.numOfAnswers = numOfAnswers;
	}

	public AmericanQuestionAnswer[] getAnswersArray() {
		return answersArray;
	}

	public void setAnswersArray(AmericanQuestionAnswer[] answersArray) {
		this.answersArray = answersArray;
	}

	
	
}