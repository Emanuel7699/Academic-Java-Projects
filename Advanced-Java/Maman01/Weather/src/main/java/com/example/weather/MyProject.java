/**Weather.
 * @author Emanuel Abraham
 * @version 23/03/2026 (2026b)
 */

package com.example.weather;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javax.swing.*;

public class MyProject {

    @FXML
    private Canvas canv;
    private GraphicsContext gc;
    private NewYear[] currentYear;
    private int start = -1;
    private int yearFromTheUser;
    @FXML
    private javafx.scene.control.Button button;
    final int YEARS = 5;
    final int MONTH = 12;
    final int TEMPERATURE = 45;

    /**This function ask the user for year and creates an array with 5 years.
     *
     */
    public void startInsert(){
        yearFromTheUser = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter year: "));
        currentYear = new NewYear[YEARS];
                for (int i = 0; i < YEARS; i++) {
            currentYear[i] = new NewYear();
            currentYear[i].setYear(yearFromTheUser+i);
        }
        button.setText("next year");
    }

    /** Shows the weather graph for a year.
     *
     * @param event
     */
    @FXML
    void onHelloButtonClick(ActionEvent event) {
        if (start == -1) {startInsert();}
        if(start<4){start++;}
        else{start=0;}
        

        gc = canv.getGraphicsContext2D();
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        gc.strokeText("Year: "+currentYear[start].getYear(), 370, 50);
        for(int j=0;j<TEMPERATURE;j+=5) {
            gc.strokeText("" + j, 0, 340 - (j * 5));
        }
        for(int i=0;i<MONTH;i++){
            System.out.println(currentYear[start].getNumber()[i]);
            gc.strokeText(""+(i+1), (i+1) * 60 + 5, 380);
            if (currentYear[start].getNumber()[i] == currentYear[start].getMax()){
                gc.setFill(Color.RED);
            }
            else if (currentYear[start].getNumber()[i] == currentYear[start].getMin()){
                gc.setFill(Color.BLUE);
            }
            else{
            gc.setFill(Color.GRAY);
            }
            gc.fillRect((i+1)*60,320-currentYear[start].getNumber()[i]*5,25,20 + currentYear[start].getNumber()[i]*5);
        }
    }
}
