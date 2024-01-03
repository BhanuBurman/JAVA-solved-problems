class Solution {
    public int numberOfBeams(String[] banks) {
        // total sum of beams
        int sum = 0;
        // beam count
        int beamCount = 0;
        for(String bank:banks){
            // count of 1's at each level
            int onesCount = 0;
            for(int i = 0; i < bank.length(); i++){
                if(bank.charAt(i) == '1'){
                    onesCount++;
                }
            }
            if(onesCount != 0){
                sum += beamCount*onesCount;
                beamCount = onesCount;
            }
        }
        return sum;
    }
}
