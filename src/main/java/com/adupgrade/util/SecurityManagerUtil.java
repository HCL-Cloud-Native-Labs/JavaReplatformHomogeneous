package com.adupgrade.util;
public class SecurityManagerUtil extends SecurityManager {
    public static boolean checkTopLevelWindowPermission(String arg) {
        try {
        //checkPermission(sun.security.util.SecurityConstants.AWT.TOPLEVEL_WINDOW_PERMISSION);
        } catch (SecurityException localSecurityException) {
        return false;
        }
        return true;
    }
}