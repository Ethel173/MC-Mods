package com.ethel.autotorch;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION, clientSideOnly = true, acceptedMinecraftVersions = Main.gamever)

public class Main {
    public static final String MODID = "allt";
    public static final String NAME = "autotorch";
    public static final String VERSION = "1.1";
    public static final String gamever = "1.12";



	public static KeyBinding Toggletorch;
	public static KeyBinding shifttorch;
	
	public static void setupkeybinds() {
		//System.out.println("Config tried init");// debug
		Toggletorch = new KeyBinding("AutoTorch Toggle", Keyboard.KEY_O, "AutoTorch");
		ClientRegistry.registerKeyBinding(Toggletorch);
		shifttorch = new KeyBinding("AutoTorch Shift LightLevel", Keyboard.KEY_P, "AutoTorch");
		ClientRegistry.registerKeyBinding(shifttorch);
	}
	
    @EventHandler
    public void init(FMLPreInitializationEvent event){
    	setupkeybinds();
    	MinecraftForge.EVENT_BUS.register(new keylistener());//seperate class literally because i dont want to deal with syntax
    }
}
   