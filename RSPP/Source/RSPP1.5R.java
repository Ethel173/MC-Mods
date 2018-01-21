package com.Ethel.RedStonePerfPack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Blocks;

@Mod(modid = RSPP.MODID, name = RSPP.MODNAME, version = RSPP.VERSION)
public class RSPP {

    public static final String MODID = "RSPP";
    public static final String MODNAME = "RedStonePerfPack";
    public static final String VERSION = "1.5R";

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	Blocks.redstone_wire.setLightLevel(3);
		Blocks.redstone_block.setLightLevel(3);
		
		Blocks.redstone_ore.setLightLevel(0);
		Blocks.lit_redstone_ore.setLightLevel(0);
		
		Blocks.redstone_torch.setLightLevel(3);
		Blocks.unlit_redstone_torch.setLightLevel(3);
		
		Blocks.powered_repeater.setLightLevel(0);
		Blocks.unpowered_repeater.setLightLevel(0);
		
		Blocks.powered_comparator.setLightLevel(3);
		Blocks.unpowered_comparator.setLightLevel(3);
    }
}