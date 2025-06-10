

public class Function_Edit {
    GUI gui;

    public Function_Edit(GUI gui){
        this.gui=gui;
    }

    public void undoFunction(){
        gui.um.undo();
    }

    public void redoFunction(){
        gui.um.redo();
    }
}
