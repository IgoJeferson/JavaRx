package utility.subscribers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.GateBasedSynchronization;

public class DemoCompletableObserver implements CompletableObserver {

    private final static Logger log = LoggerFactory.getLogger(DemoCompletableObserver.class);

    private final GateBasedSynchronization gate;
    private final String errorGateName;
    private final String completeGateName;

    public DemoCompletableObserver(GateBasedSynchronization gate, String errorGateName, String completeGateName) {
        this.gate = gate;
        this.errorGateName = errorGateName;
        this.completeGateName = completeGateName;
    }

    @Override
    public void onSubscribe(Disposable d) {
        log.info( "onSubscribe" );
    }

    @Override
    public void onComplete() {
        log.info( "onComplete" );
        gate.openGate(completeGateName);
    }

    @Override
    public void onError(Throwable e) {
        log.error("onError - {}" , e.getMessage());
        log.error(e.getMessage(), e);

        gate.openGate(errorGateName);
    }
}
