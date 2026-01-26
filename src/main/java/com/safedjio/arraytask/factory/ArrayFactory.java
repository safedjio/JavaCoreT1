package com.safedjio.arraytask.factory;

import com.safedjio.arraytask.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactory {

    public static final Logger logger = LogManager.getLogger();

    public CustomArray createArray(int[] elements){
      logger.info("Creating CustomArray with elements: {}", elements);
      return new CustomArray(elements);
    }

}
