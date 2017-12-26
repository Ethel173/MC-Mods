package com.Ethel173.RSPP;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = "RSPP", version = "1.0R", name = "RedStonePerfPack")
public class RedStonePerfPack {
	@EventHandler
	public void init(FMLPostInitializationEvent event) {
		Blocks.REDSTONE_WIRE.setLightLevel(0);
		Blocks.REDSTONE_BLOCK.setLightLevel(0);
		
		Blocks.REDSTONE_ORE.setLightLevel(0);
		Blocks.LIT_REDSTONE_ORE.setLightLevel(0);
		
		Blocks.REDSTONE_TORCH.setLightLevel(0);
		Blocks.UNLIT_REDSTONE_TORCH.setLightLevel(0);
		
		Blocks.POWERED_REPEATER.setLightLevel(0);
		Blocks.UNPOWERED_REPEATER.setLightLevel(0);
		
		Blocks.POWERED_COMPARATOR.setLightLevel(0);
		Blocks.UNPOWERED_COMPARATOR.setLightLevel(0);
		
		Blocks.PISTON.setLightOpacity(1);
		Blocks.PISTON_EXTENSION.setLightOpacity(1);
		Blocks.PISTON_HEAD.setLightOpacity(1);
		Blocks.STICKY_PISTON.setLightOpacity(1);
	}
	
}