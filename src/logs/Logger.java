/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logs;

/**
 *
 * @author Ladislav Trejtnar CVUT FEL
 */
public class Logger {
    private final boolean webLog;
    private final boolean inncomLog;

    public Logger(boolean webLog, boolean inncomLog) {
        this.webLog = webLog;
        this.inncomLog = inncomLog;
    }
    
   public void logWeb(String s){
       if(webLog){
           System.out.println(s);
       }
   } 
   
   public void logInncom(String s){
       if(inncomLog){
           System.out.println(s);
       }
   } 
    
}
