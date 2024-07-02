/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author User
 */
public class AdminLogin {
    private Map<String, String> adminCredentials;
    private final String ADMIN_FILE_NAME = "admin_credentials.xml";

    public AdminLogin() {
        adminCredentials = loadAdminCredentials();
    }

    public String authenticate(String username, String password) {
        String storedPassword = adminCredentials.get(username);
        if (storedPassword == null) {
            return "Error: Admin not registered.";
        }
        if (!storedPassword.equals(password)) {
            return "Error: Incorrect password.";
        }
        return "Admin login successful.";
    }

    public String register(String username, String password) {
        if (adminCredentials.containsKey(username)) {
            return "Error: Admin already registered.";
        }
        adminCredentials.put(username, password);
        saveAdminCredentials();
        return "New admin registration successful.";
    }

    private Map<String, String> loadAdminCredentials() {
        Map<String, String> credentials = new HashMap<>();
        File file = new File(ADMIN_FILE_NAME);
        if (!file.exists()) {
            return credentials;
        }
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("admin");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element node = (Element) nodeList.item(temp);
                String username = node.getAttribute("username");
                String password = node.getElementsByTagName("password").item(0).getTextContent();
                credentials.put(username, password);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }

    private void saveAdminCredentials() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("admin_credentials");
            doc.appendChild(rootElement);
            for (Map.Entry<String, String> entry : adminCredentials.entrySet()) {
                Element userElement = doc.createElement("admin");
                userElement.setAttribute("username", entry.getKey());
                Element passwordElement = doc.createElement("password");
                passwordElement.appendChild(doc.createTextNode(entry.getValue()));
                userElement.appendChild(passwordElement);
                rootElement.appendChild(userElement);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(ADMIN_FILE_NAME));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        AdminLogin adminLogin = new AdminLogin();
        
        // Registro de administradores
        //String result1 = adminLogin.register("Gabriel", "Gabo08");
        //System.out.println(result1);
        
        //String result2 = adminLogin.register("Sharon", "123");
        //System.out.println(result2);
        
        //String result3 = adminLogin.register("Marvin", "12345");
        //System.out.println(result3);
        
        //String result4 = adminLogin.register("Adrian", "536i19");
        //System.out.println(result4);
        
        // Intento de registro de un administrador ya registrado
        //String result5 = adminLogin.register("Gabriel", "Gabo08");
        //System.out.println(result5);
        
        // Prueba de inicio de sesión de los administradores
      //  String authResult1 = adminLogin.authenticate("Gabriel", "Gabo08");
        //System.out.println(authResult1);
        
       // String authResult2 = adminLogin.authenticate("Sharon", "123");
        //System.out.println(authResult2);
        
      //  String authResult3 = adminLogin.authenticate("Marvin", "12345");
        //System.out.println(authResult3);
        
        //String authResult4 = adminLogin.authenticate("Adrian", "536i19");
       // System.out.println(authResult4);
        
        // Intento de inicio de sesión con credenciales incorrectas
        String authResult5 = adminLogin.authenticate("Gabriel", "iuytrcfgvb");
        System.out.println(authResult5);
        
        String authResult6 = adminLogin.authenticate("kjnbhgfvcdxfg", "password");
        System.out.println(authResult6);
    }
}