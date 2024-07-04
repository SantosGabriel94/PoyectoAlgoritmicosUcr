package Logic.BST;

import java.time.LocalTime;

/**
 *
 * @author Marvin
 */
public class ViewingHistory {

    private ArbolBinarioBusqueda tree;

    public ViewingHistory() {
        this.tree = new ArbolBinarioBusqueda();
    }

    public void recordVisit(int channelNumber) {
        ArbolBinarioBusqueda.VisitRecord record = new ArbolBinarioBusqueda.VisitRecord(channelNumber);
        tree.insertar(record);
    }

    public void showHistory() {
        System.out.println("Channel History:");
        System.out.println(tree.toString());
    }

}
