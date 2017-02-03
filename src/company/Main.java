package company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner kb = new Scanner(System.in);
        People admin;
        ArrayList<People> users = new ArrayList<People>();
        int count = 1;

        System.out.println("By default the first user will be an Admin user");
        admin = new People();
        users.add(admin);

        System.out.println("Please add more people to talk too ");

        String answer;

        while(true){
            System.out.println("Create a user #" + (count+1) + "(y/n)");
            answer = kb.next();
                if(answer.equalsIgnoreCase("n")){
                break;
                }
                else if(count > 9){
                System.out.println("Sorry, too many people");
                break;
                 }
            users.add(new People());
            users.get(0).grant(users.get(count));
            count++;
        }

        int userId, userId2;
        String say;

        while(true){
            System.out.println("Pick a user to be (0 - " + count + ")");
            userId = kb.nextInt();
            System.out.println("Type message, grant access(grant), revoke access(revoke), or exit: ");
            say = kb.nextLine();
                if(say.equalsIgnoreCase("grant")){
                System.out.println("Grant who access to user " + userId + "?");
                userId2 = kb.nextInt();
                users.get(userId2).grant(users.get(userId));
             }
             else if(say.equalsIgnoreCase("revoke")){
                System.out.println("Revoke user #?");
                userId2 = kb.nextInt();
                users.get(userId2).revoke(users.get(userId));
             }
             else if(say.equalsIgnoreCase("exit")){
                break;
            }
            else{
                System.out.println(users.get(userId));
            }
        }



    }
}
