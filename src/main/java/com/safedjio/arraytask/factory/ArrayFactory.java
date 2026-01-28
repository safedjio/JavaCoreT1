package com.safedjio.arraytask.factory;

import com.safedjio.arraytask.entity.CustomArray;
import com.safedjio.arraytask.repository.CustomRepository;
import com.safedjio.arraytask.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactory {

    public static final Logger logger = LogManager.getLogger();
    private final CustomRepository repository = CustomRepository.getInstance();
    private final ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

    public CustomArray createArray(long id, int[] elements){
      logger.info("Creating CustomArray with elements: {}", elements);
      return new CustomArray(elements);
    }

}
