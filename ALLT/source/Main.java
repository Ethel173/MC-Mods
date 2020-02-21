package com.ethel.autotorch;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumSkyBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;



@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)

public class Main {
    public static final String MODID = "allt";
    public static final String NAME = "autotorch";
    public static final String VERSION = "1.0R";
    public int placing = 0;
	private int nexttrytime = 0;
	public int lighttoplaceat = 8;
	
	
    @SubscribeEvent
    public void onkeyevent(KeyInputEvent event) //need to replace with proper config ""soon""
    {
    	if(
    			Minecraft.getMinecraft().gameSettings.keyBindDrop.isKeyDown()
    			&& Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()
    		)
    		{
    			Minecraft.getMinecraft().player.sendMessage(new TextComponentString("auto torch on"));
    			placing = 1;
    			KeyBinding.unPressAllKeys();

    		}
    	
    	if(
    			Minecraft.getMinecraft().gameSettings.keyBindDrop.isKeyDown()
    			&& Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed()
    	)
    	{
    			Minecraft.getMinecraft().player.sendMessage(new TextComponentString("auto torch off"));
    			placing = 0;
    			KeyBinding.unPressAllKeys();
    	}
    	
    	if( 	Minecraft.getMinecraft().gameSettings.keyBindDrop.isKeyDown()
    			&& Minecraft.getMinecraft().gameSettings.keyBindBack.isPressed()
    		)
    	{
			lighttoplaceat++;
			if(lighttoplaceat > 15){lighttoplaceat = 0;}//loopback on overflow
			Minecraft.getMinecraft().player.sendMessage(new TextComponentString("autotorch set at " + lighttoplaceat));//print after logic
			KeyBinding.unPressAllKeys();
    	}

    }
    	  
    
    @SubscribeEvent
    public void playerTick(TickEvent.PlayerTickEvent event)
	{
    	EntityPlayer player = Minecraft.getMinecraft().player;
    	nexttrytime++; //need sleep timer to prevent double placing
    	
		if (nexttrytime >= 20) //have to iterate over each tick for a timer
			{
        if (placing == 1)
        		{
        			if (
        					!(player==null)
        					&& player.isSpectator() == false
        					&& player.world.getLightFor(EnumSkyBlock.BLOCK, player.getPosition()) < lighttoplaceat //get blocklight under feet , 8 is really 7 light level
        					&& player.world.isAirBlock(player.getPosition()) // dont overwrite liquids 
        					&& player.getHeldItemOffhand().getItem() == ItemBlock.getByNameOrId("Minecraft:torch")
        					&& player.world.mayPlace(Blocks.TORCH, player.getPosition(), true, EnumFacing.UP, player)) 
        						{
        						//System.out.println("checkplacement tried placing");// debug
        						Minecraft.getMinecraft().playerController.processRightClickBlock(Minecraft.getMinecraft().player, Minecraft.getMinecraft().world, player.getPosition(), EnumFacing.UP, (Vec3d.fromPitchYaw(90, player.cameraPitch)), EnumHand.OFF_HAND);
        						}
        		}
        	nexttrytime = 0; //reset placement timer even if failed to place
			}
  }

    

    


    @EventHandler
    public void init(FMLInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(new Main());
    }
}
   
