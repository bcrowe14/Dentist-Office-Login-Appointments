/********************************************************************************
 Brooklyn Crowe
 ********************************************************************************/

public class AppointmentList {

//*****************************Properties*****************************
    Appointment[] list;
    private int count;

//*****************************Constructors*****************************
    public AppointmentList(){
        list = new Appointment[100];
        count = 0;
    }

    //*****************************Constructors*****************************
    public void addAppointment(Appointment a){
         list[count]=a;
         count++;
    }

    public int getCount()
    {
        return count;
    }


    //*****************************Display*****************************
    public void display(){


        for(int i = 0; i<count; i++)
        {
            list[i].display();
            System.out.println("=========================");
        }

    }


    //*****************************Tester / Main*****************************
    public static void main(String args[]){
       AppointmentList ali=new AppointmentList();
       ali.addAppointment(new Appointment("Dec 1, 2013, 9am", "A900", "D201", "P321"));

        ali.display();
    }

}