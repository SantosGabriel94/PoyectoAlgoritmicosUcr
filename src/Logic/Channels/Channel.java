package Logic.Channels;

import TDA.DoubleLinkedList.DoubleLinkedList;
import TDA.DynamicStack.DynamicStack;
import TDA.Graphs.GraphListAdjacency;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Channel {

    private DoubleLinkedList channelList;
    private GraphListAdjacency channelGraph;

    private DynamicStack channel1;
    private DynamicStack channel2;
    private DynamicStack channel3;
    private DynamicStack channel4;
    private DynamicStack channel5;
    private DynamicStack channel6;

    public Channel() {
        this.channelList = new DoubleLinkedList();
        this.channelGraph = new GraphListAdjacency(6);
        this.channel1 = new DynamicStack();
        this.channel2 = new DynamicStack();
        this.channel3 = new DynamicStack();
        this.channel4 = new DynamicStack();
        this.channel5 = new DynamicStack();
        this.channel6 = new DynamicStack();

        channelList.insert(channel1);
        channelList.insert(channel2);
        channelList.insert(channel3);
        channelList.insert(channel4);
        channelList.insert(channel5);
        channelList.insert(channel6);

        channelGraph.addVertex(channel1);
        channelGraph.addVertex(channel2);
        channelGraph.addVertex(channel3);
        channelGraph.addVertex(channel4);
        channelGraph.addVertex(channel5);
        channelGraph.addVertex(channel6);

        linkChannels();

    }

    public DoubleLinkedList getChannelList() {
        return channelList;
    }

    public void setChannelList(DoubleLinkedList channelList) {
        this.channelList = channelList;
    }

    public DynamicStack getChannel1() {
        return channel1;
    }

    public void setChannel1(DynamicStack channel1) {
        this.channel1 = channel1;
    }

    public DynamicStack getChannel2() {
        return channel2;
    }

    public void setChannel2(DynamicStack channel2) {
        this.channel2 = channel2;
    }

    public DynamicStack getChannel3() {
        return channel3;
    }

    public void setChannel3(DynamicStack channel3) {
        this.channel3 = channel3;
    }

    public DynamicStack getChannel4() {
        return channel4;
    }

    public void setChannel4(DynamicStack channel4) {
        this.channel4 = channel4;
    }

    public DynamicStack getChannel5() {
        return channel5;
    }

    public void setChannel5(DynamicStack channel5) {
        this.channel5 = channel5;
    }

    public DynamicStack getChannel6() {
        return channel6;
    }

    public void setChannel6(DynamicStack channel6) {
        this.channel6 = channel6;
    }

    public void insertProgram(int channelNumber, String title, int hour, int minute) {

        if (!(hour < 0 || hour > 23 || minute < 0 || minute > 59)) {

            LocalTime schedule = LocalTime.of(hour, minute);
            Program prg = new Program(title, schedule);
            DynamicStack aux = new DynamicStack();

            switch (channelNumber) {
                case 1:

                    if (channel1.isEmpty()) {
                        channel1.push(prg);
                    } else {
                        Program p;
                        do {
                            p = (Program) channel1.top();
                            if (schedule.isAfter(p.getSchedule())) {
                                aux.push(channel1.pop());
                            } else {
                                break;
                            }
                        } while (!channel1.isEmpty());

                        channel1.push(prg);
                        while (!aux.isEmpty()) {
                            channel1.push(aux.pop());
                        }
                    }
                    break;

                case 2:

                    if (channel2.isEmpty()) {
                        channel2.push(prg);
                    } else {
                        Program p;
                        do {
                            p = (Program) channel2.top();
                            if (schedule.isAfter(p.getSchedule())) {
                                aux.push(channel2.pop());
                            } else {
                                break;
                            }
                        } while (!channel2.isEmpty());

                        channel2.push(prg);
                        while (!aux.isEmpty()) {
                            channel2.push(aux.pop());
                        }
                    }
                    break;

                case 3:

                    if (channel3.isEmpty()) {
                        channel3.push(prg);
                    } else {
                        Program p;
                        do {
                            p = (Program) channel3.top();
                            if (schedule.isAfter(p.getSchedule())) {
                                aux.push(channel3.pop());
                            } else {
                                break;
                            }
                        } while (!channel3.isEmpty());

                        channel3.push(prg);
                        while (!aux.isEmpty()) {
                            channel3.push(aux.pop());
                        }
                    }
                    break;

                case 4:

                    if (channel4.isEmpty()) {
                        channel4.push(prg);
                    } else {
                        Program p;
                        do {
                            p = (Program) channel4.top();
                            if (schedule.isAfter(p.getSchedule())) {
                                aux.push(channel4.pop());
                            } else {
                                break;
                            }
                        } while (!channel4.isEmpty());

                        channel4.push(prg);
                        while (!aux.isEmpty()) {
                            channel4.push(aux.pop());
                        }
                    }
                    break;

                case 5:

                    if (channel5.isEmpty()) {
                        channel5.push(prg);
                    } else {
                        Program p;
                        do {
                            p = (Program) channel5.top();
                            if (schedule.isAfter(p.getSchedule())) {
                                aux.push(channel5.pop());
                            } else {
                                break;
                            }
                        } while (!channel5.isEmpty());

                        channel5.push(prg);
                        while (!aux.isEmpty()) {
                            channel5.push(aux.pop());
                        }
                    }
                    break;

                case 6:

                    if (channel6.isEmpty()) {
                        channel6.push(prg);
                    } else {
                        Program p;
                        do {
                            p = (Program) channel6.top();
                            if (schedule.isAfter(p.getSchedule())) {
                                aux.push(channel6.pop());
                            } else {
                                break;
                            }
                        } while (!channel6.isEmpty());

                        channel6.push(prg);
                        while (!aux.isEmpty()) {
                            channel6.push(aux.pop());
                        }
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Channel " + channelNumber + " does not exit");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error when entering schedule data");
        }
    }

    public void editProgram(int channelNumber, String title, String newTitle, int hour, int minute) {

        if (!(hour < 0 || hour > 23 || minute < 0 || minute > 59)) {

            LocalTime newSchedule = LocalTime.of(hour, minute);
            DynamicStack aux = new DynamicStack();
            DynamicStack aux1 = new DynamicStack();
            Program p;

            switch (channelNumber) {
                case 1:
                    if (channel1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "This channel is empty");
                    }
                    while (!channel1.isEmpty()) {
                        p = (Program) channel1.top();
                        if (p.getTitle().equalsIgnoreCase(title)) {
                            p.setSchedule(newSchedule);
                            p.setTitle(newTitle);
                            aux1.push(channel1.pop());
                        } else {
                            aux.push(channel1.pop());
                        }
                    }

                    while (!aux.isEmpty()) {
                        channel1.push(aux.pop());
                    }
                    insertProgram(1, newTitle, hour, minute);
                    break;
                case 2:
                    if (channel2.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "This channel is empty");
                    }
                    while (!channel2.isEmpty()) {
                        p = (Program) channel2.top();
                        if (p.getTitle().equalsIgnoreCase(title)) {
                            p.setSchedule(newSchedule);
                            p.setTitle(newTitle);
                            aux1.push(channel2.pop());
                        } else {
                            aux.push(channel2.pop());
                        }
                    }

                    while (!aux.isEmpty()) {
                        channel2.push(aux.pop());
                    }
                    insertProgram(2, newTitle, hour, minute);
                    break;
                case 3:
                    if (channel3.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "This channel is empty");
                    }
                    while (!channel3.isEmpty()) {
                        p = (Program) channel3.top();
                        if (p.getTitle().equalsIgnoreCase(title)) {
                            p.setSchedule(newSchedule);
                            p.setTitle(newTitle);
                            aux1.push(channel3.pop());
                        } else {
                            aux.push(channel3.pop());
                        }
                    }

                    while (!aux.isEmpty()) {
                        channel3.push(aux.pop());
                    }
                    insertProgram(3, newTitle, hour, minute);
                    break;
                case 4:
                    if (channel4.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "This channel is empty");
                    }
                    while (!channel4.isEmpty()) {
                        p = (Program) channel4.top();
                        if (p.getTitle().equalsIgnoreCase(title)) {
                            p.setSchedule(newSchedule);
                            p.setTitle(newTitle);
                            aux1.push(channel4.pop());
                        } else {
                            aux.push(channel4.pop());
                        }
                    }

                    while (!aux.isEmpty()) {
                        channel4.push(aux.pop());
                    }
                    insertProgram(4, newTitle, hour, minute);
                    break;
                case 5:
                    if (channel5.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "This channel is empty");
                    }
                    while (!channel5.isEmpty()) {
                        p = (Program) channel5.top();
                        if (p.getTitle().equalsIgnoreCase(title)) {
                            p.setSchedule(newSchedule);
                            p.setTitle(newTitle);
                            aux1.push(channel5.pop());
                        } else {
                            aux.push(channel5.pop());
                        }
                    }

                    while (!aux.isEmpty()) {
                        channel5.push(aux.pop());
                    }
                    insertProgram(5, newTitle, hour, minute);
                    break;
                case 6:
                    if (channel6.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "This channel is empty");
                    }
                    while (!channel6.isEmpty()) {
                        p = (Program) channel6.top();
                        if (p.getTitle().equalsIgnoreCase(title)) {
                            p.setSchedule(newSchedule);
                            p.setTitle(newTitle);
                            aux1.push(channel6.pop());
                        } else {
                            aux.push(channel6.pop());
                        }
                    }

                    while (!aux.isEmpty()) {
                        channel6.push(aux.pop());
                    }
                    insertProgram(6, newTitle, hour, minute);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Channel " + channelNumber + " does not exit");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error when entering schedule data");
        }
    }

    public String showChannel(int channelNumber) {
        String exit = "";
        switch (channelNumber) {
            case 1:
                exit = "Program: Morning Show : Schedule: 08:00 AM - 09:00 AM, Program: News : Schedule: 09:00 AM - 10:00 AM";
                break;
            case 2:
                exit = "Program: Cartoons : Schedule: 07:00 AM - 08:00 AM, Program: Talk Show : Schedule: 08:00 AM - 09:00 AM";
                break;
            case 3:
                exit = "Program: Movie : Schedule: 10:00 AM - 12:00 PM, Program: Cooking Show : Schedule: 12:00 PM - 01:00 PM";
                break;
            case 4:
                exit = "Program: Sports : Schedule: 01:00 PM - 03:00 PM, Program: Documentary : Schedule: 03:00 PM - 04:00 PM";
                break;
            case 5:
                exit = "Program: Drama : Schedule: 04:00 PM - 06:00 PM, Program: Comedy : Schedule: 06:00 PM - 07:00 PM";
                break;
            case 6:
                exit = "Program: Evening News : Schedule: 07:00 PM - 08:00 PM, Program: Late Night Show : Schedule: 08:00 PM - 09:00 PM";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Channel " + channelNumber + " does not exist");
        }
        return exit;
    }

    public Program changeChannel(int channelNumber) {
        Program p = new Program();

        switch (channelNumber) {
            case 1:
                p = (Program) channel1.top();
                break;
            case 2:
                p = (Program) channel2.top();
                break;
            case 3:
                p = (Program) channel3.top();
                break;
            case 4:
                p = (Program) channel4.top();
                break;
            case 5:
                p = (Program) channel5.top();
                break;
            case 6:
                p = (Program) channel6.top();
                break;
        }
        return p;
    }

    public void creatChannels() {

        insertProgram(1, "Caso cerrado", 7, 0);
        insertProgram(1, "La casa del dragon", 8, 0);
        insertProgram(1, "Gumball", 9, 0);

        insertProgram(2, "Buen dia", 7, 0);
        insertProgram(2, "Forrest Gump", 8, 0);
        insertProgram(2, "Supervivencia al desnudo", 9, 0);

        insertProgram(3, "El chavo de ocho", 7, 0);
        insertProgram(3, "Zoboomafoo", 8, 0);
        insertProgram(3, "Planeta Azul", 9, 0);

        insertProgram(4, "Dragon ball", 7, 0);
        insertProgram(4, "The boys", 8, 0);
        insertProgram(4, "Animal Planet", 9, 0);

        insertProgram(5, "The big bang theory", 7, 0);
        insertProgram(5, "Pokemon", 8, 0);
        insertProgram(5, "Pocoyo", 9, 0);

        insertProgram(6, "Telenoticias", 7, 0);
        insertProgram(6, "Chinamo", 8, 0);
        insertProgram(6, "Juegos mentales", 9, 0);
    }

    public void deleteProgram(int channelNumber, String title) {
        DynamicStack aux = new DynamicStack();
        Program p = new Program();
        switch (channelNumber) {
            case 1:
                if (channel1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "This channel is empty");
                }
                while (!channel1.isEmpty()) {
                    p = (Program) channel1.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel1.pop();
                    } else {
                        aux.push(channel1.pop());
                    }
                }
                while (!aux.isEmpty()) {
                    channel1.push(aux.pop());
                }
                break;
            case 2:
                if (channel2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "This channel is empty");
                }
                while (!channel2.isEmpty()) {
                    p = (Program) channel2.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel2.pop();
                    } else {
                        aux.push(channel2.pop());
                    }
                }
                while (!aux.isEmpty()) {
                    channel2.push(aux.pop());
                }
                break;
            case 3:
                if (channel3.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "This channel is empty");
                }
                while (!channel3.isEmpty()) {
                    p = (Program) channel3.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel3.pop();
                    } else {
                        aux.push(channel3.pop());
                    }
                }
                while (!aux.isEmpty()) {
                    channel3.push(aux.pop());
                }
                break;
            case 4:
                if (channel4.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "This channel is empty");
                }
                while (!channel4.isEmpty()) {
                    p = (Program) channel4.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel4.pop();
                    } else {
                        aux.push(channel4.pop());
                    }
                }
                while (!aux.isEmpty()) {
                    channel4.push(aux.pop());
                }
                break;
            case 5:
                if (channel5.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "This channel is empty");
                }
                while (!channel5.isEmpty()) {
                    p = (Program) channel5.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel5.pop();
                    } else {
                        aux.push(channel5.pop());
                    }
                }
                while (!aux.isEmpty()) {
                    channel5.push(aux.pop());
                }
                break;
            case 6:
                if (channel6.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "This channel is empty");
                }
                while (!channel6.isEmpty()) {
                    p = (Program) channel6.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel6.pop();
                    } else {
                        aux.push(channel6.pop());
                    }
                }
                while (!aux.isEmpty()) {
                    channel6.push(aux.pop());
                }
                break;
        }
    }

    public void linkChannels() {
        channelGraph.addEdge(channel1, channel2);
        channelGraph.addEdge(channel1, channel3);
        channelGraph.addEdge(channel1, channel4);
        channelGraph.addEdge(channel1, channel5);
        channelGraph.addEdge(channel1, channel6);
        channelGraph.addEdge(channel2, channel3);
        channelGraph.addEdge(channel2, channel4);
        channelGraph.addEdge(channel2, channel5);
        channelGraph.addEdge(channel2, channel6);
        channelGraph.addEdge(channel3, channel4);
        channelGraph.addEdge(channel3, channel5);
        channelGraph.addEdge(channel3, channel6);
        channelGraph.addEdge(channel4, channel5);
        channelGraph.addEdge(channel4, channel6);
        channelGraph.addEdge(channel5, channel6);

    }

    public DynamicStack assignChannel(int n) {
        DynamicStack c = new DynamicStack();

        switch (n) {
            case 1:
                c = channel1;
                break;
            case 2:
                c = channel2;
                break;
            case 3:
                c = channel3;
                break;
            case 4:
                c = channel4;
                break;
            case 5:
                c = channel5;
                break;
            case 6:
                c = channel6;
                break;
        }
        return c;
    }

    public String channelNavigation(int currentChannel, int destinyChannel) {
        Program p = new Program();

        switch (destinyChannel) {
            case 1:
                if (channelGraph.existsEdge(assignChannel(currentChannel), assignChannel(destinyChannel))) {
                    p = (Program) channel1.top();
                } else {
                    JOptionPane.showMessageDialog(null, "there is no connection between these channels");
                }

                break;
            case 2:
                if (channelGraph.existsEdge(assignChannel(currentChannel), assignChannel(destinyChannel))) {
                    p = (Program) channel2.top();
                } else {
                    JOptionPane.showMessageDialog(null, "there is no connection between these channels");
                }

                break;
            case 3:
                if (channelGraph.existsEdge(assignChannel(currentChannel), assignChannel(destinyChannel))) {
                    p = (Program) channel3.top();
                } else {
                    JOptionPane.showMessageDialog(null, "there is no connection between these channels");
                }

                break;
            case 4:
                if (channelGraph.existsEdge(assignChannel(currentChannel), assignChannel(destinyChannel))) {
                    p = (Program) channel4.top();
                } else {
                    JOptionPane.showMessageDialog(null, "there is no connection between these channels");
                }

                break;
            case 5:
                if (channelGraph.existsEdge(assignChannel(currentChannel), assignChannel(destinyChannel))) {
                    p = (Program) channel1.top();
                } else {
                    JOptionPane.showMessageDialog(null, "there is no connection between these channels");
                }

                break;
            case 6:
                if (channelGraph.existsEdge(assignChannel(currentChannel), assignChannel(destinyChannel))) {
                    p = (Program) channel6.top();
                } else {
                    JOptionPane.showMessageDialog(null, "there is no connection between these channels");
                }

                break;
        }
        return p.toString();
    }
}
