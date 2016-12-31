/********************************************************************************
 Brooklyn Crowe
 ********************************************************************************/

import java.io.*;
import java.util.*;
//*****************************Properties*****************************
public class Patient extends Person {
    private String patId;
    private int passwd;
    private String addr;
    private String insCo;
    private Appointment appt;

//*****************************Constructors*****************************

    public Patient() {
        super();
        patId = "";
        addr = "";
        passwd = 0;
        insCo = "";
        appt = new Appointment();
    }

    public Patient(String pi, int pw, String fn, String ln, String add, String em, String ic, Appointment a){
        super(fn, ln, em);
        patId = pi;
        addr = add;
        passwd = pw;
        insCo = ic;
        appt = a;
    }
//*****************************Behaviors*****************************
    public String getPatId() {return patId;}
    public void setPatId(String pi) {patId = pi;}

    public String getAddr() {return addr;}
    public void setAddr(String add) {addr = add;}

    public int getPasswd() {return passwd;}
    public void setPasswd(int pw) {passwd = pw;}

    public String getInsCo() {return insCo;}
    public void setInsCo(String ic) {insCo = ic;}

    public Appointment getAppt() {return appt;}
    public void setAppt(Appointment a){appt = a;}

//*****************************Display*****************************

    public void display(){
        super.display();
        System.out.println("Patient ID: " + getPatId());
        System.out.println("Address: " + getAddr());
        System.out.println("Password: " + getPasswd());
        System.out.println("Insurance Company: " + getInsCo());
        System.out.println("===========================");
        appt.display();
    }

//*****************************FileDetails*****************************
    public Patient (String fileName){
        File f1 = new File (fileName);
        long sz = f1.length();
        boolean w1 = f1.canWrite();
        boolean r1 = f1.canRead();

        System.out.println("Length:" + sz);

        if(w1==false) {
            System.out.println("File does not exist, cannot write.");
        }else {
            System.out.println("File exists.");
        }
        if (r1 == false) {
            System.out.println("File does not exist, cannot read.");
        }else {
            System.out.println("File exists.");
        }
        System.out.println("===========================");
    }


//*****************************Read*****************************
    public void select(String pid) {
        patId=pid;
        BufferedReader br;

        try {
            FileInputStream fin = new FileInputStream("Patients.txt");

            String read;
            StringTokenizer st;
            br = new BufferedReader(new InputStreamReader(fin));

            do {
                read = br.readLine();
                st = new StringTokenizer(read, ":");
                String s1 = st.nextToken();

                if (pid.equals(s1)) {
                    String pw = st.nextToken();
                    String fn = st.nextToken();
                    String ln = st.nextToken();
                    String ad = st.nextToken();
                    String em = st.nextToken();
                    String ic = st.nextToken();

                    firstName = fn;
                    lastName = ln;
                    email = em;
                    addr = ad;
                    passwd = Integer.parseInt(pw);
                    insCo = ic;


                    break;

                }
            }while(true);

                br.close();
            }
         catch(IOException ie){
                System.out.println(ie);
            }

        Appointment a1;
        a1 = new Appointment();
        a1.select(pid);

         appt=a1;


        }



//*****************************Write*****************************
public void insert(String pi, int pw, String fn, String ln, String add, String em, String ic) {

    try {
        FileOutputStream fout = new FileOutputStream("Patients.txt", true); //  true will stop it from overwriting
        BufferedWriter bw;
        bw = new BufferedWriter(new OutputStreamWriter(fout));
        bw.append("\n" + pi + ":" + pw + ":" + fn + ":" + ln + ":" + add + ":" + em + ":" + ic );
        bw.close();
    }

    catch (IOException ie) {
        System.out.print(ie);
    }
}

//*****************************Tester / Main*****************************

    public static void main(String args[]){
        Patient pat1;
        pat1 = new Patient();
        pat1 = new Patient("Patients.txt");
        pat1.select("A910");
        pat1.insert("A912", 9987, "Brooklyn","Crowe", "Woodstock", "bcrowe@gmail.com","United Health Care");
        pat1.display();
    }

}