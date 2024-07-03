/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;
import Logic.graphUser.GraphUser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.NodeList;


/**
 *
 * @author User
 */
public class Login {

    private Map<String, String> credentials;
    private final String FILE_NAME = "credentials.xml";
    private List<User> users; // Lista de usuarios
    private GraphUser graphUser;

    public Login() {
        credentials = loadCredentials();
        users = new ArrayList<>();
        graphUser = new GraphUser(5000); // 5 debido a que solo se permiten 5 perfiles
        loadUsers(); // Cargar usuarios desde el archivo XML
    }

    public boolean authenticate(String username, String password) {
        String storedPassword = credentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public boolean register(String username, String password, int age) {
        if (credentials.containsKey(username)) {
            return false; // Usuario ya registrado
        }
        credentials.put(username, password);
        saveCredentials();

        User newUser = new User(username, password, age);
        newUser.agregarPerfil(username, age); // Crear perfil por defecto

        users.add(newUser);
        saveUsers();
        return true; // Registro exitoso
    }

    private Map<String, String> loadCredentials() {
        Map<String, String> credentials = new HashMap<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return credentials;
        }
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("user");
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

    private void saveCredentials() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("credentials");
            doc.appendChild(rootElement);
            for (Map.Entry<String, String> entry : credentials.entrySet()) {
                Element userElement = doc.createElement("user");
                userElement.setAttribute("username", entry.getKey());
                Element passwordElement = doc.createElement("password");
                passwordElement.appendChild(doc.createTextNode(entry.getValue()));
                userElement.appendChild(passwordElement);
                rootElement.appendChild(userElement);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FILE_NAME));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private void loadUsers() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("user");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element node = (Element) nodeList.item(temp);
                String username = node.getAttribute("username");
                String password = node.getElementsByTagName("password").item(0).getTextContent();
                String ageStr = node.getAttribute("age");
                int age = ageStr.isEmpty() ? 0 : Integer.parseInt(ageStr);
                User user = new User(username, password, age);

                user.getProfiles().clear(); // Limpiar la lista de perfiles antes de cargar nuevos
                NodeList profileList = node.getElementsByTagName("profile");
                for (int i = 0; i < profileList.getLength(); i++) {
                    Element profileElement = (Element) profileList.item(i);
                    String profileName = profileElement.getAttribute("name");
                    int profileAge = Integer.parseInt(profileElement.getAttribute("age"));
                    user.agregarPerfil(profileName, profileAge);
                    graphUser.addVertex(new Profile(profileName, profileAge)); // Agregar perfil al grafo
                }

                users.add(user);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void saveUsers() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("users");
            doc.appendChild(rootElement);

            for (User user : users) {
                Element userElement = doc.createElement("user");
                userElement.setAttribute("username", user.getUsername());
                userElement.setAttribute("age", String.valueOf(user.getEdad()));

                Element passwordElement = doc.createElement("password");
                passwordElement.appendChild(doc.createTextNode(user.getPassword()));
                userElement.appendChild(passwordElement);

                // Guardar perfiles del usuario
                Element profilesElement = doc.createElement("profiles");
                userElement.appendChild(profilesElement);

                for (Profile profile : user.getProfiles()) {
                    Element profileElement = doc.createElement("profile");
                    profileElement.setAttribute("name", profile.getNameProfile());
                    profileElement.setAttribute("age", String.valueOf(profile.getAge()));
                    profilesElement.appendChild(profileElement);
                }

                rootElement.appendChild(userElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FILE_NAME));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // Usuario no encontrado
    }

    public GraphUser getGraphUser() {
        return graphUser;
    }
}