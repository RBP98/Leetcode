class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        // if(numerator == denominator) return "1";
        
        StringBuilder sb = new StringBuilder();
        if((numerator < 0) ^ (denominator < 0)) sb.append("-");

        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        sb.append(String.valueOf(dividend/divisor));

        long remainder = dividend % divisor;

        if(remainder == 0){
            return sb.toString();
        }else{
            sb.append(".");
        }
        Map<Long, Integer> map = new HashMap<>();
        while(remainder != 0){
            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }

            map.put(remainder, sb.length());
            remainder = remainder * 10;
            sb.append(String.valueOf(remainder/divisor));
            remainder = remainder % divisor;

        }
        return sb.toString();
    }
}