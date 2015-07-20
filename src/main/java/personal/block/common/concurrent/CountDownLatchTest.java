package personal.block.common.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yaoqijun.
 * Date:2015-07-20
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class CountDownLatchTest {
    public static void main(String args[]){
        int count = 10;
        final CountDownLatch l = new CountDownLatch(count);

        for(int i = 0; i < count; ++i)
        {
            final int index = i;
            new Thread(new Runnable() {

                @Override
                public void run() {

                    try {
                        Thread.currentThread().sleep(20 * 1000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                    System.out.println("thread " + index + " has finished...");

                    l.countDown();

                }
            }).start();
        }

        try {
            l.await();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println("ALL FINISHED");
    }
}
