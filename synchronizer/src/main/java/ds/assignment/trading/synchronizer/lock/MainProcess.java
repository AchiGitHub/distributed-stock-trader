package ds.assignment.trading.synchronizer.lock;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MainProcess {
    public static final String ZOOKEEPER_URL = "127.0.0.1:2181";
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        ds.assignment.trading.synchronizer.lock.DistributedLock.setZooKeeperURL(ZOOKEEPER_URL);
        try {
            ds.assignment.trading.synchronizer.lock.DistributedLock lock = new ds.assignment.trading.synchronizer.lock.DistributedLock("myLock", "");
            lock.acquireLock();
            System.out.println("I Got the lock at " + getCurrentTimeStamp());
            accessSharedResource();
            lock.releaseLock();
            System.out.println("Releasing the lock " + getCurrentTimeStamp());
        } catch (IOException | KeeperException | InterruptedException e) {
            System.out.println("Error while creating Distributed Lock myLock :" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void accessSharedResource() throws InterruptedException {
        Random r = new Random();
        long sleepDuration = Math.abs(r.nextInt() % 20);
        System.out.println("Accessing critical section. Time remaining : " + sleepDuration + " seconds.");
        Thread.sleep(sleepDuration * 1000);
    }

    private static String getCurrentTimeStamp() {
        return timeFormat.format(new Date(System.currentTimeMillis()));
    }
}
