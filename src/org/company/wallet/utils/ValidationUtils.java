package org.company.wallet.utils;

import org.company.wallet.entities.Command;

public class ValidationUtils {

    public static Command validateAndGet(String commandStr) {
        String commandTypeStr = commandStr.substring(0, commandStr.indexOf(" "));
        commandTypeStr=commandTypeStr.toUpperCase();
        switch (commandTypeStr){
            case "ADD":

        }
        return null;
    }
}
