package com.example.weather;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MyProject {

    @FXML
    private Canvas canv;
    private GraphicsContext gc;
    private NewYear[] currentYear;
    private int start = -1;
    private int yearFromTheUser;
    @FXML
    private TextField year;


    public void startInsert(){
        currentYear = new NewYear[5];
        yearFromTheUser = Integer.parseInt(year.getText());
        for (int i = 0; i < 5; i++) {
            currentYear[i] = new NewYear();
            currentYear[i].setYear(yearFromTheUser+i);
        }
    }

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        if (start == -1) {startInsert();}

        if(start<4){start++;}
        else{start=0;}

        gc = canv.getGraphicsContext2D();
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        year.setText("" + currentYear[start].getYear());
        for(int j=0;j<45;j+=5) {
            gc.strokeText("" + j, 0, 230 - (j * 5));
        }
        for(int i=0;i<12;i++){
            System.out.println(currentYear[start].getNumber()[i]);
            gc.strokeText(""+(i+1), (i+1) * 60 + 5, 270);
            if (currentYear[start].getNumber()[i] == currentYear[start].getMax()){
                gc.setFill(Color.RED);
            }
            else if (currentYear[start].getNumber()[i] == currentYear[start].getMin()){
                gc.setFill(Color.BLUE);
            }
            else{
            gc.setFill(Color.GRAY);
            }
            gc.fillRect((i+1)*60,210-currentYear[start].getNumber()[i]*5,25,20 + currentYear[start].getNumber()[i]*5);
        }
    }
}
