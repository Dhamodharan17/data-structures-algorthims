class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int maxSpeed = Arrays.stream(piles).max().orElse(0);
        int minSpeed=1;

        while(minSpeed<=maxSpeed){
            int time=0;
            int midSpeed = minSpeed +(maxSpeed-minSpeed)/2;
            for(int pile:piles){
              //distance = speed/time
                time += Math.ceil((double)pile/midSpeed);
            }
            //possible - then look for more nearer value
            if(time<=h){
                maxSpeed = midSpeed-1;
            }else{
                minSpeed = midSpeed+1;
            }
        }
    return minSpeed;

    }

    public int minEatingSpeedLinearSearch(int[] piles, int h) {

        int max = Arrays.stream(piles).max().orElse(1);

        for(int speed=1;speed<=max;speed++){
            double time = 0;
            for(int pile:piles){
                time += Math.ceil((double) pile/speed);
            }
            if(time<=h) return speed;
        }
        return -1;
    }
}
