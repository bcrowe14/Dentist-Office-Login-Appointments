
/********************************************************************************
 Brooklyn Crowe
 ********************************************************************************/
import java.io.*;
import java.util.*;

public class Dentists extends Person{

//*****************************Properties*****************************
    private String id;
    private String passwd;
    private int office;
    private AppointmentList aList;

//*****************************Constructors*****************************
    public Dentists(){
        super();
        id = "";
        passwd = "";
        office = 0;
        aList = new AppointmentList();
    }
    public Dentists(String i, String pw, String fn, String ln, String em, int of, AppointmentList al) {
        super(fn, ln, em);
        id = i;
        passwd = pw;
        office = of;
        aList = al;

    }

//*****************************Behaviors*****************************
    public String getId() {return id;}
    public void setId(String i) {id = i;}

    public String getPasswd() {return passwd;}
    public void setPasswd(String pw) {passwd = pw;}

    public int getOffice() {return office;}
    public void setOffice(int of) {office = of;}

    public AppointmentList getAList() {return aList;}
    public void setAList(AppointmentList al) {aList = al;}

    //*****************************Display*****************************
    public void display() {
        super.display();
        System.out.println("Dentist Id: " + getId());
        System.out.println("Password: " + getPasswd());
        System.out.println("Office Number: " + getOffice());
        System.out.println("=========================");
        getAList().display();
    }

    //*****************************FileDetails*****************************
    public Dentists (String fileName){
        File f1 = new File (fileName);
        long sz = f1.length();
        boolean r1 = f1.canRead();
        boolean w1 = f1.canWrite();

        System.out.println("Length: " + sz);

        if (w1 == false) {
            System.out.println("File does not exist.");
        }else{
            System.out.println("File exists.");
        }
        if (r1 == false) {
            System.out.println("File does not exist.");
        }else{
            System.out.println("File exists.");
        }

        System.out.println("===========================");
    }


//*****************************Read*****************************
    public void select(String i) {
        id = i;
        BufferedReader br;

        try {
            FileInputStream fin = new FileInputStream("Dentists.txt");

            String read;
            StringTokenizer st;
            br = new BufferedReader(new InputStreamReader(fin));

            do {
                read = br.readLine();
                st = new StringTokenizer(read, ":");
                String s1 = st.nextToken();

                if (i.equals(s1)) {
                    String pw = st.nextToken();
                    String fn = st.nextToken();
                    String ln = st.nextToken();
                    String em = st.nextToken();
                    int o = Integer.valueOf(st.nextToken());

                    firstName = fn;
                    lastName = ln;
                    email = em;
                    passwd = pw;
                    office = o;
                    break;

                }
            }while(true);

            br.close();

        }
        catch (IOException ie) {
            System.out.println(ie);
        }

        AppointmentList ali;
        ali=new AppointmentList();

        try {
            FileInputStream fin = new FileInputStream("Appointments.txt");
            br = new BufferedReader(new InputStreamReader(fin));
            String read;
            String s1;
            String s2;
            String s3;
            String s4;
            StringTokenizer st;
            while(br.ready()){
                read = br.readLine();
                st = new StringTokenizer(read, ":");
                s1 = st.nextToken();
                s2 = st.nextToken();
                s3 = st.nextToken();
                s4 = st.nextToken();
                if(s3.equals(id))
                {
                    ali.addAppointment(new Appointment(s1, s2, s3, s4));
                }
            }
            br.close();
        }
        catch (IOException ie) {
            System.out.println(ie);
        }
        aList = ali;

    }


//*****************************Write*****************************
    public void insert(String i, String pw, String fn, String ln, String em, int of) {

        try {
            FileOutputStream fout = new FileOutputStream("Dentists.txt", true); //  true will stop it from overwriting
            BufferedWriter bw;
            bw = new BufferedWriter(new OutputStreamWriter(fout));
            bw.append("\n" + i + ":" + pw +":" +fn +":" + ln + ":" + em + ":" + of);
            bw.close();


        } catch (IOException ie) {
            System.out.print(ie);
        }
    }


//*****************************Main/Tester*****************************
    public static void main(String args[]) {
        Dentists dent1;

        dent1 = new Dentists("Dentists.txt");
        dent1.select("D203");

        dent1.display();


    }
}
