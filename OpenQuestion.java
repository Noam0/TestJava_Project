package ID_200037471;

import java.lang.Object;
public class OpenQuestion extends Question implements Cloneable , isQuestion {
	
	
	private String questionAnswer;

	
	public OpenQuestion(String questionText, String questionAnswer) {
		super(questionText);
		this.questionAnswer = questionAnswer;
		
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}
	public String getQuestionText() {
		return questionText; 
	}
	public int getAnswerLength() {
		return questionAnswer.length();
		
	}


	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof OpenQuestion))
		return false;
		if (!(super.equals(other)))
		return false ;
		
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + questionText;
	}
	@Override
	public OpenQuestion clone() throws CloneNotSupportedException{
		return (OpenQuestion) super.clone();
		
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}	
}
