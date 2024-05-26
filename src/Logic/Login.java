
package Logic;
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
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author User
 */
public class Login {
   private Map<String, String> credentials;
    private final String FILE_NAME = "credentials.xml";

    public Login() {
        credentials = loadCredentials();
    }

    public boolean authenticate(String username, String password) {
        String storedPassword = credentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public boolean register(String username, String password) {
        if (credentials.containsKey(username)) {
            return false; // Usuario ya registrado
        }
        credentials.put(username, password);
        saveCredentials();
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
}
