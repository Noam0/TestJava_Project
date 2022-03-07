package ID_200037471;

import java.util.Arrays;

public class DataBase {

	public enum addQuestionStatus {
		Question_Added_Succesfully, Question_Already_Exist
	}

	private OpenQuestion[] allOpenQuestionsArray;
	private AmericanQuestion[] allAmericanQuestionsArray;
	private int sizeOfOpenQuestionArray;
	private int sizeOfAmericanQuestionArray;
	private int numOfAllOpenQuestion;
	private int numOfAllAmericanQuestion;

	public DataBase(int sizeOfOpenQuestionArray ,int sizeOfAmericanQuestionArray) {
		
	allOpenQuestionsArray = new OpenQuestion[sizeOfOpenQuestionArray];
	allAmericanQuestionsArray = new AmericanQuestion[sizeOfAmericanQuestionArray];
	numOfAllOpenQuestion = 0;
	numOfAllAmericanQuestion = 0;

	}

	public addQuestionStatus addQuestionToDataBase(Question question) {
		if (question instanceof OpenQuestion) {
			if (question.equals(findOpenQuestion(question))) {
				return addQuestionStatus.Question_Already_Exist;
			} else if (allOpenQuestionsArray.length == numOfAllOpenQuestion) {
				allOpenQuestionsArray = Arrays.copyOf(allOpenQuestionsArray, allOpenQuestionsArray.length * 2);
				allOpenQuestionsArray[numOfAllOpenQuestion++] = (OpenQuestion) question;
				return addQuestionStatus.Question_Added_Succesfully;
			} else {
				allOpenQuestionsArray[numOfAllOpenQuestion++] = (OpenQuestion) question;
				return addQuestionStatus.Question_Added_Succesfully;
			}

		} else {
			if (question.equals(findAmericanQuestion(question))) {
				return addQuestionStatus.Question_Already_Exist;
			} else if (allAmericanQuestionsArray.length == numOfAllAmericanQuestion) {
				allAmericanQuestionsArray = Arrays.copyOf(allAmericanQuestionsArray,
						allAmericanQuestionsArray.length * 2);
				allAmericanQuestionsArray[numOfAllAmericanQuestion++] = (AmericanQuestion)question;
				return addQuestionStatus.Question_Added_Succesfully;
			} else {
				allAmericanQuestionsArray[numOfAllAmericanQuestion++] = (AmericanQuestion)question;
				return addQuestionStatus.Question_Added_Succesfully;
			}

		}
	
	}

	public boolean findOpenQuestion(Question question) {
		boolean flag = false;
		for (int i = 0; i < allOpenQuestionsArray.length && flag; i++) {
			if (allOpenQuestionsArray[i].equals(question))
				flag = true;
		}
		return flag;
	}

	public boolean findAmericanQuestion(Question question) {
		boolean flag = false;
		for (int i = 0; i < allAmericanQuestionsArray.length && flag; i++) {
			if (allAmericanQuestionsArray[i].equals(question))
				flag = true;
		}
		return flag;
	}

	public String toString() {
		return "DataBase [allOpenQuestionsArray=" + Arrays.toString(allOpenQuestionsArray)
				+ ", allAmericanQuestionsArray=" + Arrays.toString(allAmericanQuestionsArray) + "]";
	}

	public OpenQuestion[] getAllOpenQuestionsArray() {
		return allOpenQuestionsArray;
	}

	public AmericanQuestion[] getAllAmericanQuestionsArray() {
		return allAmericanQuestionsArray;
	}

}
