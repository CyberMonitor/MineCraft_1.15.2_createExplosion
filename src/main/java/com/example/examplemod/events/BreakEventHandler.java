package com.example.examplemod.events;

import com.example.examplemod.ExampleMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.event.world.BlockEvent.BreakEvent; 
import net.minecraftforge.event.world.BlockEvent.EntityPlaceEvent;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BreakEventHandler{
    @SubscribeEvent
    public static void explode(BreakEvent event) {
        //ExampleMod.LOGGER.info("Block Break");
        PlayerEntity player = event.getPlayer(); //玩家. 舊版EntityPlayer, 新版要用PlayerEntity, ......
        float power = 5;  //爆破的威力 (5代表五個方塊長的爆炸範圍)
        //boolean destroyBlocks = true;  //爆炸是否要損毀方塊, 新API 使用 Explosion.Mode.BREAK
        World world = player.getEntityWorld();
        BlockPos pos = event.getPos(); //方塊打破的位置
        // 建立爆破
     	world.createExplosion(
             // 爆炸來源為玩家
             player,
             // 藉由打破方塊事件的位置來建立爆破
             pos.getX(), 
             pos.getY(),
             pos.getZ(),
             power,
             Explosion.Mode.BREAK
     	);

    }

}