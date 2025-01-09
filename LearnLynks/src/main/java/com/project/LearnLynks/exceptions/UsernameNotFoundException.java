package com.project.LearnLynks.exceptions;

import org.antlr.v4.runtime.RuntimeMetaData;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String message) {
        super(message);
    }
}

