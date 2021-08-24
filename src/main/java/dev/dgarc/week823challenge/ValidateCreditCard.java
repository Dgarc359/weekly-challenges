package dev.dgarc.week823challenge;


import java.util.Arrays;

public class ValidateCreditCard {

//            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%,,#@@@@@@@@@#%%#@@@@@@@@@@@@@@@@&&&&@@@@&%%
//            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@/,*&@@@@@%#&#@@@@@@@@@@@@@@@@@@@@&&&%&&@@&
//            @@@@@@@@@@@@@@(@@@@@@@@@@@@@@@@@@@@@@@@%*,#@@&#&#&@@@@@@@@@@@@@@@@@@@@@@@@&&%&%&
//            @@@@@@@@@@@@@@(@@@@@@@@@@@@@@@@@@@@@@@@@@(,*(%%%@@@@&#(#&@@@@@@@@@@@@@@@@@@@&&%%
//            @@@@@#%@@@@@@@(#(%@@@@@@@@@@@@@@@@@@@@@@@@##%/&@@@@@&&%%%%%#((#&@@@@@@@@@@@@@@@&
//            @@@@&#(@@@@@@@##%%%(#@@@@@@@@@@@@@@@@@@@&#&(*,*&#/#%%&&&&&&&#(/#%%%##((%&@@@@@@@
//            @@@&%%(%@@@@@@@(&%%%%%#(#&@@@@@@@@@@@@&#&##@@%,,#@@@@@@@@@@@@@@@&&%%%%%%%%%%(((%
//            @@&&%##(&@@@@@@&#@@@&&%%%%%#(#&@@@@@@#&&#@@@@@@(,*&@@@@@@@@@@@@@@@@@@@@@&&&&%%%%
//            @&%%(#%%(&@@@@@@%%@@@@@@@@@&&%%%#(((#&#&@@@@@@@@&,,#@@@@@@@@@@@@@@@@@@@@@&&&%%##
//            @&%(#%%&@%%@@@@@@%#@@@@@@@@@@@@@@@@@&&&%#((#%&@@@&/,*&&&&&&%##(((##%&&@@@@@@@@@&
//            &&#(%%&@@&%/%%&@@@&#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%@@@@@@@@@@@@@@@@@@@@@@@@@@&
//            &%/%%%%##(%&%#@@@@@&(&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&
//            %#(%(/%@@@@@@@%#@@@@@#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&
//            %(%(%@@@@@@@@@@&@%#&@@@#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&%##&@@&
//            %/%%@@@@@@@@@@@@@@@@%#&@&#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%(*,,,,,,,*(@@&
//            #(%&@@@@@@@@@@@@@@@@@@@@%##(&@@@@@@@@@@@@@@@@@@@@@@@@@@@&(&&&/*,,,,/#&@@@@@@@@@@
//            #(%&@@@@@@@@@@@@@@@@@@@@@@@@@&@@@@@@@@@@@@@@@@@@@@@@@@%%&%*,,,/%@@@@@@@@@@@@@@@@
//            (#%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&/,*%@@@@@@@@@@@@@@@&&@@@
//            (#%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&@@@@@@@@@@@@&&&&&&&&&&&
//            ((%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&%&&&&&&
//            @(%&@@@@@@@@@@@@@@@@@&&&@&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&&&&
//            @@%#@@@@@@@@@@&%#/*,,,,,,,,,,,/&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&@@@
//            @@@@#%@@@@&/,,,,,,,*/#%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//            #(((#%(&@@&(/(&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@&&%#(////#&@@@@@@@@@@@@@@@@@@@
//            #%%%%%%##&&@&&%&&&%&&&&&&@@@@@@@@@@@@@@@@@@@&%(/(###########(/&@@@@@@@@@@@@@@@@@
//            (%%%%%%%(%&&&&&&&&&&&&&&&@@@@@@@@@@@@@@%/*/#########%%%%%%%%%(#@@@@@@@@@@@@@@&(
//              (%%%%%%%(%&&&&&&&&&&&&&@@@@@@@@@@@@@@#***(####%%%%%%%%%%%%%%%(@@@@@@@@@@@@%*,.
//               ##%%%%%%(&@@@@@@@@@@@@@@@@@@@@@@@@@@%**(##%%%%%%%%%%%%%%%%%%(@@@@@@@@@&/,,...
//             *  #%&%%%%%(&@@@@@@@@@@@@@@@@@@@@@@@@@@%/%%%%%%%%%%%%%%%%%%%%#&@@@@@@%*,,,,,...
//                 %#&%%%%%(@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#%%%%%%%%%%%%%&%%&&@@@@%/,,,*(/#&&#,/
//               ,  %#@&%%%%##@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%(#%%%%%%%%&&&@@@%(#%%%(//#&&%((%*,
//              .    /#@&%%%%%%#(#&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&%#(#%%%%%%(/%&&&&&/%/,,,


    /**
     * Valid cc: 14 - 19 digits in length, passes luhn test
     *      Luhn test:
     *          1. Remove the last digit (check digit)
     *          2. Reverse the number
     *          3. double the value of each digit in odd-number positions
     *              => if double value becomes double digits, add the digits together (ex. 8 * 2 = 16 -> 1 + 6 = 7)
     *          4. Add all digits
     *          5. subtract the last digit of the sum (from step 4) from 10. [Result should equal the check digit]
     *
     * @param ccNum
     * @return true or false based on validity of passed in credit card number
     */

    public static boolean validateCreditCard(long ccNum){
        char[] charArrayCCNum = Long.toString(ccNum).toCharArray();
        if(charArrayCCNum.length < 14 || charArrayCCNum.length > 19) return false; // Guard for invalid length

        char checkDigit = charArrayCCNum[charArrayCCNum.length - 1];

        char[] removedLastDigitCharArray = Arrays.copyOfRange(charArrayCCNum,0, charArrayCCNum.length -2);

        long sum = 0;
        int count = 0;
        for(int i = removedLastDigitCharArray.length; i == 0; i--, count++){
            System.out.println("i: " + i + " array: "+ removedLastDigitCharArray[i] + " count: " + count);
            int addable = 0;
            if (count > 0 && count % 2 != 0){
                long doubled = Long.parseLong(Character.toString(removedLastDigitCharArray[i]))  * 2L;
                System.out.println(doubled);

                if(doubled > 9L){
                    char[] doubleDigitCharArray = Long.toString(doubled).toCharArray();

                    addable = Integer.parseInt(Character.toString(doubleDigitCharArray[0])) + Integer.parseInt(Character.toString(doubleDigitCharArray[1])) ;
                    System.out.println(addable);

                }else{
                    addable = Integer.parseInt(Long.toString(doubled));
                }
            } else{
                addable = Integer.parseInt(Character.toString(removedLastDigitCharArray[i]));
            }
            System.out.println("addable " + addable);
            sum += addable;
            System.out.println("sum: " + sum);
        }

        char lastSumDigit = Long.toString(sum).toCharArray()[Long.toString(sum).toCharArray().length-1];
        long lastSumMinusTen = 10L - Long.parseLong(Character.toString(lastSumDigit));

        System.out.println();
        System.out.println(lastSumMinusTen);
        System.out.println(checkDigit);

        return checkDigit == lastSumDigit;
    }
}
