package hashTable.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ying on 2018/4/25.
 */
public class SubdomainVisits811 {
    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> list = subdomainVisits(cpdomains);
        for(String s: list)
            System.out.println(s);
    }
    /*
    * 思路：先用空格分隔cpdomains得到 个数与域名
    *         只要域名里还包含. 就得到其字符串 添加到map中
    * 需要注意的点
    *       1.split函数 里正则表达式 一个或多个空格为：\s+
    *       2.String 转换为 int  用Integer.parseInt(String)函数   Integer.getInteger(string) 是确定具有指定名称的系统属性的整数值
    *       3.domain.substring(domain.indexOf(".")+1) 注意indexof的返回值与substring的值   +1*/
    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length ; i++) {
            String[] strings = new String[2];
            strings = cpdomains[i].split("\\s+");
            //map.put(strings[1],Integer.parseInt(strings[0]));
            if(map.containsKey(strings[1])){
                map.put(strings[1],map.get(strings[1])+Integer.parseInt(strings[0]));
            }else
                map.put(strings[1],Integer.parseInt(strings[0]));
            String domain = strings[1];
            while(domain.indexOf(".")!=-1){
                domain = domain.substring(domain.indexOf(".")+1);
                if(map.containsKey(domain)){
                    map.put(domain,map.get(domain)+Integer.parseInt(strings[0]));
                }else
                    map.put(domain,Integer.parseInt(strings[0]));
            }
        }
       // String l = null;
        for(String s : map.keySet()){
           // l = map.get(s).toString()+" "+s;
            list.add(map.get(s).toString()+" "+s);
        }
      /* for(String s : map.keySet())
           System.out.println(s);*/

        return list;
    }



    private static void add(final String domain,
                            final Map<String, Integer> domains) {
        if ((domain == null) || (domain.length() == 0)) return;
        int cnt = 0;
        final char[] chs = domain.toCharArray();
        int i = 0;
        char ch;
        //由字符数组中的每一位数 得到该数组表示的数  的方法
        while ((ch = domain.charAt(i)) != ' ') {
            cnt = cnt*10 + ch - '0';
            ++i;
        }
        int start = i+1;
        int end = start;
        while (end < chs.length) {
            while (true) {
                if ((end == chs.length) || (domain.charAt(end) == '.')) {
                    break;
                }
                ++end;
            }
            final String subDomain = domain.substring(start, domain.length());
            final Integer curCnt = domains.get(subDomain);
            if (curCnt == null) {
                domains.put(subDomain, cnt);
            } else {
                domains.put(subDomain, cnt + curCnt);
            }
            start = end+1;
            end = start;
        }
    }

   /* public List<String> subdomainVisits(String[] cpdomains) {
        final Map<String, Integer> domains = new HashMap<>();
        for (final String cpdomain : cpdomains) {
            add(cpdomain, domains);
        }
        final List<String> result = new ArrayList<>();
        for (final Map.Entry<String, Integer> entry : domains.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }*/
}
