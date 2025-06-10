import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Shortcut_Kyes implements KeyListener {
    GUI gui;

    public Shortcut_Kyes(GUI gui){
        this.gui=gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.functionFile.saveFile();
        }
        if(e.isShiftDown() &&  e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){
            gui.functionFile.saveFileAs();
        }
        if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F){
            gui.file.doClick();
        }
        if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_E){
            gui.edit.doClick();
        }
        if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_C){
            gui.color.doClick();
        }
        if(e.isShiftDown() && e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F){
            gui.format.doClick();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
