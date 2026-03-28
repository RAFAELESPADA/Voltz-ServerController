package me.rafaelauler.ss;

//Conceptual Java code for a Minecraft plugin's animation task
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

public class BedwarsGen extends BukkitRunnable {

 private final ArmorStand armorStand;
 private double currentAngle = 0;

 public BedwarsGen(Location location, ItemStack item) {
     // Spawn an invisible armor stand at the location
     this.armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
     armorStand.setVisible(false);
     armorStand.setGravity(false);
     armorStand.getEquipment().setItemInHand(item); // Place the item in its "hand"
  // Run this task repeatedly every game tick (20 ticks per second)
     new BukkitRunnable() {
    	 

/*     */         public void run()
/*     */         {
    
    currentAngle += 0.1; // Adjust speed of spin
         
         // Use Euler angles to rotate the arm/item (around the Y axis)
         double angleInRadians = Math.toRadians(currentAngle);
         armorStand.setRightArmPose(new EulerAngle(Math.PI / 4, angleInRadians, 0));
           
/*     */         }
/* 280 */       }.runTaskTimer(BukkitMain.plugin, 1L, 2l);
      }

 



 // Call this in your main plugin class to start the animation
 public void startAnimation(/* Plugin instance */) {
     
 }

 // Ensure you have a method to clean up the armor stand when the game ends
 public void remove() {
     if (armorStand != null) {
         armorStand.remove();
     }
     this.cancel(); // Stop the runnable task
 }


@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}
