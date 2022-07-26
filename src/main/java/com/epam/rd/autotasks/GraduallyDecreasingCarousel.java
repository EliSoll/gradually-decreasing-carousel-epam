package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.array;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {

        super(capacity);
    }

    public DecrementingRun run() {
        if (isRunning) return null;
        isRunning = true;
        return new DecrementingRun(this);
    }
}

class DecrementingRun extends CarouselRun {
    int position = 0;

    public DecrementingRun(GraduallyDecreasingCarousel decrementingRun) {
        super(decrementingRun);
    }
    @Override
    public int next() {
        int temp;
        if(isFinished()) {
            return -1;
        }
        else {
            while (array[position %= array.length] <= 0) {
                position++;
            }
        }
        temp = array[position];
        int n = 1;
        array[position++]-=n;
        return temp;
    }
}

