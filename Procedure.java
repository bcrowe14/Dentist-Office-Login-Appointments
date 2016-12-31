/********************************************************************************
 Brooklyn Crowe
 ********************************************************************************/

import java.io.*;
import java.util.*;
public class Procedure {

 //*****************************Properties*****************************
    private String procCode;
    private String procName;
    private String procDesc;
    private double cost;


//*****************************Constructors*****************************
    public Procedure(){
        procCode = "";
        procName = "";
        procDesc = "";
        cost = 0.00;
    }

    public Procedure(String pc, String pn, String pd, float c){
        procCode = pc;
        procName = pn;
        procDesc = pd;
        cost = c;
    }

//*****************************Behaviors*****************************
    public String getProcCode(){return procCode;}
    public void setProcCode(String pc) {procCode = pc;}

    public String getProcName() {return procName;}
    public void getProcName(String pn){procName = pn;}

    public String getProcDesc() {return procDesc;}
    public void getProcDesc(String pd) {procDesc = pd;}

    public double getCost() {return cost;}
    public void setCost(double c) {cost = c;}

//*****************************Display*****************************
    public void display(){
        System.out.println("Procedure Code: " + getProcCode());
        System.out.println("Procedure Name: " + getProcName());
        System.out.println("Procedure Description: " + getProcDesc());
        System.out.printf("Cost: %.2f " , getCost());
    }

//*****************************FileDetails*****************************
    public Procedure(String fileName) {
        File f1 = new File(fileName);
        long sz = f1.length();
        boolean w1 = f1.canWrite();
        boolean r2 = f1.canRead();

        System.out.println("Length: " + sz);

        if (w1 == false) {
            System.out.println("No file exists, cannot write");
        } else {
            System.out.println("File Exists.");
        }
        if (r2 == false) {
            System.out.println("No file exists, cannot read.");
        } else {
            System.out.println("File exists.");
        }
        System.out.println("=======================");
    }


//*****************************Read*****************************
    public void select(String pc) {
        procCode = pc;
        BufferedReader br;

        try {
            FileInputStream fin = new FileInputStream("Procedures.txt");
            String s1;
            String s2;
            Double d1;
            String read;
            StringTokenizer st;
            br = new BufferedReader(new InputStreamReader(fin));
            do{
                read = br.readLine();
                st=new StringTokenizer(read, ":");
                s1 = st.nextToken();
                if(s1.equals(pc)) {
                    s1=st.nextToken();
                    s2=st.nextToken();
                    d1=Double.valueOf(st.nextToken());
                    procName = s1;
                    procDesc = s2;
                    cost = d1;
                    break;
                }
             }while (true);


            br.close();
        }

        catch (IOException ie) {
            System.out.println(ie);
        }

    }

//*****************************Write*****************************
    public void insert(String pc, String pn, String pd, String c) {

        try {
            FileOutputStream fout = new FileOutputStream("Procedures.txt", true); //  true will stop it from overwriting
            BufferedWriter bw;
            bw = new BufferedWriter(new OutputStreamWriter(fout));
            bw.append("\n" + pc + ":" + pn + ":" + pd + ":" + c);
            bw.close();

        }

        catch (IOException ie) {
            System.out.print(ie);
        }
    }



//*****************************Main for testing*****************************
            public static void main (String args[]){
                Procedure p1;
                p1 = new Procedure();
                p1 = new Procedure("Procedures.txt");
                p1.insert("P119", "Polish", "PolishTeeth","199.88");
                p1.select("P650");
                p1.display();
            }
        }

