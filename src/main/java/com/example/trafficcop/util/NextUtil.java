package com.example.trafficcop.util;

import org.springframework.stereotype.Component;

@Component
public class NextUtil {
    private final String appendix = " 116 RUS";
    char firstSymbol = 192;
    int secondSymbol = 0;
    int thirdSymbol = 0;
    int forthSymbol = 0;
    char fifthSymbol = 192;
    char sixthSymbol = 192;

    public String getContents()  {
        StringBuilder numberAuto = new StringBuilder();

        if (forthSymbol<9){
            forthSymbol++;
        } else{
            forthSymbol=0;
            if (thirdSymbol<9){
                thirdSymbol++;
            } else {
                thirdSymbol = 0;
                if (secondSymbol<9){
                    secondSymbol++;
                } else {
                    secondSymbol=0;
                    if (sixthSymbol<=223){
                        sixthSymbol++;
                    } else {
                        sixthSymbol=192;
                        if (fifthSymbol<=223){
                            fifthSymbol++;
                        } else {
                            fifthSymbol = 192;
                            if (firstSymbol<=223){
                                firstSymbol++;
                            } else {
                                System.out.println(" NumberOverFlow error! ");
                            }
                        }
                    }

                }
            }
        }

        numberAuto.append(firstSymbol);
        numberAuto.append(secondSymbol);
        numberAuto.append(thirdSymbol);
        numberAuto.append(forthSymbol);
        numberAuto.append(fifthSymbol);
        numberAuto.append(sixthSymbol);
        numberAuto.append(appendix);

        String data = numberAuto.toString();

        return data;
    }
}
