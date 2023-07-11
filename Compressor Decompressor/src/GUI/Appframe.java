package GUI;

import CompDecomp.Compressor;
import CompDecomp.Decompressor;

import javax.swing.*;
import javax.tools.Tool;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Appframe extends JFrame implements ActionListener {
    JButton compressbutton;
    JButton decompressbutton;

    Dimension size;
    Appframe(){
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressbutton = new JButton("Select File to compress");
        compressbutton.setBounds(450,300,200,50);
        compressbutton.addActionListener(this);
        decompressbutton = new JButton("Select File to decompress");
        decompressbutton.setBounds(750,300,200,50);
        decompressbutton.addActionListener(this);
        this.add(compressbutton);
        this.add(decompressbutton);
        size = new Dimension(Toolkit. getDefaultToolkit(). getScreenSize());
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);

    }
    @Override
    public void paint(Graphics g){
        Toolkit t = Toolkit.getDefaultToolkit();
        Image ii = t.getImage("C:\\Users\\master-55\\Desktop\\Compressor - Decompressor\\Compressor Decompressor\\src\\Image\\picture.jpg");
        g.drawImage(ii,0,0,this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressbutton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        if(e.getSource() == decompressbutton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
