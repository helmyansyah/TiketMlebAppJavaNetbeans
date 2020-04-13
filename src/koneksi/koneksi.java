package koneksi;
import java.io.File;
import java.sql.*;
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


public class koneksi {
    
      private static String id_pegawai;
      private static String username;
      private static String password;
     
      
    public static String get_id_pegawai(){
        return id_pegawai;
    }
    public static void set_id_pegawai(String id_pegawai){
        koneksi.id_pegawai = id_pegawai;
    }
      
   
    public static String get_username(){
        return username;
    }
    public static void set_username(String username){
        koneksi.username = username;
    }
    
     public static String get_password(){
        return password;
    }
    public static void set_password(String password){
        koneksi.password = password;
    }

      
   public static Connection koneksi(){
        String driver   = "com.mysql.jdbc.Driver";
        String host     = "jdbc:mysql://localhost/mlebnew";
        String user     = "root";
        String pass     = "";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(host, user, pass);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    
    public static void createXML(String id,String uname,String pass,String lvl){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();


            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("session");
            doc.appendChild(rootElement);
            
            
            Element id_pegawai = doc.createElement("id_pegawai");
            rootElement.appendChild(id_pegawai);
            id_pegawai.setTextContent(id);
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
