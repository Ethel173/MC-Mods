package com.Ethel173.RSPP;

import net.minecraft.init.Blocks;

@cpw.mods.fml.common.Mod(modid = "RSPP", version = "1.0R", name = "RedStonePerfPack")
public class RedStonePerfPack {
	@cpw.mods.fml.common.Mod.EventHandler
	public void init(cpw.mods.fml.common.event.FMLPostInitializationEvent event) {
		Blocks.redstone_wire.setLightLevel(0);
		Blocks.redstone_block.setLightLevel(0);
		
		Blocks.redstone_ore.setLightLevel(0);
		Blocks.lit_redstone_ore.setLightLevel(0);
		
		Blocks.redstone_torch.setLightLevel(0);
		Blocks.unlit_redstone_torch.setLightLevel(0);
		
		Blocks.powered_repeater.setLightLevel(0);
		Blocks.unpowered_repeater.setLightLevel(0);
		
		Blocks.powered_comparator.setLightLevel(0);
		Blocks.unpowered_comparator.setLightLevel(0);
		
		Blocks.piston.setLightOpacity(1);
		Blocks.piston_extension.setLightOpacity(1);
		Blocks.piston_head.setLightOpacity(1);
		Blocks.sticky_piston.setLightOpacity(1);
	}
	
}