/********************************************************************************
 Brooklyn Crowe
 ********************************************************************************/

public class Person {

//*****************************Properties*****************************
    protected String firstName;
    public String lastName;
    public String email;

//*****************************Constructors*****************************
    public Person(){
        firstName = "";
        lastName = "";
        email = "";
    }

    public Person(String fn, String ln, String em){
        firstName = fn;
        lastName = ln;
        email = em;
    }

//*****************************Behaviors*****************************
    public String getFirstName() {return firstName;}
    public void setFirstName(String fn) {firstName = fn;}

    public String getLastName() {return lastName;}
    public void setLastName(String ln) {lastName = ln;}

    public String getEmail() {return email;}
    public void setEmail(String em) {email = em;}

//*****************************Display*****************************
    public void display(){
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Email: " + getEmail());
    }


//*****************************Main*****************************
    public static void main(String args[]){
        Person p1;
        p1 = new Person("Jimmy", "Hawkins", "jhawk@yahoo.com"); // calls multi - arg constructor
        p1.display();


    }

}
