
package Logic.Channels;

import TDA.DoubleLinkedList.DoubleLinkedList;
import TDA.DynamicStack.DynamicStack;
import java.time.LocalTime;

public class Channel{
    
   private DoubleLinkedList channelList; 
   
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
    
    public void changeTitle(int channelNumber, String title){
        Program p = new Program();
        DynamicStack aux = new DynamicStack();
        
        p.setTitle(title);
    }
    
    public void changeSchedule(int hour, int minute){
        Program p = new Program();
        DynamicStack aux = new DynamicStack();
        
        p.getSchedule().withHour(hour);
        p.getSchedule().withMinute(minute);
    }
    

    public static void main(String[] args) {
        Channel c = new Channel();
        Program p = new Program();
        c.insertProgram(1, "Noticias", 1, 00);
        c.insertProgram(1, "Novelas", 2, 00);
        c.insertProgram(1, "Chinamo", 3, 00);
        c.insertProgram(1, "Musica", 0, 30);
      
        System.out.println(c.channel1.toString());      
    }
}

