package ID_200037471;

public class Question {

	public int questionId;
	public static int idGenerator = 1000;
	public String questionText;
	
	public Question(String questionText) {
		super();
		questionId = idGenerator++;
	}

	public int getQuestionId() {
		return questionId;
	}

	
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + "]";
	}

	
}
