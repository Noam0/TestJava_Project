package ID_200037471;


public class AmericanQuestionAnswer extends AmericanQuestion {
	
	
	private boolean rightOrFalse;
	
	

	public AmericanQuestionAnswer(String answerText, boolean rightOrFalse ,int numOfAnswers) {
		super(answerText, numOfAnswers);
		this.rightOrFalse = rightOrFalse;
		
	}

	public String getAnswerText() {
		return getAnswerText();
	}

	//public void setAnswerText(String answerText) {
		//getAnswerText() = answerText;
	//}

	public boolean isRightOrFalse() {
		return rightOrFalse;
	}

	public void setRightOrFalse(boolean rightOrFalse) {
		this.rightOrFalse = rightOrFalse;
	}


	public String toString() {
		return "AmericanQuestionAnswer [AnswerText=" + getAnswerText() + ", rightOrFalse=" + rightOrFalse + "]";
	}
	
}
