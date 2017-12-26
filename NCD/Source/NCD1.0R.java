package com.Ethel173.NCD;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.Explosion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
@Mod(modid = "NCD", version = "1.0R")
public class NCD {
public static final String[] TIME_SINCE_IGNITED = { "timeSinceIgnited", "field_70833_d", "bq" };
public static final String[] FUSE_TIME = { "fuseTime", "field_82225_f", "br" };
@SubscribeEvent
public void thepartwhereipickoutcreepers(LivingUpdateEvent event) {
	EntityCreeper creeper = null;
	if (event.getEntityLiving() instanceof EntityCreeper)
		creeper = (EntityCreeper) event.getEntityLiving();
	if (creeper != null && creeper.getCreeperState() == 1) {
		int ignitedTime = ((Integer) ReflectionHelper.getPrivateValue(EntityCreeper.class, creeper,TIME_SINCE_IGNITED)).intValue();
		int fuseTime = ((Integer) ReflectionHelper.getPrivateValue(EntityCreeper.class, creeper, FUSE_TIME)).intValue();
		if (ignitedTime >= fuseTime - 1){
			creeper.getEntityWorld().playSound((EntityPlayer) null, creeper.posX, creeper.posY, creeper.posZ,
					SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.HOSTILE, 0.5F,
					(1.0F + (creeper.getEntityWorld().rand.nextFloat() - creeper.getEntityWorld().rand.nextFloat()) * 0.2F)* 0.7F);
				creeper.setDead();
				theboompart(creeper);}}}
private void theboompart(EntityCreeper creeper) {
	float explosionStrength = creeper.getPowered() ? 2.0F : 1.0F;
	Explosion explosion = new Explosion(creeper.getEntityWorld(), creeper, creeper.posX, creeper.posY, creeper.posZ, 3 * explosionStrength, false, false);
	explosion.doExplosionA();}
@EventHandler
public void init(FMLInitializationEvent event){
	MinecraftForge.EVENT_BUS.register(new NCD());}
}