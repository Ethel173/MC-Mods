package com.ethel.autotorch;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.EnumSkyBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class keylistener {
    private static int nexttrytime = 0;
	public static int placing = 0;
	public static int lighttoplaceat = 7;
	
	 @SubscribeEvent
	    public void onkeyevent(KeyInputEvent event)
	    {
	    	if(Main.Toggletorch.isPressed()) 
	    		{
	    			if(placing == 1)
	    			{
	    				placing = 0;
	    				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("AutoTorch off"));
	    			}
	    				else{
	    					placing = 1;
	    					Minecraft.getMinecraft().player.sendMessage(new TextComponentString("AutoTorch on"));
	    				}
	    		}
	    	if(Main.shifttorch.isPressed())
	    	{
				lighttoplaceat++;
				if(lighttoplaceat > 15){lighttoplaceat = 0;}//loopback on overflow
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("AutoTorch set at " + lighttoplaceat));//print after logic
	    	}
	    }
	  @SubscribeEvent
	    public void playerTick(TickEvent.PlayerTickEvent event)
		{
	    	EntityPlayer player = Minecraft.getMinecraft().player;
	    	nexttrytime--; //need sleep timer to prevent double placing
			if (nexttrytime <= 0) //have to iterate over each tick for a timer
				{
	        if (placing == 1)
	        		{
	        			if (
	        					!(player==null)
	        					&& player.isSpectator() == false
	        					&& player.world.getLightFor(EnumSkyBlock.BLOCK, player.getPosition()) <= lighttoplaceat //get blocklight under feet
	        					&& player.world.isAirBlock(player.getPosition()) // dont overwrite liquids 
	        					&& player.getHeldItemOffhand().getItem() == ItemBlock.getByNameOrId("Minecraft:torch")
	        					&& player.world.mayPlace(Blocks.TORCH, player.getPosition(), true, EnumFacing.UP, player)) 
	        						{
	        						//System.out.println("checkplacement tried placing");// debug
	        						Minecraft.getMinecraft().playerController.processRightClickBlock(Minecraft.getMinecraft().player, Minecraft.getMinecraft().world,player.getPosition() , EnumFacing.UP, (Vec3d.fromPitchYaw(player.cameraPitch, player.cameraYaw)), EnumHand.OFF_HAND);
	        						nexttrytime = 2;//give few ticks for light updates being slow
	        						}
	        			else
	        			{
	        				nexttrytime = 0; //reset placement timer even if failed to place
	        			}
	        		}
				}
	  }

}
