package cn.ussshenzhou.madparticle.particle;

import cn.ussshenzhou.madparticle.command.inheritable.InheritableBoolean;
import cn.ussshenzhou.madparticle.particle.enums.ChangeMode;
import cn.ussshenzhou.madparticle.particle.enums.ParticleRenderTypes;
import cn.ussshenzhou.madparticle.particle.enums.SpriteFrom;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.Nullable;

/**
 * Helper to build a simple trailing particle option.
 */
public class TrailEffect {
    /**
     * Build a trailing {@link MadParticleOption}.
     *
     * @param r        red color channel (0-1)
     * @param g        green color channel (0-1)
     * @param b        blue color channel (0-1)
     * @param lifeTime lifetime of the trail particle
     * @param amount   amount spawned each tick
     * @param child    next child option, can be {@code null}
     * @return configured {@link MadParticleOption}
     */
    public static MadParticleOption build(float r, float g, float b, int lifeTime, int amount, @Nullable MadParticleOption child) {
        return new MadParticleOption(
                BuiltInRegistries.PARTICLE_TYPE.getId(ParticleTypes.END_ROD),
                SpriteFrom.AGE,
                lifeTime,
                InheritableBoolean.FALSE,
                amount,
                Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE,
                0f, 0f, 0f,
                0, 0, 0,
                0f, 0f, 0f,
                0f, 0f,
                InheritableBoolean.FALSE, 0,
                0f, 0f,
                0f, 0f,
                InheritableBoolean.FALSE,
                0f, 0f,
                ParticleRenderTypes.PARTICLE_SHEET_TRANSLUCENT,
                r, g, b,
                1f, 0f, ChangeMode.LINEAR,
                0.25f, 0f, ChangeMode.LINEAR,
                child != null, child,
                0f,
                0f, 0f,
                0f, 0f,
                1f,
                new CompoundTag()
        );
    }
}
