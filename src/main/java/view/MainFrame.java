package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;

public class MainFrame extends JFrame{

    private static final long serialVersionUID = 1L;
    private JMenuBar menuBar;
    private JToolBar toolBar;

   public MainFrame(){

        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception ignored) {
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        toolBar = new JToolBar("Main toolbar");
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
