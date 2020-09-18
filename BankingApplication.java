import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {

        //Creating  an Array of Accounts!!
        Banking [] Accounts = new Banking[1000];
        try{
        Accounts[0]= new Banking("Bharath","AE000001");
        Accounts[0].showMenu();
        Accounts[100]=new Banking("Ananth","AE000101");
        Accounts[100].showMenu();
        Accounts[12].showMenu();
        }catch (Exception e){
            System.out.println("Account Doesn't Exist!!");
        }
        /*
        * You can create more bank accounts (more than 1000) by specifying the Size of the Accounts
        * in Accounts Array.
        * You can Change the Code to more User Specific if the Client demands.
        *
        * */

    }
}


class Banking{

    int previousTransaction;
    int balance;
    String Customer_Name;
    String Customer_ID;

    Banking(String cName,String cID){
        this.Customer_Name=cName;
        this.Customer_ID=cID;
    }

    public void deposit(int amount){
        if(amount>0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount){
        if(amount>0){
            balance = balance -amount;
            previousTransaction = -amount;

        }
    }


    public void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited Amount is ::" + previousTransaction+"\n");
        }else if(previousTransaction < 0){
            System.out.println("Withdrawn Amount is ::" + Math.abs(previousTransaction)+"\n");
        }else{
            System.out.println("No Transaction Done!!");
        }
    }


    public void showMenu(){

        System.out.println("Welcome "+ Customer_Name);
        System.out.println("Your ID is --: "+Customer_ID+"\n\n");

        Scanner scanner=new Scanner(System.in);
        char option;

        System.out.println("A.Check Balance \n" +
                           "B.Deposit \n"+
                           "C.Withdraw \n" +
                           "D.Previous Transaction \n" +
                           "E.Exit\n");

        do {
            System.out.println("*************************************************");
            System.out.println("Enter an Option");
            System.out.println("*************************************************");
            option=scanner.next().charAt(0);

            switch (option){
                case 'A':
                    System.out.println("Your Balance is "+balance+"\n");
                    break;
                case 'B':
                    System.out.println("Enter the amount to be Deposited");
                    int deposit=scanner.nextInt();
                    deposit(deposit);
                    break;
                case 'C':
                    System.out.println("Enter the Amount to Withdraw ");
                    int withdraw=scanner.nextInt();
                    withdraw(withdraw);
                    break;
                case 'D':
                    getPreviousTransaction();
                    break;
                case 'E':
                    option='E';
                    break;
                default:
                    System.out.println("Invalid Choice Please Enter Correct Option!!\n");
                    break;

            }
        }while(option!='E' );
        System.out.println("Thank you for  Visiting Us.");
        System.out.println("Hope you have a Good Day,See you Again!!");
        System.out.println("**---------------------------------------------------------------** \n"+
                           "**---------------------------------------------------------------** \n"+
                           "**---------------------------------------------------------------**\n");
        System.out.println();

    }


}