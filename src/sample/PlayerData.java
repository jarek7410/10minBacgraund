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

    protected String[] gets1Strings(){
        String[] s=new String[s1.size()];
        for(int i = 0;i<s1.size();i++){
            s[i] = s1.get(i);
        }
        return s;
    }
    protected String[] gets2Strings(){
        String[] s=new String[s2.size()];
        for(int i = 0;i<s2.size();i++){
            s[i] = s2.get(i);
        }
        return s;
    }
    protected String[] gets3Strings(){
        String[] s=new String[s3.size()];
        for(int i = 0;i<s3.size();i++){
            s[i] = s3.get(i);
        }
        return s;
    }
    protected String[] gets4Strings(){
        String[] s=new String[s4.size()];
        for(int i = 0;i<s4.size();i++){
            s[i] = s4.get(i);
        }
        return s;
    }
    protected String[] gets5Strings(){
        String[] s=new String[s5.size()];
        for(int i = 0;i<s5.size();i++){
            s[i] = s5.get(i);
        }
        return s;
    }

    public int gets1Size(){
        return s1.size();
    }
    public int gets2Size(){
        return s2.size();
    }
    public int gets3Size(){
        return s3.size();
    }
    public int gets4Size(){
        return s4.size();
    }
    public int gets5Size(){
        return s5.size();
    }

    public void backs1(){
        if(!s1.isEmpty()){
            s1.remove(s1.size()-1);
        }
    }

}
