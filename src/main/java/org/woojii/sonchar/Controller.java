package org.woojii.sonchar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Controller {
    Text_M TM = new Text_M();

    public TextField TF_1 = new TextField();
    public TextField TF_2 = new TextField();
    public TextArea TA = new TextArea();
    public ComboBox<String> world = new ComboBox<>();
    public ComboBox<String> warn = new ComboBox<>();
    public ComboBox<String> warn1 = new ComboBox<>();
    public Button save_button;
    public Button patrol_start_bt;
    public Button patrol_stop_bt;
    public Label patrol_St;
    public Label patrol_sp;
    public Label worldview;
    public Button Load;
    String[] worldlist = {"없음","스폰","맑은마을","푸른마을","고운마을","밝은마을","힘찬마을","별빛마을","맑은자원","푸른자원","고운자원"};
    String[] warnlist = {"없음","경고 1회","경고 2회","경고 3회","경고 4회","경고 5회","경고 6회","경고 7회","경고 8회","영구밴"};
    String[] warn1list = {"없음","잠금해제","신고","부계정","추천"};
    ObservableList<String> OL = FXCollections.observableList(List.of(worldlist));
    ObservableList<String> OL_warn = FXCollections.observableList(List.of(warnlist));
    ObservableList<String> OL_warn1 = FXCollections.observableList(List.of(warn1list));
    String Atext_save = "";
    String Stext_save = "";

    public Controller() throws IOException {
    }

    public void ST_(ActionEvent event) {
    }

    public void Save(ActionEvent event) {
        String a0= (String)world.getValue(), a1=TF_1.getText(),a2=TF_2.getText(),a3= (String) warn.getValue(),a4=(String)warn1.getValue(),a_="";
        if(a0==null||a0.equals("없음")){
            a0="";
        }else a0 = "("+a0+") ";
        if(a3==null||a3.equals("없음")) {
            a3 = "";
        }else a3 = "- "+a3;
        if(a4==null||a4.equals("없음")){
            a4="";
        }else a4+=" ("+a4+" - 0000)";
        a_=a0+a1+" "+a2+" "+a3+" "+a4+"\n";

        String tmp=TA.getText();
        TA.setText(tmp+a_);
        Atext_save=TA.getText();
    }

    public void DBM_ST(ActionEvent event) {
    }

    public void Check_V(ActionEvent event) {
    }

    public void patrol_start(ActionEvent event) {
        LocalTime LT = LocalTime.now();
        DateTimeFormatter LTF = DateTimeFormatter.ofPattern("HH:mm");
        String TT=LT.format(LTF);
        patrol_St.setText(TT);
        patrol_start_bt.setDisable(true);
        patrol_stop_bt.setDisable(false);
    }

    public void patrol_stop(ActionEvent event) throws IOException {
        LocalTime LT = LocalTime.now();
        DateTimeFormatter LTF = DateTimeFormatter.ofPattern("HH:mm");
        String TT=LT.format(LTF);
        patrol_sp.setText(TT);
        patrol_start_bt.setDisable(false);
        Stext_save=patrol_St.getText()+" ~ "+patrol_sp.getText()+" 순찰 ("+worldview.getText()+")"+"\n특이사항:\n";
        TA.setText(Stext_save+Atext_save);
        TM.Text_W(Stext_save+Atext_save);
        patrol_stop_bt.setDisable(true);
    }

    public void DBLoad(ActionEvent event) {
        world.setDisable(false);
        warn.setDisable(false);
        warn1.setDisable(false);
        patrol_start_bt.setDisable(false);
        TF_1.setDisable(false);
        TF_2.setDisable(false);
        save_button.setDisable(false);
        TA.setDisable(false);
        world.setItems(OL);
        warn.setItems(OL_warn);
        warn1.setItems(OL_warn1);
        Load.setDisable(true);
    }
}
