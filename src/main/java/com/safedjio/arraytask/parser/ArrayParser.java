package com.safedjio.arraytask.parser;
import com.safedjio.arraytask.exception.ArrayException;

public interface ArrayParser {
    int[] parse(String line) throws ArrayException;
}
