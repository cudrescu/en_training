package service;

/**
 * Created by cudrescu on 5/30/2014.
 */
public interface CleanupService extends Runnable{
    public void scheduledDBClean();
}
