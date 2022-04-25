package ID_200037471;

//import ID_200037471.AmericanQuestion.addAnswerStatus;

	
public class AmericanQuestionAnswer implements Cloneable {


	public String AnswerText;
	private boolean rightOrFalse;
	
	

	public AmericanQuestionAnswer(String AnswerText, boolean rightOrFalse) {
		this.AnswerText = AnswerText;
		this.rightOrFalse = rightOrFalse;
		
	}

	public String getAnswerText() {
		return AnswerText;
	}

	public void setAnswerText(String answerText) {
		AnswerText = answerText;
	}

	public boolean isRightOrFalse() {
		return rightOrFalse;
	}

	public void setRightOrFalse(boolean rightOrFalse) {
		this.rightOrFalse = rightOrFalse;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AnswerText == null) ? 0 : AnswerText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof AmericanQuestionAnswer))
			return false;
		
		AmericanQuestionAnswer QAtemp = (AmericanQuestionAnswer)other;
		return (this.AnswerText.equals(QAtemp.AnswerText)&&this.hashCode()==QAtemp.hashCode());
		 
	}
	
	@Override
	public AmericanQuestionAnswer clone() throws CloneNotSupportedException {
		return (AmericanQuestionAnswer) super.clone();
	}

	@Override
	public String toString() {
		return "    Answer ~~~~~>" + rightOrFalse + "\n" ;
	}

}
