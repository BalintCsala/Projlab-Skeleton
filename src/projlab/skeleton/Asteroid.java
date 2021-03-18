package projlab.skeleton;

import java.util.ArrayList;

public class Asteroid extends Field {
	
	
	private Resource resource;
	
	
	
   public void solarFlare() {
	   FunctionPrinter.enter("Asteroid", "solarFlare");
	   FunctionPrinter.msg("El lehet rajtam b�jni?(I/N)");
	   String choice = System.console().readLine();
	   
	   switch(choice) 
       { 
           case "I": 
                
               break; 
           case "N": 
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
	    resource.reaction();
	   
   }
   public boolean checkEnoughResources(BillOfResources winBill) {
	   FunctionPrinter.enter("Asteroid", "checkEnoughResources");
	   
	   //return
   }
}
