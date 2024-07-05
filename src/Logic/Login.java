/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic;
//import Logic.graphUser.GraphUser;

import graphUser.GraphUser;
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
 * @author Algoritmicos
 */
public class Login {

    private Map<String, String> credentials;
    private final String FILE_NAME = "credentials.xml";
    private List<User> users; // Lista de usuarios
    private GraphUser graphUser;

    public Login() {
        credentials = loadCredentials();
        users = new ArrayList<>();
        graphUser = new GraphUser(5000); // 5 because only 5 profiles are allowed
        loadUsers(); // Load users from XML file
    }

    public boolean authenticate(String username, String password) {
        String storedPassword = credentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public boolean register(String username, String password, int age) {
        if (credentials.containsKey(username)) {
            return false; // Already registered user
        }
        credentials.put(username, password);
        saveCredentials();

        User newUser = new User(username, password, age);
        newUser.agregarPerfil(username, age); // Create default profile

        users.add(newUser);
        saveUsers();
        return true; // Successful registration
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

                user.getProfiles().clear(); // Clear the list of profiles before uploading new ones
                NodeList profileList = node.getElementsByTagName("profile");
                for (int i = 0; i < profileList.getLength(); i++) {
                    Element profileElement = (Element) profileList.item(i);
                    String profileName = profileElement.getAttribute("name");
                    int profileAge = Integer.parseInt(profileElement.getAttribute("age"));
                    user.agregarPerfil(profileName, profileAge);
                    graphUser.addVertex(new Profile(profileName, profileAge)); // Add profile to network
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
                userElement.setAttribute("age", String.valueOf(user.getAge()));

                Element passwordElement = doc.createElement("password");
                passwordElement.appendChild(doc.createTextNode(user.getPassword()));
                userElement.appendChild(passwordElement);

                // Save user profiles
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
        return null; // User not found
    }

    public GraphUser getGraphUser() {
        return graphUser;
    }
    
    public GraphUser getUserProfiles(String username) {
    GraphUser userProfilesGraph = new GraphUser(5000); 
    File file = new File(FILE_NAME);
    if (!file.exists()) {
        return userProfilesGraph; 
    }
    try {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList userList = doc.getElementsByTagName("user");

        for (int i = 0; i < userList.getLength(); i++) {
            Element userElement = (Element) userList.item(i);
            String xmlUsername = userElement.getAttribute("username");

            if (xmlUsername.equals(username)) {
                NodeList profileList = userElement.getElementsByTagName("profile");
                for (int j = 0; j < profileList.getLength(); j++) {
                    Element profileElement = (Element) profileList.item(j);
                    String profileName = profileElement.getAttribute("name");
                    int profileAge = Integer.parseInt(profileElement.getAttribute("age"));
                    Profile profile = new Profile(profileName, profileAge);
                    userProfilesGraph.addVertex(profile); 
                }
                break; 
            }
        }
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
    return userProfilesGraph; 
}


    
    public static void main(String[] args) {
        Login login = new Login();

        // Nombre de usuario a buscar
        String usernameToSearch = "Adrian";

        // Obtener el grafo de perfiles del usuario
        GraphUser userProfilesGraph = login.getUserProfiles(usernameToSearch);

        // Imprimir los perfiles del usuario
        System.out.println("Perfiles del usuario " + usernameToSearch);
        System.out.println(userProfilesGraph);
    }
    
}
