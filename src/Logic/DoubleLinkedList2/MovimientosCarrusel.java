package Logic.DoubleLinkedList2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MovimientosCarrusel {
    private List<String> imagenes;
    private int currentImageIndex;

    public MovimientosCarrusel() {
        this.imagenes = new ArrayList<>();
        this.currentImageIndex = 0;
    }

    public void cargarImagenesDesdeRecursos(String[] carpetas) {
        imagenes.clear();
        for (String carpeta : carpetas) {
            List<String> nombresDeImagenes = obtenerNombresDeImagenes(carpeta);
            imagenes.addAll(nombresDeImagenes);
        }
    }

    private List<String> obtenerNombresDeImagenes(String paquete) {
        List<String> nombresDeImagenes = new ArrayList<>();
        try {
            Enumeration<URL> recursos = getClass().getClassLoader().getResources(paquete);
            while (recursos.hasMoreElements()) {
                URL recurso = recursos.nextElement();
                String path = recurso.getPath();
                File directorio = new File(path);
                if (directorio.isDirectory()) {
                    File[] archivos = directorio.listFiles((dir, name) -> 
                        name.toLowerCase().endsWith(".jpg") ||
                        name.toLowerCase().endsWith(".png") ||
                        name.toLowerCase().endsWith(".jpeg")
                    );
                    if (archivos != null) {
                        for (File archivo : archivos) {
                            nombresDeImagenes.add(paquete + "/" + archivo.getName());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nombresDeImagenes;
    }

    public String next() {
        if (imagenes.isEmpty()) {
            return null;
        }
        currentImageIndex = (currentImageIndex + 1) % imagenes.size();
        return imagenes.get(currentImageIndex);
    }

    public String prev() {
        if (imagenes.isEmpty()) {
            return null;
        }
        currentImageIndex = (currentImageIndex - 1 + imagenes.size()) % imagenes.size();
        return imagenes.get(currentImageIndex);
    }

    public int size() {
        return imagenes.size();
    }

    public String get(int index) {
        if (index < 0 || index >= imagenes.size()) {
            return null;
        }
        return imagenes.get(index);
    }

    public int getCurrentIndex() {
        return currentImageIndex;
    }
}


