package uk.co.ayth.utility;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class LocationUtils {

    public static List<Block> getNearbyBlocks(Location location, int radius) {
        List<Block> blocks = new ArrayList<>();
        for(int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
                for(int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
                    Block blockAt = location.getWorld().getBlockAt(x, location.getBlockY() - 1, z);
                    if (!blockAt.getType().equals(Material.BEDROCK)){
                        blocks.add(blockAt);
                    }
                }
            }
        return blocks;
    }

}
