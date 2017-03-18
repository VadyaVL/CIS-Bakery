package ua.bakery.main;

import ua.bakery.logic.BusinessLogic;

public class SecondLabMain {
	
    public static void main(String[] args) {
    	int requestId = BusinessLogic.AddNewRequest();
    	BusinessLogic.EditRequest(requestId);
    	BusinessLogic.DeleteRequest(requestId);
    }
	
}
