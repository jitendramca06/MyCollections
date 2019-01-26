package com.questions.java.designpattern.anotherexample.stauctural.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class ProxyFileOperation implements FileOperation{
    private Map<String, String> userRole = new HashMap<>();
    private UserOperationOnFile userOperationOnFile;

    public void addUserRole(String user, String role) {
        userRole.put(user, role);
    }

    @Override
    public void edit(String user, String file) {
        if (userRole.get(user).equals("ADMIN")) {
            if (userOperationOnFile == null) userOperationOnFile = new UserOperationOnFile();
            userOperationOnFile.edit(user, file);
        } else {
            System.out.println("Edit is not allowed for user - " + user + " on file -" + file);
        }
    }

    @Override
    public void view(String user, String file) {
        if (userRole.get(user).equals("ADMIN") || userRole.get(user).equals("USER")) {
            if (userOperationOnFile == null) userOperationOnFile = new UserOperationOnFile();
            userOperationOnFile.view(user, file);
        } else {
            System.out.println("View is not allowed for user - " + user + " on file -" + file);
        }
    }
}
