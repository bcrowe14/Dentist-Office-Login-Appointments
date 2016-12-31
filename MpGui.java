/********************************************************************************
 Brooklyn Crowe
 ********************************************************************************/

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;

public class MpGui extends Application {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dental Login");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Login");
        scenetitle.setFont(Font.font("Britannic Bold", FontWeight.NORMAL, 30));
        grid.add(scenetitle, 0, 0, 2, 1); //columnIndex, rowIndex, colspan, rowspan

        Label userId = new Label("User ID:");
        grid.add(userId, 0, 1);

        TextField userTextField = new TextField();
        userTextField.setPromptText("Username");
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        pwBox.setPromptText("Password");
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        primaryStage.show();

        btn.setOnAction(e -> {

            //******************* Dentist ****************
            if(userTextField.getCharacters().charAt(0) == 'D')
            {

                BorderPane bp1 = new BorderPane();
                GridPane gp1 = new GridPane();
                Button btnW2 = new Button();
                bp1.setCenter(btnW2);


                Text scenetitle1= new Text("Dentist Information");
                scenetitle1.setFont(Font.font("Britannic Bold", FontWeight.NORMAL, 30));
                gp1.add(scenetitle1, 2, 2, 2, 4); //columnIndex, rowIndex, colspan, rowspan

                Text scenetitle2= new Text("Appointments");
                scenetitle2.setFont(Font.font("Britannic Bold", FontWeight.NORMAL, 30));
                gp1.add(scenetitle2, 2, 10, 2, 4); //columnIndex, rowIndex, colspan, rowspan

                //Create and show Scene and Stage
                Scene sceneW2 = new Scene(bp1, 700, 650);
                Stage stageW2 = new Stage();
                stageW2.setTitle("Dentist");
                stageW2.setScene(sceneW2);
                stageW2.show();

                TextField adtxf = new TextField();
                TextField fntxf = new TextField();
                TextField lntxf = new TextField();
                TextField emtxf = new TextField();
                TextField offtxf = new TextField();



                System.out.println("Find Button Pressed");
                Dentists d1 = new Dentists();
                d1.select(userTextField.getText());
                d1.display();

                fntxf.setText(d1.getFirstName());
                lntxf.setText(d1.getLastName());
                adtxf.setText(d1.getId());
                emtxf.setText(d1.getEmail());
                offtxf.setText(String.valueOf(d1.getOffice()));


                fntxf.setPrefColumnCount(10);
                gp1.add(fntxf, 8,4);
                gp1.add(new Label("First Name: "),7,4);

                lntxf.setPrefColumnCount(10);
                gp1.add(lntxf, 8,5);
                gp1.add(new Label("Last Name: "),7,5);

                emtxf.setPrefColumnCount(10);
                gp1.add(emtxf, 8,6);
                gp1.add(new Label("Email: "),7,6);

                offtxf.setPrefColumnCount(10);
                gp1.add(offtxf, 8,7);
                gp1.add(new Label("Office: "),7,7);

                bp1.setCenter(gp1);
                gp1.setVgap(10);
                gp1.setHgap(10);

                //******* Appointment in dentist *******

                TextField apttxf = new TextField();
                TextField ditxf = new TextField();
                TextField pctxf = new TextField();


                ComboBox<Appointment> comboBox = new ComboBox<>();
                for(int i = 0; i < d1.getAList().getCount(); i++)
                {
                    comboBox.getItems().add(d1.getAList().list[i]);
                }
                comboBox.setPromptText("Select Appointment");
                comboBox.setOnAction(comboEvent -> {
                    apttxf.setText(comboBox.getValue().getApptDateTime());
                    ditxf.setText(comboBox.getValue().getDentId());
                    pctxf.setText(comboBox.getValue().getProCode());
                });
                gp1.add(comboBox, 7, 11);


                fntxf.setPrefColumnCount(10);
                gp1.add(apttxf, 8,12);// column=1 row=4
                gp1.add(new Label("Appointment: "),7,12);

                emtxf.setPrefColumnCount(10);
                gp1.add(pctxf, 8,14);
                gp1.add(new Label("Procedure Code: "),7,14);

                bp1.setCenter(gp1);
                gp1.setVgap(10);
                gp1.setHgap(10);

            }

            //*********Patient **********
            else if(userTextField.getCharacters().charAt(0) == 'A')
            {
                BorderPane bp1 = new BorderPane();
                GridPane gp1 = new GridPane();
                Button btnW2 = new Button();
                bp1.setCenter(btnW2);

                Text scenetitle1= new Text("Patient Information");
                scenetitle1.setFont(Font.font("Britannic Bold", FontWeight.NORMAL, 30));
                gp1.add(scenetitle1, 2, 2, 2, 4); //columnIndex, rowIndex, colspan, rowspan

                Text scenetitle2= new Text("Appointment");
                scenetitle2.setFont(Font.font("Britannic Bold", FontWeight.NORMAL, 30));
                gp1.add(scenetitle2, 2, 10, 2, 4); //columnIndex, rowIndex, colspan, rowspan

                //Create and show Scene and Stage
                Scene sceneW2 = new Scene(bp1, 700, 650);
                Stage stageW2 = new Stage();
                stageW2.setTitle("Patient");
                stageW2.setScene(sceneW2);
                stageW2.show();


                TextField fntxf = new TextField();
                TextField lntxf = new TextField();
                TextField emtxf = new TextField();
                TextField ictxf = new TextField();
                TextField addrtxf = new TextField();

                System.out.println("Find Button Pressed");
                Patient p1 = new Patient();
                p1.select(userTextField.getText());
                p1.display();

                fntxf.setText(p1.getFirstName());
                lntxf.setText(p1.getLastName());
                addrtxf.setText(p1.getAddr());
                emtxf.setText(p1.getEmail());
                ictxf.setText(p1.getInsCo());

                fntxf.setPrefColumnCount(10);
                gp1.add(fntxf, 8,4);
                gp1.add(new Label("First Name: "),7,4);

                lntxf.setPrefColumnCount(10);
                gp1.add(lntxf, 8,5);
                gp1.add(new Label("Last Name: "),7,5);

                addrtxf.setPrefColumnCount(10);
                gp1.add(addrtxf, 8,6);
                gp1.add(new Label("Address: "),7,6);

                emtxf.setPrefColumnCount(10);
                gp1.add(emtxf, 8,7);
                gp1.add(new Label("Email: "),7,7);

                ictxf.setPrefColumnCount(10);
                gp1.add(ictxf, 8,8);
                gp1.add(new Label("Insurance Company: "),7,8);

                //Appointment
                TextField apttxf = new TextField();
                TextField ditxf = new TextField();
                TextField pctxf = new TextField();

                Appointment a1 = new Appointment();
                a1.select(userTextField.getText());
                a1.display();

                apttxf.setText(a1.getApptDateTime());
                ditxf.setText(a1.getDentId());
                pctxf.setText(a1.getProCode());

                fntxf.setPrefColumnCount(10);
                gp1.add(apttxf, 8,12);// column=1 row=4
                gp1.add(new Label("Appointment: "),7,12);

                lntxf.setPrefColumnCount(10);
                gp1.add(ditxf, 8,13);
                gp1.add(new Label("Dentist ID: "),7,13);

                emtxf.setPrefColumnCount(10);
                gp1.add(pctxf, 8,14);
                gp1.add(new Label("Procedure Code: "),7,14);

                bp1.setCenter(gp1);
                gp1.setVgap(10);
                gp1.setHgap(10);
            }
        });

    }

    public static void main(String[] args){
        launch(args);
    }
}
