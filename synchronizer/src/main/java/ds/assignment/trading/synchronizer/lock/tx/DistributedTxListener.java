package ds.assignment.trading.synchronizer.lock.tx;

public interface DistributedTxListener {
    void onGlobalCommit();
    void onGlobalAbort();
}
