package test;

/**
 * Created by ying on 2018/12/18.
 */
public class EnumSingleton {
    public static void main(String[] args) {
        danli one = danli.INSTANCE;
        danli two = danli.INSTANCE;
        one.setString("frist one ");
        System.out.println(one.getString());
        System.out.println(two.getString());
        System.out.println(one == two);
        two.setString("two ");
        System.out.println(one.getString());
        System.out.println(two.getString());
        System.out.println(one == two);

    }


}

enum danli{
    INSTANCE;

    private String string;
    public String getString(){
        return string;
    }
    public void setString(String string){
        this.string = string;
    }

}
