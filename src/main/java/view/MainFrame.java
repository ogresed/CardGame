package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private static final long serialVersionUID = 1L;

    public MainFrame(){

        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception ignored) {
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JToolBar toolBar = new JToolBar("Main toolbar");
        toolBar.setRollover(true);

        add(toolBar, BorderLayout.PAGE_START);
    }



   /* public File getSaveFileName(String extension, String description)
    {
        return FileUtils.getSaveFileName(this, extension, description);
    }

    public File getOpenFileName(String extension, String description)
    {
        return FileUtils.getOpenFileName(this, extension, description);
    }*/



}
