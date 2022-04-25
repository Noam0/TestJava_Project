package ID_200037471;

import java.util.Comparator;

public class AutomaticComperator implements  Comparator<isQuestion> {

	@Override
	public int compare(isQuestion o1, isQuestion o2) {
		if(o1 == null || o2 == null) {
			return 1;
	     }
			return o1.getQuestionText().toLowerCase().compareTo(o2.getQuestionText().toLowerCase());
	}
}
