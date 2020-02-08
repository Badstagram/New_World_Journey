package org.ttpi.new_world_journey;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.util.EnumSet;

public class Main {

    public static String token = "Njc1NzY0NDI2MTIwMzY0MDMz.Xj74uw.CvkNaXTDw5ZYMkZY4gh764tf6oc";

    public static void main(String[] args) {
        JDABuilder builder = new JDABuilder(token);

        // Disable parts of the cache
        builder.setDisabledCacheFlags(EnumSet.of(CacheFlag.ACTIVITY, CacheFlag.VOICE_STATE));
        // Enable the bulk delete event
        builder.setBulkDeleteSplittingEnabled(false);

        try {
            builder.build();
        } catch (Exception e) {
            System.out.println("Error Building Bot");
        }
    }
}
