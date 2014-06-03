package service.impl;

import dao.QueryDao;
import models.mergeData.Query;
import org.springframework.beans.factory.annotation.Autowired;
import service.CleanupService;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by cudrescu on 5/30/2014.
 */
public class CleanupServiceImpl implements CleanupService{

    private static final long schedulerTime = 800000;

    @Autowired
    private QueryDao queryDao;

    public synchronized void scheduledDBClean(){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        currentTime.setMinutes(currentTime.getMinutes()-15);

        List<Query> queryList = queryDao.find(currentTime);
        for(Query query : queryList){
            queryDao.delete(query);
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(schedulerTime);
            } catch (InterruptedException e) {
            }
            scheduledDBClean();
        }
    }

}
