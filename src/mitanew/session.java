/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mitanew;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 *
 * @author ASUS
 */
public class session {
  
      private static String id_pegawai;
      private static String username;
      private static String password;
        
   
    public static String get_id_pegawai(){
        return id_pegawai;
    }
    public static void set_id_pegawai(String id_pegawai){
        session.id_pegawai = id_pegawai;
    }
      
   
    public static String get_username(){
        return username;
    }
    public static void set_username(String username){
        session.username = username;
    }
    
     public static String get_password(){
        return password;
    }
    public static void set_password(String password){
        session.password = password;
    }
    
    public static void createXML(String id,String uname,String pass,String lvl){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();


            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("session");
            doc.appendChild(rootElement);
            
            
            Element id_login = doc.createElement("id_pegawai");
            rootElement.appendChild(id_login);
            id_login.setTextContent(id);
            Element username = doc.createElement("username");
            rootElement.appendChild(username);
            username.setTextContent(uname);
            Element password = doc.createElement("password");
            rootElement.appendChild(password);
            password.setTextContent(pass);

            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + "/session.xml"));
            transformer.transform(source, result);

   } catch (ParserConfigurationException | TransformerException e) {
  System.out.println(e);
   }
    }
}
