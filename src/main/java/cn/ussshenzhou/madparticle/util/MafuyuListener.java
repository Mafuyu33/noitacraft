package cn.ussshenzhou.madparticle.util;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public class MafuyuListener {

    @SubscribeEvent
    public static void onItemUse(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != InteractionHand.MAIN_HAND || event.getSide() != LogicalSide.SERVER) {
            return;
        }
        //拖尾
        if(event.getItemStack().getItem() == Items.MAGMA_CREAM) {
            ((ServerLevel)event.getLevel()).getServer().getCommands().performPrefixedCommand(event.getEntity().createCommandSourceStack(),
                    "mp minecraft:totem_of_undying RANDOM 60 FALSE 200 ~ ~ ~ 0.0 0.0 0.0 0.6 0.6 0.6 0.0 0.0 0.0 TRUE 1 1 1 0.995 0.99 0.1 0.02 0 0 0 0 0 FALSE 0 0 INSTANCED 0.911 0.860 0.179 1 1 1 LINEAR 2 1 LINEAR @a {\"disappearOnCollision\":1,\"life\":100} expireThen minecraft:totem_of_undying RANDOM 60 FALSE 1 = = = 0.0 0.0 0.0 = = = 0.0 0.0 0.0 FALSE 2 1 1 0.8 0.9 -0.15 0.5 0 0 0 0 0 FALSE 0 0 INSTANCED 0.854 0.915 0.101 = 0.7 0 LINEAR 2 2 LINEAR @a {}");
        }
        //不同的法术在这里做封装
      }
}
