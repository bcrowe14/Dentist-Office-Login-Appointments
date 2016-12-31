
/********************************************************************************
 Brooklyn Crowe
 ********************************************************************************/

import java.io.*;
import java.util.*;
public class Appointment {

    //*****************************Properties*****************************
    public String apptDateTime;
    public String patId;
    public String dentId;
    public String proCode;

    //*****************************Constructors*****************************
    public Appointment() {
        apptDateTime = "";
        patId = "";
        dentId = "";
        proCode = "";
    }

    public Appointment(String pi, String adt, String di, String pc) {
        patId = pi;
        apptDateTime = adt;
        dentId = di;
        proCode = pc;
    }

    //*****************************Behaviors*****************************
    public String getPatId() {
        return patId;
    }

    public void setPatId(String pi) {
        patId = pi;
    }

    public String getApptDateTime() {
        return apptDateTime;
    }

    public void setApptDateTime(String adt) {
        apptDateTime = adt;
    }

    public String getDentId() {
        return dentId;
    }

    public void setDentid(String di) {
        dentId = di;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String pc) {
        proCode = pc;
    }

//*****************************Display*****************************

    public void display() {
        System.out.println("Patient Id: " + getPatId());
        System.out.println("Appointment Date and Time: " + getApptDateTime());
        System.out.println("Dentist Id: " + getDentId());
        System.out.println("Procedure Code: " + getProCode());
    }

    //****************************Read*****************************
    public void select(String pi) {
        patId = pi;
        BufferedReader br;

        try {
            FileInputStream fin = new FileInputStream("Appointments.txt");
            br = new BufferedReader(new InputStreamReader(fin));
            String read;
            String s1;
            String s2;
            String s3;
            StringTokenizer st;
            do {
                read = br.readLine();
                if(read == null) return;
                st = new StringTokenizer(read, ":");
                s1 = st.nextToken();
                if(s1.equals(pi)) {
                    s1 = st.nextToken();
                    s2 = st.nextToken();
                    s3 = st.nextToken();

                    apptDateTime = s1;
                    dentId = s2;
                    proCode = s3;
                    break;
                }

            } while (true) ;

            br.close();

        }
        catch(IOException ie) {
            System.out.println(ie);
        }

    }



    //*****************************Write*****************************
    public void insert(String pi, String adt,String di, String pc) {

        try {
            FileOutputStream fout = new FileOutputStream("Appointments.txt", true);//  true will stop it from overwriting
            BufferedWriter bw;
            bw = new BufferedWriter(new OutputStreamWriter(fout));
            bw.append("\n" + pi + ":" + adt + ":" + di + ":" + pc);
            bw.close();

        }
        catch (IOException ie) {
            System.out.print(ie);
        }
    }


    //*****************************Main*****************************
    public static void main(String args[]){
        Appointment a1;
        a1 = new Appointment();
        a1.select("A905");
        a1.insert("A912","10/17/2016-9am", "D202", "P114");
        a1.display();
    }

    public String toString()
    {
        return getApptDateTime();
    }
}