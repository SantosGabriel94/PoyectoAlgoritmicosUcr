
package Logic.Channels;

import TDA.DoubleLinkedList.DoubleLinkedList;
import TDA.DynamicStack.DynamicStack;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Channel{
    
   private DoubleLinkedList channelList; 
   //private DoubleLinkedList channelList;  
   
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
    
    public void editProgram(int channelNumber, String title, String newTitle, int hour, int minute){
        
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
    
    public String showChannel(int channelNumber){
         String exit = "";
        switch(channelNumber) {
            case 1:
                exit = channel1.toString();
                break;
            case 2:
                exit = channel2.toString();
                break;
            case 3:
                exit = channel3.toString();
                break;
            case 4:
                exit = channel4.toString();
                break;
            case 5:
                exit = channel5.toString();
                break;
            case 6:
                exit = channel6.toString();
                break;
            default:
                JOptionPane.showMessageDialog(null,"Channel "+channelNumber+" does not exit");
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
    
    public void deleteProgram(int channelNumber, String title){
        DynamicStack aux = new DynamicStack();
        Program p = new Program();
        switch (channelNumber) {
            case 1:
                if(channel1.isEmpty())
                    JOptionPane.showMessageDialog(null,"This channel is empty");
                while (!channel1.isEmpty()) {
                    p = (Program) channel1.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel1.pop();
                    }else {
                        aux.push(channel1.pop()); 
                    }
                }
                while (!aux.isEmpty()) {
                    channel1.push(aux.pop());
                }
                break;
            case 2:
                if(channel2.isEmpty())
                    JOptionPane.showMessageDialog(null,"This channel is empty");
                while (!channel2.isEmpty()) {
                    p = (Program) channel2.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel2.pop();
                    }else {
                        aux.push(channel2.pop()); 
                    }
                }
                while (!aux.isEmpty()) {
                    channel2.push(aux.pop());
                }
                break;
            case 3:
                if(channel3.isEmpty())
                    JOptionPane.showMessageDialog(null,"This channel is empty");
                while (!channel3.isEmpty()) {
                    p = (Program) channel3.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel3.pop();
                    }else {
                        aux.push(channel3.pop()); 
                    }
                }
                while (!aux.isEmpty()) {
                    channel3.push(aux.pop());
                }
                break;
            case 4:
                if(channel4.isEmpty())
                    JOptionPane.showMessageDialog(null,"This channel is empty");
                while (!channel4.isEmpty()) {
                    p = (Program) channel4.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel4.pop();
                    }else {
                        aux.push(channel4.pop()); 
                    }
                }
                while (!aux.isEmpty()) {
                    channel4.push(aux.pop());
                }
                break;
            case 5:
                if(channel5.isEmpty())
                    JOptionPane.showMessageDialog(null,"This channel is empty");
                while (!channel5.isEmpty()) {
                    p = (Program) channel5.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel5.pop();
                    }else {
                        aux.push(channel5.pop()); 
                    }
                }
                while (!aux.isEmpty()) {
                    channel5.push(aux.pop());
                }
                break;
            case 6:
                if(channel6.isEmpty())
                    JOptionPane.showMessageDialog(null,"This channel is empty");
                while (!channel6.isEmpty()) {
                    p = (Program) channel6.top();
                    if (p.getTitle().equalsIgnoreCase(title)) {
                        channel6.pop();
                    }else {
                        aux.push(channel6.pop()); 
                    }
                }
                while (!aux.isEmpty()) {
                    channel6.push(aux.pop());
                }
                break;
        } 
    }

    public static void main(String[] args) {
        Channel c = new Channel();
        Program p = new Program(); 
        c.insertProgram(1, "Noticias", 1, 11);
        c.insertProgram(1, "Novelas", 3, 00);
        c.insertProgram(1, "Chinamo", 8, 00);
        c.insertProgram(1, "Musica", 1, 00);
        
        //c.deleteProgram(1, "Novelas");
        c.editProgram(1, "noticias", "el chavo del 8", -9, 0);
      
        System.out.println(c.showChannel(1));
    }
}
        
    
   



