package com.safedjio.arraytask.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.exception.ArrayException;
import com.safedjio.arraytask.factory.ArrayFactory;
import com.safedjio.arraytask.parser.ArrayParser;
import com.safedjio.arraytask.parser.impl.ArrayParserImpl;
import com.safedjio.arraytask.reader.ArrayReader;
import com.safedjio.arraytask.service.ArrayService;
import com.safedjio.arraytask.service.impl.ArrayServiceImpl;
import java.util.List;

public class Main {


    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ArrayReader reader = new ArrayReader();
        ArrayParser parser = new ArrayParserImpl();
        ArrayFactory factory = new ArrayFactory();
        ArrayService service = new ArrayServiceImpl();


        String filePath = "data/input.txt";

        try {

            List<String> lines = reader.readLines(filePath);
            //logger.info("File read successfully. Lines found: {}", lines.size());

            for (String line : lines) {

                try {
                    logger.info("Processing line: {}", line);


                    int[] elements = parser.parse(line);

                    CustomArray customArray = factory.createArray(elements);


                    int min = service.findMin(customArray);
                    //logger.info("  -> Min value: {}", min);

                    int max = service.findMax(customArray);

                    int sum = service.calculateSum(customArray);
                    //logger.info("  -> Sum: {}", sum);

                    service.bubbleSort(customArray);

                } catch (ArrayException e) {

                    logger.error("Skipping invalid line: '{}'. Reason: {}", line, e.getMessage());
                }
            }

        } catch (ArrayException e) {

            logger.fatal("Critical error: File cannot be read. Application stopped.", e);
        }
    }
}