package view;

import javax.swing.*;
import java.awt.*;

public class ServerGUI extends JFrame
{

    private JPanel serverPanel;
    private JFrame frame;
    private JTextArea textArea;

    public ServerGUI()
    {
        InitalizePanels();
    }

    private void InitalizePanels() {
        createServerFrame();
        createServerPanel();
    }

    private void createServerFrame() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(new Dimension(500,500));

    }

    private void createServerPanel() {
        serverPanel = new JPanel();
        serverPanel.setLayout(new BorderLayout());
        serverPanel.setVisible(true);
        textArea = new JTextArea();
        serverPanel.add(textArea);
        frame.add(serverPanel);
    }

    public void setConnectionText(String connectionText)
    {
        textArea.setText("\n"+connectionText);
    }
}
