/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginwithsession;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mitanew.Home;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author ASUS
 */
public class checkSession {
     public static void main(String[] args) throws UnsupportedLookAndFeelException, SAXException {
        File data = new File(System.getProperty("user.dir") + "/session.xml");
        if (data.exists()) {
            
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = (Document) dBuilder.parse(data);
                String id = doc.getElementsByTagName("id_pegawai").item(0).getTextContent();
                String username = doc.getElementsByTagName("uname").item(0).getTextContent();
                String password = doc.getElementsByTagName("pass").item(0).getTextContent();
               
                
                koneksi.koneksi.set_id_pegawai(id);
                koneksi.koneksi.set_username(username);
                koneksi.koneksi.set_password(password);
                
                
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("GTK+".equals(info.getName())) {
                        try {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(checkSession.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                Home hF = new Home();
                hF.setVisible(true);
            } catch (IOException | ParserConfigurationException | SAXException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }else {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(checkSession.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            Home lF = new Home();
            lF.setVisible(true);
        }                      
    }
}
