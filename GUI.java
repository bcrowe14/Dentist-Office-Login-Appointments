/********************************************************************************
 Brooklyn Crowe
 MP3
 11.18.16
 ********************************************************************************/

/*
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class GUI extends Application implements EventHandler<ActionEvent>
{
    BorderPane bp = new BorderPane();

    public Label idbt, fnbt, lnbt, embt, icbt;
    public TextField idtf, fntf, lntf, emtf, ictf;

    public MiddlePanel(){
    ifbt = new Label("");

    }
    public void start(Stage primaryStage)
    {


    }

    public void handle(ActionEvent event)
    {

        if(bp.bFind == event.getSource()) {
            System.out.println("Find Button Pressed");
            Patient p1 = new Patient();
            p1.selectDB(mp.idtf.getText());
            p1.display();
            mp.idft.setText(p1.getPid());
            mp.fntf.setText(p1.getFname());
            mp.lntf.setText(p1.getLname());
            mp.emtf.setText(p1.getEmail());
            mp.ictf.getText(p1.getInsCo());

        }

        if(bp.bInsert == event.getSource()) {
            Patient p2 = new Patient();
            String fn, ln, id, em, ic;
            id = mp.idtf.getText();
            fn = mp.fntf.getText();
            ln = mp.lntf.getText();
            em = mp.emtf.getText();
            ic = mp.ictf.getText();

            p2.insertDB(if. "", fn, ln, "", em, ic);
        }

    }
    //*********************************************************************
    public static void main(String[] args)
    {
        launch(args);
    }

}//End class StudentGUI

*/