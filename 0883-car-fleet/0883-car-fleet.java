class CarDetails{
    int position;
    int speed;
    public CarDetails(int position, int speed){
        this.position = position;
        this.speed = speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> st = new Stack<>(); 
        CarDetails[] cd = new CarDetails[position.length];
        for(int i = 0; i < position.length; i++){

            cd[i] = new CarDetails(position[i], speed[i]);
        }

        Arrays.sort(cd, (a,b) -> Integer.compare(a.position, b.position));

        for(int i = position.length - 1; i >= 0; i--){

            double time =(((double)(target - cd[i].position))/ cd[i].speed);
            if(st.isEmpty() || st.peek() < time){
                st.push(time);
            }
        }

        return st.size();
    }
}