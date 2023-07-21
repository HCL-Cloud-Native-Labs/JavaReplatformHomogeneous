package com.presto.banking.common;
import com.adupgrade.util.SecurityManagerUtil;
import sun.security.util.SecurityConstants;
public class PrestoSecurityManagerAPI extends SecurityManager {
    @SuppressWarnings("deprecation")
    public static void changeSecurityAPI() {
        // set the policy file as the system securuty policy
        System.setProperty("java.security.policy", "file:/C:/java.policy");
        // create a security manager
        PrestoSecurityManagerAPI sm = new PrestoSecurityManagerAPI();
        // set the system security manager
        System.setSecurityManager(sm);
        // perform the checkSystemClipboardAccess
        sm.checkPermission(SecurityConstants.AWT.ACCESS_CLIPBOARD_PERMISSION);
        // perform the checkAWTEventQueueAccess
        sm.checkPermission(SecurityConstants.AWT.CHECK_AWT_EVENTQUEUE_PERMISSION);
        // check the top level window
        boolean checked = SecurityManagerUtil.checkTopLevelWindowPermission("Window");
        System.out.println("" + checked);
        // print a message if we passed the check
        System.out.println("Allowed!");
        // set the policy file as the system securuty policy
        System.setProperty("java.security.policy", "file:/C:/java.policy");
        // perform the checkMemberAccess
        sm.checkPermission(SecurityConstants.CHECK_MEMBER_ACCESS_PERMISSION);
        // print a message if we passed the check
        System.out.println("Deprecated Methods in API!");
    }
}