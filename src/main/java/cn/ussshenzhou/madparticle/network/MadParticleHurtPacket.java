package cn.ussshenzhou.madparticle.network;

import cn.ussshenzhou.madparticle.MadParticle;
import cn.ussshenzhou.madparticle.particle.MadParticleOption;
import cn.ussshenzhou.t88.network.annotation.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/**
 * @author USS_Shenzhou
 */
@NetPacket(modid = MadParticle.MOD_ID)
public class MadParticleHurtPacket {
    private final int id;
    private final int damage;

    public MadParticleHurtPacket(int id, int damage) {
        this.id = id;
        this.damage = damage;
    }

    @Decoder
    public MadParticleHurtPacket(FriendlyByteBuf buf) {
        this.id = buf.readVarInt();
        this.damage = buf.readVarInt();
    }

    @Encoder
    public void write(FriendlyByteBuf buf) {
        buf.writeVarInt(id);
        buf.writeVarInt(damage);
    }


    @ServerHandler
    public void serverHandler(IPayloadContext context) {
        var entity = context.player().level().getEntity(id);
        if(entity != null) {
            entity.hurt(context.player().level().damageSources().source(DamageTypes.ARROW),damage);
        }
    }

}
