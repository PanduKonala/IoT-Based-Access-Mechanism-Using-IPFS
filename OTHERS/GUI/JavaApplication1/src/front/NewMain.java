/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front;
import io.ipfs.api.IPFS;
import io.ipfs.multiaddr.MultiAddress;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.*;


/**
 *
 * @author GodFather
 */
public class NewMain {
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            IPFS ipfs = new IPFS(new MultiAddress("/ip4/127.0.0.1/tcp/5001"));                       
            
            while(true){
                String topic = "lol";
                Object sub1 = ipfs.pubsub.sub(topic);
                Stream<Map<String, Object>> sub2 = (Stream<Map<String, Object>>) sub1;

                Object first = sub2.findAny();       
                String sub3 = ""+first; 
                //System.out.println(first);
                String sub4[] = sub3.split(",");
                String data = sub4[1].substring(6,sub4[1].length());
                //System.out.println(data);

                Base64.Decoder decoder = Base64.getDecoder();  

                String dStr = new String(decoder.decode(data));  
                System.out.println(dStr);                 
             }
        } catch (Exception ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
