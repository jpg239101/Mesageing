package company;

import java.util.ArrayList;

/**
 * Created by Jacob on 10/30/2016.
 */
public class People {
    private String key; // Users personal encryption key
    private ArrayList<String> keys = new ArrayList<String>();
    private Scramble crypt = new Scramble();

    public People(){
        key = crypt.keygen();
        int i = 0;
        for(String s : keys){
            keys.add(i,"");
            i++;
        }
    }

    public boolean hasAccess(People u){
        boolean status = false;
        for(int i=0;i<keys.size();i++){
            if(keys.get(i).equals(u.getKey())){
                status = true;
                break;
            }
        }
        return status;
    }
    public void grant(People u){
        int i = 0;
        for(String s : keys){
            if(s.equals("")){
                keys.add(i, u.getKey());
            }else{
                i++;
            }
        }
    }

    public void revoke(People u){
        int count = 0;
        for(String s : keys){
            if(s.equals(u.getKey())){
                keys.add(count,"");
            }else{
                count++;
            }
        }
    }

    public String getKey(){
        return key;
    }

    public ArrayList<String> getKeys(){
        return keys;
    }

    public void newKey(){
        key = crypt.keygen();
    }

    public void say(String cmt, int id, People u[], int count) {
        System.out.println("User " + id + " says " + cmt);
        String encrypted = crypt.encrypt(cmt, u[id].getKey());
        System.out.println("This is now " + encrypted);
        int i;
        for (i = 0; i < count; i++) {
            if (id == i) {
                continue;
            }
            if (u[i].hasAccess(u[id])) {
                System.out.println("User " + i + " sees: " + cmt);
            }
            else {
                System.out.println("User " + i + " sees: " + encrypted);
            }
        }
    }

}
