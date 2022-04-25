package ID_200037471;

import java.util.Comparator;

public class ManuallyComperator implements  Comparator<isQuestion> {

	@Override
	public int compare(isQuestion o1, isQuestion o2) {
		if(o1 == null || o2 == null) {
			return 1;
	     }
			return Integer.compare(o1.getAnswerLength(),o2.getAnswerLength());
	
	}

}
