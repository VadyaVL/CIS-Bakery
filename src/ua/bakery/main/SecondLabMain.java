package ua.bakery.main;

import ua.bakery.logic.BusinessLogic;

/**
 * @author Vadym
 * @deprecated
 *
 */
public class SecondLabMain {
	
    public static void main(String[] args) {
    	int requestId = BusinessLogic.AddNewRequest();
    	//BusinessLogic.EditRequest(requestId);
    	//BusinessLogic.DeleteRequest(requestId);
    }
	
}
