package io.cg360.moon.pumpkins.charms;


import io.cg360.moon.pumpkins.PumpkinsPlugin;
import io.cg360.moon.pumpkins.Utils;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.scheduler.Task;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class CharmTask implements Runnable {
    @Override
    public void run() {
        for(Player p: Sponge.getServer().getOnlinePlayers()){
            Task mt = Task.builder()
                    .execute(task1 -> {
                        p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                            for(PotionEffect data: potionEffectData.effects()){
                                if(data.getType() == PotionEffectTypes.NIGHT_VISION && data.getAmplifier() == 2)p.offer(potionEffectData.remove(data));
                            }
                        });
                    }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
            if(p.getItemInHand(HandTypes.OFF_HAND).isPresent()){
                ItemStack s = p.getItemInHand(HandTypes.OFF_HAND).get();
                s.get(Keys.ITEM_LORE).ifPresent(texts -> {
                    if(texts.size() >= 1){
                        //Tags
                        String[] tags = texts.get(0).toPlain().split(Pattern.quote(","));
                        if(tags.length > 0) {
                            if(Utils.tagStartsWith(tags, "lava_charm").isPresent()){
                                Task task = Task.builder()
                                        .execute(task1 -> {
                                            p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                                                p.offer(
                                                        potionEffectData.set(potionEffectData.effects()
                                                                .add(PotionEffect.of(PotionEffectTypes.FIRE_RESISTANCE, 1, 30))
                                                        ));
                                            });
                                        }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
                            }
                            if(Utils.tagStartsWith(tags, "speed_charm").isPresent()){
                                Task task = Task.builder()
                                        .execute(task1 -> {
                                            p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                                                p.offer(
                                                        potionEffectData.set(potionEffectData.effects()
                                                                .add(PotionEffect.of(PotionEffectTypes.SPEED, 3, 30))
                                                        ));
                                            });
                                        }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
                            }
                            if(Utils.tagStartsWith(tags, "strength_charm").isPresent()){
                                Task task = Task.builder()
                                        .execute(task1 -> {
                                            p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                                                p.offer(
                                                        potionEffectData.set(potionEffectData.effects()
                                                                .add(PotionEffect.of(PotionEffectTypes.STRENGTH, 3, 30))
                                                        ));
                                            });
                                        }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
                            }
                            if(Utils.tagStartsWith(tags, "health_charm").isPresent()){
                                Task task = Task.builder()
                                        .execute(task1 -> {
                                            p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                                                p.offer(
                                                        potionEffectData.set(potionEffectData.effects()
                                                                .add(PotionEffect.of(PotionEffectTypes.HEALTH_BOOST, 2, 30))
                                                        ));
                                            });
                                        }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
                            }
                            if(Utils.tagStartsWith(tags, "regeneration_charm").isPresent()){
                                Task task = Task.builder()
                                        .execute(task1 -> {
                                            p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                                                p.offer(
                                                        potionEffectData.addElement(PotionEffect.of(PotionEffectTypes.REGENERATION, 3, 40)));
                                            });
                                        }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
                            }
                            if(Utils.tagStartsWith(tags, "invis_charm").isPresent()){
                                Task task = Task.builder()
                                        .execute(task1 -> {
                                            p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                                                p.offer(
                                                        potionEffectData.set(potionEffectData.effects()
                                                                .add(PotionEffect.of(PotionEffectTypes.INVISIBILITY, 1, 30))
                                                        ));
                                            });
                                        }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
                            }
                            if(Utils.tagStartsWith(tags, "mining_charm").isPresent()){
                                Task task = Task.builder()
                                        .execute(task1 -> {
                                            p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                                                p.offer(
                                                        potionEffectData.set(potionEffectData.effects()
                                                                .add(PotionEffect.of(PotionEffectTypes.NIGHT_VISION, 2, 800))
                                                                .add(PotionEffect.of(PotionEffectTypes.HASTE, 2, 30))
                                                        ));
                                            });
                                        }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
                            }
                            if(Utils.tagStartsWith(tags, "water_charm").isPresent()){
                                Task task = Task.builder()
                                        .execute(task1 -> {
                                            p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                                                p.offer(
                                                        potionEffectData.set(potionEffectData.effects()
                                                                .add(PotionEffect.of(PotionEffectTypes.WATER_BREATHING, 1, 30))
                                                        ));
                                            });
                                        }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
                            }
                            if(Utils.tagStartsWith(tags, "levitation_charm").isPresent()){
                                Task task = Task.builder()
                                        .execute(task1 -> {
                                            p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                                                p.offer(
                                                        potionEffectData.set(potionEffectData.effects()
                                                                .add(PotionEffect.of(PotionEffectTypes.LEVITATION, 2, 30))
                                                        ));
                                            });
                                        }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
                            }
                            if(Utils.tagStartsWith(tags, "bunny_charm").isPresent()){
                                Task task = Task.builder()
                                        .execute(task1 -> {
                                            p.getOrCreate(PotionEffectData.class).ifPresent(potionEffectData -> {
                                                p.offer(
                                                        potionEffectData.set(potionEffectData.effects()
                                                                .add(PotionEffect.of(PotionEffectTypes.JUMP_BOOST, 4, 30))
                                                        ));
                                            });
                                        }).interval(0, TimeUnit.SECONDS).submit(PumpkinsPlugin.getPumpkinsPlugin());
                            }
                        }
                    }
                });
            }
        }
    }
}
