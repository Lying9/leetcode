package dynamicProject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by ying on 2019/3/18.
 */
public class APK {
    public static void main(String[] args) throws IOException {
        ArrayList<String> fileList = new ArrayList<>();
        ArrayList<String> metainffile = new ArrayList<>();

        File apkfile = new File("F:\\安码\\静态前后台\\static\\webpage\\upload\\0b6b98656eb59d1e6001dcf5e06c6f33.apk");

        //打开一个ZIP文件，读取apkfile对象
        ZipFile apkFile = new ZipFile(apkfile);
        //apkFile.entries()返回ZIP文件条目的枚举
        Enumeration<? extends ZipEntry> entries = apkFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = entries.nextElement();
            System.out.println(zipEntry.getName());
            if (!zipEntry.isDirectory()) {
                fileList.add(zipEntry.getName());
                if (zipEntry.getName().startsWith("META-INF/")) {
                    metainffile.add(zipEntry.getName());
                }
            }
        }
        System.out.println("----------------------");
       /* for(String s:fileList){
            System.out.println(s);
        }
        System.out.println();
        for(String s:metainffile){
            System.out.println(s);
        }*/

    }

}
