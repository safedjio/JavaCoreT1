package com.safedjio.arraytask.warehouse;

import com.safedjio.arraytask.entity.CustomArrayParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouse {
    private static final Logger logger = LogManager.getLogger();

    private static ArrayWarehouse instance;

    private final Map<Long, CustomArrayParameters> map;

    private ArrayWarehouse(){
        this.map = new HashMap<>();
    }

    public static ArrayWarehouse getInstance() {
        if (instance == null) {

            instance = new ArrayWarehouse();
            logger.info("ArrayWarehouse singleton created");
        }
        return instance;
    }

    public void put(Long arrayId, CustomArrayParameters statistics){

        map.put(arrayId, statistics);
        logger.info("Statistics put for array ID {}: {}", arrayId, statistics);

    }

    public CustomArrayParameters get(Long arrayId){
        return  map.get(arrayId);
    }

    public void remove(Long arrayId){
        map.remove(arrayId);
        logger.debug("Statistics removed for array ID {}", arrayId);
    }
}