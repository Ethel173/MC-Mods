package com.ethel.RedStonePerfPack;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = rspp.MODID, name = rspp.MODNAME, version = rspp.VERSION)
public class rspp {

    public static final String MODID = "rspp";
    public static final String MODNAME = "RedStonePerfPack";
    public static final String VERSION = "1.53R";

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	Blocks.REDSTONE_WIRE.setLightLevel((float) 0.3);
		
		Blocks.REDSTONE_ORE.setLightLevel(0);
		Blocks.LIT_REDSTONE_ORE.setLightLevel(0);
		
		Blocks.REDSTONE_TORCH.setLightLevel((float) 0.3);
		Blocks.UNLIT_REDSTONE_TORCH.setLightLevel((float) 0.3);
		
		Blocks.POWERED_REPEATER.setLightLevel((float) 0.3);
		Blocks.UNPOWERED_REPEATER.setLightLevel((float) 0.3);
		
		Blocks.POWERED_COMPARATOR.setLightLevel((float) 0.3);
		Blocks.UNPOWERED_COMPARATOR.setLightLevel((float) 0.3);
    }
}