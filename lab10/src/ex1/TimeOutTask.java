package ex1;

import java.util.Timer;
import java.util.TimerTask;

class TimeOutTask extends TimerTask {
    private Produto product;
    private Timer timer;
    private Gestor manager;

    public TimeOutTask(Gestor manager, Timer timer, Produto product) {
        this.manager = manager;
        this.timer = timer;
        this.product = product;
    }

    @Override
    public void run() {
        timer.cancel();
        manager.endAuction(product);
    }
}
