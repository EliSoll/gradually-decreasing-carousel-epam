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
    int decrement = 1;

    public DecrementingRun(GraduallyDecreasingCarousel decrementingRun) {
        super(decrementingRun);
    }

    @Override
        public int next() {
            int beforeDecreasing;
            if (isFinished())
                return -1;
            else {
                beforeDecreasing = array[position];
                array[position] -= decrement;
                do {
                    position++;
                    if (position == array.length) {
                        decrement++;
                        position = 0;
                    }
                } while ((array[position] <= 0) && !isFinished());
            }
            return beforeDecreasing;
        }

    @Override
    public boolean isFinished() {
        for (int var : array) {
            if (var > 0) return false;
        }
        return true;
    }
}


