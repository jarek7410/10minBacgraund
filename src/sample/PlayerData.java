package sample;

import java.util.ArrayList;
import java.util.List;

public class PlayerData{
    public PlayerData(String nameOfhero){
        this.name=nameOfhero;
    }
    String name;
    private List<String> s1=new ArrayList<>(),s2=new ArrayList<>(),s3=new ArrayList<>(),s4=new ArrayList<>(),s5=new ArrayList<>();

    public void adds1(String a){
        s1.add(a);
    }
    public void adds2(String a){
        s2.add(a);
    }
    public void adds3(String a){
        s3.add(a);
    }
    public void adds4(String a){
        s4.add(a);
    }
    public void adds5(String a){
        s5.add(a);
    }

    public String gets1(){
        String s="";
        for (String element : s1) {
            s=element+"\n"+s;
        }
        return s;
    }
    public String gets2(){
        String s="";
        for (var element : s2) {
            s=element+"\n"+s;
        }
        return s;
    }
    public String gets3(){
        String s="";
        for (var element : s3) {
            s=element+"\n"+s;
        }
        return s;
    }
    public String gets4(){
        String s="";
        for (var element : s4) {
            s=element+"\n"+s;
        }
        return s;
    }
    public String gets5(){
        String s="";
        for (var element : s5) {
            s=element+"\n"+s;
        }
        return s;
    }
    public void backs1(){
        if(!s1.isEmpty()){
            s1.remove(s1.size()-1);
        }
    }

}
