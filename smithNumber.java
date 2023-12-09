class Solution {
    static int smithNum(int n) {
        
        // checking if the number is composite or not
        if(isPrime(n)){
            return 0;
        }
        
        // Initializing all the required variables
        int primeNumber = 2, primeFactorDigitSum = 0, tempNumber = n, numberDigitSum = 0;

        // Get the sum of digits of prime factor of n
        // if the quotient is 1 then just come out of loop
        while(n != 1){
            if(isPrime(primeNumber)){
                while(n%primeNumber == 0){
                    // if the number is prime and it is divisible by n then count the sum of digit of the 
                    // prime number
                    
                    // System.out.println("Prime :"+primeNumber);
                    int digitSum = countDigitSum(primeNumber);
                    primeFactorDigitSum += digitSum;
                    n /= primeNumber;
                }
            }
            primeNumber++;
        }

        // get the digit sum of number
        numberDigitSum = countDigitSum(tempNumber);
        // System.out.println("Digit count : "+numberDigitSum);

        return numberDigitSum == primeFactorDigitSum?1:0;

    }
    
    // Func to count the sum of digit of a number
    static int countDigitSum(int number){
        int sum = 0;
        while( number != 0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
    
    // Func to check if a number is prime
    static boolean isPrime(int number){
        if(number <= 1){
            return false;
        }

        for( int i =2; i < number ; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
};
