package com.Ethel.NoCreeperDestruction;

import com.google.common.eventbus.Subscribe;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.world.Explosion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
@Mod(modid = NCD.MODID, name = NCD.MODNAME, version = NCD.VERSION)
public class NCD {
	
public static final String MODID = "NCD";
public static final String MODNAME = "NoCreeperDestruciton";
public static final String VERSION = "1.5R";
public static final String[] TIME_SINCE_IGNITED = { "timeSinceIgnited", "field_70833_d", "bq" };
public static final String[] FUSE_TIME = { "fuseTime", "field_82225_f", "br" };

@Subscribe
public void Creeper(LivingUpdateEvent  event) {
	EntityCreeper creeper = null;
	if (event.getEntityLiving() instanceof EntityCreeper)
		creeper = (EntityCreeper) event.getEntityLiving();
	if (creeper != null && creeper.getCreeperState() == 1) {
		int ignitedTime = ((Integer) ReflectionHelper.getPrivateValue(EntityCreeper.class, creeper,TIME_SINCE_IGNITED)).intValue();
		int fuseTime = ((Integer) ReflectionHelper.getPrivateValue(EntityCreeper.class, creeper, FUSE_TIME)).intValue();
		if (ignitedTime >= fuseTime - 1) {
			creeper.setDead();
			boom(creeper);}}
			}
private void boom(EntityCreeper creeper) {
	float explosionStrength = creeper.getPowered() ? 2.0F : 1.0F;
	double posx = creeper.posX;
	double posy = creeper.posY;
	double posz = creeper.posZ;
	Explosion explosion = creeper.world.createExplosion(creeper, posx, posy, posz,  3 * explosionStrength, false);
	explosion.doExplosionA();}

@EventHandler
public void init(FMLInitializationEvent event){
	MinecraftForge.EVENT_BUS.register(new NCD());}
}