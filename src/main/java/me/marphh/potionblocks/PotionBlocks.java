package me.marphh.potionblocks;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public final class PotionBlocks extends JavaPlugin implements Listener {

    private Random random;

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(this,this);
        random = new Random();

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        PotionEffectType[] effectTypes = PotionEffectType.values();
        PotionEffectType randomEffectType = effectTypes[random.nextInt(effectTypes.length)];

        int randomAmplifier = random.nextInt(4);

        PotionEffect potionEffect = new PotionEffect(randomEffectType, 20 * 15, randomAmplifier);
        player.addPotionEffect(potionEffect);
        getLogger().info(event.getPlayer().getName() + " received: " + potionEffect + " " + randomAmplifier);
    }


}
