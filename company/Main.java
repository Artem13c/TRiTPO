package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    public double SearchCent(double width, int len, double x){

        return x + (width - len * 10)/2;
    }

    public String[] string9(int num) throws IOException {

        String end[] = new String[9];
        String st1 = new String();
        String str = new String();

        switch(num) {
            case 1:
                st1 = "1.txt";
                break;
            case 2:
                st1 = "2.txt";
                break;
            case 3:
                st1 = "3.txt";
                break;
            case 4:
                st1 = "4.txt";
                break;
            case 5:
                st1 = "5.txt";
                break;
            case 6:
                st1 = "6.txt";
                break;
            case 7:
                st1 = "7.txt";
                break;
        }
        FileInputStream file = new FileInputStream(st1);

        byte[] buffer = new byte[file.available()];

        file.read(buffer, 0, file.available());

        for(int i = 0, j = 1, h = 0; i < buffer.length && h < 9; i++) {

            if (i == 0)
                str = "1.";
            if (buffer[i] == '#') {
                j++;
                end[h] = new String();
                end[h] = str;
                str = "";
                str = str + Integer.toString(j) + ".";
                h++;
            }
            else {
                str = str + (char)buffer[i];
            }
        }
        for(int i = 0; i < 9; i++) {
           // System.out.println(end[i]);
        }
        return end;
    }
    public Group printAffairs(Group group, int num) throws IOException {

        int kon = 0;
        String end[] = new String[100];
        Label text[] = new Label[100];
        String st1 = new String();
        switch(num) {
            case 1:
                st1 = "1.txt";
                break;
            case 2:
                st1 = "2.txt";
                break;
            case 3:
                st1 = "3.txt";
                break;
            case 4:
                st1 = "4.txt";
                break;
            case 5:
                st1 = "5.txt";
                break;
            case 6:
                st1 = "6.txt";
                break;
            case 7:
                st1 = "7.txt";
                break;
        }
        FileInputStream file = new FileInputStream(st1);
        String str = new String();

        byte[] buffer = new byte[file.available()];

        file.read(buffer, 0, file.available());

        for(int i = 0, j = 1, h = 0; i < buffer.length; i++) {

            if (i == 0)
                str = "1.";
            if (buffer[i] == '#') {
                j++;
                end[h] = new String();
                end[h] = str;
                str = "";
                str = str + Integer.toString(j) + ".";
                h++;
            }
            else {
                str = str + (char)buffer[i];
            }
            kon = h;
        }

        for (int i = 0; i < kon; i++) {
            if (i < 27) {
                //System.out.println(end[i]);
                text[i] = new Label();
                text[i].setText(end[i]);
                text[i].setFont(new Font("rockwell",20));
                text[i].setMaxWidth(300);
                text[i].setWrapText(false);
                text[i].setTextFill(Color.YELLOWGREEN);
                text[i].setLayoutX(10);
                text[i].setLayoutY(10 + i * 20);
                group.getChildren().add(text[i]);
            }
            else {
                //System.out.println(end[i]);
                text[i] = new Label();
                text[i].setText(end[i]);
                text[i].setFont(new Font("rockwell",20));
                text[i].setMaxWidth(300);
                text[i].setWrapText(false);
                text[i].setTextFill(Color.YELLOWGREEN);
                text[i].setLayoutX(350);
                text[i].setLayoutY(10 + (i - 27) * 20);
                group.getChildren().add(text[i]);
            }
        }

        return group;
    }

    public Group paintDays(Group group) throws IOException {

        Label labe[] = new Label[63];
        String end[] = new String[9];
        for(int i = 0, j = 0; i < 63; i++) {
            labe[i] = new Label();
        }

        String st[] = new String[9 * 7];

        Label lab[] = new Label[7];
        Rectangle rec[] = new Rectangle[7];

        String str[] = new String[7];
        str[0] = "Понедельник";
        str[1] = "Вторник";
        str[2] = "Среда";
        str[3] = "Четверг";
        str[4] = "Пятница";
        str[5] = "Суббота";
        str[6] = "Воскресенье";

        for (int i = 0; i < 7; i++) {

            rec[i] = new Rectangle();
            if(i < 4) {
                rec[i].setLayoutX(i * 170 + 20);
                rec[i].setLayoutY(20);
            }
            else {
                rec[i].setLayoutY(290);
                rec[i].setLayoutX((i - 4) * 170 + 20);
            }
            rec[i].setHeight(250);
            rec[i].setWidth(150);
            rec[i].setFill(Color.BISQUE);
            group.getChildren().add(rec[i]);

            lab[i] = new Label();
            lab[i].setText(str[i]);
            lab[i].setFont(new Font("rockwell",20));
            lab[i].setTextFill(Color.PURPLE);
            lab[i].setMaxWidth(130);
            lab[i].setWrapText(true);
            lab[i].setLayoutX(SearchCent(rec[i].getWidth(), str[i].length(), rec[i].getLayoutX()));
            lab[i].setLayoutY(rec[i].getLayoutY());
            group.getChildren().add(lab[i]);
        }

        int step = 50;
        for(int i = 0, j = 0, l = 0; i < 7; i++, l++) {

            end = string9(i+1);

            if(i == 4) {

                l = 0;
                step = 320;
            }

            for(int k = 0; k < 9; k++) {
                labe[j].setText(end[k]);
                labe[j].setFont(new Font("rockwell", 20));
                labe[j].setMaxWidth(130);
                labe[j].setWrapText(false);
                labe[j].setTextFill(Color.DARKRED);
                labe[j].setLayoutX(30 + l * 170);
                labe[j].setLayoutY(step + k * 20);
                group.getChildren().add(labe[j]);
                j++;
            }
        }

        return group;
    }

    public void newWindow(int num){

        Stage neW = new Stage();
        Group g1 = new Group();
        try {
            g1 = printAffairs(g1, num);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scen = new Scene(g1);
        scen.setFill(Color.INDIGO);
        neW.setScene(scen);
        neW.setWidth(715);
        neW.setHeight(600);
        neW.setResizable(false);

        neW.show();
    }

    public void WinRed(int num, Stage stage) throws IOException {

        Stage neW = new Stage();
        Group g1 = new Group();
        Button but3 = new Button("Изменить");

        TextArea text = new TextArea();

        String end = new String();

        String st1 = new String();
        switch(num) {
            case 1:
                st1 = "1.txt";
                break;
            case 2:
                st1 = "2.txt";
                break;
            case 3:
                st1 = "3.txt";
                break;
            case 4:
                st1 = "4.txt";
                break;
            case 5:
                st1 = "5.txt";
                break;
            case 6:
                st1 = "6.txt";
                break;
            case 7:
                st1 = "7.txt";
                break;
        }
        FileInputStream file = new FileInputStream(st1);
        String str = new String();

        byte[] buffer = new byte[file.available()];

        file.read(buffer, 0, file.available());

        for(int i = 0; i < buffer.length; i++) {

            if (buffer[i] == '#' && i != buffer.length - 1) {
                str = str + "\n";
            }
            else {
                if (i != buffer.length - 1)
                    str = str + (char)buffer[i];
            }
        }

        //System.out.println(str);

        text.setText(str);
        text.setPrefWidth(385);
        text.setPrefHeight(500);

        but3.setLayoutX(160);
        but3.setLayoutY(520);

        g1.getChildren().add(text);
        g1.getChildren().add(but3);

        Scene scen = new Scene(g1);
        scen.setFill(Color.INDIGO);
        neW.setScene(scen);
        neW.setWidth(400);
        neW.setHeight(600);
        neW.setResizable(false);

        var ref = new Object() {
            String str1 = new String();
        };

        String finalSt = st1;
        but3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                ref.str1 = text.getText() + "\n";
                //System.out.println(ref.str1);
                try(FileOutputStream fos = new FileOutputStream(finalSt))
                {
                    // перевод строки в байты
                    byte[] buffer = ref.str1.getBytes();

                    System.out.println((char)buffer[0]);

                    if (buffer.length > 1) {
                        for (int i = 0; i < buffer.length; i++) {

                            if (buffer[i] == '\n' && buffer[i - 1] != '#') {
                                buffer[i] = '#';
                            }
                        }
                        fos.write(buffer, 0, buffer.length);
                    }
                    else {
                        buffer[0] = '\0';
                        fos.write(buffer, 0, buffer.length);
                    }
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }
                neW.close();
                stage.close();
                try {
                    WinFirst(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        neW.show();
    }

    public void WinFirst(Stage stage) throws IOException {

        Group group = new Group();
        Button btn1[] = new Button[7];
        Button btn2[] = new Button[7];

        for(int i = 0; i < 7; i++) {

            btn1[i] = new Button();
            btn1[i].setText("Больше...");
            btn2[i] = new Button();
            btn2[i].setText("Изменить");
            if(i < 4) {

                btn2[i].setLayoutX(95 + i * 170);
                btn2[i].setLayoutY(240);
                btn1[i].setLayoutX(25 + i * 170);
                btn1[i].setLayoutY(240);
            }
            else{

                btn2[i].setLayoutX(95 + (i - 4) * 170);
                btn2[i].setLayoutY(510);
                btn1[i].setLayoutX(25 + (i - 4) * 170);
                btn1[i].setLayoutY(510);
            }
        }
        for(int i = 0; i < 7; i++) {

            int j = i + 1;
            btn1[i].setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    newWindow(j);
                }
            });
        }

        for(int i = 0; i < 7; i++) {

            int j = i + 1;
            btn2[i].setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    try {
                        WinRed(j, stage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        group = paintDays(group);

        for(int i = 0; i < 7; i++) {

            group.getChildren().add(btn1[i]);
            group.getChildren().add(btn2[i]);
        }
        Scene scene = new Scene(group);

        scene.setFill(Color.INDIGO);
        stage.setScene(scene);
        stage.setTitle("Day's affairs");
        stage.setWidth(715);
        stage.setHeight(600);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {

        WinFirst(stage);
    }

}