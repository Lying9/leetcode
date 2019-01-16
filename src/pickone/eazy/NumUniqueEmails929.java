package pickone.eazy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ying on 2019/1/16.
 */
public class NumUniqueEmails929 {
    public static void main(String[] args) {
       String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

//    优化： 用set 代替 ArrayList
    public static int numUniqueEmails(String[] emails) {
//第一种   32ms
        /*ArrayList<String> result = new ArrayList<>();
        for(String email : emails){
            int index = email.indexOf("@");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < index;i++){
                if(email.charAt(i) == '.')
                    continue;
                else if(email.charAt(i) == '+')
                    break;
                sb.append(email.charAt(i));
            }
            sb.append(email.toCharArray(),index,email.length()-index);
            if(!result.contains(sb.toString())){
                result.add(sb.toString());
            }
        }
        return result.size();*/
//第二种   61ms
        Set<String> set = new HashSet<>();
         for(String e : emails) {
             String[] email = e.split("@");
             String local = email[0];
             String domain = email[1];
             if (local.contains("+")) {
                 String[] localPlus = local.split("\\+");
                 local = localPlus[0];
             }
             if(local.contains("."))
                 local = local.replace(".", "");
             set.add(local+"@"+domain);
         }
        return set.size();
    }
}
