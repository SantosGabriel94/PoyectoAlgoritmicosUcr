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
        VisitRecord record = new VisitRecord(channelNumber);
        tree.insertar(record);
    }

    public void showHistory() {
        System.out.println("Channel History:");
        System.out.println(tree.toString());
    }

    public static class VisitRecord implements Comparable<VisitRecord> {

        private int channelNumber;

        public VisitRecord(int channelNumber) {
            this.channelNumber = channelNumber;
        }

        @Override
        public int compareTo(VisitRecord other) {
            return Integer.compare(this.channelNumber, other.channelNumber);
        }

        @Override
        public String toString() {
            return "Channel " + channelNumber;
        }
    }

}
