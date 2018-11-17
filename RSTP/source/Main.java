package com.ethel.rssp;


import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "rstp";
    public static final String VERSION = "1.0";
    public static final String NAME = "redstone transparency pack";
    
    @EventHandler
    public void init(FMLPostInitializationEvent event)
    {
    	Blocks.SLIME_BLOCK.setLightOpacity(1);
    	Blocks.PISTON.setLightOpacity(1);    	
    	Blocks.PISTON_EXTENSION.setLightOpacity(1);
    	Blocks.PISTON_HEAD.setLightOpacity(1);
    	Blocks.OBSERVER.setLightOpacity(1);
    	Blocks.DROPPER.setLightOpacity(1);
    	Blocks.DISPENSER.setLightOpacity(1);
    	Blocks.REDSTONE_BLOCK.setLightOpacity(1);
    	Blocks.REDSTONE_LAMP.setLightOpacity(1);
}
}