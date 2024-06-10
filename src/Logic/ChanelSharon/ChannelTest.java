
package Logic.ChanelSharon;




/**
 *
 * @author Sharon
 */
public class ChannelTest {

    Channel l1;

    public ChannelTest() {
        l1 = new Channel();
    }

    public void test() throws ListException {
        l1.addChannel("Canal 1");
        l1.addChannel("Canal 2");
        l1.addChannel("Canal 3");
        l1.addChannel("Canal 4");
        l1.addChannel("Canal 5");
        l1.addChannel("Canal 6");
        l1.addChannel("Canal 7");
        System.out.println(l1.isEmpty());

        System.out.println(l1.selectChannel(1));

        l1.printChannels();

        l1.nextChannel();
        l1.nextChannel();
        l1.nextChannel();
        l1.nextChannel();
        l1.nextChannel();
        l1.nextChannel();
        l1.nextChannel();
        System.out.println(l1.currentChannel());
        l1.previousChannel();
        System.out.println(l1.currentChannel());
    }
    
     public static void main(String[] args) throws ListException {
        ChannelTest p = new ChannelTest();
        p.test();
    } 
    
    
    
}
