package com.presto.banking.common;

import java.lang.reflect.Member;

public class PrestoSecurityManagerAPI extends SecurityManager {

	   public static void changeSecurityAPI() {

	      // set the policy file as the system securuty policy
	      System.setProperty("java.security.policy", "file:/C:/java.policy");

	      // create a security manager
	      PrestoSecurityManagerAPI sm = new PrestoSecurityManagerAPI();

	      // set the system security manager
	      System.setSecurityManager(sm);

	      // perform the checkSystemClipboardAccess
	      sm.checkSystemClipboardAccess();
	     

	      // perform the checkAWTEventQueueAccess
	      sm.checkAwtEventQueueAccess();
	      
	      // check the top level window
	      boolean checked = sm.checkTopLevelWindow("Window");
	      System.out.println("" + checked);

	      // print a message if we passed the check
	      System.out.println("Allowed!");
	      
	      // set the policy file as the system securuty policy
	      System.setProperty("java.security.policy", "file:/C:/java.policy");

	      // perform the checkMemberAccess
	      sm.checkMemberAccess(PrestoSecurityManagerAPI.class, Member.PUBLIC);

	      // print a message if we passed the check
	      System.out.println("Deprecated Methods in API!");
	   }
	   
}
