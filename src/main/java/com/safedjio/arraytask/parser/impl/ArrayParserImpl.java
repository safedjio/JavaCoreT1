package com.safedjio.arraytask.parser.impl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.safedjio.arraytask.exception.ArrayException;
import com.safedjio.arraytask.parser.ArrayParser;
import com.safedjio.arraytask.validator.InputDataValidator;

public class ArrayParserImpl implements ArrayParser {

    private static final Logger logger = LogManager.getLogger();

    private static final String DELIMITER_REGEX = "[,;\\s-]+";

    @Override
    public int[] parse(String line) throws ArrayException {

        if(!InputDataValidator.isValidLine(line)){
            logger.error("Invalid line format: {}", line);
            throw new ArrayException("Line contains invalid characters: " + line);
        }

        String trimmedLine = line.trim();

        String[] parts = trimmedLine.split(DELIMITER_REGEX);
        int[] numbers = new int[parts.length];

        try{
            for(int i = 0; i < parts.length; i++){
                if(Integer.parseInt(parts[i])<1000 && Integer.parseInt(parts[i])>0){
                    numbers[i] = Integer.parseInt(parts[i]);
                }
                else throw new ArrayException("Invalid number format: " + parts[i]);
            }
        } catch (NumberFormatException e) {
            logger.error("Error parsing number in line: {}", line, e);
            throw new ArrayException("Error parsing number", e);
        }

        logger.info("Successfully parsed line: '{}' to array of size {}", line, numbers.length);
        return numbers;
    }
}