package projlab.skeleton;

import java.util.ArrayList;
import java.util.Scanner;

public class Asteroid extends Field {
	
	
	private Resource resource;
	
	
	
   public void solarFlare() {
	   FunctionPrinter.enter("Asteroid", "solarFlare");
	   FunctionPrinter.msg("El lehet rajtam b�jni?(true/false)");
	   Scanner scan = new Scanner(System.in);
	   String choice= scan.nextLine();
	   scan.close();
	   switch(choice) 
       { 
           case "true": 
                
               break; 
           case "false": 
        	   for(int i =0; i< entities.size();i++) {
        		   entities.get(i).die();
        		   
        	   }
               break; 
           default: 
               System.out.println("no match"); 
       } 
	   //kiir kerdes konzolra switch case  if(resource != null)
	   
   }
   public void explode() {
	   FunctionPrinter.enter("Asteroid", "explode");
	   for(int i =0; i< entities.size();i++) {
		   entities.get(i).explode();
		   removeEntity(entities.get(i));
	   }
	   
	   
	   for(int i =0; i< neighbors.size();i++) {
		   neighbors.get(i).removeNeighbor(this);
		   neighbors.get(i).explodeReaction();
		   
	   }
   }
   public Resource mineResource() {
	   FunctionPrinter.enter("Asteroid", "mineResource");
	   Resource res = resource;
	   resource = null;
	   return res;
   }
   public void digLayer() {  //if 
	   FunctionPrinter.enter("Asteroid", "diglayer");
	   FunctionPrinter.msg("Napk�zelben vagyunk �s a r�teg 0?(I/N)");
	   String choice = System.console().readLine();
	   
	   switch(choice) 
       { 
           case "I": 
        	   resource.reaction(this);
               break; 
           case "N": 
        	   
               break; 
           default: 
               System.out.println("no match"); 
       } 
	    
	   
   }
  /* public boolean checkEnoughResources(BillOfResources winBill) {   //milegyen telepes �s robot megk�l�nb�ztet�s
	   FunctionPrinter.enter("Asteroid", "checkEnoughResources");
	   
	   //return
   }*/
   public void setResource(Resource res) {  // ezt sem �rom ki
	   resource= res;
	   
   }
}
