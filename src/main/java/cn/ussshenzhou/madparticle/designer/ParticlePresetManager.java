package cn.ussshenzhou.madparticle.designer;

import cn.ussshenzhou.madparticle.particle.MadParticleOption;
import cn.ussshenzhou.madparticle.particle.CustomParticleRegistry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Manage save and load of particle presets.
 */
public class ParticlePresetManager {
    private static final File PRESET_DIR = new File(CustomParticleRegistry.gameDir, "presets");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /** Save preset */
    public static void save(String name, MadParticleOption option) throws IOException {
        if (!PRESET_DIR.exists()) {
            //noinspection ResultOfMethodCallIgnored
            PRESET_DIR.mkdirs();
        }
        File f = new File(PRESET_DIR, name + ".json");
        try (FileWriter w = new FileWriter(f)) {
            JsonObject obj = option.toJson();
            GSON.toJson(obj, w);
        }
    }

    /** Load preset */
    public static MadParticleOption load(String name) throws IOException {
        File f = new File(PRESET_DIR, name + ".json");
        try (FileReader r = new FileReader(f)) {
            JsonObject obj = GSON.fromJson(r, JsonObject.class);
            return MadParticleOption.fromJson(obj);
        }
    }
}
