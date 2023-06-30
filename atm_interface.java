import java.util.Scanner;
import java.util.Dictionary;
import java.util.Hashtable;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class atm
{
    public static void main(String a[])
    {
        Scanner read=new Scanner(System.in);
        user obj2=new user();
        user person[]=new user[100];
        transaction t=new transaction();
        int count=0;
        System.out.println("*****************  Welcome To Atm Interface  *******************");
        
        while(true)
        {
            System.out.println("1)registeration\n2)Transaction History\n3)Withdraw\n4)Deposit\n5)Transfer\n6)Details\n7)Quit");
            System.out.print("\nEnter your choice : ");
            int ch=read.nextInt();
            switch(ch)
            {
                case 1:
                        user obj=new user();
                        obj.registration();
                        person[count]=obj;
                        
                        count++;
                        break;
                case 2:
                        int n=obj2.for_transaction(person);
                        if(n!=1000)
                        {t.transaction_(person[n],n,1);}
                        else{System.out.println("---------Complete Your Registration----------\n");}
                        break;
                case 3: 
                        int n2=obj2.for_transaction(person);
                        if(n2!=1000)
                        {t.transaction_(person[n2],n2,2);}
                        else{System.out.println("---------Complete Your Registration----------\n");}
                        break;
                case 4:
                        int n3=obj2.for_transaction(person);
                        if(n3!=1000)
                        {t.transaction_(person[n3],n3,3);}
                        else{System.out.println("---------Complete Your Registration----------\n");}
                        break;
                case 5:
                        int k[]=obj2.for_transfer(person);
                        if(k[0]!=1000 && k[1]!=1000)
                        {
                            t.transaction_1(person[0],person[1],k[0],k[1]); }
                        else{System.out.println("---------Enter valid details----------\n");}
                        break;
                case 6:
                        user obj1=new user();
                        obj1.details(person,obj1.check(person));
                        break;  
                case 7:
                        System.exit(0);
                        break;
                default:
                        System.out.println("----Enter Valid Choice----");  
                        break;   
            }
        }
    }
}


class user
{
    Scanner read=new Scanner(System.in);
    public  String name;
    public  long pswd,balance,withdraw_money,account,deposit,pno;
    public  void registration()
    {
        try
        {
        System.out.print("Enter your name : ");
        name=read.nextLine();
         System.out.print("Enter account number: ");
        account=read.nextLong();
         System.out.print("Enter phone number(10 digit) : ");
        pno=read.nextLong();
        read.nextLine();
         System.out.print("Enter your pin number(XXXXX) : ");
        pswd=read.nextLong();
        balance=0;
        System.out.print("\n-----Registration is completed-----\n");
        }
        catch(Exception e){}

    }

    public void details(user a[],int j)
    {
        
         if( j!=1000)
        {System.out.print("----------Details----------\n"+"Name : "+a[j].name+"\n"+"Phone Number : "+a[j].pno+"\n"+"Account Number : "+a[j].account+"\n"+"Balance Amount : "+a[j].balance+"\n");}
        else{System.out.println("--------Enter valid Account and Pin Number---------");}
    }

    public int check(user a[])
    {
        System.out.print("Enter Account number : ");
        long acc=read.nextLong();
        System.out.print("Enter your Pin number : ");
        long pin=read.nextLong();
        int j,f=0;
        try
        {
           for(j=0;j<a.length;j++)
           {
            if((a[j].account==acc) && a[j].pswd==pin){f=1;break;}
           }     
           if(f==1){return j;}
            else{return 1000;}
        }
        catch(Exception e)
        {return 1000;}
    }

    public int for_transaction(user a[])
    {
        System.out.print("Enter Account number : ");
        long acc=read.nextLong();
        System.out.print("Enter your Pin number : ");
        long pin=read.nextLong();
        int j,f=0;
        try
        {
           for(j=0;j<a.length;j++)
           {
            if((a[j].account==acc) && a[j].pswd==pin){f=1;break;}
           }     
           if(f==1)
            {
                return j;
            }
           else{return 1000;}
        }
        catch(Exception e)
        {return 1000;}
    }
    public int[] for_transfer(user a[])
    {
        int x=2,k[]=new int[2],i=0;
        while(x!=0)
        {
            System.out.println((x==2)?"---Enter account details that transfers money---":"---Enter account details that receives money---");
            System.out.print("Enter Account number : ");
            long acc=read.nextLong();
            System.out.print("Enter your Pin number : ");
            long pin=read.nextLong();
            int j,f=0;
            try
            {
                for(j=0;j<a.length;j++)
                {
                    if((a[j].account==acc) && a[j].pswd==pin){f=1;break;}
                }     
                if (f==1){k[i]=j;}
                else{k[i]=1000;}
            }
            catch(Exception e){}
            x--;
        }
        return k;
    }

}

class transaction
{
    
    Dictionary<Integer,String[]> dict= new Hashtable<>();
    String x[][]=new String[100][100],y;
    int j;
    void transaction_(user u,int person,int i)
    {
        //transaction details
        
            if(i==1)
            {
            System.out.println("------------Transaction Details--------------\n");
            String y[]=(dict.get(person));
            try
            {  
                for(int l=0;y[l]!=null;l++)
                {System.out.println(y[l]);}
            }
            catch(Exception e)
            {}
            }
            //withdraw
            else if(i==2)
            {
                y=new withdraw().withdraw_(u,person);
                if(y!="")
                {
                    for( j=0;x[person][j]!=null;j++){}
                    x[person][j]=y;
                    dict.put(person,x[person]);
                }
            }

            //deposit
            else if(i==3)
            {
                y=new deposit().deposit_(u,person);
                for( j=0;x[person][j]!=null;j++){}
                x[person][j]=y;
                dict.put(person,x[person]);
            }
            else 
            {
                
            }
        
        
    }

    void transaction_1(user sender,user receiver,int s,int r)
    {
        String []y1=new transfer().transfer_(sender,receiver);
        if(y1[0]!="" && y1[1]!="")
        {
            //sender
            for( j=0;x[s][j]!=null;j++){}
            x[s][j]=y1[0];
            dict.put(s,x[s]);
            //receiver
            for( j=0;x[r][j]!=null;j++){}
            x[r][j]=y1[1];
            dict.put(r,x[r]);

        }
    }
}

class withdraw extends transaction
{
    Scanner read=new Scanner(System.in);
    String withdraw_(user u,int person)
    {
        System.out.print("Withdrawal Amount : "); 
        int withdraw_money=read.nextInt();
        if(person!=1000 && u.balance>=withdraw_money)
        {
            u.balance-=withdraw_money;
            System.out.println("----Sucessfully credited Rs."+withdraw_money+"----");
            DateTimeFormatter formate = DateTimeFormatter.ofPattern("  yyyy/MM/dd : HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String x="Credited Money:"+withdraw_money+"\t\t\t ON Date : Time - "+((String)formate.format(now));
            
            return x;
        }
        else
        {
            System.out.println("----Your Available Balance is less than Rs."+withdraw_money+"----");return "";
        }

    } 

}

class deposit extends transaction
{

    Scanner read=new Scanner(System.in);
    public String deposit_(user u,int person)
   {
        System.out.print("deposit Amount : "); 
        int deposit=read.nextInt();
        u.balance+=deposit;
        System.out.println("----Sucessfully deposited Rs."+deposit+"----");
        DateTimeFormatter formate = DateTimeFormatter.ofPattern("  yyyy/MM/dd   : HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String x="Debited Money:"+deposit+"\t\t\t On Date : Time - "+((String)formate.format(now));
        return x;    

   }
}

class transfer extends transaction
{
    Scanner read=new Scanner(System.in);
    String[] transfer_(user s,user r)
    {    
        System.out.println("Enter Amount to Transfer: ");
        long m=read.nextLong();
        if(s.balance>=m)
        {
            s.balance-=m;
            r.balance+=m;
            DateTimeFormatter formate = DateTimeFormatter.ofPattern(" yyyy/MM/dd  : HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String x="Transferred Money from Account Number : "+s.account+" ,Money : "+m+"\t\t\t On Date : Time -"+((String)formate.format(now));
            String x1="Transferred Money to Account Number : "+r.account+" ,Money : "+m+"\t\t\t On Date : Time -"+((String)formate.format(now));
            System.out.println("--------Money Transferred--------");
            String x2[]={x,x1};
            return x2;
        }
        else{System.out.println("\n-------------Insufficient balance-------------\n");String y2[]={"",""};return y2;}

    }
    


}
