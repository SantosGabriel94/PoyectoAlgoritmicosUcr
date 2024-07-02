package Logic.Channels;

import TDA.Graphs.GraphException;
import TDA.Graphs.GraphListAdjacency;
import TDA.DoublyLinkedList.DoubleLinkedList;
import TDA.DynamicStack.DynamicStack;
import java.time.LocalTime;

public class Channel {

    private DoubleLinkedList channelList;

    private DynamicStack currentChannel;
    private DynamicStack channel1;
    private DynamicStack channel2;
    private DynamicStack channel3;
    private DynamicStack channel4;
    private DynamicStack channel5;
    private DynamicStack channel6;

    public Channel() {
        this.channelList = new DoubleLinkedList();
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

        this.currentChannel = channel1;
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
                System.out.println("This channel does not exist");
                break;
        }
    }

    public void changeTitle(int channelNumber, String title) {
        Program p = new Program();
        DynamicStack aux = new DynamicStack();

        p.setTitle(title);
    }

    public void changeSchedule(int hour, int minute) {
        Program p = new Program();
        DynamicStack aux = new DynamicStack();

        p.getSchedule().withHour(hour);
        p.getSchedule().withMinute(minute);
    }

    public void nextChannel() {
        if (currentChannel == null) {
            System.out.println("No select is currently selected");
            return;
        }

        if (currentChannel == channel1) {
            currentChannel = channel2;
        } else if (currentChannel == channel2) {
            currentChannel = channel3;
        } else if (currentChannel == channel3) {
            currentChannel = channel4;
        } else if (currentChannel == channel4) {
            currentChannel = channel5;
        } else if (currentChannel == channel5) {
            currentChannel = channel6;
        } else if (currentChannel == channel6) {
            currentChannel = channel1;
        } else {
            System.out.println("No more channels");
        }
    }

    public void previousChannel() {
        if (currentChannel == null) {
            System.out.println("No select is currently selected");
            return;
        }

        if (currentChannel == channel1) {
            currentChannel = channel6;
        } else if (currentChannel == channel2) {
            currentChannel = channel1;
        } else if (currentChannel == channel3) {
            currentChannel = channel2;
        } else if (currentChannel == channel4) {
            currentChannel = channel3;
        } else if (currentChannel == channel5) {
            currentChannel = channel4;
        } else if (currentChannel == channel6) {
            currentChannel = channel5;
        } else {
            System.out.println("No more channels");
        }
    }

    public String getNextAndPreviousChannel() {
        StringBuilder sb = new StringBuilder();
        if (currentChannel == null || currentChannel.isEmpty()) {
            sb.append("No programs in the current channel");
        } else {
            DynamicStack tempStack = new DynamicStack();

            while (!currentChannel.isEmpty()) {
                Program program = (Program) currentChannel.pop();
                sb.append(program.getTitle()).append(" - ").append(program.getSchedule()).append("\n");
                tempStack.push(program);
            }

            while (!tempStack.isEmpty()) {
                currentChannel.push(tempStack.pop());
            }
        }
        return sb.toString();
    }

    public DynamicStack navegateChannel(int numChannel) {
        GraphListAdjacency channelGraph = new GraphListAdjacency(6);

        channelGraph.addVertex(channel1);
        channelGraph.addVertex(channel2);
        channelGraph.addVertex(channel3);
        channelGraph.addVertex(channel4);
        channelGraph.addVertex(channel5);
        channelGraph.addVertex(channel6);

        try {
            channelGraph.addEdge(channel1, channel2);
            channelGraph.addEdge(channel2, channel3);
            channelGraph.addEdge(channel3, channel4);
            channelGraph.addEdge(channel4, channel1);
            channelGraph.addEdge(channel3, channel5);
            channelGraph.addEdge(channel3, channel6);
            channelGraph.addEdge(channel5, channel6);
            channelGraph.addEdge(channel6, channel1);
        } catch (GraphException e) {
            System.out.println("Error: " + e.getMessage());
        }

        DynamicStack selectedChannel = null;

        switch (numChannel) {
            case 1:
                selectedChannel = channel1;
                break;
            case 2:
                selectedChannel = channel2;
                break;
            case 3:
                selectedChannel = channel3;
                break;
            case 4:
                selectedChannel = channel4;
                break;
            case 5:
                selectedChannel = channel5;
                break;
            case 6:
                selectedChannel = channel6;
                break;
            default:
                System.out.println("The channel does not exist");
                break;
        }
        return selectedChannel;
    }

    public static void main(String[] args) {
        Channel c = new Channel();
        Program p = new Program();
        DynamicStack d = new DynamicStack();
        c.insertProgram(1, "Noticias", 1, 00);
        c.insertProgram(1, "Novelas", 2, 00);
        c.insertProgram(1, "Chinamo", 3, 00);
        c.insertProgram(1, "Musica", 0, 30);

        c.insertProgram(2, "Dora", 1, 00);
        c.insertProgram(2, "Bob esponja", 2, 00);
        c.insertProgram(2, "Intesamente2", 3, 00);

        c.insertProgram(3, "Titanic", 1, 00);
        c.insertProgram(3, "La monja", 2, 00);
        c.insertProgram(3, "El conjuro", 3, 00);

        System.out.println(c.channel1.toString());

        c.nextChannel();
        System.out.println(c.getNextAndPreviousChannel());
        c.previousChannel();
        System.out.println(c.getNextAndPreviousChannel());

        System.out.println(c.navegateChannel(3));

//        c.channelGraph.addVertex(c.channelList.getByPosition(0));
//        d = (DynamicStack) c.channelGraph.addVertex(c.channel1);
//        channelGraph.addVertex(channel6);
//        System.out.println(c.channelList.getByPosition(0));
//        System.out.println(c.channel1.toString());
//
//        g.getChannel().insertProgram(1, "Noticias", 1, 00);
//        g.getChannel().insertProgram(1, "Dora", 1, 00);
//        g.getChannel().insertProgram(2, "Novelas", 2, 00);
//        g.getChannel().insertProgram(3, "Chinamo", 3, 00);
//        g.getChannel().insertProgram(4, "Musica", 0, 30);
//
//        g.navigateChannel(1);
    }
}
