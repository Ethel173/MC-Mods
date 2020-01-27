package com.ethel.bedrocklight;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = bedrocklight.MODID, name = bedrocklight.NAME, version = bedrocklight.VERSION)
public class bedrocklight
{
    public static final String MODID = "brll";
    public static final String NAME = "Bedrock Low Light";
    public static final String VERSION = "1.0R";
	
    @EventHandler
    public void init(FMLInitializationEvent event){
        Blocks.BEDROCK.setLightLevel(3/16f);
    }
}