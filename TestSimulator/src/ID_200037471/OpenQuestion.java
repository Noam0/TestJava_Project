package ID_200037471;

public class OpenQuestion extends Question {
	
	private String questionAnswer;

	
	public OpenQuestion(String questionText, String questionAnswer) {
		super(questionText);
		this.questionAnswer = questionAnswer;
		
		
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}


	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}


	
	public String toString() {
		return super.toString() + "OpenQuestion [questionAnswer=" + questionAnswer + "]";
	}
	
	
	}
