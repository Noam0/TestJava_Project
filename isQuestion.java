package ID_200037471;

public interface isQuestion extends Printable {
	
	public int getAnswerLength();
	public String getQuestionText();
	public  isQuestion clone() throws CloneNotSupportedException;
    public int getQuestionId();
    public void setQuestionText(String s);
    public void setQuestionAnswer(String s);
}
