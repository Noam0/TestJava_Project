package ID_200037471;


public abstract class Question {

	
	protected int questionId;
	protected static int idGenerator = 1000;
	protected String questionText;
	
	public Question(String questionText) {
		this.questionText = questionText;
		questionId = idGenerator++;
	}

	public int getQuestionId() {
		return questionId;
	}                                      // case 8 need to change test copyed number 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Question))
			return false;
		
		Question Qtemp = (Question)other;
		return (questionText.equals(Qtemp.questionText)&& Qtemp.hashCode()==this.hashCode()) ;
	}	
	public abstract void setQuestionText(String s);
	public abstract String toString();
	public abstract int getAnswerLength();
	public abstract String getQuestionText();
	}
