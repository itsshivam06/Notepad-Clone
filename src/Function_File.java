import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
    GUI gui;
    String filename;
    String fileaddress;

    Function_File(GUI gui) {
        this.gui = gui;
    }


    public void newFile() {
        gui.jta.setText("");
        gui.jf.setTitle("Untitled");
        filename=null;
        fileaddress=null;
    }


    public void openFile() {
        FileDialog fd = new FileDialog(gui.jf, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() != "NULL") {
            filename = fd.getFile();
            fileaddress = fd.getDirectory();
            gui.jf.setTitle(filename);
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileaddress + filename));
            gui.jta.setText("");
            String line = null;
            while ((line = br.readLine()) != null) {
                gui.jta.append(line + "\n");
            }
            br.close();

        } catch (Exception e) {
            System.out.println("File Not Opened..!");
        }
    }


    public void saveFile() {
        if (filename == null)
            saveFileAs();
        else {
            try {
                FileWriter fw = new FileWriter(fileaddress + filename);
                fw.write(gui.jta.getText());
                gui.jf.setTitle(filename);
                fw.close();
            } catch (Exception e) {
                System.out.println("Something Wrong");
            }
        }
    }

    public void saveFileAs() {
        FileDialog fd = new FileDialog(gui.jf, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            filename = fd.getFile();
            fileaddress = fd.getDirectory();
            gui.jf.setTitle(filename);
        }
        try {
            FileWriter fw = new FileWriter(fileaddress + filename);
            fw.write(gui.jta.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println("Something went Wrong..!!");
        }
    }

    public void exitFile(){
        System.exit(0);
    }

}