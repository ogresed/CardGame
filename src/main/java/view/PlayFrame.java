package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayFrame extends MainFrame{


    private JPanel fieldPanel;

    public PlayFrame(){
        super();
        setSize(700, 600);
        setResizable(false);
        //AddPanels();

        ImageComponent component = new ImageComponent();
        add(component);
        setVisible(false);
    }

    public void Play()
    {
        setVisible(true);
    }

    void CreatePanels(int y, int x){
        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(x, y));
    }

    void AddPanels(){
        CreatePanels(10, 10);
        FillField();
        add(fieldPanel);
    }

    void FillField()
    {

    }
}

class ImageComponent extends JComponent
{
    public ImageComponent()
    {
        // Получаем изображения.
        try
        {
            image = ImageIO.read(new File("resources/card_images/6d76bca8aa50fe6b50776d76c5259a22.jpg"));

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g)
    {
        if(image == null) return;
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        // Отображение рисунка в левом верхнем углу.
        g.drawImage(image, 0, 0, null);

        // Многократный вывод изображения в панели.

        for(int i = 0; i * imageWidth <= getWidth(); i++)
            for(int j = 0; j * imageHeight <= getHeight(); j++)
                if(i + j > 0)
                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
    }
    private Image image;
}