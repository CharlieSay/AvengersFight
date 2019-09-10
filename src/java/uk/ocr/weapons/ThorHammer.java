package uk.ocr.weapons;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.ocr.utility.StringUtils;

import java.awt.*;
import java.util.Arrays;

public class ThorHammer extends ItemStack {

    public ThorHammer() {
        ItemMeta itemMeta = super.getItemMeta();
        super.setType(Material.GOLDEN_AXE);
        super.setAmount(1);
        super.addEnchantment(Enchantment.KNOCKBACK, 10);
        super.addEnchantment(Enchantment.LOYALTY, 10);
        itemMeta.setDisplayName(StringUtils.rainbowString("Mjölnir"));
        itemMeta.setLocalizedName("mjong");
        itemMeta.setLore(Arrays.asList(
                Color.GRAY + "The Mjölnir.",
                Color.RED  + "Only owned by those worthy.",
                StringUtils.rainbowString("YOU ARE WORTHY OF THIS.")
        ));
    }

}
