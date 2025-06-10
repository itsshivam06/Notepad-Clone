import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame jf;

    //text area
    JTextArea jta;
    JScrollPane jsp;
    boolean wordwrapON=false;

    //top menu
    JMenuBar jmb;
    JMenu file,edit,format,color,view;

    //file menu
    JMenuItem New,open,save,save_As,exit;

    //Edit Menu
    JMenuItem undo,redo;

    // Format Menu
    JMenuItem iwrap,arial,caliber,sans,bold,ten,tlv,ftn,sxtn,etn,tty;;
    JMenu font,fontSize;

    // Color Menu
    JMenu foreground,background;
    JMenuItem red,green,cyan,yellow,gray,white,black,red1,green1,cyan1,yellow1,gray1,black1;

    Function_File functionFile=new Function_File(this);
    Function_Edit functionEdit=new Function_Edit(this);
    Format_List formatList=new Format_List(this);
    Shortcut_Kyes keyHandler=new Shortcut_Kyes(this);
    UndoManager um=new UndoManager();



    public static void main(String[] args) {
        new GUI();
    }

    GUI(){
         createFrame();
         createTextArea();
         createMenuBar();
         createMenuItem();
         createEditMenu();
         createFormatMenu();
         createColorMenu();
         jf.setVisible(true);
    }

    public void createFrame(){
        jf=new JFrame("Notepad");
        jf.setBounds(300,250,800,700);
        jf.setDefaultCloseOperation(3);
    }

    public void createTextArea(){
        jta=new JTextArea();
        jta.setFont(new Font("Sans-Serif",0,20));

        jta.addKeyListener(keyHandler);

        jta.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });

        jsp=new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //jta.setBounds(10,20,480,600);
        jsp.setBorder(BorderFactory.createEmptyBorder());
        jf.add(jsp);
    }

    public void createMenuBar(){
        jmb=new JMenuBar();
        file=new JMenu("File");
        file.setFont(new Font("",1,25));
        jmb.add(file);
        edit=new JMenu("Edit");
        edit.setFont(new Font("",1,25));
        jmb.add(edit);
        format=new JMenu("Format");
        format.setFont(new Font("",1,25));
        jmb.add(format);
        color=new JMenu("Color");
        color.setFont(new Font("",1,25));
        jmb.add(color);
        view=new JMenu("View");
        view.setFont(new Font("",1,25));
        jmb.add(view);
        jf.setJMenuBar(jmb);
    }

    public void createMenuItem(){
        //File Menu item Creation ............

        New=new JMenuItem("New");
        New.addActionListener(this);//this is for action listener
        New.setActionCommand("New"); //this is for switch statement
        New.setFont(new Font("",5,20));
        file.add(New);

        open=new JMenuItem("Open");
        open.addActionListener(this);
        open.setActionCommand("Open");
        open.setFont(new Font("",5,20));
        file.add(open);

        save=new JMenuItem("Save");
        save.addActionListener(this);
        save.setActionCommand("Save");
        save.setFont(new Font("",5,20));
        file.add(save);

        save_As=new JMenuItem("Save As");
        save_As.addActionListener(this);
        save_As.setActionCommand("Save_As");
        save_As.setFont(new Font("",5,20));
        file.add(save_As);

        exit=new JMenuItem("Exit");
        exit.setActionCommand("Exit");
        exit.addActionListener(this);
        exit.setFont(new Font("",5,20));
        file.add(exit);

    }

    public void createEditMenu(){
        //Edit Menu Item Creation ............
        undo=new JMenuItem("Undo");
        undo.setFont(new Font("",5,20));
        undo.addActionListener(this);
        undo.setActionCommand("undo");
        edit.add(undo);
        redo=new JMenuItem("Redo");
        redo.setFont(new Font("",5,20));
        redo.addActionListener(this);
        redo.setActionCommand("redo");
        edit.add(redo);

    }

    public void createFormatMenu(){
        //Format Menu Creation....
        iwrap =new JMenuItem("Word Wrap:OFF");
        iwrap.addActionListener(this);
        iwrap.setActionCommand("Word Wrap");
        iwrap.setFont(new Font("",5,20));
        format.add(iwrap);
        font =new JMenu("Font");
        font.setFont(new Font("",5,20));
        format.add(font);
        fontSize = new JMenu("Font Size");
        fontSize.setFont(new Font("",5,20));
        format.add(fontSize);

//      Font Menu Item Creation ..!!

        arial=new JMenuItem("Plain");
        arial.addActionListener(this);
        arial.setActionCommand("Arial");
        arial.setFont(new Font("",5,20));
        font.add(arial);

        caliber=new JMenuItem("Bold");
        caliber.addActionListener(this);
        caliber.setActionCommand("Calibri");
        caliber.setFont(new Font("",5,20));
        font.add(caliber);

        sans=new JMenuItem("Italic");
        sans.addActionListener(this);
        sans.setActionCommand("Sans");
        sans.setFont(new Font("",5,20));
        font.add(sans);

        bold=new JMenuItem("Sans-Serif");
        bold.addActionListener(this);
        bold.setActionCommand("Bold");
        bold.setFont(new Font("",5,20));
        font.add(bold);

//      FontSize Menu Item Creation ..!!

        ten=new JMenuItem("25");
        ten.addActionListener(this);
        ten.setActionCommand("size25");
        ten.setFont(new Font("",5,20));
        fontSize.add(ten);

        tlv=new JMenuItem("30");
        tlv.addActionListener(this);
        tlv.setActionCommand("size30");
        tlv.setFont(new Font("",5,20));
        fontSize.add(tlv);

        ftn=new JMenuItem("35");
        ftn.addActionListener(this);
        ftn.setActionCommand("size35");
        ftn.setFont(new Font("",5,20));
        fontSize.add(ftn);

        sxtn=new JMenuItem("40");
        sxtn.addActionListener(this);
        sxtn.setActionCommand("size40");
        sxtn.setFont(new Font("",5,20));
        fontSize.add(sxtn);

        etn=new JMenuItem("45");
        etn.addActionListener(this);
        etn.setActionCommand("size45");
        etn.setFont(new Font("",5,20));
        fontSize.add(etn);

        tty=new JMenuItem("50");
        tty.addActionListener(this);
        tty.setActionCommand("size50");
        tty.setFont(new Font("",5,20));
        fontSize.add(tty);
    }

    public void createColorMenu(){
//     Color Menu Creation ....

        foreground = new JMenu("Foreground Color");
        foreground.setFont(new Font("Arial",0,20));
        color.add(foreground);
        background = new JMenu("Background Color");
        background.setFont(new Font("Arial",0,20));
        color.add(background);

        red=new JMenuItem("Red");
        red.setActionCommand("Red");
        red.addActionListener(this);
        red.setFont(new Font("Arial",0,18));
        foreground.add(red);
        red1=new JMenuItem("Red");
        red1.setActionCommand("Red1");
        red1.addActionListener(this);
        red1.setFont(new Font("Arial",0,18));
        background.add(red1);

        green=new JMenuItem("Green");
        green.setActionCommand("Green");
        green.addActionListener(this);
        green.setFont(new Font("Arial",0,18));
        foreground.add(green);
        green1=new JMenuItem("Green");
        green1.setActionCommand("Green1");
        green1.addActionListener(this);
        green1.setFont(new Font("Arial",0,18));
        background.add(green1);

        black=new JMenuItem("Black");
        black.setActionCommand("Black");
        black.addActionListener(this);
        black.setFont(new Font("Arial",0,18));
        foreground.add(black);

        white=new JMenuItem("White");
        white.setActionCommand("White");
        white.addActionListener(this);
        white.setFont(new Font("Arial",0,18));
        foreground.add(white);
        black1=new JMenuItem("Black");
        black1.setActionCommand("Black1");
        black1.addActionListener(this);
        black1.setFont(new Font("Arial",0,18));
        background.add(black1);

        cyan=new JMenuItem("Cyan");
        cyan.setActionCommand("Cyan");
        cyan.addActionListener(this);
        cyan.setFont(new Font("Arial",0,18));
        foreground.add(cyan);

        yellow=new JMenuItem("Yellow");
        yellow.setActionCommand("Yellow");
        yellow.addActionListener(this);
        yellow.setFont(new Font("Arial",0,18));
        foreground.add(yellow);
        yellow1=new JMenuItem("Yellow");
        yellow1.setActionCommand("Yellow1");
        yellow1.addActionListener(this);
        yellow1.setFont(new Font("Arial",0,18));
        background.add(yellow1);

        gray=new JMenuItem("Gray");
        gray.setActionCommand("Gray");
        gray.addActionListener(this);
        gray.setFont(new Font("Arial",0,18));
        foreground.add(gray);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();
        switch(cmd){
            case "New":
               functionFile.newFile();
               break;

            case "Open":
                functionFile.openFile();
                break;

            case "Save":
                functionFile.saveFile();
                break;

            case "Save_As":
                functionFile.saveFileAs();
                break;

            case "Exit":
                functionFile.exitFile();
                break;

            case "undo":
                functionEdit.undoFunction();
                break;

            case "redo":
                functionEdit.redoFunction();
                break;

            case "Word Wrap":
                formatList.wordWrap();
                break;

            case "Arial":
                formatList.setFontStyle("Arial");
                break;

            case "Calibri":
                formatList.setFontStyle("Calibri");
                break;

            case "Sans":
                formatList.setFontStyle("Sans");
                break;

            case "Bold":
                formatList.setFontStyle("Bold");
                break;

            case "size25":
                formatList.setFontSize("size25");
                break;

            case "size30":
                formatList.setFontSize("size30");
                break;

            case "size35":
                formatList.setFontSize("size35");
                break;

            case "size40":
                formatList.setFontSize("size40");
                break;

            case "size45":
                formatList.setFontSize("size45");
                break;

            case "size50":
                formatList.setFontSize("size50");
                break;

            case "Red":
                formatList.setFontColor("Red");
                break;

            case "Green":
                formatList.setFontColor("Green");
                break;

            case "Yellow":
                formatList.setFontColor("Yellow");
                break;

            case "Gray":
                formatList.setFontColor("Gray");
                break;

            case "White":
                formatList.setFontColor("White");
                break;

            case "Cyan":
                formatList.setFontColor("Cyan");
                break;

            case "Red1":
                formatList.setBGColor("Red1");
                break;

            case "Green1":
                formatList.setBGColor("Green1");
                break;

            case "Yellow1":
                formatList.setBGColor("Yellow1");
                break;

            case "Black1":
                formatList.setBGColor("Black1");
                break;
        }
    }
}





