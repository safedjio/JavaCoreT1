package com.safedjio.arraytask.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.safedjio.arraytask.exception.ArrayException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArrayReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readLines(String filePath) throws ArrayException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            if (logger.isErrorEnabled()) {
                logger.error("File not found: {}", filePath);
            }
            throw new ArrayException("File not found: " + filePath);
        }

        try {
            List<String> lines = Files.readAllLines(path);
            logger.info("Successfully read {} lines", lines.size());
            return lines;
        } catch (IOException e) {
            throw new ArrayException("Error reading file", e);
        }
    }
}