package ru.kochin.adapters;

import ru.kochin.exceptions.IlegalCommandLineException;

public interface CommandLineArgsAdapter<T> {

    T prepareContext(String[] args) throws IlegalCommandLineException;

    default void validateCommandLineArgs(String[] args) throws IlegalCommandLineException {
        if (args.length < 3) {
            throw new IlegalCommandLineException("Command line parameters are incorrect");
        }
    }
}
