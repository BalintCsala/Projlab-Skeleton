package projlab.skeleton;

import java.util.ArrayList;
import java.util.Scanner;

public class Asteroid extends Field {
	
	
	private Resource resource;
	
	
	
   public void solarFlare() {
	   FunctionPrinter.enter("Asteroid", "solarFlare");
	   FunctionPrinter.msg("El lehet rajtam bújni?(true/false)");
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
	   FunctionPrinter.exit();
	   
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
	   FunctionPrinter.exit();
   }
   public Resource mineResource() {
	   FunctionPrinter.enter("Asteroid", "mineResource");
	   Resource res = resource;
	   resource = null;
	   FunctionPrinter.exit();
	   return res;
   }
   public void digLayer() {  //if 
	   FunctionPrinter.enter("Asteroid", "diglayer");
	   FunctionPrinter.msg("Napközelben vagyunk és a réteg 0?(I/N)");
	   String choice = System.console().readLine();
	   
	   switch(choice) 
       { 
           case "I": 
        	   resource.reaction(this);
               break; 
           case "N": 
        	   
               break; 
           default: 
               System.out.println("no match"); //repeatelni kellene?
       } 
	    
	   FunctionPrinter.exit();
   }
   public boolean checkEnoughResources(BillOfResources winBill) {   //milegyen telepes és robot megkülönböztetés
	   FunctionPrinter.enter("Asteroid", "checkEnoughResources");
	   ArrayList<Resource> collectedResources = new ArrayList<Resource>();
	   for(int i =0; i< entities.size();i++) {//ha nullal tér vissza  a akkor robotgetinventoryja le kell kezelni gondolom így lesz
		  if(entities.get(i).getInventory()!= null) {
		   collectedResources.addAll(entities.get(i).getInventory());
		  }
	   }
	   FunctionPrinter.exit();
	   return winBill.isCompleted(collectedResources);
	   
   }
   public void setResource(Resource res) {  // ezt sem írom ki
	   resource= res;
	   
   }
}
