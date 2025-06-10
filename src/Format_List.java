import java.awt.*;

public class Format_List {
    GUI gui;

    public Format_List(GUI gui){
        this.gui=gui;
    }

    public void wordWrap(){
        if(gui.wordwrapON==false){
            gui.wordwrapON=true;
            gui.jta.setLineWrap(true);
            gui.jta.setWrapStyleWord(true);
            gui.iwrap.setText("Word Wrap:ON");
        }
//        if (gui.wordwrapON==true)
        else  {
            gui.wordwrapON=false;
            gui.jta.setLineWrap(false);
            gui.jta.setWrapStyleWord(false);
            gui.iwrap.setText("Word Wrap:OFF");
        }
    }

    public void setFontStyle(String s){
        switch (s){
            case "Arial":
                gui.jta.setFont(new Font("Arial",Font.PLAIN,25));
                break;
            case "Calibri":
                gui.jta.setFont(new Font("Arial",1,25));
                break;
            case "Sans":
                gui.jta.setFont(new Font(Font.SERIF,Font.ITALIC,25));
                break;
            case "Bold":
                gui.jta.setFont(new Font("Sans-Serif",Font.HANGING_BASELINE,25));
                break;
        }
    }

    public void setFontSize(String s){
        switch (s){
            case "size25":
                gui.jta.setFont(new Font("Arial",0,25));
                break;
            case "size30":
                gui.jta.setFont(new Font("Arial",0,30));
                break;
            case "size35":
                gui.jta.setFont(new Font("Arial",0,35));
                break;
            case "size40":
                gui.jta.setFont(new Font("Arial",0,40));
                break;
            case "size45":
                gui.jta.setFont(new Font("Arial",0,45));
                break;
            case "size50":
                gui.jta.setFont(new Font("Arial",0,50));
                break;
        }
    }

    public void setFontColor(String col){
        switch (col){
            case "Red":
                gui.jta.setForeground(Color.red);
                break;
            case "Green":
                gui.jta.setForeground(Color.GREEN);
                break;
            case "Cyan":
                gui.jta.setForeground(Color.CYAN);
                break;
            case "Yellow":
                gui.jta.setForeground(Color.YELLOW);
                break;
            case "Gray":
                gui.jta.setForeground(Color.GRAY);
                break;
            case "White":
                gui.jta.setForeground(Color.WHITE);
                break;
            case "Black":
                gui.jta.setForeground(Color.black);
                break;
        }
    }

    public void setBGColor(String col){
        switch (col){
            case "Red1":
                gui.jta.setBackground(Color.RED);
                break;
            case "Green1":
                gui.jta.setBackground(Color.GREEN);
                break;
            case "Yellow1":
                gui.jta.setBackground(Color.YELLOW);
                break;
            case "Cyan":
                gui.jta.setBackground(new Color(241, 186, 130));
                break;
            case "Black1":
                gui.jta.setBackground(Color.BLACK);
                break;
        }
    }

}
