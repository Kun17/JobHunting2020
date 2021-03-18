/*
 * @lc app=leetcode id=1226 lang=java
 *
 * [1226] The Dining Philosophers
 */

// @lc code=start
class DiningPhilosophers {
    Lock[] forks = new Lock[5];
    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
                                int leftFork = (philosopher + 1) % 5;
                                int rightFork = philosopher;

                                if (philosopher == 4) {
                                    forks[leftFork].lock();
                                    pickLeftFork.run();

                                    forks[rightFork].lock();
                                    pickRightFork.run();
                                    
                                    eat.run();


                                    putRightFork.run();
                                    forks[rightFork].unlock();

                                    putLeftFork.run();
                                    forks[leftFork].unlock();
                                } else {
                                    forks[rightFork].lock();
                                    pickRightFork.run();

                                    forks[leftFork].lock();
                                    pickLeftFork.run();

                                    eat.run();
                                    
                                    putLeftFork.run();
                                    forks[leftFork].unlock();

                                    putRightFork.run();
                                    forks[rightFork].unlock();
                                }

        
    }
}
// @lc code=end

