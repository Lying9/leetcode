package pickone.medium;

/**
 * Created by ying on 2018/11/7.
 */
public class PushDominoes838 {
    public static void main(String[] args) {
        String domainones = ".L.R...LR..L..";
//        String domainones = "RR.L";
        System.out.println( pushDominoes(domainones));

    }

    public static String pushDominoes(String dominoes) {
        StringBuilder result = new StringBuilder();
        char pre = '.';
        int preindex = -1;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') {
//                对前面的赋值
                if (preindex == -1) {
                    for (int j = 0; j < i; j++) {
                        result.append(".");
                    }
                }
                if (pre == 'R') {
                    for (int j = preindex; j < i; j++) {
                        result.append("R");
                    }
                } else if (pre == 'L') {
                    result.append("L");
                    for (int j = preindex + 1; j < i; j++) {
                        result.append(".");
                    }
                }
                pre = 'R';
                preindex = i;
            }else if(dominoes.charAt(i) == 'L'){
                if (preindex == -1) {
                    for (int j = 0; j < i; j++) {
                        result.append("L");
                    }
                }
                if (pre == 'R') {
                    for (int j = 0; j < (i-preindex+1)/2; j++) {
                        result.append("R");
                    }
                    if((i-preindex+1)%2 !=0){
                        result.append(".");
                    }
                    for (int j = 0; j <(i-preindex+1)/2-1 ; j++) {
                        result.append("L");
                    }
                } else if (pre == 'L') {
                    for (int j = preindex ; j < i; j++) {
                        result.append("L");
                    }
                }
                pre = 'L';
                preindex = i;
            }
        }
        if(pre == 'L'){
            result.append("L");
            for (int i = preindex+1; i <dominoes.length() ; i++) {
                result.append(".");
            }
        }else if(pre == 'R'){
            for (int i = preindex; i <dominoes.length() ; i++) {
                result.append("R");
            }
        }else{
            for (int i = 0; i <dominoes.length() ; i++) {
                result.append(".");
            }
        }
        return result.toString();
    }
}
