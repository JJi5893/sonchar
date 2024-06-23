package org.woojii.sonchar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Text_M {
    File fl = new File("순찰 텍스트.txt");
    FileWriter fw = new FileWriter(fl,true);
    BufferedWriter bf = new BufferedWriter(fw);


    public Text_M() throws IOException {
        if(!fl.exists()){
            fl.createNewFile();
        }
    }
    public void Text_W(String text) throws IOException {
        LocalDateTime LDT = LocalDateTime.now();
        String tt =LDT.format(DateTimeFormatter.ofPattern("yy년M월d일"));
        String mm = "=================="+tt+"==================\n";
        bf.write(mm+text);
        bf.flush();
    }

}
